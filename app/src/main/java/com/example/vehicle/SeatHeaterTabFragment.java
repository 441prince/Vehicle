package com.example.vehicle;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SeatHeaterTabFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.seat_heater_tab_fragment, container, false);
        return root;
    }


    //Changing colour of the seat when seat heater is selected

    Button AllOffButton;

    // int buttonSelectCount = this.getArguments().getInt("message");
    int buttonSelectCount=1;
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        AllOffButton=(Button) view.findViewById(R.id.button);
        Button DriverSeatButton = (Button) view.findViewById(R.id.driverSeatButton);
        Button PillionSeatButton = (Button) view.findViewById(R.id.pillionSeatButton);
        Button ThirdSeatButton = (Button) view.findViewById(R.id.thirdSeatButton);
        Button FourthSeatButton = (Button) view.findViewById(R.id.fourthSeatButton2);
        Button FifthSeatButton = (Button) view.findViewById(R.id.fifthSeatButton);


        DriverSeatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView image = (ImageView) view.findViewById(R.id.imageView5);
                image.setImageResource(R.drawable.driverheat);


                if(buttonSelectCount==1){
                    v.setBackgroundResource(R.drawable.rightlow);
                    Toast.makeText(requireActivity(),"Low Heat Mode On",Toast.LENGTH_SHORT).show();
                    buttonSelectCount++;
                }else if(buttonSelectCount==2){
                    v.setBackgroundResource(R.drawable.rightmed);
                    Toast.makeText(requireActivity(),"Medium Heat Mode On",Toast.LENGTH_SHORT).show();
                    buttonSelectCount++;
                }else if(buttonSelectCount==3){
                    v.setBackgroundResource(R.drawable.righthigh);
                    Toast.makeText(requireActivity(),"High Heat Mode On",Toast.LENGTH_SHORT).show();
                    buttonSelectCount++;
                }else if(buttonSelectCount==4) {
                    v.setBackgroundResource(R.drawable.ic_baseline_waves_24);
                    Toast.makeText(requireActivity()," Heat Mode Off",Toast.LENGTH_SHORT).show();
                    ImageView imageSeatHeaterOff = (ImageView) v.findViewById(R.id.imageView5);
                    image.setImageResource(R.drawable.seat);
                    buttonSelectCount=1;
                }



            }
        });

        PillionSeatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView image = (ImageView) view.findViewById(R.id.imageView5);
                image.setImageResource(R.drawable.pillionheat);

                if(buttonSelectCount==1){
                    v.setBackgroundResource(R.drawable.rightlow);
                    Toast.makeText(requireActivity(),"Low Heat Mode On",Toast.LENGTH_SHORT).show();
                    buttonSelectCount++;
                }else if(buttonSelectCount==2){
                    v.setBackgroundResource(R.drawable.rightmed);
                    Toast.makeText(requireActivity(),"Medium Heat Mode On",Toast.LENGTH_SHORT).show();
                    buttonSelectCount++;
                }else if(buttonSelectCount==3){
                    v.setBackgroundResource(R.drawable.righthigh);
                    Toast.makeText(requireActivity(),"High Heat Mode On",Toast.LENGTH_SHORT).show();
                    buttonSelectCount++;
                }else if(buttonSelectCount==4) {
                    v.setBackgroundResource(R.drawable.ic_baseline_waves_24);
                    Toast.makeText(requireActivity()," Heat Mode Off",Toast.LENGTH_SHORT).show();
                    ImageView imageSeatHeaterOff = (ImageView) v.findViewById(R.id.imageView5);
                    image.setImageResource(R.drawable.seat);
                    buttonSelectCount=1;
                }

            }
        });

        ThirdSeatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView image = (ImageView) view.findViewById(R.id.imageView5);
                image.setImageResource(R.drawable.thirdseatheat);

                if(buttonSelectCount==1){
                    v.setBackgroundResource(R.drawable.rightlow);
                    Toast.makeText(requireActivity(),"Low Heat Mode On",Toast.LENGTH_SHORT).show();
                    buttonSelectCount++;
                }else if(buttonSelectCount==2){
                    v.setBackgroundResource(R.drawable.rightmed);
                    Toast.makeText(requireActivity(),"Medium Heat Mode On",Toast.LENGTH_SHORT).show();
                    buttonSelectCount++;
                }else if(buttonSelectCount==3){
                    v.setBackgroundResource(R.drawable.righthigh);
                    Toast.makeText(requireActivity(),"High Heat Mode On",Toast.LENGTH_SHORT).show();
                    buttonSelectCount++;
                }else if(buttonSelectCount==4) {
                    v.setBackgroundResource(R.drawable.ic_baseline_waves_24);
                    Toast.makeText(requireActivity()," Heat Mode Off",Toast.LENGTH_SHORT).show();
                    ImageView imageSeatHeaterOff = (ImageView) v.findViewById(R.id.imageView5);
                    image.setImageResource(R.drawable.seat);
                    buttonSelectCount=1;
                }

            }
        });

        FourthSeatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView image = (ImageView) view.findViewById(R.id.imageView5);
                image.setImageResource(R.drawable.fourthseatheat);

                if(buttonSelectCount==1){
                    v.setBackgroundResource(R.drawable.rightlow);
                    Toast.makeText(requireActivity(),"Low Heat Mode On",Toast.LENGTH_SHORT).show();
                    buttonSelectCount++;
                }else if(buttonSelectCount==2){
                    v.setBackgroundResource(R.drawable.rightmed);
                    Toast.makeText(requireActivity(),"Medium Heat Mode On",Toast.LENGTH_SHORT).show();
                    buttonSelectCount++;
                }else if(buttonSelectCount==3){
                    v.setBackgroundResource(R.drawable.righthigh);
                    Toast.makeText(requireActivity(),"High Heat Mode On",Toast.LENGTH_SHORT).show();
                    buttonSelectCount++;
                }else if(buttonSelectCount==4) {
                    v.setBackgroundResource(R.drawable.ic_baseline_waves_24);
                    Toast.makeText(requireActivity()," Heat Mode Off",Toast.LENGTH_SHORT).show();
                    ImageView imageSeatHeaterOff = (ImageView) v.findViewById(R.id.imageView5);
                    image.setImageResource(R.drawable.seat);
                    buttonSelectCount=1;
                }

            }
        });

        FifthSeatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView image = (ImageView) view.findViewById(R.id.imageView5);
                image.setImageResource(R.drawable.fifthseatheat);

                if(buttonSelectCount==1){
                    v.setBackgroundResource(R.drawable.rightlow);
                    Toast.makeText(requireActivity(),"Low Heat Mode On",Toast.LENGTH_SHORT).show();
                    buttonSelectCount++;
                }else if(buttonSelectCount==2){
                    v.setBackgroundResource(R.drawable.rightmed);
                    Toast.makeText(requireActivity(),"Medium Heat Mode On",Toast.LENGTH_SHORT).show();
                    buttonSelectCount++;
                }else if(buttonSelectCount==3){
                    v.setBackgroundResource(R.drawable.righthigh);
                    Toast.makeText(requireActivity(),"High Heat Mode On",Toast.LENGTH_SHORT).show();
                    buttonSelectCount++;
                }else if(buttonSelectCount==4) {
                    v.setBackgroundResource(R.drawable.ic_baseline_waves_24);
                    Toast.makeText(requireActivity()," Heat Mode Off",Toast.LENGTH_SHORT).show();
                    ImageView imageSeatHeaterOff = (ImageView) v.findViewById(R.id.imageView5);
                    image.setImageResource(R.drawable.seat);
                    buttonSelectCount=1;
                }

            }
        });

        AllOffButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView image = (ImageView) view.findViewById(R.id.imageView5);
                image.setImageResource(R.drawable.seat);
               Toast.makeText(requireActivity(),"All Seat Heaters Off",Toast.LENGTH_SHORT).show();
            }
        });

    }
}
