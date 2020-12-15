package ru.bmstu.lab4;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class ReceiveJSON {
    @JsonProperty("packageId")
    private final String packageId;
    @JsonProperty ("jsScript")
    private final String jsScript;
    @JsonProperty ("functionName")
    private final String functionName;
    @JsonProperty ("tests")
    private final ArrayLists<> tests;

    @JsonCreator
    public ReceiveJSON(@JsonProperty("packageId") String packageId,
                       @JsonProperty("jsScript") String jsScript,
                       @JsonProperty("functionName") String functionName,
                       @JsonProperty ("tests")ArrayList<> tests){
        this.packageId = packageId;
        this.functionName = functionName;
        this.jsScript = jsScript;
        this.tests = tests;

    }
    public String getPackageId(){
        return packageId;
    }
    public String getJsScript(){
        return jsScript;
    }
    public String getFunctionName(){
        return functionName;
    }

}
