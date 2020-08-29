package com.shangjia.java_day_02;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.shangjia.java_day_02.inject.IntentExtra;
import com.shangjia.java_day_02.inject.IntentExtraUtils;

/**
 * Create: 2020/8/29 11:14
 * <p>
 * Description:
 */
public class TextActivity extends AppCompatActivity {

    @IntentExtra("name")
    private String name;
    @IntentExtra("sex")
    private boolean sex;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        IntentExtraUtils.initIntentExtra(this);

        Log.e(this.getClass().getName(), this.name);
        Log.e(this.getClass().getName(), this.sex + "");
    }
}
