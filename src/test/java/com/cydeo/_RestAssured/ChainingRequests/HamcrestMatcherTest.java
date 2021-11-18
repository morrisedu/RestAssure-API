package com.cydeo._RestAssured.ChainingRequests;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class HamcrestMatcherTest {
    /*
        Hamcrest id a matccher
     */

    @Test
    public void testNumber() {
        assertThat(4 + 6, is(10));
    }

    @Test
    public void testString() {
        String msg = "Hello world";
        assertThat(msg, is("Hello world"));
        assertThat(msg, equalTo("Hello world"));

        assertThat(msg, startsWith("Hello"));
        assertThat(msg, startsWithIgnoringCase("hello"));

        // Check if msg is blank
        assertThat(msg, not(blankOrNullString()));
    }

    @Test
    public void testCollections() {
        List<Integer> nums = Arrays.asList(7, 21, 19, 9, 558, 26, 51);

        // Check if List has a size of 6
        assertThat(nums, hasSize(6));

        // Check if list has item 77
        assertThat(nums, hasItem(77));

        // Check if List has item 5, 44
        assertThat(nums, hasItems(5, 44));

        // Check if every item in the List is greater than 0
        assertThat(nums, everyItem(greaterThan(0)));


        // Check if List has items greater than 50
        assertThat(nums, hasItems(greaterThan(50)));

    }
}
