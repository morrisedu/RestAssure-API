package com.cydeo._RestAssured.IntroToRestAssured;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestOneSpartan {
    Response response = get("http://54.205.116.211:8000/api/spartans/1");

    @Test
    public void testOneSpartan(){

        // sending a get request to this url and saving the response into Response object
        Response response = get("http://54.205.116.211:8000/api/spartans/1");

        // print out the status code
        // statusCode() and getStatusCode does same thing to return status of resposne
        int statusCode =  response.statusCode() ;
        System.out.println("statusCode = " + statusCode);
        // one way to get the body as string and print it out without sout
        response.prettyPrint();
        // another way to get the body as string is asString , it does not print for you , you print yourself
        System.out.println("response.asString() = " + response.asString() );

        // getting header from the response
        // using header("header name") or getHeader("header name") methods , do same exact thing
        System.out.println("response.header(\"Content-Type\") = "
                + response.header("Content-Type") );
        // this is the example of using getHeader method that does same thing
        System.out.println("response.getHeader(\"Content-Type\") = "
                + response.getHeader("Content-Type"));

        // try to get Date Header , Keep-Alive header , Connection
        // IF YOU PROVIDE WRONG HEADER NAME , IT WILL RETURN NULL
        System.out.println("response.header(\"Date\") = " + response.header("Date") );
        System.out.println("response.header(\"Keep-Alive\") = " + response.header("Keep-Alive") );
        System.out.println("response.getHeader(\"Connection\") = " + response.getHeader("Connection"));

    }

    @Test
    public void testContentTypeHeader() {
//        System.out.println("response.getContentType() = " + response.getContentType());
//        System.out.println("response.contentType() = " + response.contentType());
//
//        System.out.println("response.asString() = " + response.asString());

        // Verify contentType() == "application/json"
        assertEquals(ContentType.JSON.toString(), response.contentType());

        /* Different types of content-types are represented in ENUM coming from
            import io.restassured.http.ContentType
         */
        // System.out.println("ContentType.JSON = " + ContentType.JSON);
        System.out.println("ContentType.XML = " + ContentType.XML);
    }

    @Test
    public void testJSONBody() {
//        System.out.println("response.path(\"id\") = " + response.path("id"));
//        System.out.println("response.path(\"name\") = " + response.path("name"));
//        System.out.println("response.path(\"gender\") = " + response.path("gender"));
//        System.out.println("response.path(\"phone\") = " + response.path("phone"));

        int sp_id = response.path("id");
        String sp_name = response.path("name");
        String sp_gender = response.path("gender");
        long sp_phone = response.path("phone");

        System.out.println("ID: " + sp_id + ", Name: " + sp_name + ", Gender: " + sp_gender + ", Phone: " + sp_phone);
    }
}
