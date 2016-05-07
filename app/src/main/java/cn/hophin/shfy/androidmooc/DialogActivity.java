package cn.hophin.shfy.androidmooc;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

public class DialogActivity extends AppCompatActivity {
    private Context context;

    public DialogActivity() {
        this.context = this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    /**
     * Response for button dialog_button1
     **/
    public void dialogYes(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        //设置标题
        builder.setTitle("确认对话框");
        //设置图标
        builder.setIcon(R.drawable.shfy_mooc);
        //设置提示内容
        builder.setMessage("确认对话框提示内容！");
        //设置确认按钮
        builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(context, "点击了确认按钮", Toast.LENGTH_SHORT).show();
            }
        });
        //设置取消按钮
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(context, "点击了取消按钮", Toast.LENGTH_SHORT).show();
            }
        });

        //创建并显示对话框
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private String[] loves = {
            "吃",
            "吃好",
            "吃饱",
            "吃爽"
    };

    /**
     * Response for button dialog_single_choice
     **/
    public void dialogSingleChoice(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        //设置标题
        builder.setTitle("你喜欢什么");
        //设置图标
        builder.setIcon(R.drawable.shfy_mooc);
        //设置选项内容及响应事件
        builder.setSingleChoiceItems(loves, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(context, "你喜欢" + loves[which], Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        //创建并显示对话框
        AlertDialog dialog = builder.create();
        dialog.show();


    }

    //多选选项内容
    private String[] pref_things = {
            "看书",
            "上网",
            "把妹",
            "呆着..."
    };
    //多选选项初始状态
    private boolean[] default_things = {
            true,
            false,
            false,
            false};

    /**
     * Response for button dialog_mutual_button
     **/
    public void dialogMutualChoice(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        //设置标题
        builder.setTitle("你有什么爱好");
        //设置图标
        builder.setIcon(R.drawable.shfy_mooc);
        builder.setMultiChoiceItems(pref_things, default_things, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(context, "你喜欢" + pref_things[which], Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(context, "你不喜欢" + pref_things[which], Toast.LENGTH_SHORT).show();
                }
            }
        });
        //创建并显示对话框
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private String[] cities={
            "太原",
            "阳泉",
            "平遥",
            "沁源",
            "北京"
    };
    /**
     * Response for button dialog_list
     */
    public void dialogList(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        //设置标题
        builder.setTitle("请选择您的城市");
        //设置图标
        builder.setIcon(R.drawable.shfy_mooc);
        builder.setItems(cities, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(context,"您的城市是"+cities[which],Toast.LENGTH_SHORT).show();
            }
        });
        //创建并显示对话框
        AlertDialog dialog = builder.create();
        dialog.show();

    }
    /**
     * Response for button dialog_my
     */
    public void dialogMy(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        //设置标题
        builder.setTitle("我的对话框");
        //设置图标
        builder.setIcon(R.drawable.shfy_mooc);

        LayoutInflater inflater=LayoutInflater.from(context);
        View view1=inflater.inflate(R.layout.dialog_my,null);

        builder.setView(view1);
        //创建并显示对话框
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
