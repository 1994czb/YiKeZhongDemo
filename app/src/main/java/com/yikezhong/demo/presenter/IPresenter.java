package com.yikezhong.demo.presenter;

import android.content.Context;

import com.yikezhong.demo.app.App;
import com.yikezhong.demo.view.IView;


/**
 * Created by xxsj on 2017/11/8.
 */

public class IPresenter <T extends IView>{

    protected T view;
    public IPresenter(T view){
        this.view = view;
        init();
    }

    protected void init() {

    }

    public Context context(){

        if (view!=null&&view.context()!=null){
            return view.context();
        }
        return App.context();
    }
}
