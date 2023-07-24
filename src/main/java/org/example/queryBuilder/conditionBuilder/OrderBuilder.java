package org.example.queryBuilder.conditionBuilder;

import org.example.queryBuilder.constant.Column;

import static org.example.queryBuilder.constant.Symbol.BLANK;

public class OrderBuilder {
    private static final String ORDER = "ORDER BY";
    private static final String ASC = "ASC";
    private static final String DESC = "DESC";

    private StringBuilder stringBuilder;

    public OrderBuilder() {
        this.stringBuilder = new StringBuilder();
    }

    public StringBuilder getStringBuilder() {
        return stringBuilder;
    }

    public OrderBuilder order(Column column) {
        stringBuilder.append(BLANK.getValue())
                .append(ORDER)
                .append(BLANK.getValue())
                .append(column.getColumn());

        return this;
    }

    public OrderBuilder asc() {
        stringBuilder.append(BLANK.getValue())
                .append(ASC);

        return this;
    }

    public OrderBuilder desc() {
        stringBuilder.append(BLANK.getValue())
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
