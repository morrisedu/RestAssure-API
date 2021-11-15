package com.cydeo.utility;

import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class BrowserUtil {
    /**
       * Waiting for a number of seconds with handling excpetion
        @param seconds seconds
     */

    public static void waitFor(int seconds) {
        try {
            Thread.sleep( (long) seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method to get text from a list of web elements
     * @param webelements list of WebElements
     * @return Texts from WebElements
     */
    public static List<String> getTextFromWebElements(List<WebElement> webelements) {
        return webelements.stream().map(WebElement::getText).collect(Collectors.toList());
    }
}
