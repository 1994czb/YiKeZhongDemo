package com.yikezhong.demo.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/11/10.
 */

public class MyViewpagerAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> list;
    private Context context;

    public MyViewpagerAdapter(FragmentManager fm, ArrayList<Fragment> list, Context context) {
        super(fm);
        this.list = list;
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size() > 0 ? list.size() : 0;
    }

    //这里注释,防止fragment数据丢失
    @Override
    public void destroyItem(View container, int position, Object object) {
//        super.destroyItem(container, position, object);
    }
}
