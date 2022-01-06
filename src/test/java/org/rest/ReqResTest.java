package org.rest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Test;

public class ReqResTest {

    @Test
    public void loginTest(){
        String response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"email\": \"eve.holt@reqres.in\",\n" +
                        "    \"password\": \"cityslicka\"\n" +
                        "}")
                .post("https://reqres.in/api/login")
                .then()
                .extract()
                .asString();

        System.out.println(response);
    }
}
