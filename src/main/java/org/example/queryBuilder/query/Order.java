package org.example.queryBuilder.query;

public class Order {
    private final String query;

    public Order(String query) {
        this.query = query;
    }

    @Override
    public String toString() {
        return query;
    }
}
