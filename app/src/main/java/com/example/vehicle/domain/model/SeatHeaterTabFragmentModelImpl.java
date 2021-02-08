package com.example.vehicle.domain.model;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.widget.Toast;
import com.example.vehicle.domain.hmidata.DatabaseHelper;
import com.example.vehicle.presentation.presenter.ISeatHeaterTabFragmentPresenter;
import com.example.vehicle.utilities.Constants;
import com.example.vehicleservice.ISeatHeaterTabDataInterface;

/**
 * Created by Prince Joel
 */

public class SeatHeaterTabFragmentModelImpl implements ISeatHeaterTabFragmentModel {

    ISeatHeaterTabFragmentPresenter mSeatHeaterTabFragmentPresenter;
    ServiceConnection seatHeaterTabDataServiceConnection;
    protected ISeatHeaterTabDataInterface seatHeaterTabDataInterface;
    private DatabaseHelper databaseHelper;
    public String driver_seat="Off", pillion_seat="Off", third_seat="Off", fourth_seat="Off", fifth_seat="Off";
    public int driverSeatClickCount=1,pillionSeatClickCount=1,thirdSeatClickCount=1, fourthSeatClickCount=1,fifthSeatClickCount=1;


    public SeatHeaterTabFragmentModelImpl(ISeatHeaterTabFragmentPresenter presenter) {
        mSeatHeaterTabFragmentPresenter = presenter;
    }

