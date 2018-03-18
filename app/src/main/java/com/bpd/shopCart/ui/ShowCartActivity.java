package com.bpd.shopCart.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.bpd.shopCart.R;
import com.bpd.shopCart.controller.BaseActivity;
import com.bpd.shopCart.model.Cart;
import com.bpd.shopCart.utils.StoreData;

public class ShowCartActivity extends BaseActivity {

    Button checkout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_cart);

        checkout = findViewById(R.id.checkout);

        initTableAndTextViews();

    }


    public void initTableAndTextViews() {
        TableLayout datasProductsTable = (TableLayout) findViewById(R.id.datasProductTable);

        TableRow tbrow0 = new TableRow(this);
        TextView tv0 = new TextView(this);
        tv0.setText(getResources().getString(R.string.itemId));
        tv0.setTextColor(Color.WHITE);
        tv0.setTextSize(getResources().getDimension(R.dimen.txtTableTitle));
        tbrow0.addView(tv0);
        TextView tv1 = new TextView(this);
        tv1.setText(getResources().getString(R.string.name));
        tv1.setTextColor(Color.WHITE);
        tv1.setTextSize(getResources().getDimension(R.dimen.txtTableTitle));
        tbrow0.addView(tv1);
        TextView tv2 = new TextView(this);
        tv2.setText(getResources().getString(R.string.quantity));
        tv2.setTextColor(Color.WHITE);
        tv2.setTextSize(getResources().getDimension(R.dimen.txtTableTitle));
        tbrow0.addView(tv2);
        TextView tv3 = new TextView(this);
        tv3.setText(getResources().getString(R.string.price));
        tv3.setTextColor(Color.WHITE);
        tv3.setTextSize(getResources().getDimension(R.dimen.txtTableTitle));
        tbrow0.addView(tv3);
        datasProductsTable.addView(tbrow0);
        for (int i = 0; i < Cart.c.getProducts().size(); i++) {
            TableRow blanktable = new TableRow(this);
            TextView blankTv = new TextView(this);
            blankTv.setText("");
            blanktable.addView(blankTv);

            TableRow cartTable = new TableRow(this);
            TextView id = new TextView(this);
            id.setText(String.valueOf(Cart.c.getProducts().get(i).getId()));
            id.setTextColor(Color.WHITE);
            id.setGravity(Gravity.CENTER);
            id.setTextSize(getResources().getDimension(R.dimen.txtTable));
            cartTable.addView(id);
            TextView productName = new TextView(this);
            productName.setText(Cart.c.getProducts().get(i).getName());
            productName.setTextColor(Color.WHITE);
            productName.setGravity(Gravity.CENTER);
            productName.setTextSize(getResources().getDimension(R.dimen.txtTable));
            cartTable.addView(productName);
            TextView quantity = new TextView(this);
            quantity.setText(String.valueOf(Cart.c.getProducts().get(i).getQuantity()));
            quantity.setTextColor(Color.WHITE);
            quantity.setGravity(Gravity.CENTER);
            quantity.setTextSize(getResources().getDimension(R.dimen.txtTable));
            cartTable.addView(quantity);
            TextView price = new TextView(this);
            price.setText(String.valueOf(Cart.c.getProducts().get(i).getPrice()));
            price.setTextColor(Color.WHITE);
            price.setGravity(Gravity.CENTER);
            price.setTextSize(getResources().getDimension(R.dimen.txtTable));
            cartTable.addView(price);
            datasProductsTable.addView(cartTable);
            datasProductsTable.addView(blanktable);
        }
        TableRow totalValueTable = new TableRow(this);
        TextView totalPrice = new TextView(this);
        totalPrice.setText(getResources().getString(R.string.price));
        totalPrice.setTextColor(Color.WHITE);
        totalPrice.setTextSize(getResources().getDimension(R.dimen.txtTableTitle));
        totalPrice.setText(getResources().getString(R.string.totalPrice) + ": " + String.valueOf(Cart.c.getTotalPrice() + " "));
        totalValueTable.addView(totalPrice);
        TextView totalTransport = new TextView(this);
        totalTransport.setText(getResources().getString(R.string.price));
        totalTransport.setTextColor(Color.WHITE);
        totalTransport.setTextSize(getResources().getDimension(R.dimen.txtTableTitle));
        totalTransport.setText(getResources().getString(R.string.totalTransport) + ": " + String.valueOf(Cart.c.getTotalTransport()));
        totalValueTable.addView(totalTransport);
        TextView totalPaymanet = new TextView(this);
        totalPaymanet.setText(getResources().getString(R.string.price));
        totalPaymanet.setTextColor(Color.WHITE);
        totalPaymanet.setTextSize(getResources().getDimension(R.dimen.txtTableTitle));
        totalPaymanet.setText(getResources().getString(R.string.totalPayment) + ": " + String.valueOf(Cart.c.getTotalPayment()));
        totalValueTable.addView(totalPaymanet);
        datasProductsTable.addView(totalValueTable);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        StoreData.s.clearAllProductsFromCart();
    }
}
