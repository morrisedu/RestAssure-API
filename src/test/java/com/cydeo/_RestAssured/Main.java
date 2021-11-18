package com.cydeo._RestAssured;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> items = new ArrayList<>(Arrays.asList("Banana", "Mango", "Banana", "Apple"));

        items.removeIf(p -> Collections.frequency(items, p) > 1);

        System.out.println("items = " + items);
    }
}
