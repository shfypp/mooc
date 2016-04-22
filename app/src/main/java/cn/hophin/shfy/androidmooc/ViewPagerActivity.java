package cn.hophin.shfy.androidmooc;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cn.hophin.shfy.androidmooc.adapter.MyPagerAdapter;

public class ViewPagerActivity extends AppCompatActivity {
    private List<View> viewList;
    private List<String> titleList;
    private ViewPager viewPager;
    private PagerTabStrip pagerTabStrip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewList=new ArrayList<View>();
        viewList.add(View.inflate(this, R.layout.pager_view_1, null));
        viewList.add(View.inflate(this, R.layout.pager_view_2, null));
        viewList.add(View.inflate(this, R.layout.pager_view_3, null));
        viewList.add(View.inflate(this, R.layout.pager_view_4, null));

        String[] titles={
                "PageOne",
                "PageTwo",
                "PageThree",
                "PageFour"
        };
        titleList= Arrays.asList(titles);

        pagerTabStrip= (PagerTabStrip) findViewById(R.id.pager_tab);
        /**设置PagerTabStrip相关属性**/
        pagerTabStrip.setBackgroundColor(Color.GREEN);
        pagerTabStrip.setTextColor(Color.WHITE);
        //设置标题下面的长线是否显示
        pagerTabStrip.setDrawFullUnderline(false);
        //设置标题下面短线颜色
        pagerTabStrip.setTabIndicatorColor(Color.BLUE);
        PagerAdapter pagerAdapter=new MyPagerAdapter(viewList,titleList);

        viewPager= (ViewPager) findViewById(R.id.view_pager_views);
        viewPager.setAdapter(pagerAdapter);

    }

}
