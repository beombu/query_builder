package org.example;

import org.example.queryBuilder.conditionBuilder.OrderBuilder;
import org.example.queryBuilder.conditionBuilder.WhereBuilder;
import org.example.queryBuilder.constant.Column;
import org.example.queryBuilder.constant.Table;
import org.example.queryBuilder.dmlBuilder.SelectBuilder;

import static org.example.queryBuilder.constant.Column.*;
import static org.example.queryBuilder.constant.Column.CUSTOMER_ID;
import static org.example.queryBuilder.constant.Column.CUSTOMER_NAME;
import static org.example.queryBuilder.constant.Table.*;

public class Main {
    public static void main(String[] args) {
        WhereBuilder where = new WhereBuilder()
                .where()
                .gt(CUSTOMER_ID, 1L)
                .and()
                .equal(CUSTOMER_NAME, "신범철")
                .build();

        System.out.println(where.toString());

        OrderBuilder order = new OrderBuilder()
                .order(CUSTOMER_NAME)
                .asc()
                .build();

        System.out.println(order.toString());

        SelectBuilder select = new SelectBuilder()
                .select(ALL)
                .from(CUSTOMER)
                .where(where)
                .build();

        System.out.println(select.toString());
    }
}
