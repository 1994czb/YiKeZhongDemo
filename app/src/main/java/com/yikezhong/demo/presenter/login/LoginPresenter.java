package com.yikezhong.demo.presenter.login;

import android.util.Log;


import com.yikezhong.demo.model.login.LoginModle;
import com.yikezhong.demo.presenter.IPresenter;
import com.yikezhong.demo.view.LoginView;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

/**
 * Created by Administrator on 2017/10/9.
 */

public class LoginPresenter extends IPresenter<LoginView> {

    private static final String TAG = "TAG";
    private LoginModle mRegisterModle;

    public LoginPresenter(LoginView view) {
        super(view);
    }

    @Override
    protected void init() {
        super.init();
        mRegisterModle = new LoginModle();
    }

    public void login(String userPassword, String userPhone){
        Observable<ResponseBody> responseBodyObservable = mRegisterModle.register(userPassword,userPhone);
        responseBodyObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ResponseBody>() {
                    @Override
                    public void accept(ResponseBody responseBody) throws Exception {
                        Log.e(TAG, "accept: "+responseBody);
                        if (view!=null){
                            view.LoginSucceed();
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.e(TAG, "accept: "+throwable );
                        if (view!=null){
                            view.LoginFail();
                        }
                    }
                });
    }

}
