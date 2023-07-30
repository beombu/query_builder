package org.example.queryBuilder.dmlBuilder;

import org.example.queryBuilder.constant.Column;
import org.example.queryBuilder.constant.Table;
import org.example.queryBuilder.query.Where;

import java.util.Objects;

public class UpdateBuilder {
    private static final String UPDATE = "UPDATE ";
    private static final String SET = " SET ";

    private StringBuilder stringBuilder;

    public UpdateBuilder() {
        this.stringBuilder = new StringBuilder();
    }

    public UpdateBuilder update(Table table) {
        stringBuilder
                .append(UPDATE)
                .append(table.getTable());

        return this;
    }

    public <T>UpdateBuilder set(Column column, T value) {
        notifyTypeMismatch(column, value);

        stringBuilder
                .append(SET)
                .append(column.getColumn())
                .append(" = ")
                .append(value);

        return this;
    }

    private <T> void notifyTypeMismatch(Column column, T value) {
        if (!Objects.equals(column.getType(), value.getClass().getName())) {
              throw new IllegalArgumentException("타입이 맞지 않습니다.");
        }
    }

    public <T>UpdateBuilder addSet(Column column, T value) {
        notifyTypeMismatch(column, value);

        stringBuilder
                .append(", ")
                .append(column.getColumn())
                .append(" = ")
                .append(value);

        return this;
    }

    public UpdateBuilder where(Where where) {
        stringBuilder.append(where.toString());

        return this;
    }

    public UpdateBuilder build() {
        return this;
    }

    public String toString() {
        return stringBuilder.toString();
    }
}
