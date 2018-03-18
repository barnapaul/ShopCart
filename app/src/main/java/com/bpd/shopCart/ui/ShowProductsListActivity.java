package com.bpd.shopCart.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.bpd.shopCart.utils.StoreData;

import com.bpd.shopCart.R;
import com.bpd.shopCart.controller.BaseActivity;
import com.bpd.shopCart.controller.ProductCustomArrayAdapter;
import com.bpd.shopCart.model.Product;

import java.util.ArrayList;

public class ShowProductsListActivity extends BaseActivity {

    ProductCustomArrayAdapter adapter;
    ListView listView;
    ArrayList<Product> products;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_products_list);

        listView = findViewById(R.id.listView);

        setProducts();

        StoreData.s.saveProduct(products);

        onShowStudents(products);

    }


    public void onShowStudents(ArrayList<Product> products) {
        if (adapter == null) {
            adapter = new ProductCustomArrayAdapter(this, products);
//            dismissLoading();
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Product product = (Product) listView.getItemAtPosition(position);
                    Bundle b = new Bundle();
                    b.putString("ID_PRODUCT", String.valueOf(product.getId()));

                    startTheActivity(DetailedProductListAddActivity.class, b);

                }
            });

            listView.setAdapter(adapter);
        } else {
            adapter.setProduct(products);
            adapter.notifyDataSetChanged();
        }
    }

    public void setProducts(){
        products = new ArrayList<>();

        products.add( new Product(0,"Cafea boabe 250g","g",250,20));
        products.add(new Product(1,"Cafea boabe 500g","g",500,35));
        products.add(new Product(2,"Cafea boabe 1kg","g",1000,50));
        products.add(new Product(3,"Sirop Caramel","buc",1,12));
        products.add(new Product(4,"Suc","buc",1,14));
        products.add(new Product(5,"Cana Cafea","buc",1,15));
        products.add(new Product(6  ,"Bax Cafea","buc",12,600));



    }

}
