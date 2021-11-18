package com.cydeo._RestAssured.API_PostPutPatch_Requests;

import com.cydeo.utility.SpartanTestBase;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class PATCH_Request extends SpartanTestBase {
    /*
            PATCH /spartans/id
            Content-Type == JSON
            body is:
                {
                    "name": "Kim Convenience",
                    "gender": "Female",
                    "phone": 1565798744
                }
         */

    @Test
    public void testPatchSpartan() {
        String json_body = "{\"name\": \"Paige Keller\"}";

        given()
                .log().all()
                .pathParam("id", "4")
                .contentType(ContentType.JSON)
                .body(json_body)
        .when()
                .patch("/spartans/{id}")
        .then()
                .log().all()
                .statusCode(204);

        /*
            Above API request does not return any body
            ToDO create a request to verify PATCH
         */
    }
}
