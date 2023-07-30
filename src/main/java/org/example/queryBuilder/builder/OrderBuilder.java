package org.example.queryBuilder.builder;

import org.example.queryBuilder.constant.Column;
import org.example.queryBuilder.query.Order;

public class OrderBuilder {
    private static final String ORDER = " ORDER BY ";
    private static final String ASC = " ASC";
    private static final String DESC = " DESC";

    private StringBuilder stringBuilder;

    public OrderBuilder() {
        this.stringBuilder = new StringBuilder();
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

    public Order build() {
        return new Order(this.toString());
    }

    public String toString() {
        return stringBuilder.toString();
    }
}
