package org.example.queryBuilder.constant;

public enum Column {
    CUSTOMER_ID("customer_id", "java.lang.Long"),
    CUSTOMER_NAME("customer_name", "java.lang.String"),
    ALL("*", "java.lang.String")
    ;

    private final String column;
    private final String type;

    Column(String column, String type) {
        this.column = column;
        this.type = type;
    }

    public String getColumn() {
        return column;
    }

    public String getType() {
        return type;
    }
}
