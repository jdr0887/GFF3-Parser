package org.renci.gff3;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.List;

import org.junit.Test;
import org.renci.gff3.filters.GFF3AttributeValueFilter;
import org.renci.gff3.model.GFF3Record;

public class DeserializeTest {

    @Test
    public void test() {
        GFF3Manager gff3Mgr = GFF3Manager.getInstance();
        long start = System.currentTimeMillis();
        List<GFF3Record> results = gff3Mgr
                .deserialize(new File("/tmp", "GCF_000001405.28_knownrefseq_alignments.gff3"));
        long end = System.currentTimeMillis();
        assertTrue(results != null);
        assertTrue(!results.isEmpty());
        System.out.println(String.format("%d seconds", (end - start) / 1000));
        assertTrue(results.get(0).getAttributes().containsKey("Target"));
        // System.out.println(results.get(0));
    }

    @Test
    public void testFilter() {
        GFF3Manager gff3Mgr = GFF3Manager.getInstance();
        long start = System.currentTimeMillis();
        List<GFF3Record> results = gff3Mgr.deserialize(
                new File("/tmp/refseq/mappings", "GCF_000001405.28_knownrefseq_alignments.gff3"),
                new GFF3AttributeValueFilter("Target", "NM_001317111.1"));
        long end = System.currentTimeMillis();
        assertTrue(results != null);
        assertTrue(!results.isEmpty());
        System.out.println(results.size());
        System.out.println(String.format("%s seconds", (end - start) / 1000D));
        assertTrue(results.get(0).getAttributes().containsKey("Target"));

        // System.out.println(results.get(0));
    }
}
