package com.yikezhong.demo.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.yikezhong.demo.R;
import com.yikezhong.demo.adapter.MyViewpagerAdapter;
import com.yikezhong.demo.custom.MyViewPager;
import com.yikezhong.demo.custom.UiUtils;
import com.yikezhong.demo.view.activity.login_register.MoreLogInActivity;
import com.yikezhong.demo.view.activity.login_register.RegisterActivity;
import com.yikezhong.demo.view.fragment.cross_talk.Cross_talkFragment;
import com.yikezhong.demo.view.fragment.recommend.RecommendFragment;
import com.yikezhong.demo.view.fragment.video.VideoFragment;
import com.zcw.togglebutton.ToggleButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private NavigationView mNavigationView;
    private DrawerLayout mDrawerLayout;
    private MyViewPager viewpager;
    private RadioGroup radioGroup;
    private ArrayList<Fragment> fragments;
    private RadioButton rb_fg_punch;

    //标题栏
    private ImageView image_left;
    private TextView title;
    private ImageView image_right;
    private ToggleButton toggleBtn;
    private ImageView iv_day_naght;

    //设置日夜间模式
    private int theme = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //切换主题必须放在onCreate()之前
        if (savedInstanceState == null) {
            theme = UiUtils.getAppTheme(MainActivity.this);
        } else {
            theme = savedInstanceState.getInt("theme");
        }
        setTheme(theme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();


        //日夜间模式按钮
        toggleButton();
        //设置适配器
        viewpager.setAdapter(new MyViewpagerAdapter(getSupportFragmentManager(), fragments, this));
        //radioButton点击事件
        radioFragment();
        //点击左侧图片打开侧滑菜单
        image_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDrawerLayout.openDrawer(Gravity.LEFT);
            }
        });

        //点击右侧图片跳转到创作页面
        image_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, CrationActivity.class));


                finish();
            }
        });


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
                        title.setText("推荐");
                        break;
                    case R.id.rb_fg_report:
                        current = 1;
                        title.setText("段子");
                        break;
                    case R.id.rb_fg_msg:
                        current = 2;
                        title.setText("视频");
                        break;
                }
                if (viewpager.getCurrentItem() != current) {
                    viewpager.setCurrentItem(current, false);
                }
            }
        });
    }

    //实现侧滑效果的方法
    //http://blog.csdn.net/w1186859682/article/details/72049913
    //日夜间模式链接
    private void setNavigationViewItemClickListener() {
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_item_home:
                        // mToolbar.setTitle("首页");
                        mNavigationView.getMenu().getItem(0).setTitle("我的关注");
                        //switchFragment("MainFragment");
                        break;
                    case R.id.navigation_item_blog:
                        // mToolbar.setTitle("我的博客");
                        mNavigationView.getMenu().getItem(0).setTitle("我的收藏");
                        //switchFragment("BlogFragment");
                        break;
                    case R.id.navigation_item_about:
                        //mToolbar.setTitle("关于");
                        mNavigationView.getMenu().getItem(0).setTitle("搜索好友");
                        //switchFragment("AboutFragment");
                        break;

                    case R.id.navigation_item_tongzhi:
                        //mToolbar.setTitle("关于");
                        mNavigationView.getMenu().getItem(0).setTitle("消息通知");
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
        mDrawerLayout = (DrawerLayout) findViewById(R.id.mDrawerLayout);
        mNavigationView = (NavigationView) findViewById(R.id.navigation_view);
        setNavigationViewItemClickListener();
        image_right = (ImageView) findViewById(R.id.icon_right);
        image_left = (ImageView) findViewById(R.id.icon_left);
        title = (TextView) findViewById(R.id.title);
        viewpager = (MyViewPager) findViewById(R.id.viewPager);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        rb_fg_punch = (RadioButton) findViewById(R.id.rb_fg_punch);
        toggleBtn = (ToggleButton) findViewById(R.id.toggleBtn);
        //日夜间图片
        iv_day_naght = (ImageView) findViewById(R.id.iv_day_naght);


        fragments = new ArrayList<>();
        fragments.add(new RecommendFragment());
        fragments.add(new Cross_talkFragment());
        fragments.add(new VideoFragment());
        title.setText("推荐");
    }

    //日夜间模式按钮
    public void toggleButton() {
        //切换开关
        toggleBtn.toggle();
        //切换无动画
        toggleBtn.toggle(false);
        //开关切换事件
        toggleBtn.setOnToggleChanged(new ToggleButton.OnToggleChanged() {
            @Override
            public void onToggle(boolean on) {
                Toast.makeText(MainActivity.this, "点击了日夜间模式的按钮", Toast.LENGTH_SHORT).show();

                UiUtils.switchAppTheme(MainActivity.this);
                //跳转
                Intent intent = getIntent();
                overridePendingTransition(R.anim.activity_in, R.anim.activity_out);//进入动画
                finish();
                overridePendingTransition(R.anim.activity_in, R.anim.activity_out);
                startActivity(intent);
            }
        });

        toggleBtn.setToggleOn();
        toggleBtn.setToggleOff();

//        //无动画切换
//        toggleBtn.setToggleOn(false);
//        toggleBtn.setToggleOff(false);
//
//        //禁用动画
//        toggleBtn.setAnimate(false);

    }

    public void iv_logIn(View view) {

        startActivity(new Intent(MainActivity.this,RegisterActivity.class));
        finish();

    }

    public void iv_more_login(View view) {

        startActivity(new Intent(MainActivity.this, MoreLogInActivity.class));

    }
}
