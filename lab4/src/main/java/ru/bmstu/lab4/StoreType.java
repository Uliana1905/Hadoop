package ru.bmstu.lab4;

import java.util.Map;

public class StoreType {
    private Map<String, String> value;
    private String key;

    public String getKey(){
        return key;
    }

    public Map <String, String> getValue(){
        return value;
    }

    public StoreType (String key, Map<String, String> value ){
        this.key = key;
        this.value = value;
    }


}