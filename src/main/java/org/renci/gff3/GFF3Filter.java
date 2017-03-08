package org.renci.gff3;

import org.renci.gff3.model.GFF3Record;

public interface GFF3Filter {

    public boolean accept(GFF3Record record);

}
