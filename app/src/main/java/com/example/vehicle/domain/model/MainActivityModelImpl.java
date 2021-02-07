package com.example.vehicle.domain.model;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.Gravity;
import android.widget.Toast;

import com.example.vehicle.presentation.presenter.IMainActivityPresenter;
import com.example.vehicleservice.IMainDataInterface;

public class MainActivityModelImpl implements IMainActivityModel {

    IMainActivityPresenter mMainActivityPresenter;
    //HmiMainDataServiceInterface mHmiServiceInterface;
    protected IMainDataInterface mainDataInterface;
    public int autoClickCount = 1, acClickCount = 1, leftSeatClickCount = 1, fanClickCount = 1, rightSeatClickCount = 1, frontDefrostClickCount = 1, rearDefrostClickCount = 1;
    public int dogModeClickCount = 1, campModeClickCount = 1, userModeClickCount = 1;
    public String auto = "Off", ac = "Off", left_seat = "Off", fan = "Off", right_seat = "Off", front_defrost = "Off", rear_defrost = "Off", dog_mode = "Off", camp_mode = "Off", user_mode = "Off";


    public MainActivityModelImpl(IMainActivityPresenter presenter) {
        mMainActivityPresenter = presenter;
    }

    @Override
    public void init(Context context) {

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
        if (mainDataInterface == null) {
            Intent it = new Intent();
            it.setPackage("com.example.vehicleservice");
            it.setAction("service.MainData");
            // binding to remote service
            context.bindService(it, mainDataServiceConnection, Service.BIND_AUTO_CREATE);
        }


        //Log.d("Hmi", "init");
        //mHmiServiceInterface = new HmiMainDataServiceInterface(context);
    }

