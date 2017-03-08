package org.renci.gff3.filters;

import org.renci.gff3.GFF3Filter;
import org.renci.gff3.model.GFF3Record;

public class GFF3AttributeValueFilter implements GFF3Filter {

    private String key;

    private String value;

    public GFF3AttributeValueFilter(String key, String value) {
        super();
        this.key = key;
        this.value = value;
    }

    @Override
    public boolean accept(GFF3Record record) {
        if (record.getAttributes().containsKey(key) && record.getAttributes().get(key).startsWith(value)) {
            return true;
        }
        return false;
    }

}
