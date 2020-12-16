package ru.bmstu.lab4;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class ContentTests {
    @JsonProperty("testName") private final String testName;
    @JsonProperty ("expectedResult") private final String expectedResult;
    @JsonProperty ("params") private final ArrayList<String> params;

    public ContentTests (
            @JsonProperty("testName") String testName,
            @JsonProperty ("expectedResult") String expectedResult,
            @JsonProperty ("params") ArrayList<String> params){
        this.testName = testName;
        this.expectedResult = expectedResult;
        this.params = params;
    }

    public String getTestName(){
        return testName;
    }
    public String getExpectedResult(){
        return expectedResult;
    }

    public ArrayList<String> getParams(){
        return params;
    }





}
