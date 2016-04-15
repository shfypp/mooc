package cn.hophin.shfy.androidmooc;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GridViewActivity extends AppCompatActivity {
    public GridViewActivity() {
        this.context = this;
    }

    private Context context;
    private GridView gridView;
    private List<Map<String, Object>> dataList;
    private SimpleAdapter simpleAdapter;

    //from:对应List中Map的键名
    private String[] from={
            "icon",
            "info"
    };
    //to:Adapter适配的资源文件中具体资源ID
    private int[] to={
            R.id.light_switch_image_view,
            R.id.light_info_text_view
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        gridView = (GridView) findViewById(R.id.grid_view);

        //1.准备数据资源
        //2.封装数据到适配器
        simpleAdapter = new SimpleAdapter(
                context,
                getData(),
                R.layout.grid_view_item,
                from,
                to

        );
        //3.添加适配器到GridView
        gridView.setAdapter(simpleAdapter);
        //4.添加监听到GridView
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(context,"客厅"+position,Toast.LENGTH_SHORT).show();
            }
        });

    }

    /**
     * 为适配器封装数据
     * @return
     */
    private List<Map<String, Object>> getData() {
        dataList = new ArrayList<Map<String, Object>>();
        for(int i=0;i<30;i++){
            Map<String,Object> map=new HashMap<String, Object>();
            map.put(from[0],R.drawable.light_switch_on);
            map.put(from[1],"客厅"+i);
            dataList.add(map);
        }
        return dataList;
    }

}
