package org.renci.gff3.model;

import java.io.Serializable;
import java.util.Properties;

public class GFF3Record implements Serializable {

    private static final long serialVersionUID = -1412644075950094125L;

    private String sequenceId;

    private String source;

    private String type;

    private Integer start;

    private Integer end;

    private Float score;

    private StrandType strand;

    private Integer phase;

    private Properties attributes;

    public GFF3Record() {
        super();
        attributes = new Properties();
    }

    public String getSequenceId() {
        return sequenceId;
    }

    public void setSequenceId(String sequenceId) {
        this.sequenceId = sequenceId;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getEnd() {
        return end;
    }

    public void setEnd(Integer end) {
        this.end = end;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    public StrandType getStrand() {
        return strand;
    }

    public void setStrand(StrandType strand) {
        this.strand = strand;
    }

    public Integer getPhase() {
        return phase;
    }

    public void setPhase(Integer phase) {
        this.phase = phase;
    }

    public Properties getAttributes() {
        return attributes;
    }

    public void setAttributes(Properties attributes) {
        this.attributes = attributes;
    }

    @Override
    public String toString() {
        return "GFF3Record [sequenceId=" + sequenceId + ", source=" + source + ", type=" + type + ", start=" + start
                + ", end=" + end + ", score=" + score + ", strand=" + strand + ", phase=" + phase + "]";
    }

}
