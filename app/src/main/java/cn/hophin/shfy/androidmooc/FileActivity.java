package cn.hophin.shfy.androidmooc;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileActivity extends AppCompatActivity {
    private EditText fileName;
    private EditText fileContent;
    private Button saveFile;
    private Context context;
    private TextView textView;

    public FileActivity() {
        this.context = this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);
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

        fileName = (EditText) findViewById(R.id.file_name_edit_text);
        saveFile = (Button) findViewById(R.id.save_file_button);
        fileContent = (EditText) findViewById(R.id.file_content_edit_text);
        textView = (TextView) findViewById(R.id.file_info_text);
        saveFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strFileName = fileName.getText().toString() + ".txt";
                String strFileContent = fileContent.getText().toString();
                FileOutputStream outputStream;
                FileInputStream inputStream;

                //getFilesDir():当前应用程序默认的数据存储目录 /data/data/包名/files
                //getCacheDir():当前应用程序默认的缓存文件目录，该处可被自动删除    /data/data/包名/cache
                //getDir(String name,int mode):自定义文件目录  /data/data/包名/name
                File file = new File(context.getFilesDir(), strFileName);
                try {
                    outputStream = openFileOutput(strFileName, Context.MODE_PRIVATE);
                    outputStream.write(strFileContent.getBytes());
                    outputStream.close();
                    Toast.makeText(
                            context,
                            context.getResources().getString(R.string.success_save_file),
                            Toast.LENGTH_SHORT).show();
                    fileName.setText("");
                    fileContent.setText("");

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                //读文件并显示到TextView中
                try {
                    inputStream = openFileInput(strFileName);
                    ByteArrayOutputStream stream = new ByteArrayOutputStream();
                    byte[] buffer = new byte[1024];
                    int lenght = 0;
                    while ((lenght = inputStream.read(buffer)) != -1) {
                        stream.write(buffer, 0, lenght);
                    }
                    if(stream.size()>0){
                        textView.setText(stream.toString());
                    }
                    stream.close();
                    inputStream.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                }

            }
        });
    }

}
