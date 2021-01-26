package com.example.vehicle;

import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
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
import com.example.vehicle.presentation.view.TwoTabFragment;

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
    public int clickCount=1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        initListeners();
        initObjects();

        acImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
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

                Toast.makeText(getApplicationContext(),"Auto On",Toast.LENGTH_SHORT).show();
                return;

            case R.id.acImageButton:
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

                if(clickCount==1){
                    leftSeatImageButton.setImageResource(R.drawable.leftlow);
                    Toast.makeText(getApplicationContext(),"Low Heat Mode On",Toast.LENGTH_SHORT).show();
                    clickCount++;
                }else if(clickCount==2){
                    leftSeatImageButton.setImageResource(R.drawable.leftmed);
                    Toast.makeText(getApplicationContext(),"Medium Heat Mode On",Toast.LENGTH_SHORT).show();
                    clickCount++;
                }else if(clickCount==3){
                    leftSeatImageButton.setImageResource(R.drawable.lefthigh);
                    Toast.makeText(getApplicationContext(),"High Heat Mode On",Toast.LENGTH_SHORT).show();
                    clickCount++;
                }else if(clickCount==4){
                    leftSeatImageButton.setImageResource(R.drawable.leftseat);
                    Toast.makeText(getApplicationContext()," Heat Mode Off",Toast.LENGTH_SHORT).show();
                    clickCount=1;
                }
                return;

            case R.id.fanImageButton:

                fanImageButton.animate().rotation(fanImageButton.getRotation()+360).start();
                FragmentTransaction ft= getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.framelayout,new TwoTabFragment());
                ft.commit();
                return;
            case R.id.rightSeatImageButton:

                if(clickCount==1){
                    rightSeatImageButton.setImageResource(R.drawable.rightlow);
                    Toast.makeText(getApplicationContext(),"Low Heat Mode On",Toast.LENGTH_SHORT).show();
                    clickCount++;
                }else if(clickCount==2){
                    rightSeatImageButton.setImageResource(R.drawable.rightmed);
                    Toast.makeText(getApplicationContext(),"Medium Heat Mode On",Toast.LENGTH_SHORT).show();
                    clickCount++;
                }else if(clickCount==3){
                    rightSeatImageButton.setImageResource(R.drawable.righthigh);
                    Toast.makeText(getApplicationContext(),"High Heat Mode On",Toast.LENGTH_SHORT).show();
                    clickCount++;
                }else if(clickCount==4){
                    rightSeatImageButton.setImageResource(R.drawable.rightseat);
                    Toast.makeText(getApplicationContext()," Heat Mode Off",Toast.LENGTH_SHORT).show();
                    clickCount=1;
                }
                return;

            case R.id.frontDefrostImageButton:   //front defrost mode
                Toast.makeText(getApplicationContext(),"Defrost On",Toast.LENGTH_SHORT).show();
                return;

            case R.id.rearDefrostImageButton:   //rear defrost mode
                Toast.makeText(getApplicationContext(),"Rear Defrost On",Toast.LENGTH_SHORT).show();
                    for (int i = 0; i < 5; i++) { new Handler().postDelayed(new Runnable() {
                        @Override public void run() {
                            Toast toast= Toast.makeText(getApplicationContext(),"Rear Defrosting.....",Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.TOP|Gravity.CENTER_VERTICAL, 0, 0);
                            toast.show();
                        }
                    }, i * 1000);
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
                dog.setBackgroundColor(getResources().getColor(R.color.Blue));
                Toast.makeText(getApplicationContext(),"Dog Mode is activated",Toast.LENGTH_SHORT).show();
                usermode.dismiss();
            }

        });

        camp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                camp.setBackgroundColor(getResources().getColor(R.color.Blue));
                Toast.makeText(getApplicationContext(),"Camp Mode is activated",Toast.LENGTH_SHORT).show();
                usermode.dismiss();
            }

        });

        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.setBackgroundColor(getResources().getColor(R.color.Blue));
                Toast.makeText(getApplicationContext(),"User Mode is activated",Toast.LENGTH_SHORT).show();
                usermode.dismiss();
            }

        });
        Window window = usermode.getWindow();
        window.setGravity(Gravity.TOP | Gravity.RIGHT);
        usermode.show();
        usermode.getWindow().getDecorView().setBackgroundResource(android.R.color.transparent);

    }
}