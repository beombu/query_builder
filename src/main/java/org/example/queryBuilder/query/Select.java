package org.example.queryBuilder.query;

public class Select {
    private final String query;

    public Select(String query) {
        this.query = query;
    }

    @Override
    public String toString() {
        return query;
    }
}
