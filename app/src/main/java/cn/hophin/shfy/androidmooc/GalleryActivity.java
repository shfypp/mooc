package cn.hophin.shfy.androidmooc;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.Gallery;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

import cn.hophin.shfy.androidmooc.adapter.MyGalleryAdapter;

public class GalleryActivity extends AppCompatActivity {
    private Context context;
    private ImageSwitcher imageSwitcher;
    public GalleryActivity() {
        this.context = this;
    }

    private int[] res={
            R.drawable.wdcgq1,
            R.drawable.wdcgq2,
            R.drawable.wdcgq3,
            R.drawable.wdcgq4,
            R.drawable.wdcgq5,
            R.drawable.wdcgq6
    };
    private Gallery gallery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        gallery= (Gallery) findViewById(R.id.images_gallery);
        MyGalleryAdapter adapter=new MyGalleryAdapter(context,res);
        gallery.setAdapter(adapter);

        imageSwitcher= (ImageSwitcher) findViewById(R.id.image_image_Switcher);
        //ImageSwitcher显示图片需要setFactory()
        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView=new ImageView(context);
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER); //按比例缩放并居中显示
                return imageView;
            }
        });
        //设置淡入淡出效果
        imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(context,android.R.anim.fade_in));
        imageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(context,android.R.anim.fade_out));
        //设置监听
        gallery.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                imageSwitcher.setBackgroundResource(res[position%res.length]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

}
