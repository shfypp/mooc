package cn.hophin.shfy.androidmooc;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SQLiteActivity extends AppCompatActivity {

    private static final String DB_USERS = "users.db";    //数据库名
    private static final String TB_USERS = "users";          //表名
    private static final String USER_ID = "_id";
    private static final String USER_NAME = "name";
    private static final String USER_AGE = "age";
    private static final String USER_SEX = "sex";
    private static final String tag = "SHFY";
    private Context context;
    private RelativeLayout sqlite_users_tb;

    public SQLiteActivity() {
        this.context = this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);
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

        sqlite_users_tb = (RelativeLayout) findViewById(R.id.sqlite_users_tb);

        //创建数据库
        SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(DB_USERS, MODE_PRIVATE, null);
        //创建表
        String sql =String.format("create table if not exists %s(" +
                "%s integer primary key autoincrement," +
                "%s text not null," +
                "%s integer not null," +
                "%s text not null)",
                TB_USERS,USER_ID,USER_NAME,USER_AGE,USER_SEX
                );
        sqLiteDatabase.execSQL(sql);

        //添加表
        sql = String.format("insert into %s(%s,%s,%s) values('Joan',32,'man')",
                TB_USERS,USER_NAME,USER_AGE,USER_SEX);
        sqLiteDatabase.execSQL(sql);
        //用SQLiteDatabase自带方法添加数据
        ContentValues values=new ContentValues();
        values.put(USER_NAME,"Bob");
        values.put(USER_SEX,"woman");
        values.put(USER_AGE,19);
        sqLiteDatabase.insert(TB_USERS,null,values);
        //查询数据集
        sql = String.format("select * from %s",TB_USERS);
        Cursor cursor = sqLiteDatabase.rawQuery(sql, null);
        //将查询到的数据集通过TextView显示到主布局
        StringBuffer msg = new StringBuffer();
        if (cursor != null) {
            while (cursor.moveToNext()) {
                msg.append(cursor.getInt(cursor.getColumnIndex(USER_ID)));
                msg.append(",");
                msg.append(cursor.getString(cursor.getColumnIndex(USER_NAME)));
                msg.append(",");
                msg.append(cursor.getString(cursor.getColumnIndex(USER_SEX)));
                msg.append(",");
                msg.append(cursor.getInt(cursor.getColumnIndex(USER_AGE)));
                msg.append("\n");
            }
            cursor.close(); //这里要注意cursor的释放，以提高应用性能
        }
        sqLiteDatabase.close(); //同样这里注意数据库的释放
        if (msg.toString().length() > 0) {
            TextView textView = new TextView(context);
            textView.setLayoutParams(
                    new ViewGroup.LayoutParams(
                            ViewGroup.LayoutParams.WRAP_CONTENT,
                            ViewGroup.LayoutParams.WRAP_CONTENT
                    ));
            textView.setText(msg.toString());
            textView.setTextSize(20);
            sqlite_users_tb.addView(textView);
        }
    }

}
