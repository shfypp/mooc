package cn.hophin.shfy.androidmooc;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Context context;
    private MarqueeText mMarqueeText;
    private AutoCompleteTextView mAutoCompleteTextView;
    private MultiAutoCompleteTextView mMultiAutoCompleteTextView;
    private ToggleButton mToggleButton;
    private ImageView mImageView;
    private CheckBox mCheckBox;
    private ImageView mImageView2;
    private RadioGroup sex;
    private RadioButton sex_man;
    private RadioButton sex_woman;
    private RadioGroup device;
    private RadioButton device_android;
    private RadioButton device_mac;
    private Spinner spinner;

    public MainActivity() {
        this.context = this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //跑马灯TextView的实现
        mMarqueeText= (MarqueeText) findViewById(R.id.pao_ma_deng_text_view);
        mMarqueeText.setText(Article.articleContent[0]);

        //自动补全TextView的实现
        //1.初始化控件
        mAutoCompleteTextView= (AutoCompleteTextView) findViewById(R.id.key_words_ac_text_view);
        //2.初始化数据
        List<String> data=new ArrayList<String>(Arrays.asList(Article.keyWords));
        //3.创建适配器
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                data);
        //4.关联适配器到控件
        mAutoCompleteTextView.setAdapter(adapter);

        //多输入自动补全TextView的实现
        mMultiAutoCompleteTextView= (MultiAutoCompleteTextView) findViewById(R.id.key_words_mac_text_view);
        mMultiAutoCompleteTextView.setAdapter(adapter);
        //设置以逗号为分隔符
        mMultiAutoCompleteTextView.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());

        //ToggleButton的实现
        mImageView= (ImageView) findViewById(R.id.light_image_view);
        mToggleButton= (ToggleButton) findViewById(R.id.light_switch_tg_button);

        mToggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mImageView.setImageResource(isChecked ? R.drawable.light_switch_on : R.drawable.light_switch_off);
            }
        });

        //CheckBox的实现
        mImageView2 = (ImageView) findViewById(R.id.light_image_view_2);
        mCheckBox= (CheckBox) findViewById(R.id.light_image_show_check_box);
        mCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mImageView2.setVisibility(isChecked?View.VISIBLE:View.INVISIBLE);
            }
        });

        //RadioButton的实现
        sex= (RadioGroup) findViewById(R.id.sex_radio_group);
        sex_man= (RadioButton) findViewById(R.id.sex_man_radio_button);
        sex_woman= (RadioButton) findViewById(R.id.sex_woman_radio_button);

        device= (RadioGroup) findViewById(R.id.device_radio_group);
        device_android= (RadioButton) findViewById(R.id.device_android_radio_button);
        device_mac= (RadioButton) findViewById(R.id.device_mac_radio_button);

        //监听RadioGroup
        sex.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.sex_man_radio_button:
                        Toast.makeText(context,"sex_man is selected!",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.sex_woman_radio_button:
                        Toast.makeText(context,"sex_woman is selected!",Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });

        //也可以监听RadioButton
        device_android.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked ) {
                    Toast.makeText(context,"device_android is selected!",Toast.LENGTH_SHORT).show();
                }
            }
        });
        device_mac.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(context,"device_mac is selected!",Toast.LENGTH_SHORT).show();
                }
            }
        });

        //Spinner实现下拉列表
        spinner= (Spinner) findViewById(R.id.cities_spinner);
        //准备数据
        final String[] arrayData={
                "==PleaseSelect==",
                "option1",
                "option2",
                "option3",
                "option4",
                "option5"
        };
        List<String> listData=Arrays.asList(arrayData);
        //封装数据到适配器
        ArrayAdapter spinnerAdapter=new ArrayAdapter(
                context,
                android.R.layout.simple_spinner_item,
                listData
        );
        //为Spinner的Adapter设置一个下拉列表样式
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //添加适配器到Spinner
        spinner.setAdapter(spinnerAdapter);
        //添加监听
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //添加判断，默认选择0位置时不弹出Toast
                if(position!=0) {
                    Toast.makeText(context, arrayData[position], Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**Response for button list_array**/
    public void listArray(View view){
        Intent intent=new Intent(context,ListArrayActivity.class);
        startActivity(intent);
    }

    /**Response for button date_and_time_picker_button**/
    public void dateTimePicker(View view){
        Intent intent=new Intent(context,DateAndTimePickerActivity.class);
        startActivity(intent);
    }

    /**Response for button grid_view_button**/
    public void gridView(View view){
        Intent intent=new Intent(context,GridViewActivity.class);
        startActivity(intent);
    }

    /**Response for button progress_bar**/
    public void progressBar(View view){
        Intent intent=new Intent(context,ProgressBarActivity.class);
        startActivity(intent);
    }
    /**Response for button web_view**/
    public void webView(View view){
        Intent intent=new Intent(context,WebViewActivity.class);
        startActivity(intent);
    }
    /**Response for use_fragment_button**/
    public void useFragment(View view){
        Intent intent=new Intent(context,UseFragmentActivity.class);
        startActivity(intent);
    }
    /**Response for use_view_pager button**/
    public void useViewPager(View view){
        Intent intent=new Intent(context,ViewPagerActivity.class);
        startActivity(intent);
    }
    /**Response for use_view_pager2 button**/
    public void useViewPager2(View view){
        Intent intent=new Intent(context,ViewPager2Activity.class);
        startActivity(intent);
    }

    /**Response for use_view_flipper_button**/
    public void useViewFlipper(View view){
        Intent intent=new Intent(context,ViewFlipperActivity.class);
        startActivity(intent);
    }
    /**Response for use_gallery_and_image_switcher_button**/
    public void useGalleryAndImageSwitcher(View view){
        Intent intent=new Intent(context,GalleryActivity.class);
        startActivity(intent);
    }

}
