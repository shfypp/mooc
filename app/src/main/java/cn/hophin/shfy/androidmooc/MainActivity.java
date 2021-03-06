package cn.hophin.shfy.androidmooc;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private MarqueeText mMarqueeText;
    private AutoCompleteTextView mAutoCompleteTextView;
    private MultiAutoCompleteTextView mMultiAutoCompleteTextView;
    private ToggleButton mToggleButton;
    private ImageView mImageView;
    private CheckBox mCheckBox;
    private ImageView mImageView2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
                mImageView.setImageResource(isChecked? R.drawable.light_switch_on:R.drawable.light_switch_off);
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
}
