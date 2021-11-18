package com.cydeo._RestAssured.ChainingRequests;

import com.cydeo.utility.SpartanTestBase;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class SpartanChainMethodTest extends SpartanTestBase {
    @Test
    public void testGetOneSpartan() {
        given()
                .log().all()
                .pathParam("id", "1")
                .accept(ContentType.JSON)
        .when()
                .get("/spartans/{id}")
        .then()
                .statusCode(200)
                // .header("Content-Type", ContentType.JSON.toString())
                .contentType(ContentType.JSON)
                .body("id", is(1))
                .body("name", is("Kim"));

    }

    @Test
    public void testSearch() {
        /*
            /spartans/search?nameContains=Ea&gender=Male
            Verify status code is 200
            Content-Type is JSON
            totalElements == 3
            JSON array size == 3
            Sean is in the response
            every gender is male
            All names should contain, ignoring case, ea
         */

        given()
                .log().all()
                .queryParam("nameContains", "Ea")
                .queryParam("gender", "Male")
        .when()
                .get("/spartans/search")
        .then()
                .log().all()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("totalElement", is(2))
                .body("content", hasSize(2))
                .body("content.name", hasItem("Sean"))
                .body("content.gender", everyItem(is("Male")))
                .body("content.name", everyItem(containsStringIgnoringCase("ea")));

    }
}
