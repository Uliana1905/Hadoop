package ru.bmstu.lab4;

import java.util.ArrayList;

public class oneTest {
    private String packageId;
    private String jsScript;
    private String functionName;
    
    private ArrayList<String> params;

    public oneTest (String packageId,
             String jsScript,
            String functionName,
            ArrayList<String> params){
        this.packageId = packageId;
        this.jsScript =  jsScript;
        this.functionName = functionName;
        this.params = params;
    }
}
