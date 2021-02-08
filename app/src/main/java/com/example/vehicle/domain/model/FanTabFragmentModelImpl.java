package com.example.vehicle.domain.model;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.database.Cursor;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.widget.Toast;
import com.example.vehicle.domain.hmidata.DatabaseHelper;
import com.example.vehicle.presentation.presenter.IFanTabFragmentPresenter;
import com.example.vehicle.utilities.Constants;
import com.example.vehicleservice.IFanTabDataInterface;

/**
 * Created by Prince Joel
 */

public class FanTabFragmentModelImpl implements IFanTabFragmentModel {

    IFanTabFragmentPresenter mFanTabFragmentPresenter;
    ServiceConnection fanTabDataServiceConnection;
    protected IFanTabDataInterface fanTabDataInterface;
    private DatabaseHelper databaseHelper;
    public String ac_direction="Off",max_ac="Off",air_circulate="Off",bio_hazard="Off",rear_fan="Off", fan_speed;
    public String value;
    public int count=0;
    public int faceDirectionClickCount=1,feetDirectionClickCount=1,faceFeetDirectionClickCount=1,faceFeetWindShieldDirectionClickCount=1,maxAcClickCount=1,airCirculateClickCount=1,bioHazardClickCount=1,rearFanClickCount=1;


    public FanTabFragmentModelImpl(IFanTabFragmentPresenter presenter) {
        mFanTabFragmentPresenter = presenter;
    }

