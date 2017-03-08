package org.renci.gff3.filters;

import org.renci.gff3.GFF3Filter;
import org.renci.gff3.model.GFF3Record;

public class GFF3SequenceIdValueFilter implements GFF3Filter {

    private String value;

    public GFF3SequenceIdValueFilter(String value) {
        super();
        this.value = value;
    }

    @Override
    public boolean accept(GFF3Record record) {
        if (record.getSequenceId().equals(value)) {
            return true;
        }
        return false;
    }

}
