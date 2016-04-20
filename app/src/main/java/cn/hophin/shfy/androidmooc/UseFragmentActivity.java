package cn.hophin.shfy.androidmooc;

import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class UseFragmentActivity extends AppCompatActivity implements StaticFragmentContentActivity.getSex {
    private RadioGroup fragmentSelect;
    private RadioButton fragmentStatic;

    private Context context;
    public static String USER_NAME="userName";

    public UseFragmentActivity() {
        this.context = this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_use_fragment);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        fragmentSelect= (RadioGroup) findViewById(R.id.fragment_select_radio_group);
        fragmentStatic= (RadioButton) findViewById(R.id.fragment_static);

        fragmentSelect.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.fragment_static_radio_button:
                        startActivity(new Intent(context,StaticFragmentActivity.class));
                        break;
                    case R.id.fragment_dynamic_radio_button:
                        //创建Fragment
                        StaticFragmentContentActivity fragment=new StaticFragmentContentActivity();
                        //创建Bundle对象，并封装数据
                        Bundle bundle=new Bundle();
                        bundle.putString(USER_NAME,"Joan");
                        //调用Fragment的setArguments(Bundle bundle)方法，传递Bundle数据到Fragment
                        fragment.setArguments(bundle);
                        //调用FragmentManager将Fragment加载到当前布局中
                        FragmentManager fragmentManager=getFragmentManager();
                        fragmentManager
                                .beginTransaction()
                                .add(R.id.content_linear_layout,fragment )
                                .addToBackStack(null)
                                .commit();
                        break;
                }
            }
        });
    }

    @Override
    public void say(String sex) {
        Toast.makeText(context,sex,Toast.LENGTH_SHORT).show();
    }
}
