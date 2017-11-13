package com.yikezhong.demo.presenter;


import com.yikezhong.demo.model.Registermodel;
import com.yikezhong.demo.view.RegisterView;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

/**
 * Created by xxsj on 2017/11/8.
 */

public class RegisterPresenter extends IPresenter<RegisterView>{

    private Registermodel registermodel;

    public RegisterPresenter(RegisterView view) {
        super(view);
    }

    @Override
    protected void init() {
        registermodel = new Registermodel();
    }

    //presenter利用model返回的被觀察者，用rejavva的形式處理請求結果
    public void register(String userName, String userPassword, String userPhone, String userSex){
        //model提供对应的被观察者
        final Observable<ResponseBody> register = registermodel.login(userName, userPassword, userPhone, userSex);
        //用rxjava的形式处理被观察者
        register
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ResponseBody>() {
                    @Override
                    public void accept(ResponseBody responseBody) throws Exception {
                        if (view != null) {
                          view.RegisterSucceed();
                        }

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        if (view!=null){
                            view.RegisterFail();
                        }
                    }
                });

    }
}
