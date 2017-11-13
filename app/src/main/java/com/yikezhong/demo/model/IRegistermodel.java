package com.yikezhong.demo.model;

import io.reactivex.Observable;
import okhttp3.ResponseBody;

/**
 * Created by xxsj on 2017/11/8.
 */

public interface IRegistermodel {

    Observable<ResponseBody> login(String userName, String userPassword, String userPhone, String userSex);
}
