package ru.whitejoker.alkoshop.model;

import com.google.gson.Gson;

import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class UserOrdersResponse {

    private int status;
    private List<UserOrder> data = new ArrayList<>();

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<UserOrder> getData() {
        return data;
    }

    public void setData(List<UserOrder> data) {
        this.data = data;
    }

    public static UserOrdersResponse fromJson(Reader json){
        try{
            return new Gson().fromJson(json, UserOrdersResponse.class);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
