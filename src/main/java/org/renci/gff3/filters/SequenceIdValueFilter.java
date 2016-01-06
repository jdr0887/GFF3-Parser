package org.renci.gff3.filters;

import org.renci.gff3.Filter;
import org.renci.gff3.model.GFF3Record;

public class SequenceIdValueFilter implements Filter {

    private String value;

    public SequenceIdValueFilter(String value) {
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
