package org.example.queryBuilder.builder;

import org.example.queryBuilder.constant.Table;
import org.example.queryBuilder.query.Delete;
import org.example.queryBuilder.query.Where;

public class DeleteBuilder {
    private static final String DELETE = "DELETE ";
    private static final String FROM = "FROM ";

    private final StringBuilder stringBuilder;

    public DeleteBuilder() {
        this.stringBuilder = new StringBuilder();
    }

    public DeleteBuilder delete(Table table) {
        stringBuilder.append(DELETE)
                .append(FROM)
                .append(table.getTable());

        return this;
    }

    public DeleteBuilder where(Where where) {
        stringBuilder.append(where.toString());

        return this;
    }

    public Delete build() {
        return new Delete(this.toString());
    }

    public String toString() {
        return stringBuilder.toString();
    }
}
