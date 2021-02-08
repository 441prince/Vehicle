package com.example.vehicle;

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
import com.example.vehicle.presentation.presenter.ISeatHeaterTabFragmentPresenter;
import com.example.vehicle.presentation.presenter.SeatHeaterTabFragmentPresenterImpl;
import com.example.vehicle.presentation.view.ISeatHeaterTabFragmentView;

public class SeatHeaterTabFragment extends Fragment implements View.OnClickListener , ISeatHeaterTabFragmentView {
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
    private ISeatHeaterTabFragmentPresenter mSeatHeaterTabFragmentPresenter;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initViews(view);
        initListeners();
        initObjects();
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

        mSeatHeaterTabFragmentPresenter = new SeatHeaterTabFragmentPresenterImpl(this);
        mSeatHeaterTabFragmentPresenter.init(getContext());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.allOffButton:

                if (mSeatHeaterTabFragmentPresenter != null) {
                    mSeatHeaterTabFragmentPresenter.updateAllOffButtonStatus(getContext());
                }
                return;

            case R.id.driverSeatButton:

                if (mSeatHeaterTabFragmentPresenter != null) {
                    mSeatHeaterTabFragmentPresenter.updateDriverSeatButtonStatus(getContext());
                }
                return;

            case R.id.pillionSeatButton:

                if (mSeatHeaterTabFragmentPresenter != null) {
                    mSeatHeaterTabFragmentPresenter.updatePillionSeatButtonStatus(getContext());
                }
                return;

            case R.id.thirdSeatButton:

                if (mSeatHeaterTabFragmentPresenter != null) {
                    mSeatHeaterTabFragmentPresenter.updateThirdSeatButtonStatus(getContext());
                }
                return;

            case R.id.fourthSeatButton:

                if (mSeatHeaterTabFragmentPresenter != null) {
                    mSeatHeaterTabFragmentPresenter.updateFourthSeatButtonStatus(getContext());
                }
                return;

