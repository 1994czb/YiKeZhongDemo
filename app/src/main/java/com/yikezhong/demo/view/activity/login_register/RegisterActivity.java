package com.yikezhong.demo.view.activity.login_register;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.yikezhong.demo.R;
import com.yikezhong.demo.presenter.RegisterPresenter;
import com.yikezhong.demo.view.RegisterView;

public class RegisterActivity extends AppCompatActivity implements RegisterView{

    private RegisterPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        presenter = new RegisterPresenter(this);
        presenter.register("李宁","123456","13521546653","女");

    }

    @Override
    public void RegisterSucceed() {
        Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void RegisterFail() {
        Toast.makeText(this, "注册失败", Toast.LENGTH_SHORT).show();
    }

    @Override
    public Context context() {
        return this;
    }
}
