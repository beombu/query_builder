package org.example;

import org.example.queryBuilder.conditionBuilder.WhereBuilder;

import static org.example.queryBuilder.constant.Column.CUSTOMER_ID;
import static org.example.queryBuilder.constant.Column.CUSTOMER_NAME;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        WhereBuilder where = new WhereBuilder()
                .where()
                .gt(CUSTOMER_ID, 1L)
                .and()
                .equal(CUSTOMER_NAME, "신범철")
                .build();

        System.out.println(where.toString());
    }
}
