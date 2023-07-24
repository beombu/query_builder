package org.example;

import org.example.queryBuilder.conditionBuilder.OrderBuilder;
import org.example.queryBuilder.conditionBuilder.WhereBuilder;
import org.example.queryBuilder.constant.Column;
import org.example.queryBuilder.constant.Table;
import org.example.queryBuilder.dmlBuilder.DeleteBuilder;
import org.example.queryBuilder.dmlBuilder.SelectBuilder;
import org.example.queryBuilder.dmlBuilder.UpdateBuilder;

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

        SelectBuilder select2 = new SelectBuilder()
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
