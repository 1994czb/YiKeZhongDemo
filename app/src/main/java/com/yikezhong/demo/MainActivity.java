package com.yikezhong.demo;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private NavigationView mNavigationView;
    private DrawerLayout mDrawerLayout;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.mDrawerLayout);
        mNavigationView = (NavigationView) findViewById(R.id.navigation_view);
        imageView = (ImageView) findViewById(R.id.image);
        setNavigationViewItemClickListener();
        //点击图片打开侧滑菜单
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDrawerLayout.openDrawer(Gravity.LEFT);
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

                return false;
            }
        });
    }
}
