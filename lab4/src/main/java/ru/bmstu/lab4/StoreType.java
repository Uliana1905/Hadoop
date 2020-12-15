package ru.bmstu.lab4;

import java.util.ArrayList;
import java.util.Map;

public class StoreType {
    private ArrayList<String> value;
    private String key;

    public String getKey(){
        return key;
    }

    public ArrayList getValue(){
        return value;
    }

    public StoreType (String key, ArrayList<String> value ){
        this.key = key;
        this.value = value;
    }


}