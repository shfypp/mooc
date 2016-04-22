package cn.hophin.shfy.androidmooc.adapter;

import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Administrator on 2016/4/21.
 */
public class MyPagerAdapter extends android.support.v4.view.PagerAdapter {

    private List<View> viewList;
    private List<String> titleList;

    public MyPagerAdapter(List<View> viewList, List<String> titleList) {
        this.viewList = viewList;
        this.titleList=titleList;
    }

    @Override
    public int getCount() {
        return viewList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(viewList.get(position));
        return viewList.get(position);
//        return super.instantiateItem(container, position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(viewList.get(position));
//        super.destroyItem(container, position, object);
    }

    @Override
    public CharSequence getPageTitle(int position) {
     return titleList.get(position);
    }
}
