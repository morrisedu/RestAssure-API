package com.cydeo._RestAssured.IntroToRestAssured;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSpartanAPI {
    @Test
    public void testHello() {
        // Send request to http://54.205.116.211:8000/api/hello & save the response

        Response response = get("http://54.205.116.211:8000/api/hello"); // Get method comes from RestAssured class
        System.out.println("response.statusCode() = " + response.statusCode());
        response.prettyPrint();

        // Make sure that the API request was successful
        assertEquals(200, response.statusCode());
    }
}
