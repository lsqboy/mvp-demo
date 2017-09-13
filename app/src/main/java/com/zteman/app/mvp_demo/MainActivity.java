package com.zteman.app.mvp_demo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.zteman.app.mvp_demo.model.AccountModel;

public class MainActivity extends AppCompatActivity {

    private static final String EXTRA_ACCOUNT_MODEL = "EXTRA_ACCOUNT_MODEL";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public static void actionMain(Context context, AccountModel accountModel) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra(EXTRA_ACCOUNT_MODEL, accountModel);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        context.startActivity(intent);
    }
}
