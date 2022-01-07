package org.rest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Test;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.equalTo;
public class ReqResTest {

    @Test
    public void loginTest(){
         RestAssured
                .given()
                .log()
                .all()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"email\": \"eve.holt@reqres.in\",\n" +
                        "    \"password\": \"cityslicka\"\n" +
                        "}")
                .post("https://reqres.in/api/login")
                .then()
                .log()
                .all()
                .statusCode(200)
                 .body("token", notNullValue());


    }
    @Test
    public void registerTest(){
        String response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"email\": \"eve.holt@reqres.in\",\n" +
                        "    \"password\": \"pistol\"\n" +
                        "}")
                .post("https://reqres.in/api/register")
                .then()
                .extract()
                .asString();

        System.out.println(response);
    }
    @Test
    public void getSingleUserTest(){
        RestAssured
                .given()
                .log()
                .all()
                .contentType(ContentType.JSON)
                .get("https://reqres.in/api/users/2")
                .then()
                .log()
                .all()
                .statusCode(200)
                .body("data.id", equalTo(2));


    }
}
