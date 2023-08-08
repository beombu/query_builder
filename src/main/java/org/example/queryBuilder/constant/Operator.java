package org.example.queryBuilder.constant;

public enum Operator {
    EQUALS("="),
    GT(">"),
    LT("<");

    private final String symbol;

    Operator(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
