package com.yikezhong.demo.model;


import com.yikezhong.demo.api.RegisterApi;
import com.yikezhong.demo.utils.RetrofitManager;

import io.reactivex.Observable;
import okhttp3.ResponseBody;

/**
 * Created by xxsj on 2017/11/8.
 */

public class Registermodel implements IRegistermodel{


    @Override
    public Observable<ResponseBody> login(String userName, String userPassword, String userPhone, String userSex) {
        return RetrofitManager.getDefault().create(RegisterApi.class).register(userName, userPassword,userPhone, userSex);
    }
}
