package com.bpd.shopCart.model;

import android.content.Context;

import com.bpd.shopCart.utils.StoreData;

import java.util.ArrayList;

public class Cart {

    public static Cart c;
    private ArrayList<Product> products = new ArrayList<>();
    private int totalPrice;
    private int totalTransport;
    private int totalPayment;
    private int quantity;
    private int over1000;

    public int getOver1000() {
        return over1000;
    }

    public void setOver1000(int over1000) {
        this.over1000 = over1000;
    }



    public int getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    private int totalQuantity;

    public void setTotalTransport(int totalTransport) {
        this.totalTransport = totalTransport;
    }

    public void setTotalPayment(int totalPayment) {
        this.totalPayment = totalPayment;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }



    public int getTotalTransport() {
        return totalTransport;
    }

    public int getTotalPayment() {
        return totalPayment;
    }

    public int getQuantity() {
        return quantity;
    }



    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }



    public static void cartInit(Context context) {
        if (c == null) {
            c = new Cart();
        }
    }


    public void
    addProduct(Product product) {
            products.add(product);
            StoreData.s.saveProductToCart(products);

    }

    public ArrayList<Product> getProducts() {
        return StoreData.s.retrieveProductFromCart();
    }


}
