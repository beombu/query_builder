package org.example.queryBuilder.conditionBuilder;

import org.example.queryBuilder.constant.Column;

import static org.example.queryBuilder.constant.Symbol.BLANK;
import static org.example.queryBuilder.constant.Symbol.EQUAL;
import static org.example.queryBuilder.constant.Symbol.GT;
import static org.example.queryBuilder.constant.Symbol.GTE;
import static org.example.queryBuilder.constant.Symbol.LT;
import static org.example.queryBuilder.constant.Symbol.LTE;

public class WhereBuilder {
    private static final String WHERE = "WHERE";
    private static final String AND = "AND";
    private static final String OR = "OR";

    private StringBuilder stringBuilder;

    public WhereBuilder() {
        this.stringBuilder = new StringBuilder();
    }

    public StringBuilder getStringBuilder() {
        return stringBuilder;
    }

    public WhereBuilder where() {
        stringBuilder.append(BLANK.getValue())
                .append(WHERE)
                .append(BLANK.getValue());

        return this;
    }

    public <T>WhereBuilder equal(Column column, String value) {
        stringBuilder
                .append(column.getColumn())
                .append(BLANK.getValue())
                .append(EQUAL.getValue())
                .append(BLANK.getValue())
                .append(value);

        return this;
    }

    public <T>WhereBuilder gte(Column column, T value) {
        stringBuilder
                .append(column.getColumn())
                .append(BLANK.getValue())
                .append(GTE.getValue())
                .append(BLANK.getValue())
                .append(value);

        return this;
    }

    public <T>WhereBuilder lte(Column column, T value) {
        stringBuilder
                .append(column.getColumn())
                .append(BLANK.getValue())
                .append(LTE.getValue())
                .append(BLANK.getValue())
                .append(value);

        return this;
    }

    public <T>WhereBuilder gt(Column column, T value) {
        stringBuilder
                .append(column.getColumn())
                .append(BLANK.getValue())
                .append(GT.getValue())
                .append(BLANK.getValue())
                .append(value);

        return this;
    }

    public <T>WhereBuilder lt(Column column, T value) {
        stringBuilder
                .append(column.getColumn())
                .append(BLANK.getValue())
                .append(LT.getValue())
                .append(BLANK.getValue())
                .append(value);

        return this;
    }

    public WhereBuilder and() {
        stringBuilder.append(BLANK.getValue())
                .append(AND)
                .append(BLANK.getValue());

        return this;
    }

    public WhereBuilder or() {
        stringBuilder.append(BLANK.getValue())
                .append(OR)
                .append(BLANK.getValue());

        return this;
    }

    public WhereBuilder build() {
        return this;
    }

    public String toString() {
        return stringBuilder.toString();
    }
}
