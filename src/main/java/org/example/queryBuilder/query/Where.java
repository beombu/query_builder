package org.example.queryBuilder.query;

public class Where {

    private final String query;

    public Where(String query) {
        this.query = query;
    }

    @Override
    public String toString() {
        return query;
    }
}
