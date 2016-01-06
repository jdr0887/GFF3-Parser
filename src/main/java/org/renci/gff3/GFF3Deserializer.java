package org.renci.gff3;

import java.util.concurrent.Callable;

import org.apache.commons.lang3.StringUtils;
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

        String[] tabSplit = StringUtils.split(line);

        String sequenceId = tabSplit[0];
        record.setSequenceId(sequenceId);

        String source = tabSplit[1];
        record.setSource(source);

        String type = tabSplit[2];
        record.setType(type);

        String start = tabSplit[3];
        if (!".".equals(start)) {
            record.setStart(Integer.valueOf(start));
        }

        String end = tabSplit[4];
        if (!".".equals(end)) {
            record.setEnd(Integer.valueOf(end));
        }

        String score = tabSplit[5];
        if (!".".equals(score)) {
            record.setScore(Float.valueOf(score));
        }

        String strandValue = tabSplit[6];
        for (StrandType sType : StrandType.values()) {
            if (sType.getSymbol().equals(strandValue)) {
                record.setStrand(sType);
            }
        }

        String phase = tabSplit[7];
        if (!".".equals(phase)) {
            record.setPhase(Integer.valueOf(phase));
        }

        String attributes = tabSplit[8];
        String[] attributeSplit = StringUtils.split(attributes, ";");
        for (String attribute : attributeSplit) {
            String[] split = StringUtils.split(attribute, "=");
            String key = split[0];
            String value = split[1];
            record.getAttributes().put(key, value);
        }

        if (filter != null && !filter.accept(record)) {
            return null;
        }

        return record;
    }

}
