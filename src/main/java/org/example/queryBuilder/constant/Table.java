package org.example.queryBuilder.constant;

public enum Table {
    CUSTOMER("customer")
    ;

    private final String table;

    Table(String table) {
        this.table = table;
    }

    public String getTable() {
        return table;
    }
}
