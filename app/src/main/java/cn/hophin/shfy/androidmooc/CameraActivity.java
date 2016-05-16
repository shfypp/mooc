package cn.hophin.shfy.androidmooc;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class CameraActivity extends AppCompatActivity {
    private ImageView cameraImage;
    private int mRequestCode = 100;   //请求码
    private String mFilePath;       //自定义图片保存路径

    public CameraActivity() {
        this.context = this;
    }

    private Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        cameraImage = (ImageView) findViewById(R.id.camera_image);
        //SD卡文件保存路径
        mFilePath = Environment.getExternalStorageDirectory().getPath();
        mFilePath = mFilePath + "/temp.png";
    }

    public void startCamera(View view) {
        //启动系统摄像头
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        //自定义拍摄图像保存路径
        Uri photoUri = Uri.fromFile(new File(mFilePath));
        intent.putExtra(MediaStore.EXTRA_OUTPUT, photoUri);
        startActivityForResult(intent, mRequestCode);
    }

    private FileInputStream fileInputStream;
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == mRequestCode) {
            //获取Bundle对象
//            Bundle bundle = data.getExtras();
            //从Bundle对象中获取图片数据(拍摄图片缩略图)
//            Bitmap bitmap= (Bitmap) bundle.get("data");
            //这里去拍摄图片的真实数据
            try {
                fileInputStream = new FileInputStream(mFilePath);
                Bitmap bitmap = BitmapFactory.decodeStream(fileInputStream);
                cameraImage.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } finally {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
