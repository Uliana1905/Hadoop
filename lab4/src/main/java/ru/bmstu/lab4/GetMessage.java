package ru.bmstu.lab4;

public class GetMessage {
    private String packageId;
    private String testName;
    private String result;

    public GetMessage (String packageId, String testName, String result){
        this.packageId = packageId;
        this.result = result;
        this.testName = testName;
    }

    public String getPackageId(){
        return packageId;
    }


}
