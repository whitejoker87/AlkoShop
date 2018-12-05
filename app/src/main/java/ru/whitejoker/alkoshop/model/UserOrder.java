package ru.whitejoker.alkoshop.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class UserOrder implements Serializable {

    private long id;
    private String date;
    @SerializedName("order_rows")
    private List<UserOrderItem> items;
    @SerializedName("skidka")
    private int discount;
    @SerializedName("dostavka")
    private int delivery;
    private int payed;
    private String status;
    @SerializedName("skidka_rub")
    private int discountRub;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<UserOrderItem> getItems() {
        return items;
    }

    public void setItems(List<UserOrderItem> items) {
        this.items = items;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getDelivery() {
        return delivery;
    }

    public void setDelivery(int delivery) {
        this.delivery = delivery;
    }

    public int getPayed() {
        return payed;
    }

    public void setPayed(int payed) {
        this.payed = payed;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getDiscountRub() {
        return discountRub;
    }

    public void setDiscountRub(int discountRub) {
        this.discountRub = discountRub;
    }
}