    @Override
    public void init(Context context) {

        Log.d("Hmi", "init");
        seatHeaterTabDataServiceConnection = new ServiceConnection() {

            @Override
            public void onServiceDisconnected(ComponentName name) {
                // TODO Auto-generated method stub
                seatHeaterTabDataInterface = null;
                mSeatHeaterTabFragmentPresenter.notifyServiceConnectionStatus(0);
                Log.d("IRemote", "Binding - Seat Heater Tab Data Service disconnected");
            }

            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                // TODO Auto-generated method stub
                seatHeaterTabDataInterface = ISeatHeaterTabDataInterface.Stub.asInterface((IBinder) service);
                mSeatHeaterTabFragmentPresenter.notifyServiceConnectionStatus(1);
                Log.d("IRemote", "Binding is done - Seat Heater Tab Data Service connected");
            }
        };
        if (seatHeaterTabDataInterface == null) {
            Intent serviceIntent = new Intent();
            serviceIntent.setPackage(Constants.SERVICE_PACKAGE);
            serviceIntent.setAction(Constants.SEAT_HEATER_TAB_SERVICE_PACKAGE_NAME);
            // binding to remote service
            context.bindService(serviceIntent, seatHeaterTabDataServiceConnection, Service.BIND_AUTO_CREATE);
        }
    }

    @Override
    public void updateAllOffButtonStatus(Context context) {
        try {
            int num=1;
            if(seatHeaterTabDataInterface.allOffButton(num)==1){
                driver_seat="Off";
                pillion_seat="Off";
                third_seat="Off";
                fourth_seat="Off";
                fifth_seat="Off";
                mSeatHeaterTabFragmentPresenter.notifyAllOffButtonStatus(num);
            }
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void updateDriverSeatButtonStatus(Context context) {
        try {
            if(seatHeaterTabDataInterface.driverSeatButtonOn(driverSeatClickCount)==1){
                driver_seat="Low Heat Mode On";
                mSeatHeaterTabFragmentPresenter.notifyDriverSeatButtonStatus(driverSeatClickCount);
                driverSeatClickCount++;
            }else if(seatHeaterTabDataInterface.driverSeatButtonOn(driverSeatClickCount)==2){
                driver_seat="Medium Heat Mode On";
                mSeatHeaterTabFragmentPresenter.notifyDriverSeatButtonStatus(driverSeatClickCount);
                driverSeatClickCount++;
            }else if(seatHeaterTabDataInterface.driverSeatButtonOn(driverSeatClickCount)==3){
                driver_seat="High Heat Mode On";
                mSeatHeaterTabFragmentPresenter.notifyDriverSeatButtonStatus(driverSeatClickCount);
                driverSeatClickCount++;
            }else if(seatHeaterTabDataInterface.driverSeatButtonOff(driverSeatClickCount)==4) {
                driver_seat=" Heat Mode Off";
                mSeatHeaterTabFragmentPresenter.notifyDriverSeatButtonStatus(driverSeatClickCount);
                driverSeatClickCount=1;
            }

        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void updatePillionSeatButtonStatus(Context context) {
        try {
            if(seatHeaterTabDataInterface.pillionSeatButtonOn(pillionSeatClickCount)==1){
                pillion_seat="Low Heat Mode On";
                mSeatHeaterTabFragmentPresenter.notifyPillionSeatButtonStatus(pillionSeatClickCount);
                pillionSeatClickCount++;
            }else if(seatHeaterTabDataInterface.pillionSeatButtonOn(pillionSeatClickCount)==2){
                pillion_seat="Medium Heat Mode On";
                mSeatHeaterTabFragmentPresenter.notifyPillionSeatButtonStatus(pillionSeatClickCount);
                pillionSeatClickCount++;
            }else if(seatHeaterTabDataInterface.pillionSeatButtonOn(pillionSeatClickCount)==3){
                pillion_seat="High Heat Mode On";
                mSeatHeaterTabFragmentPresenter.notifyPillionSeatButtonStatus(pillionSeatClickCount);
                pillionSeatClickCount++;
            }else if(seatHeaterTabDataInterface.pillionSeatButtonOff(pillionSeatClickCount)==4) {
                pillion_seat="Heat Mode Off";
                mSeatHeaterTabFragmentPresenter.notifyPillionSeatButtonStatus(pillionSeatClickCount);
                pillionSeatClickCount=1;
            }
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void updateThirdSeatButtonStatus(Context context) {
        try {
            if(seatHeaterTabDataInterface.thirdSeatButtonOn(thirdSeatClickCount)==1){
                third_seat="Low Heat Mode On";
                mSeatHeaterTabFragmentPresenter.notifyThirdSeatButtonStatus(thirdSeatClickCount);
                thirdSeatClickCount++;
            }else if(seatHeaterTabDataInterface.thirdSeatButtonOn(thirdSeatClickCount)==2){
                third_seat="Medium Heat Mode On";
                mSeatHeaterTabFragmentPresenter.notifyThirdSeatButtonStatus(thirdSeatClickCount);
                thirdSeatClickCount++;
            }else if(seatHeaterTabDataInterface.thirdSeatButtonOn(thirdSeatClickCount)==3){
                third_seat="High Heat Mode On";
                mSeatHeaterTabFragmentPresenter.notifyThirdSeatButtonStatus(thirdSeatClickCount);
                thirdSeatClickCount++;
            }else if(seatHeaterTabDataInterface.thirdSeatButtonOff(thirdSeatClickCount)==4) {
                third_seat="Heat Mode Off";
                mSeatHeaterTabFragmentPresenter.notifyThirdSeatButtonStatus(thirdSeatClickCount);
                thirdSeatClickCount=1;
            }
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void updateFourthSeatButtonStatus(Context context) {
        try {

            if(seatHeaterTabDataInterface.fourthSeatButtonOn(fourthSeatClickCount)==1){
                fourth_seat="Low Heat Mode On";
                mSeatHeaterTabFragmentPresenter.notifyFourthSeatButtonStatus(fourthSeatClickCount);
                fourthSeatClickCount++;
            }else if(seatHeaterTabDataInterface.fourthSeatButtonOn(fourthSeatClickCount)==2){
                fourth_seat="Medium Heat Mode On";
                mSeatHeaterTabFragmentPresenter.notifyFourthSeatButtonStatus(fourthSeatClickCount);
                fourthSeatClickCount++;
            }else if(seatHeaterTabDataInterface.fourthSeatButtonOn(fourthSeatClickCount)==3){
                fourth_seat="High Heat Mode On";
                mSeatHeaterTabFragmentPresenter.notifyFourthSeatButtonStatus(fourthSeatClickCount);
                fourthSeatClickCount++;
            }else if(seatHeaterTabDataInterface.fourthSeatButtonOff(fourthSeatClickCount)==4) {
                fourth_seat="Heat Mode Off";
                mSeatHeaterTabFragmentPresenter.notifyFourthSeatButtonStatus(fourthSeatClickCount);
                fourthSeatClickCount=1;
            }
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void updateFifthSeatButtonStatus(Context context) {
        try {
            if(seatHeaterTabDataInterface.fifthSeatButtonOn(fifthSeatClickCount)==1){
                fifth_seat="Low Heat Mode On";
                mSeatHeaterTabFragmentPresenter.notifyFifthSeatButtonStatus(fifthSeatClickCount);
                fifthSeatClickCount++;
            }else if(seatHeaterTabDataInterface.fifthSeatButtonOn(fifthSeatClickCount)==2){
                fifth_seat="Medium Heat Mode On";
                mSeatHeaterTabFragmentPresenter.notifyFifthSeatButtonStatus(fifthSeatClickCount);
                fifthSeatClickCount++;
            }else if(seatHeaterTabDataInterface.fifthSeatButtonOn(fifthSeatClickCount)==3){
                fifth_seat="High Heat Mode On";
                mSeatHeaterTabFragmentPresenter.notifyFifthSeatButtonStatus(fifthSeatClickCount);
                fifthSeatClickCount++;
            }else if(seatHeaterTabDataInterface.fifthSeatButtonOff(fifthSeatClickCount)==4) {
                fifth_seat="Heat Mode Off";
                mSeatHeaterTabFragmentPresenter.notifyFifthSeatButtonStatus(fifthSeatClickCount);
                fifthSeatClickCount=1;
            }
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void updateServiceConnectionStatus(Context context) {
        context.unbindService(seatHeaterTabDataServiceConnection);
    }

    @Override
    public void updateDatabase(Context context) {
        this.databaseHelper = new DatabaseHelper(context);
        boolean isInserted = databaseHelper.insertSeatTabData(driver_seat, pillion_seat, third_seat, fourth_seat, fifth_seat);
        if(isInserted==true)
            Toast.makeText(context,"Seat Tab Data saved",Toast.LENGTH_LONG).show();
        else
            Toast.makeText(context,"Data not Inserted",Toast.LENGTH_LONG).show();
    }

}
