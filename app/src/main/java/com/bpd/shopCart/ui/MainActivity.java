package com.bpd.shopCart.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.bpd.shopCart.controller.BaseActivity;
import com.bpd.shopCart.R;
import com.bpd.shopCart.model.Cart;
import com.bpd.shopCart.utils.StoreData;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    Button showProductList;
    Button showCart;
    Button checkout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Cart.cartInit(this);
        StoreData.init(this);
        init();
    }


    public void init() {
        showProductList = findViewById(R.id.showProductList);
        showCart = findViewById(R.id.showCart);
        checkout = findViewById(R.id.checkout);

        showProductList.setOnClickListener(this);
        showCart.setOnClickListener(this);
        checkout.setOnClickListener(this);

    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.showProductList:
                startTheActivity(ShowProductsListActivity.class);
                break;
            case R.id.showCart:
                showCartMsg();
                break;
            case R.id.checkout:
                checkoutMsg();
        }
    }

    public void checkoutMsg() {

        if (Cart.c.getTotalPayment() == 0) {
            popUp("Adauga un produs in cos");
        } else {
            popUp("Comanda dvs in valoare totala de " + Cart.c.getTotalPayment() + " (din care "
                    + Cart.c.getTotalPrice() + " produse si "
                    + Cart.c.getTotalTransport() + " valoare transport)");
        }
    }

    public void showCartMsg() {
        if (Cart.c.getProducts().isEmpty() || Cart.c.getTotalPayment() == 0) {
            popUp(getResources().getString(R.string.emptyCart));

        } else {
            startTheActivity(ShowCartActivity.class);
        }
    }


}

