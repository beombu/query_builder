package org.example.queryBuilder.dmlBuilder;

import org.example.queryBuilder.conditionBuilder.WhereBuilder;
import org.example.queryBuilder.constant.Column;
import org.example.queryBuilder.constant.Table;

import java.util.Objects;

import static org.example.queryBuilder.constant.Symbol.BLANK;
import static org.example.queryBuilder.constant.Symbol.COMMA;
import static org.example.queryBuilder.constant.Symbol.EQUAL;

public class UpdateBuilder {
    private static final String UPDATE = "UPDATE";
    private static final String SET = "SET";

    private StringBuilder stringBuilder;

    public UpdateBuilder() {
        this.stringBuilder = new StringBuilder();
    }

    public UpdateBuilder update(Table table) {
        stringBuilder.append(UPDATE)
                .append(BLANK.getValue())
                .append(table.getTable());

        return this;
    }

    public <T>UpdateBuilder set(Column column, T value) {
        notifyTypeMismatch(column, value);

        stringBuilder.append(BLANK.getValue())
                .append(SET)
                .append(BLANK.getValue())
                .append(column.getColumn())
                .append(BLANK.getValue())
                .append(EQUAL.getValue())
                .append(BLANK.getValue())
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

        stringBuilder.append(COMMA.getValue())
                .append(BLANK.getValue())
                .append(column.getColumn())
                .append(BLANK.getValue())
                .append(EQUAL.getValue())
                .append(BLANK.getValue())
                .append(value);

        return this;
    }

    public UpdateBuilder where(WhereBuilder whereBuilder) {
        stringBuilder.append(whereBuilder.getStringBuilder());

        return this;
    }

    public UpdateBuilder build() {
        return this;
    }

    public String toString() {
        return stringBuilder.toString();
    }
}
