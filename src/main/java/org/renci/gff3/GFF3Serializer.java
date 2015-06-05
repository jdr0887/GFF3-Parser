package org.renci.gff3;

import java.io.File;
import java.util.List;

import org.renci.gff3.model.GFF3Record;

public class GFF3Serializer implements Runnable {

    private File gff3File;

    private List<GFF3Record> records;

    public GFF3Serializer(File gff3File, List<GFF3Record> records) {
        super();
        this.gff3File = gff3File;
        this.records = records;
    }

    @Override
    public void run() {

    }

}
