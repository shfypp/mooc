package cn.hophin.shfy.androidmooc.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.hophin.shfy.androidmooc.R;

/**
 * Created by Administrator on 2016/4/21.
 */
public class ViewPagerFragment1 extends Fragment{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.pager_view_1,container,false);
    }
}
