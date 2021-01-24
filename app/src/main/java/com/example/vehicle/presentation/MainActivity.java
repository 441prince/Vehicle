package com.example.vehicle.presentation;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.example.vehicle.R;
import com.example.vehicle.presentation.view.FanTabFragment;
import com.example.vehicle.presentation.view.SeatHeaterTabFragment;


public class MainActivity extends AppCompatActivity {
    private ImageButton fan;
    private ImageButton leftSeat;
    private ImageButton rightSeat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fan=(ImageButton)findViewById(R.id.imageButton6);
        fan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //BottomSheetDialog bottomSheet = new BottomSheetDialog();
                //bottomSheet.show(getSupportFragmentManager(),
                 //       "ModalBottomSheet");
                fan.animate().rotation(fan.getRotation()+360).start();

                FragmentTransaction ft= getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.framelayout,new FanTabFragment());
                ft.commit();

            }
        });

        leftSeat=(ImageButton)findViewById(R.id.imageButton5);
        leftSeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft= getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.framelayout,new SeatHeaterTabFragment());
                ft.commit();

            }
        });

        rightSeat=(ImageButton)findViewById(R.id.imageButton7);
        rightSeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft= getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.framelayout,new SeatHeaterTabFragment());
                ft.commit();

            }
        });

    }
}