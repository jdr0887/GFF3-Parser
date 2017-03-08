package org.renci.gff3.filters;

import java.util.List;

import org.renci.gff3.GFF3Filter;
import org.renci.gff3.model.GFF3Record;

public class GBFFAndFilter implements GFF3Filter {

    private List<GFF3Filter> filters;

    public GBFFAndFilter(List<GFF3Filter> filters) {
        super();
        this.filters = filters;
    }

    @Override
    public boolean accept(GFF3Record record) {
        for (GFF3Filter f : filters) {
            if (!f.accept(record)) {
                return false;
            }
        }
        return true;
    }

}
