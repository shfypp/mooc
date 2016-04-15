package cn.hophin.shfy.androidmooc;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;

import java.util.Calendar;

public class DateAndTimePickerActivity extends AppCompatActivity implements View.OnClickListener {
    private Context context;

    public DateAndTimePickerActivity() {
        this.context = this;
    }

    private DatePicker datePicker;
    private TimePicker timePicker;
    private Calendar calendar;

    private int mYear;
    private int month;
    private int day;
    private int hour;
    private int mMinute;
    private int mSeconde;

    private Button dialogDatePickerButton;
    private Button dialogTimePickerButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_and_time_picker);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        datePicker = (DatePicker) findViewById(R.id.datePicker);
        timePicker = (TimePicker) findViewById(R.id.timePicker);

        calendar = Calendar.getInstance();
        mYear = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        hour = calendar.get(Calendar.HOUR_OF_DAY);
        mMinute = calendar.get(Calendar.MINUTE);
        mSeconde =calendar.get(Calendar.SECOND);

        setTitle(String.format("%d年%d月%d日 %d:%d:%d", mYear, month+1, day, hour, mMinute,mSeconde));

        datePicker.init(mYear, month, day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                updateDate(year, monthOfYear, dayOfMonth);
            }
        });

        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                updateTime(hourOfDay, minute);
            }
        });

        dialogDatePickerButton= (Button) findViewById(R.id.dialog_date_picker_button);
        dialogTimePickerButton= (Button) findViewById(R.id.dialog_time_picker_button);

        dialogTimePickerButton.setOnClickListener(this);
        dialogDatePickerButton.setOnClickListener(this);
    }

    private void updateTime(int hourOfDay, int minute) {
        hour = hourOfDay;
        mMinute = minute;
        setTitle(String.format("%d年%d月%d日 %d:%d:%d",
                mYear,
                month + 1,
                day,
                hourOfDay,
                minute,
                Calendar.getInstance().get(Calendar.SECOND)));
    }

    private void updateDate(int year, int monthOfYear, int dayOfMonth) {
        mYear = year;
        month = monthOfYear;
        day = dayOfMonth;
        setTitle(String.format("%d年%d月%d日 %d:%d:%d",
                year,
                monthOfYear + 1,
                dayOfMonth,
                hour, mMinute,
                Calendar.getInstance().get(Calendar.SECOND)));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.dialog_date_picker_button:
                new DatePickerDialog(
                        context,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                updateDate(year,monthOfYear,dayOfMonth);
                            }
                        },
                        mYear,
                        month,
                        day
                ).show();
                break;
            case R.id.dialog_time_picker_button:
                new TimePickerDialog(
                        context,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                updateTime(hourOfDay,minute);
                            }
                        },
                        hour,
                        mMinute,
                        true
                ).show();
                break;
        }

    }
}
