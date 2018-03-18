package com.bpd.shopCart.model;

public class Product {

    private int id;
    private String name;
    private String unit;
    private int unitQuantity;
    private int price;
    private int quantity;

    public Product(int id, String name, String unit, int unitQuantity, int price) {
        this.id = id;
        this.name = name;
        this.unit = unit;
        this.unitQuantity = unitQuantity;
        this.price = price;


    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUnit() {
        return unit;
    }

    public int getUnitQuantity() {
        return unitQuantity;
    }

    public int getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public void setUnitQuantity(int unitQuantity) {
        this.unitQuantity = unitQuantity;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

}
