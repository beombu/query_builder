package org.example.queryBuilder.constant;

public enum Column {
    CUSTOMER_ID("customer_id"),
    CUSTOMER_NAME("customer_name"),
    ALL("*")
    ;

    private final String column;

    Column(String column) {
        this.column = column;
    }

    public String getColumn() {
        return column;
    }
}
