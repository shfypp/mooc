package cn.hophin.shfy.androidmooc.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

/**
 * Created by Administrator on 2016/5/7.
 */
public class MyGalleryAdapter extends BaseAdapter {
    private Context context;
    private int[] res;

    public MyGalleryAdapter(Context context, int[] res) {
        this.context = context;
        this.res = res;
    }

    @Override
    public int getCount() {
//        return res.length;
        return Integer.MAX_VALUE;
    }

    @Override
    public Object getItem(int position) {
        return res[position%res.length];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView=new ImageView(context);
        imageView.setBackgroundResource(res[position%res.length]);
        imageView.setLayoutParams(new Gallery.LayoutParams(300, 300));
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        return imageView;
    }
}
