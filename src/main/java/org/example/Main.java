package org.example;

import org.example.queryBuilder.conditionBuilder.OrderBuilder;
import org.example.queryBuilder.conditionBuilder.WhereBuilder;

public class Main {
    public static void main(String[] args) {
        WhereBuilder where = new WhereBuilder()
                .where()
                .gt("customer_id", 1L)
                .and()
                .equal("name", "신범철")
                .build();

        System.out.println(where.toString());

        OrderBuilder order = new OrderBuilder()
                .order("name")
                .asc()
                .build();

        System.out.println(order.toString());
    }
}
