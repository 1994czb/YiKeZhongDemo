package com.yikezhong.demo;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.yikezhong.demo.adapter.MyViewpagerAdapter;
import com.yikezhong.demo.custom.MyViewPager;
import com.yikezhong.demo.fragment.VideoFragment;
import com.yikezhong.demo.fragment.recommend.RecommendFragment;
import com.yikezhong.demo.fragment.Cross_talkFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private NavigationView mNavigationView;
    private DrawerLayout mDrawerLayout;
    private MyViewPager viewpager;
    private RadioGroup radioGroup;
    private ArrayList<Fragment> fragments;
    private RadioButton rb_fg_punch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        mDrawerLayout = (DrawerLayout) findViewById(R.id.mDrawerLayout);
        mNavigationView = (NavigationView) findViewById(R.id.navigation_view);
        setNavigationViewItemClickListener();

        //设置适配器
        viewpager.setAdapter(new MyViewpagerAdapter(getSupportFragmentManager(), fragments, this));
        radioFragment();

    }

    //radioButton点击事件
    private void radioFragment() {
        //设置RadioGroup中button的点击事件
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                int current = 0;
                switch (checkedId) {
                    case R.id.rb_fg_punch:
                        current = 0;
                        break;
                    case R.id.rb_fg_report:
                        current = 1;
                        break;
                    case R.id.rb_fg_msg:
                        current = 2;
                        break;
                }
                if (viewpager.getCurrentItem() != current) {
                    viewpager.setCurrentItem(current, false);
                }
            }
        });
    }

    //实现侧滑效果的方法
    private void setNavigationViewItemClickListener() {
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_item_home:
                        // mToolbar.setTitle("首页");
                        mNavigationView.getMenu().getItem(0).setTitle("首页");
                        //switchFragment("MainFragment");
                        break;
                    case R.id.navigation_item_blog:
                        // mToolbar.setTitle("我的博客");
                        //switchFragment("BlogFragment");
                        break;
                    case R.id.navigation_item_about:
                        //mToolbar.setTitle("关于");
                        //switchFragment("AboutFragment");
                        break;
                    default:
                        break;
                }
                item.setChecked(true);
                mDrawerLayout.setMinimumWidth(100);
                mDrawerLayout.closeDrawer(Gravity.LEFT);
                //打开侧滑菜单（可用来做点击打开侧滑菜单）
                //mDrawerLayout.openDrawer(Gravity.NO_GRAVITY);

                return false;
            }
        });
    }
    //找控件
    private void initView() {
        viewpager = (MyViewPager) findViewById(R.id.viewPager);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        rb_fg_punch = (RadioButton) findViewById(R.id.rb_fg_punch);
        fragments = new ArrayList<>();
        fragments.add(new RecommendFragment());
        fragments.add(new Cross_talkFragment());
        fragments.add(new VideoFragment());
    }
}
