package cn.hophin.shfy.androidmooc;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListArrayActivity extends AppCompatActivity {
    private Context context;
    private String LIGHT_IMAGE="light_image";
    private String LIGHT_NAME="light_name";

    public ListArrayActivity() {
        this.context = this;
    }

    private ListView mListView;
    private RadioGroup mRadioGroup;

    private ArrayAdapter mArrayAdapter;
    private SimpleAdapter mSimpleAdapter;
    private List<Map<String,Object>> mapData;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_array);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //初始化控件
        mListView= (ListView) findViewById(R.id.array_data_list_view);
        //为Adapter准备数据
        List<String> listData = getListData();
        //封装数据到Adapter
        mArrayAdapter=new ArrayAdapter(
                context,
                android.R.layout.simple_list_item_1,
                listData
        );

        mSimpleAdapter=new SimpleAdapter(
                context,
                getSimpleAdapterData(),
                R.layout.simple_list_item,
                new String[]{LIGHT_IMAGE,LIGHT_NAME},
                new int[]{R.id.light_image_view,R.id.light_text_view}
        );

        mRadioGroup= (RadioGroup) findViewById(R.id.list_select_radio_group);
        mListView.setAdapter(
                mRadioGroup.getCheckedRadioButtonId()==R.id.array_adapter_radio_button?
                        mArrayAdapter:mSimpleAdapter);
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.array_adapter_radio_button:
                        mListView.setAdapter(mArrayAdapter);
                        break;
                    case R.id.simple_adapter_radio_button:
                        mListView.setAdapter(mSimpleAdapter);
                        break;
                }
            }
        });

    }

    private  List<Map<String,Object>> getSimpleAdapterData() {
        mapData=new ArrayList<Map<String,Object>>();

        for(int i=0;i<10;i++){
            Map<String,Object> map=new HashMap<String, Object>();
            map.put(LIGHT_IMAGE, R.drawable.light_switch_on);

            map.put(LIGHT_NAME,"客厅"+(i+1));
            mapData.add(map);
        }
        return mapData;
    }

    @NonNull
    private List<String> getListData() {
        String[] arrayData={
                "option1",
                "option2",
                "option3",
                "option4",
                "option5"
        };
        return new ArrayList<String>(Arrays.asList(arrayData));
    }

}
