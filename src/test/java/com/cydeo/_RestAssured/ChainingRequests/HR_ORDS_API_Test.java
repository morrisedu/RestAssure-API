package com.cydeo._RestAssured.ChainingRequests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class HR_ORDS_API_Test {
    @BeforeAll
    public static void setup() {
        baseURI = "http://54.205.116.211:1000";
        basePath = "/ords/hr/";
    }

    @AfterAll
    public static void tearDown() {
        reset();
    }

    @Test
    public void testGetAllJobs() {
        Response response = given()
                    .log().all()
                .when()
                    .get("jobs");


        assertEquals(200, response.statusCode());
        assertEquals(ContentType.JSON.toString(), response.contentType());

        int count_value = response.path("count");
        assertEquals(19, count_value);

        // Get second job_id
        String second_job_id = response.path("items[1].job_id");
        System.out.println("second_job_id = " + second_job_id);

        // Fourth min salary
        int fourth_min_salary = response.path("items[3].min_salary");
        System.out.println("fourth_min_salary = " + fourth_min_salary);

        // All job titles
        List<String> all_job_titles = response.path("items.job_title");

        System.out.println("all_job_titles = " + all_job_titles);
    }

    @Test
    public void testJobsWithQueryParam() {
        Response response = given()
                    .log().all()
                    .queryParam("limit", 5)
                .when()
                    .get("jobs");

        int response_count = response.path("count");
        assertEquals(5, response_count);
    }

    @Test
    public void testSingleJobWithParam() {
        Response response = given()
                    .log().all()
                    .pathParam("job_id", "AD_VP")
                .when()
                    .get("jobs/{job_id}");

        String actual_job_title = response.path("job_title");

        assertEquals("Administration Vice President", actual_job_title);
    }
}
