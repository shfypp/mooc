package cn.hophin.shfy.androidmooc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Arrays;

public class ContextMenuActivity extends AppCompatActivity {
    private ListView listView;
    private ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_context_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listView= (ListView) findViewById(R.id.content_list_view);
        String[] list={
                "周一",
                "周二",
                "周三",
                "周四",
                "周五",
                "周六",
                "周日"
        };
        arrayAdapter=new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                Arrays.asList(list));
        listView.setAdapter(arrayAdapter);
        this.registerForContextMenu(listView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        //设置Menu显示内容
        menu.setHeaderTitle("文件操作");    //设置菜单标题
        menu.setHeaderIcon(R.drawable.shfy_mooc);   //设置菜单图标
        menu.add(1, 1, 100, "复制");
        menu.add(1, 2, 101, "剪切");
        menu.add(1, 3, 102, "删除");
        menu.add(1, 4, 103, "粘贴");
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
//        return super.onContextItemSelected(item);
        String msg="";
        switch (item.getItemId()) {
            case 1:
                msg="复制";
                break;
            case 2:
                msg="剪切";
                break;
            case 3:
                msg="删除";
                break;
            case 4:
                msg="粘贴";
                break;

        }
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        return true;
    }

}
