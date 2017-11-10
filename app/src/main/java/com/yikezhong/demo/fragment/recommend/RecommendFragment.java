package com.yikezhong.demo.fragment.recommend;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yikezhong.demo.R;

/**
 * Created by Administrator on 2017/11/10.
 */
//// // TODO: 2017/11/10 推荐页面
public class RecommendFragment extends Fragment {
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = View.inflate(getContext(), R.layout.recommend, null);

        return view;
    }

}
