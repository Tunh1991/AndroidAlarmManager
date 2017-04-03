package com.svmc.alarm;


import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class SetAlarm extends Activity {
    private ListView lvAlarm;
    private TextView btOk;
    private TextView btCancel;
    private TimePickerDialog.OnTimeSetListener clockDialog;
    private int hour;
    private int minutes;
    private int CLOCK_ANALOG = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        final boolean customTitle = requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.activity_set_alarm);
//        if (customTitle) {
//            getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.titlebar);
//        }
//        final TextView tvTitle = (TextView) findViewById(R.id.tvTitleAlarm);
//        if (tvTitle != null) {
//            tvTitle.setText("Set Alarm");
//            tvTitle.setTextColor(getResources().getColor(R.color.white));
//            tvTitle.setBackgroundColor(getResources().getColor(R.color.blue));
//
//        }
        lvAlarm = (ListView) findViewById(R.id.lvAlarm);
        btCancel = (TextView) findViewById(R.id.btCancel);
        btOk = (TextView) findViewById(R.id.btOK);

        btCancel.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        btCancel.setTextColor(getResources().getColor(R.color.black));
                        btCancel.setBackgroundColor(getResources().getColor(R.color.blue_2));

                        break;

                    case MotionEvent.ACTION_UP:
                        btCancel.setTextColor(getResources().getColor(R.color.white));
                        btCancel.setBackgroundColor(getResources().getColor(R.color.blue_1));

                        break;
                }
                return true;
            }
        });
        btOk.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        btOk.setTextColor(getResources().getColor(R.color.black));
                        btOk.setBackgroundColor(getResources().getColor(R.color.blue_2));

                        break;

                    case MotionEvent.ACTION_UP:
                        btOk.setTextColor(getResources().getColor(R.color.white));
                        btOk.setBackgroundColor(getResources().getColor(R.color.blue_1));

                        break;
                }
                return true;
            }
        });


        ListItem item1 = new ListItem("Time", "Alarm");
        item1.setType(1);
        ListItem item2 = new ListItem("Repeat", "Never");
        item2.setType(1);
        ListItem item3 = new ListItem("Ringtone", "Default");
        item3.setType(1);

        ListItem item4 = new ListItem("Vibrate");
        item4.setLabel("Vibrate");
        item4.setType(3);
        ListItem item5 = new ListItem("Alarm of method", "How to turn off the alarm");
        item5.setType(1);
        ListItem item6 = new ListItem("Label");
        item6.setType(2);

//
        final CustomItemAdapter adapter = new CustomItemAdapter(SetAlarm.this);
//
        adapter.addItem(item1);
        adapter.addItem(item2);
        adapter.addItem(item3);
        adapter.addItem(item4);
        adapter.addItem(item5);
        adapter.addItem(item6);
//
        lvAlarm.setAdapter(adapter);

        Calendar calendar = Calendar.getInstance();
        hour = calendar.get(Calendar.HOUR_OF_DAY);
        minutes = calendar.get(Calendar.MINUTE);
        lvAlarm.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                switch (position) {
                    case 0:

                        TimePickerDialog timePickerDialog = new TimePickerDialog(SetAlarm.this,
                                new TimePickerDialog.OnTimeSetListener() {

                                    @Override
                                    public void onTimeSet(TimePicker view, int hourOfDay,
                                                          int minute) {


                                    }
                                }, hour, minutes, true);
//                        //http://www.android-examples.com/change-timepickerdialog-theme-in-android-programmatically/
//
//
//


                        LayoutInflater layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

                        View view1 = layoutInflater.inflate(R.layout.custom_title_clock, null);
                        timePickerDialog.setCustomTitle(view1);
                        timePickerDialog.show();
//                        Dialog dialog = new Dialog(SetAlarm.this);
//                        dialog.setContentView(R.layout.custom_clock_dialog);
//                        TimePicker timePicker = (TimePicker)dialog.findViewById(R.id.timePicker);
////                        timePicker.setLayoutMode(Mode.S);
//                        dialog.show();
//                        showTimePickerDialog(view);
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                }


                if (position == 3) {
                    adapter.setCheckBox(position);
                    CheckBox cb = (CheckBox) findViewById(R.id.cbVibrate);
                    if (cb.isChecked())
                        cb.setChecked(false);
                    else
                        cb.setChecked(true);
                }
            }
        });
//


    }

    public void showTimePickerDialog(View v) {

        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getFragmentManager(), "timePicker");
    }
}