    @Override
    public void init(Context context) {

        /**
         * Database
         */
        this.databaseHelper = new DatabaseHelper(context);
        Cursor cursor= databaseHelper.getFanTabData();
        if (cursor.getCount()==0){
            Toast.makeText(context,"No data",Toast.LENGTH_SHORT).show();
        }
        else {
            while (cursor.moveToNext()){
                fan_speed=(cursor.getString(6));
                mFanTabFragmentPresenter.updateFromDatabase(fan_speed);
            }
        }

         /**
        * Service
        */

        Log.d("Hmi", "init");
        fanTabDataServiceConnection = new ServiceConnection() {

            @Override
            public void onServiceDisconnected(ComponentName name) {
                // TODO Auto-generated method stub
                fanTabDataInterface = null;
                mFanTabFragmentPresenter.notifyServiceConnectionStatus(0);
                Log.d("IRemote", "Binding - Fan Tab Data Service disconnected");
            }

            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                // TODO Auto-generated method stub


                fanTabDataInterface = IFanTabDataInterface.Stub.asInterface((IBinder) service);
                mFanTabFragmentPresenter.notifyServiceConnectionStatus(1);
                Log.d("IRemote", "Binding is done - Fan Tab Data Service connected");
            }
        };
        if (fanTabDataInterface == null) {
            Intent serviceIntent = new Intent();
            serviceIntent.setPackage(Constants.SERVICE_PACKAGE);
            serviceIntent.setAction(Constants.FAN_TAB_SERVICE_PACKAGE_NAME);
            // binding to remote service
            context.bindService(serviceIntent, fanTabDataServiceConnection, Service.BIND_AUTO_CREATE);
        }
    }

    @Override
    public void updateFaceDirectionButtonStatus(Context context) {
        try {
            if(fanTabDataInterface.faceDirectionButtonOn(faceDirectionClickCount)==1){
                ac_direction="To Face On";
                feetDirectionClickCount=1;
                faceFeetDirectionClickCount=1;
                faceFeetWindShieldDirectionClickCount=1;
                mFanTabFragmentPresenter.notifyFaceDirectionButtonStatus(faceDirectionClickCount);
                faceDirectionClickCount++;
            }else if(fanTabDataInterface.faceDirectionButtonOff(faceDirectionClickCount)==2){
                ac_direction="To Face Off";
                mFanTabFragmentPresenter.notifyFaceDirectionButtonStatus(faceDirectionClickCount);
                faceDirectionClickCount=1;
            }
        }
        catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void updateFeetDirectionButtonStatus(Context context) {
        try{
            if(fanTabDataInterface.feetDirectionButtonOn(feetDirectionClickCount)==1){
                ac_direction="To Feet On";
                faceDirectionClickCount=1;
                faceFeetDirectionClickCount=1;
                faceFeetWindShieldDirectionClickCount=1;
                mFanTabFragmentPresenter.notifyFeetDirectionButtonStatus(feetDirectionClickCount);
                feetDirectionClickCount++;
            }else if(fanTabDataInterface.feetDirectionButtonOff(feetDirectionClickCount)==2){
                ac_direction="To Feet Off";
                mFanTabFragmentPresenter.notifyFeetDirectionButtonStatus(feetDirectionClickCount);
                feetDirectionClickCount=1;
            }
        }
        catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @Override
    public void updateFaceFeetDirectionButtonStatus(Context context) {
        try{
            if(fanTabDataInterface.faceFeetDirectionButtonOn(faceFeetDirectionClickCount)==1){
                ac_direction="To Face and Feet On";
                faceDirectionClickCount=1;
                feetDirectionClickCount=1;
                faceFeetWindShieldDirectionClickCount=1;
                mFanTabFragmentPresenter.notifyFaceFeetDirectionButtonStatus(faceFeetDirectionClickCount);
                faceFeetDirectionClickCount++;
            }else if(fanTabDataInterface.faceFeetDirectionButtonOff(faceFeetDirectionClickCount)==2){
                ac_direction="To Face and Feet Off";
                mFanTabFragmentPresenter.notifyFaceFeetDirectionButtonStatus(faceFeetDirectionClickCount);
                faceFeetDirectionClickCount=1;
            }
        }
        catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @Override
    public void updateFaceFeetWindShieldDirectionButtonStatus(Context context) {
        try{
            if(fanTabDataInterface.faceFeetWindShieldDirectionButtonOn(faceFeetWindShieldDirectionClickCount)==1){
                ac_direction="To Face,Feet and WindShield On";
                faceDirectionClickCount=1;
                feetDirectionClickCount=1;
                faceFeetDirectionClickCount=1;
                mFanTabFragmentPresenter.notifyFaceFeetWindShieldDirectionButtonStatus(faceFeetWindShieldDirectionClickCount);
                faceFeetWindShieldDirectionClickCount++;
            }else if(fanTabDataInterface.faceFeetWindShieldDirectionButtonOff(faceFeetWindShieldDirectionClickCount)==2){
                ac_direction="To Face,Feet and WindShield Off";
                mFanTabFragmentPresenter.notifyFaceFeetWindShieldDirectionButtonStatus(faceFeetWindShieldDirectionClickCount);
                faceFeetWindShieldDirectionClickCount=1;
            }
        }
        catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @Override
    public void updateMaxAcButtonStatus(Context context) {
        try{
            if(fanTabDataInterface.maxAcButtonOn(maxAcClickCount)==1){
                max_ac="On";
                mFanTabFragmentPresenter.notifyMaxAcButtonStatus(maxAcClickCount);
                maxAcClickCount++;
            }else if(fanTabDataInterface.maxAcButtonOff(maxAcClickCount)==2){
                max_ac="Off";
                mFanTabFragmentPresenter.notifyMaxAcButtonStatus(maxAcClickCount);
                maxAcClickCount=1;
            }
        }
        catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @Override
    public void updateAirCirculateButtonStatus(Context context) {
        try {
            if(fanTabDataInterface.airCirculateButtonOn(airCirculateClickCount)==1){
                air_circulate="On";
                mFanTabFragmentPresenter.notifyAirCirculateButtonStatus(airCirculateClickCount);
                airCirculateClickCount++;
            }else if(fanTabDataInterface.airCirculateButtonOff(airCirculateClickCount)==2){
                air_circulate="Off";
                mFanTabFragmentPresenter.notifyAirCirculateButtonStatus(airCirculateClickCount);
                airCirculateClickCount=1;
            }
        }
        catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void updateBioHazardButtonStatus(Context context) {
        try {
            if(fanTabDataInterface.bioHazardButtonOn(bioHazardClickCount)==1){
                bio_hazard="On";
                mFanTabFragmentPresenter.notifyBioHazardButtonStatus(bioHazardClickCount);
                bioHazardClickCount++;
            }else if(fanTabDataInterface.bioHazardButtonOff(bioHazardClickCount)==2){
                bio_hazard="Off";
                mFanTabFragmentPresenter.notifyBioHazardButtonStatus(bioHazardClickCount);
                bioHazardClickCount=1;
            }
        }
        catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void updateRearFanButtonStatus(Context context) {
        try{
            if(fanTabDataInterface.rearFanButtonOn(rearFanClickCount)==1){
                rear_fan="On";
                mFanTabFragmentPresenter.notifyRearFanButtonStatus(rearFanClickCount);
                rearFanClickCount++;
            }else if(fanTabDataInterface.rearFanButtonOff(rearFanClickCount)==2){
                rear_fan="Off";
                mFanTabFragmentPresenter.notifyRearFanButtonStatus(rearFanClickCount);
                rearFanClickCount=1;
            }
        }
        catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @Override
    public void updateFanIncreaseSpeedStatus(Context context) {
        try{
            if(count<7){
                count++;
            }
            value=Integer.toString(count);
            if(fanTabDataInterface.fanSpeed(count)==count){
                mFanTabFragmentPresenter.notifyFanIncreaseSpeedStatus(value);
                fan_speed=value;
            }
        }
        catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    @Override
    public void updateFanDecreaseSpeedStatus(Context context) {
        try{
            if(count>0){
                count--;}
            value=Integer.toString(count);
            if(fanTabDataInterface.fanSpeed(count)==count){
                mFanTabFragmentPresenter.notifyFanDecreaseSpeedStatus(value);
                fan_speed=value;
            }
        }
        catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void updateServiceConnectionStatus(Context context) {
        context.unbindService(fanTabDataServiceConnection);
    }

    @Override
    public void updateDatabase(Context context) {
        this.databaseHelper = new DatabaseHelper(context);
        boolean isInserted = databaseHelper.insertFanTabData(ac_direction,max_ac,air_circulate,bio_hazard,rear_fan,fan_speed);
        if(isInserted==true)
            Toast.makeText(context,"Fan Tab Data saved",Toast.LENGTH_LONG).show();
        else
            Toast.makeText(context,"Data not Inserted",Toast.LENGTH_LONG).show();
    }

}
