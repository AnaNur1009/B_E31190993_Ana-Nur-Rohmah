package com.banenos.labs.ptaniapp.model;

public class Product {
    String id;
    String categoryId;
    String title;
    String description;
    String attribute;
    String currency;
    String price;
    String discount;
    String image;

    public Product(String id, String categoryId, String title, String description, String attribute, String currency, String price, String discount, String image) {
        this.id = id;
        this.categoryId = categoryId;
        this.title = title;
        this.description = description;
        this.attribute = attribute;
        this.currency = currency;
        this.price = price;
        this.discount = discount;
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public String getAttribute() {
        return attribute;
    }

    public String getPrice() {
        return price;
    }

    public String getDiscount() {
        return discount;
    }

    public String getImage() {
        return image;
    }

    public String getCurrency() {
        return currency;
    }

}
