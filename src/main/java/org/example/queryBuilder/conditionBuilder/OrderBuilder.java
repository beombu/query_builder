package org.example.queryBuilder.conditionBuilder;

import org.example.queryBuilder.constant.Column;

public class OrderBuilder {
    private static final String ORDER = " ORDER BY ";
    private static final String ASC = " ASC";
    private static final String DESC = " DESC";

    private StringBuilder stringBuilder;

    public OrderBuilder() {
        this.stringBuilder = new StringBuilder();
    }

    public StringBuilder getStringBuilder() {
        return stringBuilder;
    }

    public OrderBuilder order(Column column) {
        stringBuilder
                .append(ORDER)
                .append(column.getColumn());

        return this;
    }

    public OrderBuilder asc() {
        stringBuilder
                .append(ASC);

        return this;
    }

    public OrderBuilder desc() {
        stringBuilder
                .append(DESC);

        return this;
    }

    public OrderBuilder build() {
        return this;
    }

    public String toString() {
        return stringBuilder.toString();
    }
}
