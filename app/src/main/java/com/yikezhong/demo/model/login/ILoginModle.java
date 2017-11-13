package com.yikezhong.demo.model.login;

import io.reactivex.Observable;
import okhttp3.ResponseBody;

/**
 * Created by Administrator on 2017/10/9.
 */

public interface ILoginModle {

    Observable<ResponseBody> register(String userPassword, String userPhone);

}
