package com.banenos.labs.ptaniapp.model;

public class Order {
    String id;
    String orderId;
    String date;
    String total;
    String status;


    public Order(String id, String orderId, String date, String total, String status) {
        this.id = id;
        this.orderId = orderId;
        this.date = date;
        this.total = total;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getDate() {
        return date;
    }

    public String getTotal() {
        return total;
    }

    public String getStatus() {
        return status;
    }

}
