package com.cydeo._RestAssured.IntroToRestAssured;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSpartan3 {
    @BeforeAll
    public static void setup() {
        baseURI = "http://54.205.116.211:8000";
        basePath = "/api";
    }

    @AfterAll
    public static void tearDown() {
        /*
            To avoid static values being carried over, moreso the baseURI & basePath,
            we use the RestAssured.reset() method
         */
        reset();
    }

    // Send Get request /spartans & check if code is 200 & content-type is json
    @Test
    public void testAllSpartans() {
        Response response = get("/spartans");

        // response.prettyPrint();

        assertEquals(200, response.statusCode());
        assertEquals(ContentType.JSON.toString(), response.contentType());

        System.out.println("response.path(\"[0].gender\") = " + response.path("[0].gender"));

        // Get all values for a particular key:
        List<Integer> id_list = response.path("id");

        System.out.println("id_list = " + id_list);
    }

    @Test
    public void testGetXMLResponse() {
        Response response = given()
                //.header("Accept", ContentType.XML)
                .accept(ContentType.XML)
                .when()
                .get("/spartans");

        // response.prettyPrint();

        assertEquals(200, response.statusCode());
        assertEquals(ContentType.XML.toString(), response.getContentType());
    }

    @Test
    public void testSearchRequest() {
        // spartans/search?nameContains=Ea&gender=Male

        Response response = given()
                .queryParam("nameContains", "Ea")
                .queryParam("gender", "Male")
                .when()
                .get("/spartans/search");

        System.out.println("response.path(\"totalElement\") = " + response.path("totalElement")); // Get total elements

        // Get content
        List<String> names_with_ea = response.path("content.name");

        // System.out.println("names_with_ea = " + names_with_ea);

        System.out.println("response.path(\"id.content[0]\") = " + response.path("content[1].id"));

    }

    @Test
    public void testOneSpartanPathParam() {
        Response response = given()
                .pathParam("id", 65)
                .when()
                .get("/spartans/{id}");
        
        response.prettyPrint();

        assertEquals("Sean", response.path("name"));
    }

    @Test
    public void testLogRequest() {
        Response response = given()
                .pathParam("id", 65)
                .accept(ContentType.JSON)
                .log().all()
                .when()
                .get("/spartans/{id}");
    }
}
