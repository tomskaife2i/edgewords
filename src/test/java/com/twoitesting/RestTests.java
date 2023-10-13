package com.twoitesting;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

public class RestTests {
    @Test
    void bddStatic() {
        given().baseUri("http://localhost:2002")
                .when().get("/api/products")
                .then().statusCode(200);
    }

}
