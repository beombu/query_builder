package org.example.queryBuilder.query;

public class Update {
    private final String query;

    public Update(String query) {
        this.query = query;
    }

    @Override
    public String toString() {
        return query;
    }
}
