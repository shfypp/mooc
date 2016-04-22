package cn.hophin.shfy.androidmooc;

import android.annotation.TargetApi;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cn.hophin.shfy.androidmooc.adapter.MyFragmentPagerAdapter;
import cn.hophin.shfy.androidmooc.fragment.ViewPagerFragment1;
import cn.hophin.shfy.androidmooc.fragment.ViewPagerFragment2;
import cn.hophin.shfy.androidmooc.fragment.ViewPagerFragment3;
import cn.hophin.shfy.androidmooc.fragment.ViewPagerFragment4;

public class ViewPager2Activity extends AppCompatActivity {
    private ViewPager viewPager;
    private PagerTabStrip pagerTabStrip;
    private List<Fragment> fragmentList;
    private List<String> titleList;

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager= (ViewPager) findViewById(R.id.view_pager2_views);

        String[] titles={
                "PageOne",
                "PageTwo",
                "PageThree",
                "PageFour"
        };
        titleList= Arrays.asList(titles);

        fragmentList =new ArrayList<Fragment>();
        fragmentList.add(new ViewPagerFragment1());
        fragmentList.add(new ViewPagerFragment2());
        fragmentList.add(new ViewPagerFragment3());
        fragmentList.add(new ViewPagerFragment4());

        viewPager= (ViewPager) findViewById(R.id.view_pager2_views);
        FragmentPagerAdapter adapter=new MyFragmentPagerAdapter(getSupportFragmentManager(),fragmentList,titleList);
        viewPager.setAdapter(adapter);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Toast.makeText(ViewPager2Activity.this,String.format("This is page %d!",position+1),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        pagerTabStrip = (PagerTabStrip) findViewById(R.id.pager_tab2);
        /**设置PagerTabStrip相关属性**/
        pagerTabStrip.setBackgroundColor(Color.GREEN);
        pagerTabStrip.setTextColor(Color.WHITE);
        //设置标题下面的长线是否显示
        pagerTabStrip.setDrawFullUnderline(false);
        //设置标题下面短线颜色
        pagerTabStrip.setTabIndicatorColor(Color.BLUE);


    }

}
