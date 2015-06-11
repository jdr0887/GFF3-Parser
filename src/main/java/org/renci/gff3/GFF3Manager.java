package org.renci.gff3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.renci.gff3.model.GFF3Record;

public class GFF3Manager {
    private static GFF3Manager instance;

    public static GFF3Manager getInstance() {
        if (instance == null) {
            instance = new GFF3Manager();
        }
        return instance;
    }

    private GFF3Manager() {
        super();
    }

    public List<GFF3Record> deserialize(File... gff3Files) {
        return deserialize(null, gff3Files);
    }

    public List<GFF3Record> deserialize(Filter filter, File... gff3Files) {
        List<GFF3Record> ret = new ArrayList<GFF3Record>();
        for (File f : gff3Files) {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f)))) {
                String line;
                while ((line = br.readLine()) != null) {
                    if (line.startsWith("#")) {
                        continue;
                    }
                    GFF3Deserializer deserializer = new GFF3Deserializer(line, filter);
                    GFF3Record record = deserializer.call();
                    if (record != null) {
                        ret.add(record);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return ret;
    }

    public void serialize(File gbFile, List<GFF3Record> gff3Records) {
        GFF3Serializer serializer = new GFF3Serializer(gbFile, gff3Records);
        serializer.run();
    }
}
