package com.bpd.shopCart.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {

    public void startTheActivity(Class cls, Bundle bundle, Boolean closePrevious){
        Intent intent = new Intent(this,cls);

        if (bundle != null) {
            intent.putExtras(bundle);
        }
//        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);

        startActivity(intent);

    }

    public void startTheActivity(Class cls) {
        startTheActivity(cls,null,false);
    }

    public void startTheActivity(Class cls, Bundle bundle){
        startTheActivity(cls,bundle,false);
    }

//    public void startTheActivity(Class cls, Boolean closePrevious){
//        startTheActivity(cls,null,closePrevious);
//    }

    public void popUp(String m) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setPositiveButton("OK", null);
        builder.setMessage(m);
        builder.show();
    }


}
