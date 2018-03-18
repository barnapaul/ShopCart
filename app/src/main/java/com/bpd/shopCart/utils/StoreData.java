package com.bpd.shopCart.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.bpd.shopCart.model.Product;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class StoreData {

    private static SharedPreferences.Editor editor;
    private static SharedPreferences sharedPref;

    public static StoreData s;

    private final static String PREFS_NAME = "shop";
    private final static String PRODUCT = "product";
    private final static String PRODUCT_CART = "product_carts";
    private final static String PRODUCT_ID = "product_id";

    public static void init(Context context) {

        if (s == null) {

            sharedPref = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
            editor = sharedPref.edit();
            editor.apply();
            s = new StoreData();
        }

    }

    public ArrayList<Product> retrieveProduct() {
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Product>>() {
        }.getType();
        ArrayList<Product> products = gson.fromJson(sharedPref.getString(PRODUCT, null), type);
        return products == null ? new ArrayList<Product>() : products;
    }

    public void saveProduct(ArrayList<Product> products) {
        Gson gson = new Gson();
        String json = gson.toJson(products);
        editor.putString(PRODUCT, json);
        editor.apply();
    }

    public ArrayList<Product> retrieveProductFromCart() {
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Product>>() {
        }.getType();
        ArrayList<Product> products = gson.fromJson(sharedPref.getString(PRODUCT_CART, null), type);
        return products == null ? new ArrayList<Product>() : products;
    }

    public void saveProductToCart(ArrayList<Product> products) {
        Gson gson = new Gson();
        String json = gson.toJson(products);
        editor.putString(PRODUCT_CART, json);
        editor.apply();
    }

    public void clearAllProductsFromCart(){
        sharedPref.edit().remove(PRODUCT_CART).apply();
    }

    public boolean productIdExistInCart(int id) {
        boolean valid = false;
        ArrayList<Product> product = StoreData.s.retrieveProductFromCart();

        if (product.size() != 0) {
            for (int i=0; i<product.size(); i++){
                if (product.get(i).getId() == id){
                    valid = true;
                    break;
                }else {
                    valid = false;
                }
            }
            return valid;
        }
        else {
            return false;
        }
    }

}
