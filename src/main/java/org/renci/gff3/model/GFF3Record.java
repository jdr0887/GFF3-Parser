package org.renci.gff3.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class GFF3Record implements Serializable, Comparable<GFF3Record> {

    private static final long serialVersionUID = -1412644075950094125L;

    private String sequenceId;

    private String source;

    private String type;

    private Integer start;

    private Integer end;

    private Float score;

    private StrandType strand;

    private Integer phase;

    private Map<String, String> attributes = new HashMap<String, String>();

    public GFF3Record() {
        super();
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

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, String> attributes) {
        this.attributes = attributes;
    }

    @Override
    public String toString() {
        return String.format("GFF3Record [sequenceId=%s, source=%s, start=%s, end=%s, score=%s, strand=%s, phase=%s]",
                sequenceId, source, start, end, score, strand, phase);
    }

    @Override
    public int compareTo(GFF3Record o) {
        int ret = 0;
        ret = this.getStart().compareTo(o.getStart());
        return ret;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((end == null) ? 0 : end.hashCode());
        result = prime * result + ((phase == null) ? 0 : phase.hashCode());
        result = prime * result + ((score == null) ? 0 : score.hashCode());
        result = prime * result + ((sequenceId == null) ? 0 : sequenceId.hashCode());
        result = prime * result + ((source == null) ? 0 : source.hashCode());
        result = prime * result + ((start == null) ? 0 : start.hashCode());
        result = prime * result + ((strand == null) ? 0 : strand.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        GFF3Record other = (GFF3Record) obj;
        if (end == null) {
            if (other.end != null)
                return false;
        } else if (!end.equals(other.end))
            return false;
        if (phase == null) {
            if (other.phase != null)
                return false;
        } else if (!phase.equals(other.phase))
            return false;
        if (score == null) {
            if (other.score != null)
                return false;
        } else if (!score.equals(other.score))
            return false;
        if (sequenceId == null) {
            if (other.sequenceId != null)
                return false;
        } else if (!sequenceId.equals(other.sequenceId))
            return false;
        if (source == null) {
            if (other.source != null)
                return false;
        } else if (!source.equals(other.source))
            return false;
        if (start == null) {
            if (other.start != null)
                return false;
        } else if (!start.equals(other.start))
            return false;
        if (strand != other.strand)
            return false;
        if (type == null) {
            if (other.type != null)
                return false;
        } else if (!type.equals(other.type))
            return false;
        return true;
    }

}
