package com.svmc.alarm;

import java.util.Calendar;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.DialogFragment;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * @author manish
 */

public class MainActivity extends Activity implements OnClickListener {

    private Button btAddAlarm, btStopAlarm, btSetAlarm;
    Context context;
    static PendingIntent pendingIntent;
    static AlarmManager alarmManager;
    private int hours;
    private int minutes;
    private String url;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        context = MainActivity.this;


//        Intent intentsOpen = new Intent(this, AlarmReceiver.class);
//        intentsOpen.setAction("com.svmc.alarm.ACTION");
//        pendingIntent = PendingIntent.getBroadcast(this, 111, intentsOpen, 0);
//        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);


        btAddAlarm = (Button) findViewById(R.id.btAddAlarm);
        btSetAlarm = (Button) findViewById(R.id.btSetAlarm);
        btStopAlarm = (Button) findViewById(R.id.btStopAlarm);
        btAddAlarm.setOnClickListener(this);
        btSetAlarm.setOnClickListener(this);
        btStopAlarm.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        if (v == btAddAlarm) {
//            fireAlarm();
//            showTimePickerDialog(v);
            Intent intent = new Intent(MainActivity.this, SetAlarm.class);
            startActivity(intent);


        }
        if (v == btStopAlarm) {
            stopAlarm();
        }
        if (v == btSetAlarm) {
            fireAlarm();
        }
    }

    public void fireAlarm() {
        /**
         * call broadcost reciver
         */
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
//        TextView tvHour = (TextView) findViewById(R.id.tvHour);
//        TextView tvMinutes = (TextView) findViewById(R.id.tvMinute);
//        hours = Integer.parseInt(tvHour.getText().toString());
//        minutes = Integer.parseInt(tvMinutes.getText().toString());
        int hourNow = calendar.get(Calendar.HOUR_OF_DAY);
        int dayNow = calendar.get(Calendar.DAY_OF_MONTH);
        if (hourNow > hours)
            calendar.set(Calendar.DAY_OF_MONTH, dayNow + 1);
        calendar.set(Calendar.HOUR_OF_DAY, hours);
        calendar.set(Calendar.MINUTE, minutes);


        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), 1000 * 60 * 60 * 24, pendingIntent);


    }

    public void stopAlarm() {
        alarmManager.cancel(pendingIntent);


    }

    public void showTimePickerDialog(View v) {
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getFragmentManager(), "timePicker");
    }


}
