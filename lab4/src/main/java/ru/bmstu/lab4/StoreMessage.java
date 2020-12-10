package ru.bmstu.lab4;

public class StoreMessage {
    private String packageId;
    private String testName;
    private String result;

    public StoreMessage (String packageId, String testName, String result){
        this.packageId = packageId;
        this.result = result;
        this.testName = testName;
    }

    public String getPackageId(){
        return packageId;
    }

    public String getTestName(){
        return testName;
    }

    public String getResult(){
        return result;
    }
}
