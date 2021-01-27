package com.example.vehicle.presentation.view;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.vehicle.R;
import com.example.vehicle.domain.hmidata.DatabaseHelper;

public class SeatHeaterTabFragment extends Fragment implements View.OnClickListener {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.seat_heater_tab_fragment, container, false);
        return root;
    }


    private Button allOffButton;
    private Button driverSeatButton;
    private Button pillionSeatButton;
    private Button thirdSeatButton;
    private Button fourthSeatButton;
    private Button fifthSeatButton;
    private ImageView dashBoardImageView;
    private TextView SeatHeatersTextView;
    private DatabaseHelper databaseHelper;
    public String driver_seat="Off", pillion_seat="Off", third_seat="Off", fourth_seat="Off", fifth_seat="Off";
    public int driverSeatClickCount=1,pillionSeatClickCount=1,thirdSeatClickCount=1, fourthSeatClickCount=1,fifthSeatClickCount=1;


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initViews(view);
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

    }

    public void initViews(View view){

        allOffButton = (Button) view.findViewById(R.id.allOffButton);
        driverSeatButton = (Button) view.findViewById(R.id.driverSeatButton);
        pillionSeatButton = (Button) view.findViewById(R.id.pillionSeatButton);
        thirdSeatButton = (Button) view.findViewById(R.id.thirdSeatButton);
        fourthSeatButton = (Button) view.findViewById(R.id.fourthSeatButton);
        fifthSeatButton = (Button) view.findViewById(R.id.fifthSeatButton);
        dashBoardImageView = (ImageView) view.findViewById(R.id.dashBoardImageView);

    }

    public void initListeners(){

        this.allOffButton.setOnClickListener(this);
        this.driverSeatButton.setOnClickListener(this);
        this.pillionSeatButton.setOnClickListener(this);
        this.thirdSeatButton.setOnClickListener(this);
        this.fourthSeatButton.setOnClickListener(this);
        this.fifthSeatButton.setOnClickListener(this);
    }

    public void initObjects(){

        this.databaseHelper=new DatabaseHelper(requireContext());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.allOffButton:
                dashBoardImageView.setImageResource(R.drawable.seat);
                driverSeatButton.setBackgroundResource(R.drawable.ic_baseline_waves_24);
                pillionSeatButton.setBackgroundResource(R.drawable.ic_baseline_waves_24);
                thirdSeatButton.setBackgroundResource(R.drawable.ic_baseline_waves_24);
                fourthSeatButton.setBackgroundResource(R.drawable.ic_baseline_waves_24);
                fifthSeatButton.setBackgroundResource(R.drawable.ic_baseline_waves_24);
                driver_seat="Off";
                pillion_seat="Off";
                third_seat="Off";
                fourth_seat="Off";
                fifth_seat="Off";
                Toast.makeText(requireActivity(),"All Seat Heaters Off",Toast.LENGTH_SHORT).show();
                return;

            case R.id.driverSeatButton:

                dashBoardImageView.setImageResource(R.drawable.driverheat);
                if(driverSeatClickCount==1){
                    driver_seat="Low Heat Mode On";
                    v.setBackgroundResource(R.drawable.rightlow);
                    Toast.makeText(requireActivity(),"Low Heat Mode On",Toast.LENGTH_SHORT).show();
                    driverSeatClickCount++;
                }else if(driverSeatClickCount==2){
                    driver_seat="Medium Heat Mode On";
                    v.setBackgroundResource(R.drawable.rightmed);
                    Toast.makeText(requireActivity(),"Medium Heat Mode On",Toast.LENGTH_SHORT).show();
                    driverSeatClickCount++;
                }else if(driverSeatClickCount==3){
                    driver_seat="High Heat Mode On";
                    v.setBackgroundResource(R.drawable.righthigh);
                    Toast.makeText(requireActivity(),"High Heat Mode On",Toast.LENGTH_SHORT).show();
                    driverSeatClickCount++;
                }else if(driverSeatClickCount==4) {
                    driver_seat=" Heat Mode Off";
                    v.setBackgroundResource(R.drawable.ic_baseline_waves_24);
                    Toast.makeText(requireActivity()," Heat Mode Off",Toast.LENGTH_SHORT).show();
                    dashBoardImageView.setImageResource(R.drawable.seat);
                    driverSeatClickCount=1;
                }
                return;

            case R.id.pillionSeatButton:

                dashBoardImageView.setImageResource(R.drawable.pillionheat);

                if(pillionSeatClickCount==1){
                    pillion_seat="Low Heat Mode On";
                    v.setBackgroundResource(R.drawable.rightlow);
                    Toast.makeText(requireActivity(),"Low Heat Mode On",Toast.LENGTH_SHORT).show();
                    pillionSeatClickCount++;
                }else if(pillionSeatClickCount==2){
                    pillion_seat="Medium Heat Mode On";
                    v.setBackgroundResource(R.drawable.rightmed);
                    Toast.makeText(requireActivity(),"Medium Heat Mode On",Toast.LENGTH_SHORT).show();
                    pillionSeatClickCount++;
                }else if(pillionSeatClickCount==3){
                    pillion_seat="High Heat Mode On";
                    v.setBackgroundResource(R.drawable.righthigh);
                    Toast.makeText(requireActivity(),"High Heat Mode On",Toast.LENGTH_SHORT).show();
                    pillionSeatClickCount++;
                }else if(pillionSeatClickCount==4) {
                    pillion_seat="Heat Mode Off";
                    v.setBackgroundResource(R.drawable.ic_baseline_waves_24);
                    Toast.makeText(requireActivity()," Heat Mode Off",Toast.LENGTH_SHORT).show();
                    dashBoardImageView.setImageResource(R.drawable.seat);
                    pillionSeatClickCount=1;
                }
                return;

            case R.id.thirdSeatButton:

                dashBoardImageView.setImageResource(R.drawable.thirdseatheat);

                if(thirdSeatClickCount==1){
                    third_seat="Low Heat Mode On";
                    v.setBackgroundResource(R.drawable.rightlow);
                    Toast.makeText(requireActivity(),"Low Heat Mode On",Toast.LENGTH_SHORT).show();
                    thirdSeatClickCount++;
                }else if(thirdSeatClickCount==2){
                    third_seat="Medium Heat Mode On";
                    v.setBackgroundResource(R.drawable.rightmed);
                    Toast.makeText(requireActivity(),"Medium Heat Mode On",Toast.LENGTH_SHORT).show();
                    thirdSeatClickCount++;
                }else if(thirdSeatClickCount==3){
                    third_seat="High Heat Mode On";
                    v.setBackgroundResource(R.drawable.righthigh);
                    Toast.makeText(requireActivity(),"High Heat Mode On",Toast.LENGTH_SHORT).show();
                    thirdSeatClickCount++;
                }else if(thirdSeatClickCount==4) {
                    third_seat="Heat Mode Off";
                    v.setBackgroundResource(R.drawable.ic_baseline_waves_24);
                    Toast.makeText(requireActivity()," Heat Mode Off",Toast.LENGTH_SHORT).show();
                    dashBoardImageView.setImageResource(R.drawable.seat);
                    thirdSeatClickCount=1;
                }
                return;
            case R.id.fourthSeatButton:

                dashBoardImageView.setImageResource(R.drawable.fourthseatheat);

                if(fourthSeatClickCount==1){
                    fourth_seat="Low Heat Mode On";
                    v.setBackgroundResource(R.drawable.rightlow);
                    Toast.makeText(requireActivity(),"Low Heat Mode On",Toast.LENGTH_SHORT).show();
                    fourthSeatClickCount++;
                }else if(fourthSeatClickCount==2){
                    fourth_seat="Medium Heat Mode On";
                    v.setBackgroundResource(R.drawable.rightmed);
                    Toast.makeText(requireActivity(),"Medium Heat Mode On",Toast.LENGTH_SHORT).show();
                    fourthSeatClickCount++;
                }else if(fourthSeatClickCount==3){
                    fourth_seat="High Heat Mode On";
                    v.setBackgroundResource(R.drawable.righthigh);
                    Toast.makeText(requireActivity(),"High Heat Mode On",Toast.LENGTH_SHORT).show();
                    fourthSeatClickCount++;
                }else if(fourthSeatClickCount==4) {
                    fourth_seat="Heat Mode Off";
                    v.setBackgroundResource(R.drawable.ic_baseline_waves_24);
                    Toast.makeText(requireActivity(),"Heat Mode Off",Toast.LENGTH_SHORT).show();
                    dashBoardImageView.setImageResource(R.drawable.seat);
                    fourthSeatClickCount=1;
                }
                return;

            case R.id.fifthSeatButton:
                dashBoardImageView.setImageResource(R.drawable.fifthseatheat);

                if(fifthSeatClickCount==1){
                    fifth_seat="Low Heat Mode On";
                    v.setBackgroundResource(R.drawable.rightlow);
                    Toast.makeText(requireActivity(),"Low Heat Mode On",Toast.LENGTH_SHORT).show();
                    fifthSeatClickCount++;
                }else if(fifthSeatClickCount==2){
                    fifth_seat="Medium Heat Mode On";
                    v.setBackgroundResource(R.drawable.rightmed);
                    Toast.makeText(requireActivity(),"Medium Heat Mode On",Toast.LENGTH_SHORT).show();
                    fifthSeatClickCount++;
                }else if(fifthSeatClickCount==3){
                    fifth_seat="High Heat Mode On";
                    v.setBackgroundResource(R.drawable.righthigh);
                    Toast.makeText(requireActivity(),"High Heat Mode On",Toast.LENGTH_SHORT).show();
                    fifthSeatClickCount++;
                }else if(fifthSeatClickCount==4) {
                    fifth_seat="Heat Mode Off";
                    v.setBackgroundResource(R.drawable.ic_baseline_waves_24);
                    Toast.makeText(requireActivity(),"Heat Mode Off",Toast.LENGTH_SHORT).show();
                    dashBoardImageView.setImageResource(R.drawable.seat);
                    fifthSeatClickCount=1;
                }
                return;
            default:
                return;
        }
    }
    public void onStop() {
        super.onStop();
        boolean isInserted = databaseHelper.insertSeatTabData(driver_seat, pillion_seat, third_seat, fourth_seat, fifth_seat);
        if(isInserted==true)
            Toast.makeText(requireActivity(),"Seat Tab Data saved",Toast.LENGTH_LONG).show();
        else
            Toast.makeText(requireActivity(),"Data not Inserted",Toast.LENGTH_LONG).show();

    }
}
