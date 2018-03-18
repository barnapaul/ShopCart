package com.bpd.shopCart.controller;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bpd.shopCart.R;
import com.bpd.shopCart.model.Product;

import java.util.ArrayList;

public class ProductCustomArrayAdapter extends ArrayAdapter<Product> {

    private ArrayList<Product> productsList;
    private LayoutInflater layoutInflater;


    public ProductCustomArrayAdapter(Context context, ArrayList<Product> products) {
        super(context, R.layout.row, products);
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        productsList = products;
    }

    @Override
    public int getCount() {

        return productsList.size();
    }

    @Override
    public @NonNull
    View getView(int position, View convertView, @NonNull ViewGroup parent) {
        LinearLayout linearLayout = null;
        if (convertView == null) {

            convertView = layoutInflater.inflate(R.layout.row, parent, false);
            linearLayout = (LinearLayout) convertView;

            Product p = productsList.get(position);

            TextView productName = new TextView(getContext());
            productName.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            productName.setGravity(Gravity.CENTER);
            productName.setTextSize(30);
            productName.setText(p.getName());
            linearLayout.addView(productName);


//            convertView.setBackgroundResource(R.drawable.shape);
        }

        return convertView;
    }

    public void setProduct(ArrayList<Product> products) {
        this.productsList = products;
    }

}

