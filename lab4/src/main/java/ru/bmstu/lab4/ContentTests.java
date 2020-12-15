package ru.bmstu.lab4;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ContentTests {
    @JsonProperty("testName") private final String testName;
    @JsonProperty ("expectedResult") private final String expectedResult;
    @JsonProperty ("params") private final ArrayList 
}
