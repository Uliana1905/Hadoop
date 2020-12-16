package ru.bmstu.lab4;

import java.util.ArrayList;

public class oneTest {
    private String packageId;
    private String jsScript;
    private String functionName;
    private String testName;
    private String expectedResult;
    private ArrayList<String> params;

    public oneTest (String packageId,
             String jsScript,
            String functionName,
            String testName,
            String expectedResult,
            ArrayList<String> params){
        this.packageId = packageId;
        this.jsScript =  jsScript;
        this.functionName = functionName;
        this.testName = testName;
        this.expectedResult = expectedResult;
        this.params = params;
    }

    public String getFunctionName() {
        return functionName;
    }

    public ArrayList<String> getParams() {
        return params;
    }

    public String getJsScript() {
        return jsScript;
    }
    public String getPackageId(){
        return packageId;
    }
}
