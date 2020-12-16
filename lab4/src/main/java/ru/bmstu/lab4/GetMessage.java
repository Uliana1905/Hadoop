package ru.bmstu.lab4;

import java.util.ArrayList;

public class GetMessage {
    private String packageId;
    private  ArrayList<String> result;

    public GetMessage (String packageId, ArrayList<String>result){
        this.packageId = packageId;
        this.result = result;
    }

    public String getPackageId(){
        return packageId;
    }


}
