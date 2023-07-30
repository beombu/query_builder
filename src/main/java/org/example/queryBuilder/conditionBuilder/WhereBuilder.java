package org.example.queryBuilder.conditionBuilder;

import org.example.queryBuilder.constant.Column;
import org.example.queryBuilder.query.Where;

import java.util.Objects;
public class WhereBuilder {
    private static final String WHERE = " WHERE ";
    private static final String AND = " AND ";
    private static final String OR = " OR ";
    private final StringBuilder stringBuilder = new StringBuilder();

    public WhereBuilder where() {
        stringBuilder.append(WHERE);

        return this;
    }

    public <T> WhereBuilder equal(Column column, T value) {
        notifyTypeMismatch(column, value);

        stringBuilder
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

    public <T> WhereBuilder gte(Column column, T value) {
        notifyTypeMismatch(column, value);

        stringBuilder
                .append(column.getColumn())
                .append(" >= ")
                .append(value);

        return this;
    }

    public <T> WhereBuilder lte(Column column, T value) {
        notifyTypeMismatch(column, value);

        stringBuilder
                .append(column.getColumn())
                .append(" <= ")
                .append(value);

        return this;
    }

    public <T> WhereBuilder gt(Column column, T value) {
        notifyTypeMismatch(column, value);

        stringBuilder
                .append(column.getColumn())
                .append(" > ")
                .append(value);

        return this;
    }

    public <T> WhereBuilder lt(Column column, T value) {
        notifyTypeMismatch(column, value);

        stringBuilder
                .append(column.getColumn())
                .append(" < ")
                .append(value);

        return this;
    }

    public WhereBuilder and() {
        stringBuilder.append(AND);

        return this;
    }

    public WhereBuilder or() {
        stringBuilder.append(OR);

        return this;
    }

    public String toString() {
        return stringBuilder.toString();
    }

    public Where Build() {
        return new Where(this.toString());
    }
}
