package com.svmc.alarm;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.TimePicker;

import java.util.Calendar;

/**
 * Created by sev_user on 3/5/2017.
 */

public class TimePickerFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener {


    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minutes) {

//        TextView tv = (TextView) getActivity().findViewById(R.id.tvHour);
//        tv.setText(hourOfDay + "");
//        TextView tv1 = (TextView) getActivity().findViewById(R.id.tvMinute);
//        tv1.setText(minutes+"");

    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minutes = calendar.get(Calendar.MINUTE);

        return new TimePickerDialog(getActivity(), this, hour, minutes, android.text.format.DateFormat.is24HourFormat(getActivity()));

    }
}
