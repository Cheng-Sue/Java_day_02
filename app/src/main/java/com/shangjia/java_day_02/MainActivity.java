package com.shangjia.java_day_02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onJoin(View view) {
        Intent intent = new Intent(this,TextActivity.class);
        intent.putExtra("name","张三");
        intent.putExtra("sex",true);
        startActivity(intent);
    }
}
