package org.renci.gff3.filters;

import org.renci.gff3.Filter;
import org.renci.gff3.model.GFF3Record;

public class AttributeValueFilter implements Filter {

    private String key;

    private String value;

    public AttributeValueFilter(String key, String value) {
        super();
        this.key = key;
        this.value = value;
    }

    @Override
    public boolean accept(GFF3Record record) {
        if (record.getAttributes().containsKey(key) && record.getAttributes().getProperty(key).startsWith(value)) {
            return true;
        }
        return false;
    }

}
