package com.yikezhong.demo.api;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by xxsj on 2017/11/8.
 */

public interface RegisterApi {
    @FormUrlEncoded
    @POST("user/addUser")
    Observable<ResponseBody> register(@Field("userName") String userName, @Field("userPassword") String userPassword, @Field("userPhone") String userPhone, @Field("userSex") String userSex);



}
