package ru.bmstu.lab4;

public class MessageResult {
    private final String packageId;

    public MessageResult(String packageId){
        this.packageId= packageId;
    }

    public String getPackageId() {
        return packageId;
    }
}
