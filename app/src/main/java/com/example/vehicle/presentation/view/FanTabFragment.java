package com.example.vehicle.presentation.view;

import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.vehicle.R;
import com.example.vehicle.domain.hmidata.DatabaseHelper;


public class FanTabFragment extends Fragment implements View.OnClickListener {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fan_tab_fragment, container, false);
        return view;
    }

    private ImageButton faceDirectionImageButton;
    private ImageButton feetDirectionImageButton;
    private ImageButton faceFeetDirectionImageButton;
    private ImageButton faceFeetWindShieldDirectionImageButton;
    private ImageButton maxAcImageButton;
    private ImageButton airCirculateImageButton;
    private ImageButton bioHazardImageButton;
    private ImageButton rearFanImageButton;
    private Button increase;
    private Button decrease;
    private ImageView fanImageView;
    private ImageView dashBoardImageView;
    private TextView fanSpeedText;
    private DatabaseHelper databaseHelper;
    public int count=0;
    public String ac_direction="Off",max_ac="Off",air_circulate="Off",bio_hazard="Off",rear_fan="Off", fan_speed;
    public String value;


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initViews(view);
        initListeners();
        initObjects();
        getAcDirection();

        Cursor cursor= databaseHelper.getFanSpeedData();
        if (cursor.getCount()==0){
            Toast.makeText(requireContext(),"No data",Toast.LENGTH_SHORT).show();
        }
        else {
            //while (cursor.moveToNext()){
             //   fanSpeedText.setText(cursor.getString(6));
           // }
            while (cursor.moveToNext()){
                fanSpeedText.setText(cursor.getString(6));
            }
        }

    }

    public  void initViews(View view){

        faceDirectionImageButton = (ImageButton) view.findViewById(R.id.faceDirectionImageButton);
        feetDirectionImageButton = (ImageButton) view.findViewById(R.id.feetDirectionImageButton);
        faceFeetDirectionImageButton =(ImageButton) view.findViewById(R.id.faceFeetDirectionImageButton);
        faceFeetWindShieldDirectionImageButton = (ImageButton) view.findViewById(R.id.faceFeetWindShieldDirectionImageButton);
        maxAcImageButton = (ImageButton)  view.findViewById(R.id.maxAcImageButton);
        airCirculateImageButton = (ImageButton) view.findViewById(R.id.airCirculateImageButton);
        bioHazardImageButton = (ImageButton) view.findViewById(R.id.bioHazardImageButton);
        rearFanImageButton = (ImageButton) view.findViewById(R.id.rearFanImageButton);
        increase = (Button) view.findViewById(R.id.increase);
        decrease = (Button) view.findViewById(R.id.decrease);
        fanImageView = (ImageView) view.findViewById(R.id.fanImageView) ;
        dashBoardImageView = (ImageView) view.findViewById(R.id.dashBoardImageView);
        fanSpeedText = (TextView) view.findViewById(R.id.fanSpeedText);


    }
    public  void initListeners(){

        this.faceDirectionImageButton.setOnClickListener(this);
        this.feetDirectionImageButton.setOnClickListener(this);
        this.faceFeetDirectionImageButton.setOnClickListener(this);
        this.faceFeetWindShieldDirectionImageButton.setOnClickListener(this);
        this.maxAcImageButton.setOnClickListener(this);
        this.airCirculateImageButton.setOnClickListener(this);
        this.bioHazardImageButton.setOnClickListener(this);
        this.rearFanImageButton.setOnClickListener(this);
        this.increase.setOnClickListener(this);
        this.decrease.setOnClickListener(this);
        this.fanImageView.setOnClickListener(this);
        this.fanSpeedText.setOnClickListener(this);

    }
    public  void initObjects(){

        this.databaseHelper=new DatabaseHelper(requireContext());
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.faceDirectionImageButton:
                dashBoardImageView.setImageResource(R.drawable.dashfanon);
                getAcDirection();
                Toast.makeText(requireActivity(), "Face Direction On", Toast.LENGTH_SHORT).show();
             new Handler().postDelayed(new Runnable() {
                @Override public void run() {
                    //DashBoardImageView.setImageResource(R.drawable.dashfannew);
                }
            }, 1000);

                return;

            case R.id.feetDirectionImageButton:

                getAcDirection();
                Toast.makeText(requireActivity(), "Feet Direction On", Toast.LENGTH_SHORT).show();
                return;

            case R.id.faceFeetDirectionImageButton:

                getAcDirection();
                Toast.makeText(requireActivity(), "Face & Feet Direction On", Toast.LENGTH_SHORT).show();
                return;

            case R.id.faceFeetWindShieldDirectionImageButton:

                getAcDirection();
                Toast.makeText(requireActivity(), "Face, Feet, WindShield Direction On", Toast.LENGTH_SHORT).show();
                return;

            case R.id.maxAcImageButton:

                if(maxAcImageButton.isEnabled()){
                    max_ac="On";
                }
                Toast.makeText(requireActivity(), "Max-AC On", Toast.LENGTH_SHORT).show();
                return;

            case R.id.airCirculateImageButton:

                if(airCirculateImageButton.isEnabled()){
                    air_circulate="On";
                }
                Toast.makeText(requireActivity(), "AirCirculate On", Toast.LENGTH_SHORT).show();
                return;

            case R.id.bioHazardImageButton:

                if(bioHazardImageButton.isEnabled()){
                    bio_hazard="On";
                }
                Toast.makeText(requireActivity(), "Bio-Hazard On", Toast.LENGTH_SHORT).show();
                return;

            case R.id.rearFanImageButton:

                if(rearFanImageButton.isEnabled()){
                    rear_fan="On";
                }
                Toast.makeText(requireActivity(), "Rear Fan On", Toast.LENGTH_SHORT).show();
                return;

            case R.id.increase:

                if(count<7){
                    count++;}


                dashBoardImageView.setImageResource(R.drawable.dashfanon);
                value=Integer.toString(count);
                fanSpeedText.setText( value);
                return;

            case R.id.decrease:

                if(count>0){
                    count--;}
                else if(count<1) {
                    dashBoardImageView.setImageResource(R.drawable.dashfannew);
                    Toast.makeText(requireActivity(),"Fan Turned Off",Toast.LENGTH_SHORT).show();
                }
                value=Integer.toString(count);
                fanSpeedText.setText( value);
                return;

            case R.id.fanSpeedText:
                return;
            default:
                return;
        }
    }

    public void getAcDirection(){

        if(faceDirectionImageButton.isPressed()){
            ac_direction="To Face";
        }
        if(feetDirectionImageButton.isPressed()){
            ac_direction="To Feet";
        }
        if(faceFeetDirectionImageButton.isPressed()){
            ac_direction="To Face and Feet";
        }
        if(faceFeetWindShieldDirectionImageButton.isPressed()){
            ac_direction="To Face,Feet and WindShield";
        }
    }

    /*@Override
    public void onPause() {
        super.onPause();
        boolean isInserted = databaseHelper.insertFanTabData(ac_direction,max_ac,air_circulate,bio_hazard,rear_fan,fanSpeedText.getText().toString());
        if(isInserted==true)
            Toast.makeText(requireActivity(),"Fan speed saved",Toast.LENGTH_LONG).show();
        else
            Toast.makeText(requireActivity(),"Data not Inserted",Toast.LENGTH_LONG).show();
    }*/

    @Override
    public void onStop() {
        super.onStop();
        boolean isInserted = databaseHelper.insertFanTabData(ac_direction,max_ac,air_circulate,bio_hazard,rear_fan,fanSpeedText.getText().toString());
        if(isInserted==true)
            Toast.makeText(requireActivity(),"Fan speed saved",Toast.LENGTH_LONG).show();
        else
            Toast.makeText(requireActivity(),"Data not Inserted",Toast.LENGTH_LONG).show();

    }
}