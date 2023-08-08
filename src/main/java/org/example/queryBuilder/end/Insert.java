package org.example.queryBuilder.end;

import java.util.List;
import java.util.Map;

public class Insert {
    private final Class<? extends Entity> table;
    private final Map<String, Object> values;
    private final String query;

    private Insert(Class<? extends Entity> table, Map<String, Object> values) {
        this.table = table;
        this.values = values;
        this.query = generateQuery();
    }

    private String generateQuery() {
        List<String> columSet = this.values.entrySet()
                .stream()
                .map(Map.Entry::getKey)
                .toList();

        List<String> valueSet = this.values.entrySet().stream()
                .map(Map.Entry::getValue)
                .map(value -> {
                    if (value instanceof String) {
                        return String.format("%s", value);
                    }

                    return value.toString();
                })
                .toList();

        String columns = String.join(", ", columSet);
        String values = String.join(", ", valueSet);

        return "INSERT INTO %s (%s) VALUES (%s)".formatted(this.table.getSimpleName(), columns, values);
    }

    public String getQuery() {
        return this.query;
    }

    public static InsertCriteria into(Class<? extends Entity> table) {
        return new InsertCriteria(table);
    }

    public static class InsertCriteria {
        private final Class<? extends Entity> table;

        private InsertCriteria(Class<? extends Entity> table) {
            this.table = table;
        }

        public Insert values(Map<String, Object> values) {
            return new Insert(table, values);
        }
    }
}