    @Override
    public void updateAutoButtonStatus(Context context) {

        try {
            if (mainDataInterface.autoButtonOn(autoClickCount) == 1) {
                auto = "On";
                mMainActivityPresenter.notifyAutoButtonStatus(autoClickCount);
                autoClickCount++;
            } else if (mainDataInterface.autoButtonOff(autoClickCount) == 2) {
                auto = "Off";
                mMainActivityPresenter.notifyAutoButtonStatus(autoClickCount);
                autoClickCount = 1;
            }
            Log.d("IRemote", "Binding - AutoButton operation");
        }
        catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @Override
    public void updateAcButtonStatus(Context context) {
        try{
            if (mainDataInterface.acButtonOn(acClickCount) == 1) {
                ac = "On";
                mMainActivityPresenter.notifyAcButtonStatus(acClickCount);
                acClickCount++;
            } else if (mainDataInterface.acButtonOff(acClickCount) == 2) {
                ac = "Off";
                mMainActivityPresenter.notifyAcButtonStatus(acClickCount);
                acClickCount = 1;
            }
            Log.d("IRemote", "Binding - AcButton operation");
        }
        catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @Override
    public void updateLeft_seatButtonStatus(Context context) {
        try{
            if (mainDataInterface.left_seatButtonOn(leftSeatClickCount) == 1) {
                left_seat = "Low Heat Mode On";
                mMainActivityPresenter.notifyLeft_seatButtonStatus(leftSeatClickCount);
                leftSeatClickCount++;
            } else if (mainDataInterface.left_seatButtonOn(leftSeatClickCount) == 2) {
                left_seat = "Medium Heat Mode On";
                mMainActivityPresenter.notifyLeft_seatButtonStatus(leftSeatClickCount);
                leftSeatClickCount++;
            } else if (mainDataInterface.left_seatButtonOn(leftSeatClickCount) == 3) {
                left_seat = "High Heat Mode On";
                mMainActivityPresenter.notifyLeft_seatButtonStatus(leftSeatClickCount);
                leftSeatClickCount++;
            } else if (mainDataInterface.left_seatButtonOff(leftSeatClickCount) == 4) {
                left_seat = "Heat Mode Off";
                mMainActivityPresenter.notifyLeft_seatButtonStatus(leftSeatClickCount);
                leftSeatClickCount = 1;
            }
            Log.d("IRemote", "Binding - LeftSeatButton operation");
        }
        catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @Override
    public void updateFanButtonStatus(Context context) {
        try{
            if (mainDataInterface.fanButtonOn(fanClickCount) == 1) {
                fan = "Opened";
                mMainActivityPresenter.notifyFanButtonStatus(fanClickCount);
                fanClickCount++;
            } else if (mainDataInterface.fanButtonOff(fanClickCount) == 2) {
                fan = "Closed";
                mMainActivityPresenter.notifyFanButtonStatus(fanClickCount);
                fanClickCount = 1;

            }
            Log.d("IRemote", "Binding - FanButton operation");
        }
        catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @Override
    public void updateRight_seatButtonStatus(Context context) {
        try{
            if (mainDataInterface.right_seatButtonOn(rightSeatClickCount) == 1) {
                right_seat = "Low Heat Mode On";
                mMainActivityPresenter.notifyRight_seatButtonStatus(rightSeatClickCount);
                rightSeatClickCount++;
            } else if (mainDataInterface.right_seatButtonOn(rightSeatClickCount) == 2) {
                right_seat = "Medium Heat Mode On";
                mMainActivityPresenter.notifyRight_seatButtonStatus(rightSeatClickCount);
                rightSeatClickCount++;
            } else if (mainDataInterface.right_seatButtonOn(rightSeatClickCount) == 3) {
                right_seat = "High Heat Mode On";
                mMainActivityPresenter.notifyRight_seatButtonStatus(rightSeatClickCount);
                rightSeatClickCount++;
            } else if (mainDataInterface.right_seatButtonOff(rightSeatClickCount) == 4) {
                right_seat = "Heat Mode Off";
                mMainActivityPresenter.notifyRight_seatButtonStatus(rightSeatClickCount);
                rightSeatClickCount = 1;
            }
            Log.d("IRemote", "Binding - RightSeatButton operation");
        }
        catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @Override
    public void updateFrontDefrostButtonStatus(Context context) {
        try {
            if (mainDataInterface.frontDefrostButtonOn(frontDefrostClickCount) == 1) {

                front_defrost = "On";
                mMainActivityPresenter.notifyFrontDefrostButtonStatus(frontDefrostClickCount);
                frontDefrostClickCount++;

            } else if (mainDataInterface.frontDefrostButtonOff(frontDefrostClickCount) == 2) {

                front_defrost = "Off";
                mMainActivityPresenter.notifyFrontDefrostButtonStatus(frontDefrostClickCount);
                frontDefrostClickCount = 1;

            }
        Log.d("IRemote", "Binding - frontDefrostButton operation");
        }
        catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void updateRearDefrostButtonStatus(Context context) {
        try {
            if (mainDataInterface.rearDefrostButtonOn(rearDefrostClickCount) == 1) {
                rear_defrost = "On";
                mMainActivityPresenter.notifyRearDefrostButtonStatus(rearDefrostClickCount);
            }
            for (int i = 0; i < 5; i++) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Toast toast = Toast.makeText(context, "Rear Defrosting....." + rearDefrostClickCount, Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER | Gravity.BOTTOM, 450, 100);
                        toast.show();
                        rearDefrostClickCount++;
                        try {
                            if (mainDataInterface.rearDefrostButtonOff(rearDefrostClickCount) == 6) {
                                rear_defrost = "Off";
                                mMainActivityPresenter.notifyRearDefrostButtonStatus(rearDefrostClickCount);
                                rearDefrostClickCount = 1;
                            }
                        } catch (RemoteException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                }, i * 1000);
            }
            Log.d("IRemote", "Binding - rearDefrostButton operation");
        }
        catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    @Override
    public void updateDogModeButtonStatus() {

        try{
            if (mainDataInterface.dogModeButtonOn(dogModeClickCount) == 1) {
                dog_mode = "Activated";
                camp_mode = "De-activated";
                user_mode = "De-activated";
                mMainActivityPresenter.notifyDogModeButtonStatus(dogModeClickCount);
                dogModeClickCount++;
            } else if (mainDataInterface.dogModeButtonOff(dogModeClickCount) == 2) {
                dog_mode = "De-activated";
                mMainActivityPresenter.notifyDogModeButtonStatus(dogModeClickCount);
                dogModeClickCount = 1;
            }
            Log.d("IRemote", "Binding - Dog Mode operation");
        }
        catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @Override
    public void updateCampModeButtonStatus() {

        try{
            if (mainDataInterface.campModeButtonOn(campModeClickCount) == 1) {
                camp_mode = "Activated";
                dog_mode = "De-activated";
                user_mode = "De-activated";
                mMainActivityPresenter.notifyCampModeButtonStatus(campModeClickCount);
                campModeClickCount++;
            } else if (mainDataInterface.campModeButtonOff(campModeClickCount) == 2) {
                camp_mode = "De-activated";
                mMainActivityPresenter.notifyCampModeButtonStatus(campModeClickCount);
                campModeClickCount = 1;
            }
            Log.d("IRemote", "Binding - Camp Mode operation");
        }
        catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void updateUserModeButtonStatus() {

        try{
            if (mainDataInterface.userModeButtonOn(userModeClickCount) == 1) {
                user_mode = "Activated";
                dog_mode = "De-activated";
                camp_mode = "De-activated";
                mMainActivityPresenter.notifyUserModeButtonStatus(userModeClickCount);
                userModeClickCount++;
            } else if (mainDataInterface.userModeButtonOff(userModeClickCount) == 2) {
                user_mode = "De-activated";
                mMainActivityPresenter.notifyUserModeButtonStatus(userModeClickCount);
                userModeClickCount = 1;
            }
            Log.d("IRemote", "Binding - Add operation");
        }
        catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
