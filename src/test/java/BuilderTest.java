import org.example.queryBuilder.end.Delete;
import org.example.queryBuilder.end.Insert;
import org.example.queryBuilder.end.Order;
import org.example.queryBuilder.end.Select;
import org.example.queryBuilder.end.Update;
import org.example.queryBuilder.end.User;
import org.example.queryBuilder.end.Where;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;

import static java.util.Map.of;
import static org.example.queryBuilder.constant.Operator.EQUALS;
import static org.example.queryBuilder.constant.Operator.GT;

class SelectBuilderTest {
    @Test
    void insetTest1() {
        Insert insert = Insert.into(User.class)
                .values(of(
                        "id", 1,
                        "name", "신범철",
                        "age", 26
                ));

        System.out.println(insert.getQuery());
    }

    @Test
    void insertTest2() {
        Insert insert = Insert.into(User.class)
                .values(
                        new LinkedHashMap() {{
                            put("id", 1);
                            put("name", "신범철");
                            put("age", 26);
                        }}
                );

        System.out.println(insert.getQuery());
    }

    @Test
    void selectTest() {
        Select select = Select.builder()
                .select(User.class)
                .from(User.class)
//			.from(SimpleUser.class) // Entity 타입이 아니라 컴파일 오류
                .where(
                        Where
                                .builder("no", EQUALS, 2)
                                .and("age", GT, 10)
                                .build()
                )
                .order(
                        Order
                                .builder()
                                .asc("no")
                                .build()
                )
                .build();

        System.out.println(select.getQuery());
    }

    @Test
    void updateTest1() {
        Update update = Update.builder()
                .update(User.class)
                .set(of(
                        "id", 1,
                        "name", "신범철",
                        "age", 26
                ))
                .where(
                        Where
                                .builder("no", EQUALS, 10)
                                .build()
                )
                .build();

        System.out.println(update.getQuery());
    }

    @Test
    void updateTest2() {
        Update update = Update.builder()
                .update(User.class)
                .set(of(
                        "id", 1
                ))
                .where(
                        Where
                                .builder("no", EQUALS, 10)
                                .build()
                )
                .build();

        System.out.println(update.getQuery());
    }

    @Test
    void deleteTest1() {
        Delete delete = Delete.builder()
                .delete(User.class)
                .where(
                        Where
                                .builder("no", EQUALS, 10)
                                .build()
                )
                .build();

        System.out.println(delete.getQuery());
    }

    @Test
    void deleteTest2() {
        Delete delete = Delete.builder()
                .delete(User.class)
                .build();

        System.out.println(delete.getQuery());
    }
}
