package com.example.vehicle;

import android.app.Dialog;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import com.example.vehicle.domain.hmidata.DatabaseHelper;
import com.example.vehicle.presentation.view.HomeFragment;
import com.example.vehicle.presentation.view.TwoTabFragment;
import com.example.vehicleservice.DatabaseHelper2;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageButton autoImageButton;
    private ImageButton acImageButton;
    private ImageButton leftSeatImageButton;
    private ImageButton fanImageButton;
    private ImageButton rightSeatImageButton;
    private ImageButton frontDefrostImageButton;
    private ImageButton rearDefrostImageButton;
    private ImageButton carImageButton;
    private SeekBar customSeekBar;
    private TextView acTemperatureText;
    private DatabaseHelper databaseHelper;
    private Dialog usermode;
    private ImageButton dog,camp,user;
    public int autoClickCount=1,acClickCount=1,leftSeatClickCount=1,fanClickCount=1,rightSeatClickCount=1,frontDefrostClickCount=1,rearDefrostClickCount=1;;
    public int dogModeClickCount=1, campModeClickCount=1,userModeClickCount=1;
    public String auto ="Off", ac ="Off", left_seat="Off", fan="Off", right_seat="Off", front_defrost="Off", rear_defrost="Off", dog_mode="Off", camp_mode="Off", user_mode="Off";

    protected DatabaseHelper2 AddService;
    ServiceConnection AddServiceConnection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        initListeners();
        initObjects();

        /*Cursor cursor= databaseHelper.getFanTabData();
        if (cursor.getCount()==0){
            Toast.makeText(getApplicationContext(),"No data",Toast.LENGTH_SHORT).show();
        }
        else {
            while (cursor.moveToNext()){
               fanSpeedText.setText(cursor.getString(6));
            }
            while (cursor.moveToNext()){
                fanSpeedText.setText(cursor.getString(6));
            }
        }*/
        initConnection();

    }
    void initConnection() {
        AddServiceConnection = new ServiceConnection() {

            @Override
            public void onServiceDisconnected(ComponentName name) {
                // TODO Auto-generated method stub
                AddService = null;
                Toast.makeText(getApplicationContext(), "Service Disconnected",
                        Toast.LENGTH_SHORT).show();
                Log.d("IRemote", "Binding - Service disconnected");
            }

            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                // TODO Auto-generated method stub



                AddService = DatabaseHelper2.Stub.asInterface((IBinder) service);
                Toast.makeText(getApplicationContext(),
                        "Addition Service Connected", Toast.LENGTH_SHORT)
                        .show();
                Log.d("IRemote", "Binding is done - Service connected");
            }
        };
        if (AddService == null) {

            Intent it = new Intent();
            it.setPackage("com.example.vehicleservice");
            it.setAction("service.Calculator");
            // binding to remote service
            bindService(it, AddServiceConnection, Service.BIND_AUTO_CREATE);
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        unbindService(AddServiceConnection);
    };

    /*public void onClick(View v) {
        // TODO Auto-generated method stub
        switch (v.getId()) {
            case R.id.add: {
                int num1 = Integer.parseInt(etValue1.getText().toString());
                int num2 = Integer.parseInt(etValue2.getText().toString());
                try {
                    mSum.setText("Result:" + AddService.add(num1, num2));
                    Log.d("IRemote", "Binding - Add operation");
                } catch (RemoteException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            break;
        }
    }*/
    public void initViews(){

        autoImageButton = (ImageButton) findViewById(R.id.autoImageButton);
        acImageButton = (ImageButton) findViewById(R.id.acImageButton);
        leftSeatImageButton =(ImageButton) findViewById(R.id.leftSeatImageButton);
        fanImageButton = (ImageButton) findViewById(R.id.fanImageButton);
        rightSeatImageButton = (ImageButton) findViewById(R.id.rightSeatImageButton);
        frontDefrostImageButton = (ImageButton) findViewById(R.id.frontDefrostImageButton);
        rearDefrostImageButton = (ImageButton) findViewById(R.id.rearDefrostImageButton);
        carImageButton = (ImageButton) findViewById(R.id.carImageButton);
        customSeekBar = (SeekBar) findViewById(R.id.customSeekBar);
        acTemperatureText= findViewById(R.id.acTemperatureText);

        customSeekBar.setVisibility(View.GONE);
        acTemperatureText.setVisibility(View.GONE);

    }

    public void initListeners(){

        this.autoImageButton.setOnClickListener(this);
        this.acImageButton.setOnClickListener(this);
        this.leftSeatImageButton.setOnClickListener(this);
        this.fanImageButton.setOnClickListener(this);
        this.rightSeatImageButton.setOnClickListener(this);
        this.frontDefrostImageButton.setOnClickListener(this);
        this.rearDefrostImageButton.setOnClickListener(this);
        //this.carImageButton.setOnClickListener(this);

    }

    public void initObjects(){

        this.databaseHelper = new DatabaseHelper(this);
        this.usermode = new Dialog(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.autoImageButton:
                    try {
                        if(AddService.AutoButton(autoClickCount)==1){
                            auto ="On";
                            autoImageButton.setImageResource(R.drawable.autoon);
                            Toast.makeText(getApplicationContext(),"Auto On",Toast.LENGTH_SHORT).show();
                            autoClickCount++;
                        }
                        else if(AddService.AutoButtonOff(autoClickCount)==2){
                            auto ="Off";
                            autoImageButton.setImageResource(R.drawable.autobutton);
                            Toast.makeText(this, "Auto" + auto, Toast.LENGTH_SHORT).show();
                            autoClickCount=1;
                        }
                        Log.d("IRemote", "Binding - Add operation");
                    } catch (RemoteException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }


                return;

            case R.id.acImageButton:
                try {
                    if(AddService.AutoButton(acClickCount)==1){
                        ac ="On";
                        acImageButton.setImageResource(R.drawable.acon);
                        Toast.makeText(getApplicationContext(),"AC On",Toast.LENGTH_SHORT).show();
                        acClickCount++;
                    }else if(AddService.AutoButton(acClickCount)==2){
                        ac ="Off";
                        acImageButton.setImageResource(R.drawable.ac);
                        Toast.makeText(getApplicationContext(),"AC Off",Toast.LENGTH_SHORT).show();
                        acClickCount=1;
                    }
                    Log.d("IRemote", "Binding - Add operation");
                }catch (RemoteException e){
                    e.printStackTrace();
                }

                customSeekBar.setVisibility(View.VISIBLE);
                acTemperatureText.setVisibility(View.GONE);
                customSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        //ac_temp.setText(String.format("%d°C",progress));
                        int val = (progress * (seekBar.getWidth() - 5 * seekBar.getThumbOffset())) / seekBar.getMax();
                        acTemperatureText.setText(String.format("%d°C",progress));
                        acTemperatureText.setX(seekBar.getX()-100 + val + seekBar.getThumbOffset() / 2);
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {
                        acTemperatureText.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                        acTemperatureText.setVisibility(View.GONE);
                        customSeekBar.setVisibility(View.GONE);
                    }

                });
                return;

            case R.id.leftSeatImageButton:

                if(leftSeatClickCount==1){
                    left_seat="Low Heat Mode On";
                    leftSeatImageButton.setImageResource(R.drawable.leftlow);
                    Toast.makeText(getApplicationContext(),"Low Heat Mode On",Toast.LENGTH_SHORT).show();
                    leftSeatClickCount++;
                }else if(leftSeatClickCount==2){
                    left_seat="Medium Heat Mode On";
                    leftSeatImageButton.setImageResource(R.drawable.leftmed);
                    Toast.makeText(getApplicationContext(),"Medium Heat Mode On",Toast.LENGTH_SHORT).show();
                    leftSeatClickCount++;
                }else if(leftSeatClickCount==3){
                    left_seat="High Heat Mode On";
                    leftSeatImageButton.setImageResource(R.drawable.lefthigh);
                    Toast.makeText(getApplicationContext(),"High Heat Mode On",Toast.LENGTH_SHORT).show();
                    leftSeatClickCount++;
                }else if(leftSeatClickCount==4){
                    left_seat="Heat Mode Off";
                    leftSeatImageButton.setImageResource(R.drawable.leftseat);
                    Toast.makeText(getApplicationContext()," Heat Mode Off",Toast.LENGTH_SHORT).show();
                    leftSeatClickCount=1;
                }
                return;

            case R.id.fanImageButton:

                if(fanClickCount==1){
                    fan="Opened";
                    fanImageButton.animate().rotation(fanImageButton.getRotation()+360).start();
                    FragmentTransaction ft= getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.framelayout,new TwoTabFragment());
                    ft.commit();
                    fanClickCount++;
                }else if(fanClickCount==2){
                    fan="Closed";
                    fanImageButton.animate().rotation(fanImageButton.getRotation()-360).start();
                    FragmentTransaction ft= getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.framelayout,new HomeFragment());
                    ft.commit();
                    fanClickCount=1;
                }

                return;
            case R.id.rightSeatImageButton:

                if(rightSeatClickCount==1){
                    right_seat="Low Heat Mode On";
                    rightSeatImageButton.setImageResource(R.drawable.rightlow);
                    Toast.makeText(getApplicationContext(),"Low Heat Mode On",Toast.LENGTH_SHORT).show();
                    rightSeatClickCount++;
                }else if(rightSeatClickCount==2){
                    right_seat="Medium Heat Mode On";
                    rightSeatImageButton.setImageResource(R.drawable.rightmed);
                    Toast.makeText(getApplicationContext(),"Medium Heat Mode On",Toast.LENGTH_SHORT).show();
                    rightSeatClickCount++;
                }else if(rightSeatClickCount==3){
                    right_seat="High Heat Mode On";
                    rightSeatImageButton.setImageResource(R.drawable.righthigh);
                    Toast.makeText(getApplicationContext(),"High Heat Mode On",Toast.LENGTH_SHORT).show();
                    rightSeatClickCount++;
                }else if(rightSeatClickCount==4){
                    right_seat="Heat Mode Off";
                    rightSeatImageButton.setImageResource(R.drawable.rightseat);
                    Toast.makeText(getApplicationContext(),"Heat Mode Off",Toast.LENGTH_SHORT).show();
                    rightSeatClickCount=1;
                }
                return;

            case R.id.frontDefrostImageButton:   //front defrost mode

                try {
                    if(AddService.DefrostButtonOn(frontDefrostClickCount)==1){
                        front_defrost="On";
                        frontDefrostImageButton.setImageResource(R.drawable.defroston);
                        Toast.makeText(getApplicationContext(),"Defrost On",Toast.LENGTH_SHORT).show();
                        frontDefrostClickCount++;
                    }else if(AddService.DefrostButtonOff(frontDefrostClickCount)==2){
                        front_defrost="Off";
                        frontDefrostImageButton.setImageResource(R.drawable.frontdefrost);
                        Toast.makeText(getApplicationContext(),"Defrost Off",Toast.LENGTH_SHORT).show();
                        frontDefrostClickCount=1;
                    }
                    Log.d("IRemote", "Binding - Add operation");
                }catch (RemoteException e){

                    e.printStackTrace();
                }


                return;

            case R.id.rearDefrostImageButton:   //rear defrost mode

                try {

                    if (AddService.RearDefrostButtonOn(rearDefrostClickCount) == 1) {
                        rear_defrost = "On";
                        rearDefrostImageButton.setImageResource(R.drawable.reardefroston);
                        Toast.makeText(getApplicationContext(), "Rear Defrost On", Toast.LENGTH_SHORT).show();

                    }
                    for (int i = 0; i < 5; i++) {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Toast toast = Toast.makeText(getApplicationContext(), "Rear Defrosting....." + rearDefrostClickCount, Toast.LENGTH_SHORT);
                                toast.setGravity(Gravity.CENTER | Gravity.BOTTOM, 450, 100);
                                toast.show();
                                rearDefrostClickCount++;
                                if (rearDefrostClickCount == 6) {
                                    rear_defrost = "Off";
                                    rearDefrostImageButton.setImageResource(R.drawable.reardefrost);
                                    Toast.makeText(getApplicationContext(), "Rear Defrost Off", Toast.LENGTH_SHORT).show();
                                    rearDefrostClickCount = 1;

                                }
                            }
                        }, i * 1000);

                    }
                    Log.d("IRemote", "Binding - Add operation");
                }catch (RemoteException e){
                    e.printStackTrace();
                }
                return;
            default:
                return;
        }
    }

    public void popup(View view){
        usermode.setContentView(R.layout.custommode);
        dog=(ImageButton) usermode.findViewById(R.id.dog);
        camp=(ImageButton) usermode.findViewById(R.id.camp);
        user=(ImageButton) usermode.findViewById(R.id.user);
        dog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                      if(AddService.UserButtonOn(dogModeClickCount)==1){
                    dog_mode="Activated";
                    carImageButton.setImageResource(R.drawable.dogon);
                    Toast.makeText(getApplicationContext(),"Dog Mode is activated",Toast.LENGTH_SHORT).show();
                    dogModeClickCount++;
                }else if(AddService.UserButtonOff(dogModeClickCount)==2){
                    dog_mode="De-activated";
                    carImageButton.setImageResource(R.drawable.car);
                    Toast.makeText(getApplicationContext(),"Dog mode is De-activated",Toast.LENGTH_SHORT).show();
                    dogModeClickCount=1;
                }

                usermode.dismiss();
                    Log.d("IRemote", "Binding - Add operation");
                }
                catch (RemoteException e){
                    e.printStackTrace();
                }
            }
        });

        camp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                camp_mode="Activated";
                camp.setBackgroundColor(getResources().getColor(R.color.Blue));

                try {
                    if(AddService.UserButtonOn(campModeClickCount)==1){

                        carImageButton.setImageResource(R.drawable.campon);
                        Toast.makeText(getApplicationContext(),"Camp Mode is activated",Toast.LENGTH_SHORT).show();
                        campModeClickCount++;
                    }else if(AddService.UserButtonOff(campModeClickCount)==2){
                        camp_mode="De-activated";
                        carImageButton.setImageResource(R.drawable.car);
                        Toast.makeText(getApplicationContext(),"Camp mode is De-activated",Toast.LENGTH_SHORT).show();
                        campModeClickCount=1;
                    }
                    usermode.dismiss();
                    Log.d("IRemote", "Binding - Add operation");
                }catch (RemoteException e){
                    e.printStackTrace();
                }

            }

        });

        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.setBackgroundColor(getResources().getColor(R.color.Blue));

                try {
                    if(AddService.UserButtonOn(userModeClickCount)==1){
                        user_mode="Activated";
                        carImageButton.setImageResource(R.drawable.useron);
                        Toast.makeText(getApplicationContext(),"User Mode is activated",Toast.LENGTH_SHORT).show();
                        userModeClickCount++;
                    }else if(AddService.UserButtonOff(userModeClickCount)==2){
                        user_mode="De-activated";
                        carImageButton.setImageResource(R.drawable.car);
                        Toast.makeText(getApplicationContext(),"User mode is De-activated",Toast.LENGTH_SHORT).show();
                        userModeClickCount=1;
                    }
                    usermode.dismiss();
                    Log.d("IRemote", "Binding - Add operation");
                }catch (RemoteException e){
                    e.printStackTrace();
                }

            }

        });
        Window window = usermode.getWindow();
        window.setGravity(Gravity.TOP | Gravity.RIGHT);
        usermode.show();
        usermode.getWindow().getDecorView().setBackgroundResource(android.R.color.transparent);
    }

    @Override
    public void onStop() {
        super.onStop();
        boolean isInserted = databaseHelper.insertMainData(auto, ac, left_seat, fan, right_seat, front_defrost, rear_defrost, dog_mode, camp_mode, user_mode);
        if(isInserted==true)
            Toast.makeText(getApplicationContext(),"Main Data saved",Toast.LENGTH_LONG).show();
        else
            Toast.makeText(getApplicationContext(),"Data not Inserted",Toast.LENGTH_LONG).show();

    }
}