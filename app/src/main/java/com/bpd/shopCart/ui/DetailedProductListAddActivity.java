package com.bpd.shopCart.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.bpd.shopCart.R;
import com.bpd.shopCart.controller.BaseActivity;
import com.bpd.shopCart.model.Cart;
import com.bpd.shopCart.model.Product;
import com.bpd.shopCart.utils.StoreData;

import java.util.ArrayList;

public class DetailedProductListAddActivity extends BaseActivity {

    TextView itemId;
    TextView unit;
    TextView unitQuantity;
    TextView price;
    Button addToCart;

    Product p;

    int counterQuantity;
    int totalPrice;
    int countUnitQuantity;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_product_list_add);

        initControl();
        final ArrayList<Product> product = StoreData.s.retrieveProduct();

        Bundle b = getIntent().getExtras();
        assert b != null;
        final int id_product = Integer.parseInt(b.getString("ID_PRODUCT"));

        p = product.get(id_product);

        product.add(p);
        showTextViews();

        addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (StoreData.s.productIdExistInCart(id_product)) {

                    counterQuantity++;
                    p.setQuantity(counterQuantity);

                    int sum = counterQuantity * p.getPrice();
                    totalPrice = Cart.c.getTotalPrice() + sum - p.getPrice();
                    p.setPrice(sum);


                } else {
                    if (p.getQuantity() == 0) {
                        counterQuantity = 1;
                        p.setQuantity(counterQuantity);
                        totalPrice = Cart.c.getTotalPrice() + p.getPrice();
                    }

                    Cart.c.addProduct(p);

                }
                calculateTransport();
                Toast.makeText(DetailedProductListAddActivity.this, getResources().getString(R.string.itemAddedToCart), Toast.LENGTH_SHORT).show();

                Cart.c.setTotalPrice(totalPrice);
                Cart.c.setTotalPayment(Cart.c.getTotalPrice() + Cart.c.getTotalTransport());
//                startTheActivity(ShowCartActivity.class);
            }
        });


    }

    public void initControl() {
        itemId = findViewById(R.id.itemId);
        unit = findViewById(R.id.unit);
        unitQuantity = findViewById(R.id.unitQuantity);
        price = findViewById(R.id.price);

        addToCart = (Button) findViewById(R.id.addToCart);
    }

    public void showTextViews() {
        itemId.setText(getResources().getString(R.string.itemId) + " " + String.valueOf(p.getId()));
        unitQuantity.setText(getResources().getString(R.string.unitQuantity) + " " + String.valueOf(p.getUnitQuantity()));
        unit.setText(getResources().getString(R.string.unit) + " " + p.getUnit());
        price.setText(getResources().getString(R.string.price) + " " + String.valueOf(p.getPrice()));
    }

    public void calculateTransport() {

        if (Cart.c.getTotalTransport() == 0) {
            Cart.c.setOver1000(1000);
            Cart.c.setTotalTransport(12);
            countUnitQuantity = 0;

        }
        if (p.getUnit().equals("g")) {
            int totalQuantity = Cart.c.getTotalQuantity() + p.getUnitQuantity();
            Cart.c.setTotalQuantity(totalQuantity);
            if (Cart.c.getTotalQuantity() >= 1000) {

                if (Cart.c.getTotalQuantity() >= Cart.c.getOver1000()) {
                    int over1000 = Cart.c.getOver1000() +1000;
                    Cart.c.setOver1000(over1000); 

                    int transport = Cart.c.getTotalTransport() + 1;
                    Cart.c.setTotalTransport(transport);
                }
            }
        }
    }

}
