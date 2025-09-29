package ru.netology.restAPI;

import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Test_1 {
    @Test
    void should() {
        String body = "{\"id\": 1," +
                "\"name\": \"Текущий счёт\"," +
                "\"number\": \"** 8574\"," +
                "\"balance\": 550000," +
                "\"currency\": \"RUB\"" +
                "}";
        // Given - When - Then
        // Предусловия
        given()
                .baseUri("https://postman-echo.com")
                .contentType("application/json")
                .body(body) // отправляемые данные (заголовки и query можно выставлять аналогично)
                // Выполняемые действия
                .when()
                .post("/post")
                // Проверки
                .then()
                .statusCode(200)
                .body("json.id", equalTo(1))
                .body("json.name", equalTo("Текущий счёт"))
                .body("json.number", equalTo("** 8574"))
                .body("json.balance", equalTo(550000))
                .body("json.currency", equalTo("RUB"))
        ;
    }
}

