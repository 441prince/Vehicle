package com.example.vehicle.domain;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import com.example.vehicle.utilities.Constants;
import com.example.vehicleservice.IMainDataInterface;


/**
 * Not Used
 */


public class HmiMainDataServiceInterface  {

    protected IMainDataInterface mainDataInterface;



    public HmiMainDataServiceInterface(Context context) {
        bindServiceApp(context);
    }

    private void bindServiceApp(Context context) {
        if (mainDataInterface == null) {
            Intent serviceIntent = new Intent();
            serviceIntent.setPackage(Constants.SERVICE_PACKAGE);
            serviceIntent.setAction(Constants.MAIN_SERVICE_PACKAGE_NAME);
            // binding to remote service
            context.bindService(serviceIntent, mainDataServiceConnection, Service.BIND_AUTO_CREATE);
        }

    }

    ServiceConnection mainDataServiceConnection = new ServiceConnection() {

        @Override
        public void onServiceDisconnected(ComponentName name) {
            // TODO Auto-generated method stub
            mainDataInterface = null;
            Log.d("IRemote", "Binding - Main Data Service disconnected");
        }

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            // TODO Auto-generated method stub
            mainDataInterface = IMainDataInterface.Stub.asInterface((IBinder) service);
            Log.d("IRemote", "Binding is done - Main Data Service connected");
        }
    };

}
