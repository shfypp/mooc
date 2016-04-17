package cn.hophin.shfy.androidmooc;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class ProgressBarActivity extends AppCompatActivity implements View.OnClickListener {
    private ProgressBar progressBar;
    private Button progressAdd;
    private Button progressLess;
    private Button progressInitial;
    private Button progressDialog;
    private ProgressDialog progressBarDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //启动窗口特征，启用带进度条的进度条
        requestWindowFeature(Window.FEATURE_PROGRESS);
        //启动窗口特征，启用不带进度条的进度条
        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_probress_bar);
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

        //显示两种进度条_带进度条
        setProgressBarVisibility(true);
        //显示两种进度条_不带进度条
        setProgressBarIndeterminateVisibility(true);
        //设置带进度条的进度条进度（进度完成为常量：10000）
        setProgress(5000);

        progressAdd= (Button) findViewById(R.id.progress_add);
        progressLess= (Button) findViewById(R.id.progress_less);
        progressInitial= (Button) findViewById(R.id.progress_initial);
        progressBar= (ProgressBar) findViewById(R.id.progress_bar_horizontal);

        progressDialog = (Button) findViewById(R.id.progressbar_dialog_button);

        progressAdd.setOnClickListener(this);
        progressLess.setOnClickListener(this);
        progressInitial.setOnClickListener(this);

        progressDialog.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.progress_add:
//                progressBar.setProgress(
//                        progressBar.getProgress() < 90 ?
//                                progressBar.getProgress() + 10 : 100);
                progressBar.incrementProgressBy(10);
                progressBar.incrementSecondaryProgressBy(10);
                break;
            case R.id.progress_less:
//                progressBar.setProgress(
//                        progressBar.getProgress()>10?
//                                progressBar.getProgress()-10:0);
                progressBar.incrementProgressBy(-10);
                progressBar.incrementSecondaryProgressBy(-10);
                break;
            case R.id.progress_initial:
                progressBar.setProgress(0);
                progressBar.setSecondaryProgress(0);
                break;
            case R.id.progressbar_dialog_button:
                /**
                 * 设置页面风格
                 */
                //创建ProgressDialog对象
                progressBarDialog=new ProgressDialog(ProgressBarActivity.this);
                //设置显示风格
                progressBarDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                //设置标题
                progressBarDialog.setTitle("慕课网(www.imooc.com)");
                //设置对话框里的文字信息
                progressBarDialog.setMessage("这么好的慕课网大家要支持(⊙o⊙)哦");
                //设置图标
                progressBarDialog.setIcon(R.mipmap.ic_launcher);
                /**
                 * 设置关于进度条的一些属性
                 */
                progressBarDialog.setMax(100);
                progressBarDialog.incrementProgressBy(50);
                //明确显示进度
                progressBarDialog.setIndeterminate(false);
                /**
                 * 设定一个确定按钮
                 */
                progressBarDialog.setButton(DialogInterface.BUTTON_POSITIVE, "确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(ProgressBarActivity.this,"欢迎大家支持慕课网",Toast.LENGTH_SHORT).show();
                    }
                });
                //是否可以通过返回按钮退出对话框
                progressBarDialog.setCancelable(true);
                //显示progressBar
                progressBarDialog.show();
                break;
        }

    }
}
