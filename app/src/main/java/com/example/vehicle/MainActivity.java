package com.example.vehicle.presentation.view;

import android.app.Dialog;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;


public class MainActivity extends AppCompatActivity {
    private ImageButton fan;
    private ImageButton leftSeat;
    private ImageButton rightSeat;
    private ImageButton ac;
    Dialog usermode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        usermode = new Dialog(this);
        setContentView(R.layout.activity_main);
        ac=findViewById(R.id.imageButton4);
        SeekBar colorSeekBar;
        colorSeekBar=findViewById(R.id.customSeekBar);
        colorSeekBar.setVisibility(View.GONE);
        TextView ac_temp;
        ac_temp= findViewById(R.id.actemp);
        ac_temp.setVisibility(View.GONE);

        ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView ac_temp;
                ac_temp= findViewById(R.id.actemp);
                SeekBar colorSeekBar;
                colorSeekBar=findViewById(R.id.customSeekBar);
                colorSeekBar.setVisibility(View.VISIBLE);

                ac_temp.setVisibility(View.GONE);

                colorSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        //ac_temp.setText(String.format("%d°C",progress));
                        int val = (progress * (seekBar.getWidth() - 5 * seekBar.getThumbOffset())) / seekBar.getMax();
                        ac_temp.setText(String.format("%d°C",progress));
                        ac_temp.setX(seekBar.getX()-100 + val + seekBar.getThumbOffset() / 2);
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {
                        ac_temp.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                        ac_temp.setVisibility(View.GONE);
                        colorSeekBar.setVisibility(View.GONE);
                    }


                });
            }
        });

        fan=(ImageButton)findViewById(R.id.imageButton6);
        fan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //BottomSheetDialog bottomSheet = new BottomSheetDialog();
                //bottomSheet.show(getSupportFragmentManager(),
                //       "ModalBottomSheet");
                fan.animate().rotation(fan.getRotation()+360).start();

                FragmentTransaction ft= getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.framelayout,new com.example.climate.TwoTabFragment());
                ft.commit();

            }
        });

        leftSeat=(ImageButton)findViewById(R.id.imageButton5);
        leftSeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft= getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.framelayout,new com.example.climate.TwoTabFragment());
                ft.commit();

            }
        });

        rightSeat=(ImageButton)findViewById(R.id.imageButton7);
        rightSeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft= getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.framelayout,new com.example.climate.TwoTabFragment());
                ft.commit();

            }
        });

    }
    public void popup(View view){
        ImageButton dog,camp,user;
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