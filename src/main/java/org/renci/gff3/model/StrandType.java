package org.renci.gff3.model;

public enum StrandType {

    POSITIVE("+"),

    NEGATIVE("-");

    private String symbol;

    private StrandType(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

}
