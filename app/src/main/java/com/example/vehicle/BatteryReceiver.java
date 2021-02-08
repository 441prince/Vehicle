package com.example.vehicle;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.BatteryManager;
import android.widget.TextView;
import android.widget.Toast;

public class BatteryReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

    TextView percentage=((MainActivity)context).findViewById(R.id.batteryPercentage);
    int level=intent.getIntExtra(BatteryManager.EXTRA_LEVEL,-1);
    int scale=intent.getIntExtra(BatteryManager.EXTRA_SCALE,-1);
    int percentageValue=level*100/scale;
    percentage.setText(percentageValue+"%");
    String action =intent.getAction();
    if(action!=null&&action.equals(Intent.ACTION_BATTERY_CHANGED)){
        int status=intent.getIntExtra(BatteryManager.EXTRA_STATUS,-1);
            switch(status){
                case BatteryManager.BATTERY_STATUS_DISCHARGING :
                    if(percentageValue<20){
                        Toast.makeText(context,"Battery low",Toast.LENGTH_SHORT).show();

                        AlertDialog.Builder builder=new AlertDialog.Builder(context);
                        builder.setCancelable(true);
                        builder.setTitle("Battery Low");
                        builder.setMessage(" connect charger");
                        builder.setIcon(R.drawable.lowpercent);
                        builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });

                        builder.show();
                    }
                break;

                case BatteryManager.BATTERY_STATUS_FULL :
                        Toast.makeText(context,"Battery Full ",Toast.LENGTH_SHORT).show();
                        AlertDialog.Builder builder=new AlertDialog.Builder(context);
                        builder.setCancelable(true);
                        builder.setTitle("Battery Full");
                        builder.setMessage("Disconnect The Charger");
                        builder.setIcon(R.drawable.hundredpercent);
                        builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });

                        builder.show();

                break;

                case BatteryManager.BATTERY_STATUS_NOT_CHARGING :

                    if(percentageValue==50){
                        Toast.makeText(context,"Battery Half Full",Toast.LENGTH_SHORT).show();
                        AlertDialog.Builder builder2=new AlertDialog.Builder(context);
                        builder2.setCancelable(true);
                        builder2.setTitle("50% charge Remaining");
                        builder2.setMessage(" connect charger");
                        builder2.setIcon(R.drawable.fiftypercent);
                        builder2.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                        builder2.show();
                    }
                break;
            }
        }
    }
}
