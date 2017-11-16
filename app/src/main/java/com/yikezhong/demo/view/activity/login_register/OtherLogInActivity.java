package com.yikezhong.demo.view.activity.login_register;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.yikezhong.demo.R;
import com.yikezhong.demo.presenter.login.LoginPresenter;
import com.yikezhong.demo.view.LoginView;

import java.util.regex.Pattern;

public class OtherLogInActivity extends AppCompatActivity implements LoginView, View.OnClickListener {

    private LoginPresenter presenter;
    private EditText edit_login_activity_username;
    private EditText edit_login_activity_password;
    private Button btn_login_activity_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_log_in);
        //找控件
        initView();
        presenter = new LoginPresenter(this);
        //presenter.login("123456", "13521546653");
    }

    //点击返回更多登录方式页面
    public void btn_other_back(View view) {

        finish();
    }

    //点击跳转到注册页面
    public void btn_register(View view) {
        startActivity(new Intent(OtherLogInActivity.this, RegisterActivity.class));

    }


    //// // TODO: 2017/11/16 找到控件
    private void initView() {
        edit_login_activity_username = (EditText) findViewById(R.id.edit_login_activity_username);
        edit_login_activity_password = (EditText) findViewById(R.id.edit_login_activity_password);
        btn_login_activity_login = (Button) findViewById(R.id.btn_login_activity_login);

        btn_login_activity_login.setOnClickListener(this);
    }

    /**
     * 判断手机格式 是否正确的方法
     */
    public static boolean isMobileNO(String mobiles) {
    /*
    移动：134、135、136、137、138、139、150、151、157(TD)、158、159、187、188
    联通：130、131、132、152、155、156、185、186
    电信：133、153、180、189、（1349卫通）
    总结起来就是第一位必定为1，第二位必定为3或5或8，其他位置的可以为0-9
    */
        String telRegex = "[1][358]\\d{9}";//"[1]"代表第1位为数字1，"[358]"代表第二位可以为3、5、8中的一个，"\\d{9}"代表后面是可以是0～9的数字，有9位。
        if (TextUtils.isEmpty(mobiles)){
            return false;
        }
        else{
            //return telRegex.matches(mobiles);
            return Pattern.matches(telRegex,mobiles);
        }
    }

    //// // TODO: 2017/11/16 判断登录逻辑的方法
    private void setLogin() {
        String username = edit_login_activity_username.getText().toString();
        String password = edit_login_activity_password.getText().toString();
        if (TextUtils.isEmpty(username)) {
            Toast.makeText(this, "账号不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        //判断手机号格式是否正确
        if (isMobileNO(username)) {

        } else {
            Toast.makeText(this, "账号格式不正确", Toast.LENGTH_SHORT).show();
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "密码不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        presenter.login(password, username);
    }

    //// // TODO: 2017/11/16 登录按钮点击事件
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login_activity_login:
                setLogin();
                break;
        }
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
