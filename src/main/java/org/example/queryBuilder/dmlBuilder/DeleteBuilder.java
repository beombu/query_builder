package org.example.queryBuilder.dmlBuilder;

import org.example.queryBuilder.conditionBuilder.WhereBuilder;
import org.example.queryBuilder.constant.Table;

import static org.example.queryBuilder.constant.Symbol.BLANK;

public class DeleteBuilder {
    private static final String DELETE = "DELETE";
    private static final String FROM = "FROM";

    private StringBuilder stringBuilder;

    public DeleteBuilder() {
        this.stringBuilder = new StringBuilder();
    }

    public DeleteBuilder delete(Table table) {
        stringBuilder.append(DELETE)
                .append(BLANK.getValue())
                .append(FROM)
                .append(BLANK.getValue())
                .append(table.getTable());

        return this;
    }

    public DeleteBuilder where(WhereBuilder whereBuilder) {
        stringBuilder.append(whereBuilder.getStringBuilder());

        return this;
    }

    public DeleteBuilder build() {
        return this;
    }

    public String toString() {
        return stringBuilder.toString();
    }
}
