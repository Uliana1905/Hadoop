package ru.lab5;

public class StoreResults {
    private String Url;
    private Integer result;

    public StoreResults(String url, Integer result){
        this.Url = url;
        this.result = result;
    }

    public String getUrl(){
        return Url;
    }

    public Integer getResult(){
        return result;
    }
}
