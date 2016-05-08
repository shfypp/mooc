package cn.hophin.shfy.androidmooc;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class NotificationActivity extends AppCompatActivity {
    private Context context;
    private NotificationManager manager;

    public NotificationActivity() {
        this.context = this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
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

        manager= (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
    }

    /**
     * Response for button notification_send
     */
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public void sendNotification(View view) {
        Notification.Builder builder = new Notification.Builder(context);
        //设置通知图标
        builder.setSmallIcon(R.drawable.shfy_mooc);
        //设置通知到达时通知状态栏提示
        builder.setTicker("I'm here!");
        //设置时间
        builder.setWhen(System.currentTimeMillis());
        //设置通知标题
        builder.setContentTitle("My First Notification");
        //设置通知内容
        builder.setContentInfo("This is my first notification...");
        //设置点击通知后的响应事件
        Intent intent = new Intent(context, WebViewActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);
        builder.setContentIntent(pendingIntent);
        //设置通知到达时的提示效果
        builder.setDefaults(Notification.DEFAULT_SOUND);    //声音
        builder.setDefaults(Notification.DEFAULT_LIGHTS);   //灯光    需要权限
        builder.setDefaults(Notification.DEFAULT_VIBRATE);  //震动    需要权限
//        builder.setDefaults(Notification.DEFAULT_ALL);      //上面三种效果全有
        Notification notification = builder.build();  //4.1以上用该方法，否则用builder.getNotification()
        manager.notify(0,notification);
    }

    /**
     * Response for button notification_dismiss
     */
    public void dismissNotification(View view) {
       manager.cancel(0);
    }


}
