package com.cydeo.utility;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.*;

/**
 * This will serve as the base class for the Spartan API test, setting up the baseURI & basePath, & performing clean up
 */
public class SpartanTestBase {
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
}
