package com.yikezhong.demo.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.yikezhong.demo.R;

public class CrationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cration);
    }

    //点击取消按钮，回退到MainActivity中
    public void tv_back(View view) {
        Intent intent = new Intent(CrationActivity.this, MainActivity.class);
        startActivity(intent);
        finish();




    }
}
