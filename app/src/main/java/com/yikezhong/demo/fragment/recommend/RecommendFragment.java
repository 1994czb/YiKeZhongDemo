package com.yikezhong.demo.fragment.recommend;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yikezhong.demo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/11/10.
 */
//// // TODO: 2017/11/10 推荐页面
public class RecommendFragment extends Fragment {
    private View view;
    private TabLayout tablayout;
    private ViewPager viewpager;
    private List<Fragment> list;
    private String[] title = {"热门", "关注"};
    private MyAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = View.inflate(getContext(), R.layout.recommend, null);
        initView();



        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        adapter = new MyAdapter(getChildFragmentManager());
        viewpager.setAdapter(adapter);
        tablayout.setupWithViewPager(viewpager);
    }

    private void initView() {
        tablayout = (TabLayout) view.findViewById(R.id.tablayout);
        viewpager = (ViewPager) view.findViewById(R.id.viewpager);

        list = new ArrayList<>();
        list.add(new HotFragment());
        list.add(new AttentionFragment());

    }

    public class MyAdapter extends FragmentPagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return list.get(position);
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            //super.destroyItem(container, position, object);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return title[position];
        }
    }
}
