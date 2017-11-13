package com.yikezhong.demo.model.login;

import com.yikezhong.demo.api.LoginApi;
import com.yikezhong.demo.utils.RetrofitManager;

import io.reactivex.Observable;
import okhttp3.ResponseBody;

/**
 * Created by Administrator on 2017/10/9.
 */

public class LoginModle implements ILoginModle {

    @Override
    public Observable<ResponseBody> register(String userPassword, String userPhone) {
        return RetrofitManager.getDefault().create(LoginApi.class).login(userPassword,userPhone);
    }
}
