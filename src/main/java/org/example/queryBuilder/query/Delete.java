package org.example.queryBuilder.query;

public class Delete {
    private final String query;

    public Delete(String query) {
        this.query = query;
    }

    @Override
    public String toString() {
        return query;
    }
}
