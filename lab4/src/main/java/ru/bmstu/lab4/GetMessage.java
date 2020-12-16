package ru.bmstu.lab4;

public class GetMessage {
    private String packageId;
    private String result;

    public GetMessage (String packageId, String result){
        this.packageId = packageId;
        this.result = result;
    }

    public String getPackageId(){
        return packageId;
    }


}
