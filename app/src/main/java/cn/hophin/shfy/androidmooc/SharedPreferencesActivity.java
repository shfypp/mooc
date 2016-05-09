package cn.hophin.shfy.androidmooc;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SharedPreferencesActivity extends AppCompatActivity {

    private EditText key;
    private EditText value;
    private TextView shared_pref_info;
    private Context context;
    private SharedPreferences preferences;


    public SharedPreferencesActivity() {
        this.context = this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);
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

        key = (EditText) findViewById(R.id.key_edit_text);
        value = (EditText) findViewById(R.id.value_edit_text);
        shared_pref_info = (TextView) findViewById(R.id.shared_pref_info_text_view);
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
        if (preferences.getAll().size() > 0) {
            shared_pref_info.setText(preferences.getAll().toString());
        }
    }

    /**
     * Response for button
     */
    public void savePref(View view) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key.getText().toString(), value.getText().toString());
        editor.commit();
        key.setText("");
        value.setText("");
        shared_pref_info.setText(preferences.getAll().toString());
    }

    /**
     * Response for button
     */
    public void clearPrefs(View view) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
        editor.commit();
        shared_pref_info.setText(preferences.getAll().toString());
    }


}
