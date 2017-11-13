package com.yikezhong.demo.view.fragment.video;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yikezhong.demo.R;

/**
 * Created by Administrator on 2017/11/11.
 */
//// // TODO: 2017/11/11 视频页面的热门页面
public class Hot_VideoFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.hot_video_fragment,container,false);
        return view;
    }

}
