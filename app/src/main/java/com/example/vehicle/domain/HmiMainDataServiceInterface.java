package com.example.vehicle.domain;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.example.vehicleservice.IMainDataInterface;

public class HmiMainDataServiceInterface {

    protected IMainDataInterface mainDataInterface;

    ServiceConnection mainDataServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceDisconnected(ComponentName name) {
            // TODO Auto-generated method stub
            mainDataInterface = null;
            //Toast.makeText(getApplicationContext(), "Main Data Service Disconnected", Toast.LENGTH_SHORT).show();
            Log.d("IRemote", "Binding - Main Data Service disconnected");
        }

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            // TODO Auto-generated method stub


            mainDataInterface = IMainDataInterface.Stub.asInterface((IBinder) service);
            //Toast.makeText(getApplicationContext(), "Main Data Service Connected", Toast.LENGTH_SHORT).show();
            Log.d("IRemote", "Binding is done - Main Data Service connected");
        }
    };

    public void updateIcons(Context context) {
        try {
            if (mainDataInterface != null) {
                mainDataInterface.rearDefrostButtonOn(1);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public HmiMainDataServiceInterface(Context context) {
        bindServiceApp(context);
    }


    private void bindServiceApp(Context context) {
        if (mainDataInterface == null) {
            Intent it = new Intent();
            it.setPackage("com.example.vehicleservice");
            it.setAction("service.MainData");
            // binding to remote service
            context.bindService(it, mainDataServiceConnection, Service.BIND_AUTO_CREATE);
        }

    }

}
