package com.yikezhong.demo.view.activity.login_register;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.yikezhong.demo.R;

public class MoreLogInActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_log_in);
    }

    //点击返回主Activity中
    public void more_login_back(View view) {
        finish();
    }

    //点击跳转到其他登录方式页面
    public void other_login(View view) {
        startActivity(new Intent(MoreLogInActivity.this, OtherLogInActivity.class));
    }
}
