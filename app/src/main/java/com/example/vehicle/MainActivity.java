package com.example.vehicle;

import android.app.Dialog;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
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
import com.example.vehicle.presentation.presenter.IMainActivityPresenter;
import com.example.vehicle.presentation.presenter.MainActivityPresenterImpl;
import com.example.vehicle.presentation.view.IMainActivityView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener , IMainActivityView {

    private ImageButton autoImageButton;
    private ImageButton acImageButton;
    private ImageButton leftSeatImageButton;
    private ImageButton fanImageButton;
    private ImageButton rightSeatImageButton;
    private ImageButton frontDefrostImageButton;
    private ImageButton rearDefrostImageButton;
    private ImageButton carImageButton;
    private SeekBar customSeekBar;
    private TextView acTemperatureText, batteryPercentage;
    private Dialog userMode;
    private ImageButton dog, camp, user;
    private BatteryReceiver batteryReceiver;
    private IntentFilter mIntentFilter;
    private MyBroadcastReceiver MyReceiver;
    private IMainActivityPresenter mMainActivityPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("HMI MainActivity", "onCreate() called");

        batteryReceiver = new BatteryReceiver();
        mIntentFilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        initBroadcastReceiver();
        initViews();
        initListeners();
        initObjects();


    }
    void initBroadcastReceiver(){
        MyReceiver = new MyBroadcastReceiver();
        IntentFilter intentFilter = new IntentFilter("com.example.vehicleservice");
        if(intentFilter != null)
        {
            Log.d("HMI MainActivity", "onCreate() called");
            registerReceiver(MyReceiver, intentFilter);
        }
    }

    public void initViews() {

        autoImageButton = (ImageButton) findViewById(R.id.autoImageButton);
        acImageButton = (ImageButton) findViewById(R.id.acImageButton);
        leftSeatImageButton = (ImageButton) findViewById(R.id.leftSeatImageButton);
        fanImageButton = (ImageButton) findViewById(R.id.fanImageButton);
        rightSeatImageButton = (ImageButton) findViewById(R.id.rightSeatImageButton);
        frontDefrostImageButton = (ImageButton) findViewById(R.id.frontDefrostImageButton);
        rearDefrostImageButton = (ImageButton) findViewById(R.id.rearDefrostImageButton);
        carImageButton = (ImageButton) findViewById(R.id.carImageButton);
        customSeekBar = (SeekBar) findViewById(R.id.customSeekBar);
        acTemperatureText = findViewById(R.id.acTemperatureText);
        batteryPercentage = findViewById(R.id.batteryPercentage);
        customSeekBar.setVisibility(View.GONE);
        acTemperatureText.setVisibility(View.GONE);

    }

    public void initListeners() {

        this.autoImageButton.setOnClickListener(this);
        this.acImageButton.setOnClickListener(this);
        this.leftSeatImageButton.setOnClickListener(this);
        this.fanImageButton.setOnClickListener(this);
        this.rightSeatImageButton.setOnClickListener(this);
        this.frontDefrostImageButton.setOnClickListener(this);
        this.rearDefrostImageButton.setOnClickListener(this);

    }

    public void initObjects() {

        this.userMode = new Dialog(this);
        mMainActivityPresenter = new MainActivityPresenterImpl(this);
        mMainActivityPresenter.init(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.autoImageButton:
                if (mMainActivityPresenter != null) {
                    mMainActivityPresenter.updateAutoButtonStatus(this);
                }
                return;

            case R.id.acImageButton:
                if (mMainActivityPresenter != null) {
                    mMainActivityPresenter.updateAcButtonStatus(this);
                }
                return;

            case R.id.leftSeatImageButton:
                if (mMainActivityPresenter != null) {
                    mMainActivityPresenter.updateLeft_seatButtonStatus(this);
                }
                return;

            case R.id.fanImageButton:
                if (mMainActivityPresenter != null) {
                    mMainActivityPresenter.updateFanButtonStatus(this);
                }
                return;

            case R.id.rightSeatImageButton:
                if (mMainActivityPresenter != null) {
                    mMainActivityPresenter.updateRight_seatButtonStatus(this);
                }
                return;

            case R.id.frontDefrostImageButton://front defrost mode
                if (mMainActivityPresenter != null) {
                    mMainActivityPresenter.updateFrontDefrostButtonStatus(this);
                }
                return;

            case R.id.rearDefrostImageButton:   //rear defrost mode
                if (mMainActivityPresenter != null) {
                    mMainActivityPresenter.updateRearDefrostButtonStatus(this);
                }
                return;
            default:
                return;
        }
    }

    public void popup (View view){
        userMode.setContentView(R.layout.custommode);
        dog = (ImageButton) userMode.findViewById(R.id.dog);
        camp = (ImageButton) userMode.findViewById(R.id.camp);
        user = (ImageButton) userMode.findViewById(R.id.user);
        dog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mMainActivityPresenter != null) {
                    mMainActivityPresenter.updateDogModeButtonStatus();
                }
            }
        });
        camp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mMainActivityPresenter != null) {
                    mMainActivityPresenter.updateCampModeButtonStatus();
                }
            }
        });
        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mMainActivityPresenter != null) {
                    mMainActivityPresenter.updateUserModeButtonStatus();
                }
            }
        });
        Window window = userMode.getWindow();
        window.setGravity(Gravity.TOP | Gravity.RIGHT);
        userMode.show();
        userMode.getWindow().getDecorView().setBackgroundResource(android.R.color.transparent);
    }


    @Override
    public void notifyAutoButtonStatus(int num) {
        if (num == 1) {
            autoImageButton.setImageResource(R.drawable.autoon);
            Toast.makeText(getApplicationContext(), "Auto On", Toast.LENGTH_SHORT).show();
        } else if (num == 2) {
            autoImageButton.setImageResource(R.drawable.autobutton);
            Toast.makeText(getApplicationContext(), "Auto Off" , Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void notifyAcButtonStatus(int num) {
        if (num == 1) {
            acImageButton.setImageResource(R.drawable.acon);
            Toast.makeText(getApplicationContext(), "AC On", Toast.LENGTH_SHORT).show();
            customSeekBar.setVisibility(View.VISIBLE);
            acTemperatureText.setVisibility(View.GONE);
            customSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    //ac_temp.setText(String.format("%d°C",progress));
                    int val = (progress * (seekBar.getWidth() - 5 * seekBar.getThumbOffset())) / seekBar.getMax();
                    acTemperatureText.setText(String.format("%d°C", progress));
                    acTemperatureText.setX(seekBar.getX() - 100 + val + seekBar.getThumbOffset() / 2);
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
        } else if (num == 2) {
            acImageButton.setImageResource(R.drawable.ac);
            Toast.makeText(getApplicationContext(), "AC Off", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void notifyLeft_seatButtonStatus(int num) {
        if (num == 1) {
            leftSeatImageButton.setImageResource(R.drawable.leftlow);
            Toast.makeText(getApplicationContext(), "Low Heat Mode On", Toast.LENGTH_SHORT).show();
        } else if (num == 2) {
            leftSeatImageButton.setImageResource(R.drawable.leftmed);
            Toast.makeText(getApplicationContext(), "Medium Heat Mode On", Toast.LENGTH_SHORT).show();
        } else if (num == 3) {
            leftSeatImageButton.setImageResource(R.drawable.lefthigh);
            Toast.makeText(getApplicationContext(), "High Heat Mode On", Toast.LENGTH_SHORT).show();
        } else if (num == 4) {
            leftSeatImageButton.setImageResource(R.drawable.leftseat);
            Toast.makeText(getApplicationContext(), " Heat Mode Off", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void notifyFanButtonStatus(int num) {

        if (num == 1) {
            fanImageButton.animate().rotation(fanImageButton.getRotation() + 360).start();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.framelayout, new TwoTabFragment());
            ft.commit();
        } else if (num == 2) {
            fanImageButton.animate().rotation(fanImageButton.getRotation() - 360).start();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.framelayout, new HomeFragment());
            ft.commit();
        }
    }

    @Override
    public void notifyRight_seatButtonStatus(int num) {
        if (num == 1) {
            rightSeatImageButton.setImageResource(R.drawable.rightlow);
            Toast.makeText(getApplicationContext(), "Low Heat Mode On", Toast.LENGTH_SHORT).show();
        } else if (num == 2) {
            rightSeatImageButton.setImageResource(R.drawable.rightmed);
            Toast.makeText(getApplicationContext(), "Medium Heat Mode On", Toast.LENGTH_SHORT).show();
        } else if (num == 3) {
            rightSeatImageButton.setImageResource(R.drawable.righthigh);
            Toast.makeText(getApplicationContext(), "High Heat Mode On", Toast.LENGTH_SHORT).show();
        } else if (num == 4) {
            rightSeatImageButton.setImageResource(R.drawable.rightseat);
            Toast.makeText(getApplicationContext(), "Heat Mode Off", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void notifyFrontDefrostButtonStatus(int num) {
        if (num == 1) {
            frontDefrostImageButton.setImageResource(R.drawable.defroston);
            Toast.makeText(getApplicationContext(), "Defrost On", Toast.LENGTH_SHORT).show();
        } else if (num == 2) {
            frontDefrostImageButton.setImageResource(R.drawable.frontdefrost);
            Toast.makeText(getApplicationContext(), "Defrost Off", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void notifyRearDefrostButtonStatus(int num) {
        if (num == 1) {
            rearDefrostImageButton.setImageResource(R.drawable.reardefroston);
            Toast.makeText(getApplicationContext(), "Rear Defrost On", Toast.LENGTH_SHORT).show();
        }
        if (num == 6) {
            rearDefrostImageButton.setImageResource(R.drawable.reardefrost);
            Toast.makeText(getApplicationContext(), "Rear Defrost Off", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void notifyDogModeButtonStatus(int num) {

        if (num == 1) {
            carImageButton.setImageResource(R.drawable.dogon);
            Toast.makeText(getApplicationContext(), "Dog Mode is activated", Toast.LENGTH_SHORT).show();
        } else if (num == 2) {
            carImageButton.setImageResource(R.drawable.car);
            Toast.makeText(getApplicationContext(), "Dog mode is De-activated", Toast.LENGTH_SHORT).show();
        }
        userMode.dismiss();
    }

    @Override
    public void notifyCampModeButtonStatus(int num) {
        camp.setBackgroundColor(getResources().getColor(R.color.Blue));
        if (num == 1) {
            carImageButton.setImageResource(R.drawable.campon);
            Toast.makeText(getApplicationContext(), "Camp Mode is activated", Toast.LENGTH_SHORT).show();
        } else if (num == 2) {
            carImageButton.setImageResource(R.drawable.car);
            Toast.makeText(getApplicationContext(), "Camp mode is De-activated", Toast.LENGTH_SHORT).show();
        }
        userMode.dismiss();
        Log.d("IRemote", "Binding - Add operation");
    }

    @Override
    public void notifyUserModeButtonStatus(int num) {
        user.setBackgroundColor(getResources().getColor(R.color.Blue));
        if (num == 1) {
            carImageButton.setImageResource(R.drawable.useron);
            Toast.makeText(getApplicationContext(), "User Mode is activated", Toast.LENGTH_SHORT).show();
        } else if (num == 2) {
            carImageButton.setImageResource(R.drawable.car);
            Toast.makeText(getApplicationContext(), "User mode is De-activated", Toast.LENGTH_SHORT).show();
        }
        userMode.dismiss();
        Log.d("IRemote", "Binding - Add operation");

    }

    @Override
    public void notifyServiceConnectionStatus(int num) {
        if(num==1){
            Toast.makeText(getApplicationContext(), "Main Data Service connected", Toast.LENGTH_SHORT).show();
        }
        else if(num==0){
            Toast.makeText(getApplicationContext(), "Main Data Service Disconnected", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onResume () {
        super.onResume();
        registerReceiver(batteryReceiver, mIntentFilter);
    }

    @Override
    protected void onPause () {
        super.onPause();
        registerReceiver(batteryReceiver, mIntentFilter);
    }

    @Override
    public void onStop () {
        super.onStop();
        unregisterReceiver(batteryReceiver);
        mMainActivityPresenter.updateDatabase(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mMainActivityPresenter.updateServiceConnectionStatus(this);
    }

}