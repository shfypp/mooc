package cn.hophin.shfy.androidmooc;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.Toast;

public class SubMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_menu);
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
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //创建子菜单
        SubMenu file = menu.addSubMenu("文件");
        SubMenu edit = menu.addSubMenu("编辑");
        //添加子菜单项
        file.setHeaderTitle("文件操作");
        file.setHeaderIcon(R.drawable.shfy_mooc);
        file.add(1, 1, 100, "新建");
        file.add(1, 2, 101, "打开");
        file.add(1, 3, 102, "查找");
        edit.setHeaderTitle("编辑内容");
        edit.setHeaderIcon(R.drawable.shfy_mooc);
        edit.add(2, 1, 100, "复制");
        edit.add(2, 2, 101, "剪切");
        edit.add(2, 3, 102, "粘贴");
        return true;
//        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String msg = "";
        if (item.getGroupId() == 1) {
            switch (item.getItemId()) {
                case 1:
                    msg = "新建";
                    break;
                case 2:
                    msg = "打开";
                    break;
                case 3:
                    msg = "查找";
                    break;

            }
            Toast.makeText(SubMenuActivity.this, msg, Toast.LENGTH_SHORT).show();
        }
        if (item.getGroupId() == 2) {
            switch (item.getItemId()) {
                case 1:
                    msg = "复制";
                    break;
                case 2:
                    msg = "剪切";
                    break;
                case 3:
                    msg = "粘贴";
                    break;

            }
            Toast.makeText(SubMenuActivity.this, msg, Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}
