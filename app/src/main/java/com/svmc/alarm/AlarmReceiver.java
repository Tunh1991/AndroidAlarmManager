package com.svmc.alarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class AlarmReceiver extends BroadcastReceiver {
    private final String SOMEACTION = "com.manish.alarm.ACTION";

    @Override
    public void onReceive(Context context, Intent intent) {


        Intent intent3 = new Intent();
        intent3.setClassName("com.svmc.alarm","com.svmc.alarm.OutPut");
        intent3.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent3);

    }



}