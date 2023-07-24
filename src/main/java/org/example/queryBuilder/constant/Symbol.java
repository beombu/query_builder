package org.example.queryBuilder.constant;

public enum Symbol {
    BLANK(" "),
    EQUAL("="),
    NOT_EQUAL("!="),
    GTE(">="),
    LTE("<="),
    GT(">"),
    LT("<"),
    COMMA(","),
    COLON(":"),
    LEFT_BRACKET("("),
    RIGHT_BRACKET(")")
    ;

    private final String value;

    Symbol(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
