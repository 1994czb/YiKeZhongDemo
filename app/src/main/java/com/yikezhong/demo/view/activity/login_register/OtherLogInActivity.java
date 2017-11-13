package com.yikezhong.demo.view.activity.login_register;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.yikezhong.demo.R;
import com.yikezhong.demo.presenter.login.LoginPresenter;
import com.yikezhong.demo.view.LoginView;

public class OtherLogInActivity extends AppCompatActivity implements LoginView{

    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_log_in);
        presenter = new LoginPresenter(this);
        presenter.login("123456", "13521546653");
    }

    //点击返回更多登录方式页面
    public void btn_other_back(View view) {

        finish();
    }

    //点击跳转到注册页面
    public void btn_register(View view) {
        startActivity(new Intent(OtherLogInActivity.this, RegisterActivity.class));

    }


    @Override
    public void LoginSucceed() {
        Toast.makeText(OtherLogInActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void LoginFail() {
        Toast.makeText(OtherLogInActivity.this, "登录失败", Toast.LENGTH_SHORT).show();
    }

    @Override
    public Context context() {
        return this;
    }
}
