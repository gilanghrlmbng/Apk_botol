package com.depot_air.model;

import com.google.gson.annotations.SerializedName;

public class ResponseErrorModel {
    @SerializedName("error_msg")
    private String errorMsg;
    @SerializedName("id")
    private String id;
    @SerializedName("error")
    private boolean error;
    @SerializedName("username")
    private String username;
    public void setErrorMsg(String errorMsg){
        this.errorMsg = errorMsg;
    }
    public String getErrorMsg(){
        return errorMsg;
    }
    public void setId(String id){
        this.id = id;
    }
    public String getId(){
        return id;
    }
    public void setError(boolean error){
        this.error = error;
    }
    public boolean isError(){
        return error;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public String getUsername(){
        return username;
    }
}
