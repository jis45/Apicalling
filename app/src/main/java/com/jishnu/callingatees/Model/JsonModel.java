package com.jishnu.callingatees.Model;

import com.google.gson.annotations.SerializedName;

public class JsonModel {

    @SerializedName("name")
    private String UserName;
    @SerializedName("email")
    private String Email;
    @SerializedName("password")
    private String Password;
    @SerializedName("status")
    private String Status;
    @SerializedName("Success")
    private String Success;

    public JsonModel(String userName, String email, String password) {
        UserName = userName;
        Email = email;
        Password = password;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getSuccess() {
        return Success;
    }

    public void setSuccess(String success) {
        Success = success;
    }
}
