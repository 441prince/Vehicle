package com.example.vehicle.presentation.view;

import android.database.Cursor;
import android.os.Bundle;
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
    public int faceDirectionClickCount=1,feetDirectionClickCount=1,faceFeetDirectionClickCount=1,faceFeetWindShieldDirectionClickCount=1,maxAcClickCount=1,airCirculateClickCount=1,bioHazardClickCount=1,rearFanClickCount=1;;


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initViews(view);
        initListeners();
        initObjects();
        getOnAcDirection();
        getOffAcDirection();

        Cursor cursor= databaseHelper.getFanTabData();
        if (cursor.getCount()==0){
            Toast.makeText(requireContext(),"No data",Toast.LENGTH_SHORT).show();
        }
        else {
            /*while (cursor.moveToNext()){
               fanSpeedText.setText(cursor.getString(6));
            }*/
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
                if(faceDirectionClickCount==1){
                    getOnAcDirection();
                    faceDirectionImageButton.setImageResource(R.drawable.upon);
                    dashBoardImageView.setImageResource(R.drawable.fanup);
                    Toast.makeText(requireActivity(),"Face Direction On",Toast.LENGTH_SHORT).show();
                    faceDirectionClickCount++;
                }else if(faceDirectionClickCount==2){
                    getOffAcDirection();
                    faceDirectionImageButton.setImageResource(R.drawable.up);
                    dashBoardImageView.setImageResource(R.drawable.dashfan);
                    Toast.makeText(requireActivity(),"Face Direction Off",Toast.LENGTH_SHORT).show();
                    faceDirectionClickCount=1;
                }

                /*Toast.makeText(requireActivity(), "", Toast.LENGTH_SHORT).show();
             new Handler().postDelayed(new Runnable() {
                @Override public void run() {
                    DashBoardImageView.setImageResource(R.drawable.dashfannew);
                }
            }, 1000);*/

                return;

            case R.id.feetDirectionImageButton:

                if(feetDirectionClickCount==1){
                    getOnAcDirection();
                    feetDirectionImageButton.setImageResource(R.drawable.downon);
                    dashBoardImageView.setImageResource(R.drawable.fandown);
                    Toast.makeText(requireActivity(),"Feet Direction On",Toast.LENGTH_SHORT).show();
                    feetDirectionClickCount++;
                }else if(feetDirectionClickCount==2){
                    getOffAcDirection();
                    feetDirectionImageButton.setImageResource(R.drawable.down);
                    dashBoardImageView.setImageResource(R.drawable.dashfan);
                    Toast.makeText(requireActivity(),"Feet Direction Off",Toast.LENGTH_SHORT).show();
                    feetDirectionClickCount=1;
                }

                return;

            case R.id.faceFeetDirectionImageButton:

                if(faceFeetDirectionClickCount==1){
                    getOnAcDirection();
                    faceFeetDirectionImageButton.setImageResource(R.drawable.updownon);
                    dashBoardImageView.setImageResource(R.drawable.fanupdown);
                    Toast.makeText(requireActivity(),"Face & Feet Direction On",Toast.LENGTH_SHORT).show();
                    faceFeetDirectionClickCount++;
                }else if(faceFeetDirectionClickCount==2){
                    getOffAcDirection();
                    faceFeetDirectionImageButton.setImageResource(R.drawable.updown);
                    dashBoardImageView.setImageResource(R.drawable.dashfan);
                    Toast.makeText(requireActivity(),"Face & Feet Direction Off",Toast.LENGTH_SHORT).show();
                    faceFeetDirectionClickCount=1;
                }

                return;

            case R.id.faceFeetWindShieldDirectionImageButton:

                if(faceFeetWindShieldDirectionClickCount==1){
                    getOnAcDirection();
                    faceFeetWindShieldDirectionImageButton.setImageResource(R.drawable.updownwindshieldon);
                    dashBoardImageView.setImageResource(R.drawable.fanupdowndefrost);
                    Toast.makeText(requireActivity(),"Face, Feet, WindShield Direction On",Toast.LENGTH_SHORT).show();
                    faceFeetWindShieldDirectionClickCount++;
                }else if(faceFeetWindShieldDirectionClickCount==2){
                    getOffAcDirection();
                    faceFeetWindShieldDirectionImageButton.setImageResource(R.drawable.updownwindshield);
                    dashBoardImageView.setImageResource(R.drawable.dashfan);
                    Toast.makeText(requireActivity(),"Face, Feet, WindShield Direction Off",Toast.LENGTH_SHORT).show();
                    faceFeetWindShieldDirectionClickCount=1;
                }

                return;

            case R.id.maxAcImageButton:

                if(maxAcClickCount==1){
                    max_ac="On";
                    maxAcImageButton.setImageResource(R.drawable.maxacon);
                    Toast.makeText(requireActivity(),"Max-AC On",Toast.LENGTH_SHORT).show();
                    maxAcClickCount++;
                }else if(maxAcClickCount==2){
                    max_ac="Off";
                    maxAcImageButton.setImageResource(R.drawable.maxac);
                    Toast.makeText(requireActivity(),"Max-AC Off",Toast.LENGTH_SHORT).show();
                    maxAcClickCount=1;
                }

                return;

            case R.id.airCirculateImageButton:

                if(airCirculateClickCount==1){
                    air_circulate="On";
                    airCirculateImageButton.setImageResource(R.drawable.circulateon);
                    Toast.makeText(requireActivity(),"AirCirculate On",Toast.LENGTH_SHORT).show();
                    airCirculateClickCount++;
                }else if(airCirculateClickCount==2){
                    air_circulate="Off";
                    airCirculateImageButton.setImageResource(R.drawable.circulate);
                    Toast.makeText(requireActivity(),"AirCirculate Off",Toast.LENGTH_SHORT).show();
                    airCirculateClickCount=1;
                }

                return;

            case R.id.bioHazardImageButton:

                if(bioHazardClickCount==1){
                    bio_hazard="On";
                    bioHazardImageButton.setImageResource(R.drawable.biohazardon);
                    Toast.makeText(requireActivity(),"Bio-Hazard On",Toast.LENGTH_SHORT).show();
                    bioHazardClickCount++;
                }else if(bioHazardClickCount==2){
                    bio_hazard="Off";
                    bioHazardImageButton.setImageResource(R.drawable.biohazard);
                    Toast.makeText(requireActivity(),"Bio-Hazard Off",Toast.LENGTH_SHORT).show();
                    bioHazardClickCount=1;
                }

                return;

            case R.id.rearFanImageButton:

                if(rearFanClickCount==1){
                    rear_fan="On";
                    rearFanImageButton.setImageResource(R.drawable.rearfanchange);
                    Toast.makeText(requireActivity(),"Rear Fan On",Toast.LENGTH_SHORT).show();
                    rearFanClickCount++;
                }else if(rearFanClickCount==2){
                    rear_fan="Off";
                    rearFanImageButton.setImageResource(R.drawable.rearfan);
                    Toast.makeText(requireActivity(),"Rear Fan Off",Toast.LENGTH_SHORT).show();
                    rearFanClickCount=1;
                }

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
                else if(count==0) {
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

    public void getOnAcDirection(){

        if(faceDirectionImageButton.isPressed()){
            ac_direction="To Face On";
        }
        if(feetDirectionImageButton.isPressed()){
            ac_direction="To Feet On";
        }
        if(faceFeetDirectionImageButton.isPressed()){
            ac_direction="To Face and Feet On";
        }
        if(faceFeetWindShieldDirectionImageButton.isPressed()){
            ac_direction="To Face,Feet and WindShield On";
        }
    }

    public void getOffAcDirection(){

        if(faceDirectionImageButton.isPressed()){
            ac_direction="To Face Off";
        }
        if(feetDirectionImageButton.isPressed()){
            ac_direction="To Feet Off";
        }
        if(faceFeetDirectionImageButton.isPressed()){
            ac_direction="To Face and Feet Off";
        }
        if(faceFeetWindShieldDirectionImageButton.isPressed()){
            ac_direction="To Face,Feet and WindShield Off";
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
            Toast.makeText(requireActivity(),"Fan Tab Data saved",Toast.LENGTH_LONG).show();
        else
            Toast.makeText(requireActivity(),"Data not Inserted",Toast.LENGTH_LONG).show();

    }
}