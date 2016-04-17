package cn.hophin.shfy.androidmooc;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewActivity extends AppCompatActivity {
    private WebView webView;
    private String url = "http://wwww.baidu.com";
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

//        通过Intent加载网页
//        Uri uri=Uri.parse(url);
//        Intent intent=new Intent(Intent.ACTION_VIEW,uri);
//        startActivity(intent);

        webView = (WebView) findViewById(R.id.web_view);
        //加载本地文件：即assets目录下文件，注意路径为：file:///android_asset/*.*
//        webView.loadUrl("file:///android_asset/answer_and_question.txt");
        //加载网络资源
        webView.loadUrl(url);
        //覆盖WebView默认通过第三方或者系统浏览器打开网页的行为，使得网页可以在WebView中打开
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                webView.loadUrl(url);
                //返回值为True时控制网页在WebView中打开
                //返回值为False时控制网页在第三方或者系统浏览器中打开
                return true;
//                return super.shouldOverrideUrlLoading(view, url);
            }
        });
        //启用支持JavaScript
        WebSettings settings=webView.getSettings();
        settings.setJavaScriptEnabled(true);
        //WebView加载网页优先使用缓存
        settings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        //显示网页加载进度
        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                //newProgress:1-100之间的整数
                if (newProgress == 100) {
                    //网页加载完毕，关闭加载进度条
                    closeDialog();
                } else {
                    //网页正在加载，显示加载进度
                    openDialog(newProgress);
                }
                super.onProgressChanged(view, newProgress);
            }
        });



    }

    /**
     * 显示网页加载进度条
     * @param newProgress
     */
    private void openDialog(int newProgress) {
        if (progressDialog == null) {
            progressDialog=new ProgressDialog(WebViewActivity.this);
            progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            progressDialog.setTitle("Loading...");
            progressDialog.setProgress(newProgress);
            progressDialog.show();
        }else{
            progressDialog.setProgress(newProgress);
        }
    }

    /**
     * 关闭网页加载进度条
     */
    private void closeDialog() {
        if (progressDialog!=null&&progressDialog.isShowing()){
            progressDialog.dismiss();
            progressDialog=null;
        }

    }
    //改写物理按键返回按钮返回的逻辑


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK){
            if(webView.canGoBack()){
                webView.goBack();
                return true;
            }
        }else{
            //退出程序
            System.exit(0);
        }
        return super.onKeyDown(keyCode,event);
    }
}
