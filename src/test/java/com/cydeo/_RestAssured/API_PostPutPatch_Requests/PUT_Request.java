package com.cydeo._RestAssured.API_PostPutPatch_Requests;

import com.cydeo.utility.SpartanTestBase;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class PUT_Request extends SpartanTestBase {
    /*
            PUT /spartans/id
            Content-Type == JSON
            body is:
                {
                    "name": "Kim Convenience",
                    "gender": "Female",
                    "phone": 1565798744
                }
         */

    @Test
    public void testPutSpartan() {
        String json_body = "{\n" +
                "                    \"name\": \"Kim Convenience\",\n" +
                "                    \"gender\": \"Female\",\n" +
                "                    \"phone\": 1565798744\n" +
                "                }";

        given()
                .log().all()
                .pathParam("id", "1")
                .contentType(ContentType.JSON)
                .body(json_body)
        .when()
                .put("/spartans/{id}")
        .then()
                .log().all()
                .statusCode(204);

        /*
            Above API request does not return any body
            ToDO create a request to verify PUT
         */
    }
}
