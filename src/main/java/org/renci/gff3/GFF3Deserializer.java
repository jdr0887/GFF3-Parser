package org.renci.gff3;

import java.util.Scanner;
import java.util.concurrent.Callable;

import org.renci.gff3.model.GFF3Record;
import org.renci.gff3.model.StrandType;

public class GFF3Deserializer implements Callable<GFF3Record> {

    private String line;

    private Filter filter;

    public GFF3Deserializer(String line, Filter filter) {
        super();
        this.line = line;
        this.filter = filter;
    }

    @Override
    public GFF3Record call() throws Exception {
        GFF3Record record = new GFF3Record();

        try (Scanner scanner = new Scanner(line).useDelimiter("\t")) {
            String sequenceId = scanner.next();
            record.setSequenceId(sequenceId);

            String source = scanner.next();
            record.setSource(source);

            String type = scanner.next();
            record.setType(type);

            String start = scanner.next();
            if (!".".equals(start)) {
                record.setStart(Integer.valueOf(start));
            }

            String end = scanner.next();
            if (!".".equals(end)) {
                record.setEnd(Integer.valueOf(end));
            }

            String score = scanner.next();
            if (!".".equals(score)) {
                record.setScore(Float.valueOf(score));
            }

            String strandValue = scanner.next();
            for (StrandType sType : StrandType.values()) {
                if (sType.getSymbol().equals(strandValue)) {
                    record.setStrand(sType);
                }
            }

            String phase = scanner.next();
            if (!".".equals(phase)) {
                record.setPhase(Integer.valueOf(phase));
            }

            String attributes = scanner.next();
            try (Scanner attributeScanner = new Scanner(attributes).useDelimiter(";")) {
                while (attributeScanner.hasNext()) {
                    String attribute = attributeScanner.next();
                    String[] split = attribute.split("=");
                    String key = split[0];
                    String value = split[1];
                    record.getAttributes().setProperty(key, value);
                }

            }

        }

        if (filter != null && !filter.accept(record)) {
            return null;
        }

        return record;
    }

}
