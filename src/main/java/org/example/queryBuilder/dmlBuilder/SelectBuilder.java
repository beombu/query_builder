package org.example.queryBuilder.dmlBuilder;

import org.example.queryBuilder.constant.Column;
import org.example.queryBuilder.constant.Table;
import org.example.queryBuilder.query.Where;

public class SelectBuilder {
    private static final String SELECT = "SELECT ";
    private static final String FROM = " FROM ";

    private StringBuilder stringBuilder;

    public SelectBuilder() {
        this.stringBuilder = new StringBuilder();
    }

    public SelectBuilder select(Column... columns) {
        stringBuilder.append(SELECT);

        for (Column column : columns) {
            stringBuilder.append(column.getColumn())
                    .append(",");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);

        return this;
    }

    public SelectBuilder from(Table table) {
        stringBuilder
                .append(FROM)
                .append(table.getTable());

        return this;
    }

    public SelectBuilder where(Where where) {
        stringBuilder.append(where.toString());

        return this;
    }

    public SelectBuilder build() {
        return this;
    }

    public String toString() {
        return stringBuilder.toString();
    }
}