            case R.id.fifthSeatButton:
                if (mSeatHeaterTabFragmentPresenter != null) {
                    mSeatHeaterTabFragmentPresenter.updateFifthSeatButtonStatus(getContext());
                }
                return;
            default:
                    return;
        }
    }

    @Override
    public void notifyAllOffButtonStatus(int num) {
        if(num == 1){
        dashBoardImageView.setImageResource(R.drawable.seat);
        driverSeatButton.setBackgroundResource(R.drawable.ic_baseline_waves_24);
        pillionSeatButton.setBackgroundResource(R.drawable.ic_baseline_waves_24);
        thirdSeatButton.setBackgroundResource(R.drawable.ic_baseline_waves_24);
        fourthSeatButton.setBackgroundResource(R.drawable.ic_baseline_waves_24);
        fifthSeatButton.setBackgroundResource(R.drawable.ic_baseline_waves_24);

            Toast.makeText(requireActivity(),"All Seat Heaters Off",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void notifyDriverSeatButtonStatus(int num) {
        dashBoardImageView.setImageResource(R.drawable.driverheat);
        if(num==1){
            driverSeatButton.setBackgroundResource(R.drawable.rightlow);
            Toast.makeText(requireActivity(),"Low Heat Mode On",Toast.LENGTH_SHORT).show();
        }else if(num==2){
            driverSeatButton.setBackgroundResource(R.drawable.rightmed);
            Toast.makeText(requireActivity(),"Medium Heat Mode On",Toast.LENGTH_SHORT).show();
        }else if(num==3){
            driverSeatButton.setBackgroundResource(R.drawable.righthigh);
            Toast.makeText(requireActivity(),"High Heat Mode On",Toast.LENGTH_SHORT).show();
        }else if(num==4) {
            driverSeatButton.setBackgroundResource(R.drawable.ic_baseline_waves_24);
            Toast.makeText(requireActivity()," Heat Mode Off",Toast.LENGTH_SHORT).show();
            dashBoardImageView.setImageResource(R.drawable.seat);
        }
    }

    @Override
    public void notifyPillionSeatButtonStatus(int num) {

        dashBoardImageView.setImageResource(R.drawable.pillionheat);
        if(num==1){
            pillionSeatButton.setBackgroundResource(R.drawable.rightlow);
            Toast.makeText(requireActivity(),"Low Heat Mode On",Toast.LENGTH_SHORT).show();
        }else if(num==2){
            pillionSeatButton.setBackgroundResource(R.drawable.rightmed);
            Toast.makeText(requireActivity(),"Medium Heat Mode On",Toast.LENGTH_SHORT).show();
        }else if(num==3){
            pillionSeatButton.setBackgroundResource(R.drawable.righthigh);
            Toast.makeText(requireActivity(),"High Heat Mode On",Toast.LENGTH_SHORT).show();
        }else if(num==4) {
            pillionSeatButton.setBackgroundResource(R.drawable.ic_baseline_waves_24);
            Toast.makeText(requireActivity()," Heat Mode Off",Toast.LENGTH_SHORT).show();
            dashBoardImageView.setImageResource(R.drawable.seat);
        }
    }

    @Override
    public void notifyThirdSeatButtonStatus(int num) {

        dashBoardImageView.setImageResource(R.drawable.thirdseatheat);
        if(num==1){
            thirdSeatButton.setBackgroundResource(R.drawable.rightlow);
            Toast.makeText(requireActivity(),"Low Heat Mode On",Toast.LENGTH_SHORT).show();
        }else if(num==2){
            thirdSeatButton.setBackgroundResource(R.drawable.rightmed);
            Toast.makeText(requireActivity(),"Medium Heat Mode On",Toast.LENGTH_SHORT).show();
        }else if(num==3){
            thirdSeatButton.setBackgroundResource(R.drawable.righthigh);
            Toast.makeText(requireActivity(),"High Heat Mode On",Toast.LENGTH_SHORT).show();
        }else if(num==4) {
            thirdSeatButton.setBackgroundResource(R.drawable.ic_baseline_waves_24);
            Toast.makeText(requireActivity()," Heat Mode Off",Toast.LENGTH_SHORT).show();
            dashBoardImageView.setImageResource(R.drawable.seat);
        }
    }

    @Override
    public void notifyFourthSeatButtonStatus(int num) {

        dashBoardImageView.setImageResource(R.drawable.fourthseatheat);

        if(num==1){
            fourthSeatButton.setBackgroundResource(R.drawable.rightlow);
            Toast.makeText(requireActivity(),"Low Heat Mode On",Toast.LENGTH_SHORT).show();
        }else if(num==2){
            fourthSeatButton.setBackgroundResource(R.drawable.rightmed);
            Toast.makeText(requireActivity(),"Medium Heat Mode On",Toast.LENGTH_SHORT).show();
        }else if(num==3){
            fourthSeatButton.setBackgroundResource(R.drawable.righthigh);
            Toast.makeText(requireActivity(),"High Heat Mode On",Toast.LENGTH_SHORT).show();
        }else if(num==4) {
            fourthSeatButton.setBackgroundResource(R.drawable.ic_baseline_waves_24);
            Toast.makeText(requireActivity(),"Heat Mode Off",Toast.LENGTH_SHORT).show();
            dashBoardImageView.setImageResource(R.drawable.seat);
        }
    }

    @Override
    public void notifyFifthSeatButtonStatus(int num) {

        dashBoardImageView.setImageResource(R.drawable.fifthseatheat);

        if(num==1){
            fifthSeatButton.setBackgroundResource(R.drawable.rightlow);
            Toast.makeText(requireActivity(),"Low Heat Mode On",Toast.LENGTH_SHORT).show();
        }else if(num==2){
            fifthSeatButton.setBackgroundResource(R.drawable.rightmed);
            Toast.makeText(requireActivity(),"Medium Heat Mode On",Toast.LENGTH_SHORT).show();
        }else if(num==3){
            fifthSeatButton.setBackgroundResource(R.drawable.righthigh);
            Toast.makeText(requireActivity(),"High Heat Mode On",Toast.LENGTH_SHORT).show();
        }else if(num==4) {
            fifthSeatButton.setBackgroundResource(R.drawable.ic_baseline_waves_24);
            Toast.makeText(requireActivity(),"Heat Mode Off",Toast.LENGTH_SHORT).show();
            dashBoardImageView.setImageResource(R.drawable.seat);
        }
    }

    @Override
    public void notifyServiceConnectionStatus(int num) {
        if(num==1){
            Toast.makeText(requireContext(), "Seat Heater Tab Data Service connected", Toast.LENGTH_SHORT).show();
        }
        else if(num==0){
            Toast.makeText(requireContext(), "Seat Heater Tab Data Service Disconnected", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void updateFromDatabase(String num) {

    }

    @Override
    public void onStop() {
        super.onStop();
        mSeatHeaterTabFragmentPresenter.updateDatabase(getContext());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mSeatHeaterTabFragmentPresenter.updateServiceConnectionStatus(getContext());
    }
}
