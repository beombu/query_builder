package org.example;

import org.example.queryBuilder.builder.OrderBuilder;
import org.example.queryBuilder.builder.WhereBuilder;
import org.example.queryBuilder.dmlBuilder.DeleteBuilder;
import org.example.queryBuilder.builder.SelectBuilder;
import org.example.queryBuilder.dmlBuilder.UpdateBuilder;
import org.example.queryBuilder.query.Order;
import org.example.queryBuilder.query.Select;
import org.example.queryBuilder.query.Where;

import static org.example.queryBuilder.constant.Column.*;
import static org.example.queryBuilder.constant.Column.CUSTOMER_ID;
import static org.example.queryBuilder.constant.Column.CUSTOMER_NAME;
import static org.example.queryBuilder.constant.Table.*;

public class Main {
    public static void main(String[] args) {
        Where where = new WhereBuilder()
                .where()
                .equal(CUSTOMER_ID, 1L)
                .or()
                .gt(CUSTOMER_NAME, "신범철")
                .Build();

        System.out.println(where.toString());

        Order order = new OrderBuilder()
                .order(CUSTOMER_NAME)
                .asc()
                .build();

        System.out.println(order.toString());

        Select select = new SelectBuilder()
                .select(ALL)
                .from(CUSTOMER)
                .where(where)
                .build();

        System.out.println(select.toString());

        Select select2 = new SelectBuilder()
                .select(CUSTOMER_ID, CUSTOMER_NAME)
                .from(CUSTOMER)
                .where(where)
                .build();

        System.out.println(select2.toString());

        UpdateBuilder update = new UpdateBuilder()
                .update(CUSTOMER)
                .set(CUSTOMER_ID, 3L)
                .addSet(CUSTOMER_NAME, "오세한")
                .where(where)
                .build();

        System.out.println(update.toString());

        DeleteBuilder delete = new DeleteBuilder()
                .delete(CUSTOMER)
                .where(where)
                .build();

        System.out.println(delete.toString());
    }
}
