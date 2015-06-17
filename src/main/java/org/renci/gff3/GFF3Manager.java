package org.renci.gff3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.renci.gff3.model.GFF3Record;

public class GFF3Manager {

    private final File gff3File;

    private static GFF3Manager instance;

    public static GFF3Manager getInstance(File gff3File) {
        if (instance == null) {
            instance = new GFF3Manager(gff3File);
        }
        return instance;
    }

    private GFF3Manager(File gff3File) {
        super();
        this.gff3File = gff3File;
    }

    public List<GFF3Record> deserialize() {
        return deserialize(null);
    }

    public List<GFF3Record> deserialize(Filter filter) {
        List<GFF3Record> ret = new ArrayList<GFF3Record>();
        List<Future<GFF3Record>> futures = new ArrayList<Future<GFF3Record>>();

        ExecutorService es = Executors.newFixedThreadPool(8);
        try (FileInputStream fis = new FileInputStream(gff3File);
                InputStreamReader isr = new InputStreamReader(fis);
                BufferedReader br = new BufferedReader(isr)) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("#")) {
                    continue;
                }
                futures.add(es.submit(new GFF3Deserializer(line, filter)));
            }

            es.shutdown();
            es.awaitTermination(5L, TimeUnit.MINUTES);

            for (Future<GFF3Record> future : futures) {
                GFF3Record record = future.get();
                if (record != null) {
                    ret.add(record);
                }
            }
        } catch (IOException | InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        return ret;
    }

    public void serialize(File gbFile, List<GFF3Record> gff3Records) {
        GFF3Serializer serializer = new GFF3Serializer(gbFile, gff3Records);
        serializer.run();
    }
}
