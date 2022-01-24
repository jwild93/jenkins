package tests;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.when;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class TestRest {
    @Test
    public void testGetUser() {
        Response response = when()
                .get("https://reqres.in/api/users/{id}", 2);
        response.then().statusCode(200);

        System.out.println(response.asString());
    }


    @Test
    public void testGetUser2() {
        Response response = when()
                .get("https://reqres.in/api/users/{id}", 2);
        response.then()
                .statusCode(200)
                .assertThat().body(matchesJsonSchemaInClasspath("schema_j.json"));
    }
}