package cn.hophin.shfy.androidmooc;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class ViewFlipperActivity extends AppCompatActivity {
    private Context context;

    public ViewFlipperActivity() {
        this.context = this;
    }

    private ViewFlipper images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_flipper);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        images = (ViewFlipper) findViewById(R.id.images_view_flipper);

        images.addView(getImage(R.drawable.navigation_1));
        images.addView(getImage(R.drawable.navigation_2));


        //设定ViewFlipper视图切换时间间隔
        images.setFlipInterval(3000);
        //开始播放
        images.startFlipping();
    }

    private View getImage(int navigation_1) {
        ImageView imageView = new ImageView(context);
        //为了让ImageView全屏显示，调用ImageView的setBackgroundResource方法，设置其BackGround属性
        imageView.setBackgroundResource(navigation_1);
//        imageView.setImageResource(navigation_1);
//        imageView.setLayoutParams(
//                new ViewGroup.LayoutParams(
//                        ViewGroup.LayoutParams.MATCH_PARENT,
//                        ViewGroup.LayoutParams.MATCH_PARENT));
        return imageView;
    }

}
