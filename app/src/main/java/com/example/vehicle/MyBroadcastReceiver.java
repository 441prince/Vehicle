package com.example.vehicle;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.Gravity;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent)
    {
        String data = intent.getStringExtra("data");
        Toast toast= Toast.makeText(context, data, Toast.LENGTH_LONG);
        toast.show();
        toast.setGravity(Gravity.CENTER | Gravity.BOTTOM, 450, 100);
        Log.i("BR" ,"Data received:  " + data);
    }
}
