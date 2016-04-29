package cn.hophin.shfy.androidmooc;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class ToastActivity extends AppCompatActivity implements View.OnClickListener {
    private Context context;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;

    public ToastActivity() {
        this.context = this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);
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

        button1= (Button) findViewById(R.id.button1);
        button2= (Button) findViewById(R.id.button2);
        button3= (Button) findViewById(R.id.button3);
        button4= (Button) findViewById(R.id.button4);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.button1:
                Toast toast=Toast.makeText(context,"这是普通Toast！",Toast.LENGTH_SHORT);
                toast.show();
                break;
            case R.id.button2:
                Toast toast2=Toast.makeText(context,"这是自定义位置的Toast！",Toast.LENGTH_SHORT);
                toast2.setGravity(Gravity.CENTER,0,0);
                toast2.show();
                break;
            case R.id.button3:
                Toast toast3=Toast.makeText(context,"这是带有图片的Toast！",Toast.LENGTH_SHORT);
                toast3.setGravity(Gravity.CENTER, 0, 0);
                LinearLayout linearLayout= (LinearLayout) toast3.getView();
                ImageView imageView=new ImageView(context);
                imageView.setImageResource(R.drawable.shfy_mooc);
                linearLayout.addView(imageView, 0);
                toast3.show();
                break;
            case R.id.button4:
                LayoutInflater inflater=LayoutInflater.from(context);
                View view=inflater.inflate(R.layout.toast_my, null);
                Toast toast4=new Toast(context);
                toast4.setGravity(Gravity.BOTTOM, 0, 0);
                toast4.setView(view);
                toast4.show();
                break;



        }

    }
}
