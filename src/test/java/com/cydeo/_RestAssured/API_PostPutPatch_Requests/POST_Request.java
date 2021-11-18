package com.cydeo._RestAssured.API_PostPutPatch_Requests;

import com.cydeo.utility.SpartanTestBase;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class POST_Request extends SpartanTestBase {
    @Test
    public void testAdd1DataStringBody() {
        /*
            POST /spartans
            Content-Type == JSON
            body is:
                {
                    "name": "Regan Kovacs",
                    "gender": "Male",
                    "phone": 1565798744
                }
         */

        String name = "Regan Kovacs";
        long phone = 156579874;
        String gender = "Male";

        String json_body = "{\n" +
                "                    \"name\": \"Regan Kovacs\",\n" +
                "                    \"gender\": \"Male\",\n" +
                "                    \"phone\": 1565798744\n" +
                "                }";

        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(json_body)
        .when()
                .post("/spartans")
        .then()
                .log().all()
                .statusCode(201)
                .body("success", is("A Spartan is Born!"))
                .body("data.name", is(name))
                .body("data.phone.toLong()", is(phone))
                .body("data.gender", is(gender));
    }
}
