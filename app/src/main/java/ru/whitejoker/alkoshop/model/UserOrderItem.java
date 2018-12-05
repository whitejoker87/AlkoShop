package ru.whitejoker.alkoshop.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class UserOrderItem implements Serializable {
    public UserOrderItem() {
    }

    private long id;
    private String name;
    private int price;
    @SerializedName("kol")
    private int count;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
