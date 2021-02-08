package com.example.vehicle;

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
import com.example.vehicle.presentation.presenter.FanTabFragmentPresenterImpl;
import com.example.vehicle.presentation.presenter.IFanTabFragmentPresenter;
import com.example.vehicle.presentation.view.IFanTabFragmentView;


public class FanTabFragment extends Fragment implements View.OnClickListener, IFanTabFragmentView {
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
    private IFanTabFragmentPresenter mFanTabFragmentPresenter;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initViews(view);
        initListeners();
        initObjects();

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

        mFanTabFragmentPresenter = new FanTabFragmentPresenterImpl(this);
        mFanTabFragmentPresenter.init(getContext());
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.faceDirectionImageButton:
                if (mFanTabFragmentPresenter != null) {
                    mFanTabFragmentPresenter.updateFaceDirectionButtonStatus(getContext());
                }
                return;

            case R.id.feetDirectionImageButton:
                if (mFanTabFragmentPresenter != null) {
                    mFanTabFragmentPresenter.updateFeetDirectionButtonStatus(getContext());
                }
                return;

            case R.id.faceFeetDirectionImageButton:
                if (mFanTabFragmentPresenter != null) {
                    mFanTabFragmentPresenter.updateFaceFeetDirectionButtonStatus(getContext());
                }
                return;

            case R.id.faceFeetWindShieldDirectionImageButton:
                if (mFanTabFragmentPresenter != null) {
                     mFanTabFragmentPresenter.updateFaceFeetWindShieldDirectionButtonStatus(getContext());
                }
                return;

            case R.id.maxAcImageButton:
                if (mFanTabFragmentPresenter != null) {
                    mFanTabFragmentPresenter.updateMaxAcButtonStatus(getContext());
                }
                return;

            case R.id.airCirculateImageButton:
                if (mFanTabFragmentPresenter != null) {
                    mFanTabFragmentPresenter.updateAirCirculateButtonStatus(getContext());
                }
                return;

            case R.id.bioHazardImageButton:
                if (mFanTabFragmentPresenter != null) {
                    mFanTabFragmentPresenter.updateBioHazardButtonStatus(getContext());
                }
                return;

            case R.id.rearFanImageButton:
                if (mFanTabFragmentPresenter != null) {
                    mFanTabFragmentPresenter.updateRearFanButtonStatus(getContext());
                }
                return;

            case R.id.increase:
                if (mFanTabFragmentPresenter != null) {
                    mFanTabFragmentPresenter.updateFanIncreaseSpeedStatus(getContext());
                }
                return;

            case R.id.decrease:
                if (mFanTabFragmentPresenter != null) {
                    mFanTabFragmentPresenter.updateFanDecreaseSpeedStatus(getContext());
                }
                return;

            case R.id.fanSpeedText:

                return;

            default:
                return;
        }

    }

    @Override
    public void notifyFaceDirectionButtonStatus(int num) {
        if(num==1){
            faceDirectionImageButton.setImageResource(R.drawable.upon);
            feetDirectionImageButton.setImageResource(R.drawable.down);
            faceFeetDirectionImageButton.setImageResource(R.drawable.updown);
            faceFeetWindShieldDirectionImageButton.setImageResource(R.drawable.updownwindshield);
            dashBoardImageView.setImageResource(R.drawable.fanup);
            Toast.makeText(requireActivity(),"Face Direction On",Toast.LENGTH_SHORT).show();
        }else if(num ==2){
            faceDirectionImageButton.setImageResource(R.drawable.up);
            dashBoardImageView.setImageResource(R.drawable.dashfan);
            Toast.makeText(requireActivity(),"Face Direction Off",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void notifyFeetDirectionButtonStatus(int num) {
        if(num==1){
            feetDirectionImageButton.setImageResource(R.drawable.downon);
            faceDirectionImageButton.setImageResource(R.drawable.up);
            faceFeetDirectionImageButton.setImageResource(R.drawable.updown);
            faceFeetWindShieldDirectionImageButton.setImageResource(R.drawable.updownwindshield);
            dashBoardImageView.setImageResource(R.drawable.fandown);
            Toast.makeText(requireActivity(),"Feet Direction On",Toast.LENGTH_SHORT).show();

        }else if(num==2){
            feetDirectionImageButton.setImageResource(R.drawable.down);
            dashBoardImageView.setImageResource(R.drawable.dashfan);
            Toast.makeText(requireActivity(),"Feet Direction Off",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void notifyFaceFeetDirectionButtonStatus(int num) {
        if(num ==1){
            faceFeetDirectionImageButton.setImageResource(R.drawable.updownon);
            faceDirectionImageButton.setImageResource(R.drawable.up);
            feetDirectionImageButton.setImageResource(R.drawable.down);
            faceFeetWindShieldDirectionImageButton.setImageResource(R.drawable.updownwindshield);
            dashBoardImageView.setImageResource(R.drawable.fanupdown);
            Toast.makeText(requireActivity(),"Face & Feet Direction On",Toast.LENGTH_SHORT).show();
        }else if(num ==2){
            faceFeetDirectionImageButton.setImageResource(R.drawable.updown);
            dashBoardImageView.setImageResource(R.drawable.dashfan);
            Toast.makeText(requireActivity(),"Face & Feet Direction Off",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void notifyFaceFeetWindShieldDirectionButtonStatus(int num) {
        if(num==1){
            faceFeetWindShieldDirectionImageButton.setImageResource(R.drawable.updownwindshieldon);
            faceDirectionImageButton.setImageResource(R.drawable.up);
            feetDirectionImageButton.setImageResource(R.drawable.down);
            faceFeetDirectionImageButton.setImageResource(R.drawable.updown);
            dashBoardImageView.setImageResource(R.drawable.fanupdowndefrost);
            Toast.makeText(requireActivity(),"Face, Feet, WindShield Direction On",Toast.LENGTH_SHORT).show();
        }else if(num ==2){
            faceFeetWindShieldDirectionImageButton.setImageResource(R.drawable.updownwindshield);
            dashBoardImageView.setImageResource(R.drawable.dashfan);
            Toast.makeText(requireActivity(),"Face, Feet, WindShield Direction Off",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void notifyMaxAcButtonStatus(int num) {
        if(num==1){
            maxAcImageButton.setImageResource(R.drawable.maxacon);
            Toast.makeText(requireActivity(),"Max-AC On",Toast.LENGTH_SHORT).show();
        }else if(num ==2){
            maxAcImageButton.setImageResource(R.drawable.maxac);
            Toast.makeText(requireActivity(),"Max-AC Off",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void notifyAirCirculateButtonStatus(int num) {
        if(num==1){
            airCirculateImageButton.setImageResource(R.drawable.circulateon);
            Toast.makeText(requireActivity(),"AirCirculate On",Toast.LENGTH_SHORT).show();
        }else if(num==2){
            airCirculateImageButton.setImageResource(R.drawable.circulate);
            Toast.makeText(requireActivity(),"AirCirculate Off",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void notifyBioHazardButtonStatus(int num) {
        if(num==1){
            bioHazardImageButton.setImageResource(R.drawable.biohazardon);
            Toast.makeText(requireActivity(),"Bio-Hazard On",Toast.LENGTH_SHORT).show();
        }else if(num==2){
            bioHazardImageButton.setImageResource(R.drawable.biohazard);
            Toast.makeText(requireActivity(),"Bio-Hazard Off",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void notifyRearFanButtonStatus(int num) {
        if(num==1){
            rearFanImageButton.setImageResource(R.drawable.rearfanchange);
            Toast.makeText(requireActivity(),"Rear Fan On",Toast.LENGTH_SHORT).show();
        }else if(num==2){
            rearFanImageButton.setImageResource(R.drawable.rearfan);
            Toast.makeText(requireActivity(),"Rear Fan Off",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void notifyFanIncreaseSpeedStatus(String num) {
        dashBoardImageView.setImageResource(R.drawable.dashfanon);
        fanSpeedText.setText(num);
    }
    @Override
    public void notifyFanDecreaseSpeedStatus(String num) {
        if(num=="0") {
            dashBoardImageView.setImageResource(R.drawable.dashfannew);
            Toast.makeText(requireActivity(),"Fan Turned Off",Toast.LENGTH_SHORT).show();
        }
        fanSpeedText.setText( num);
    }

    @Override
    public void notifyServiceConnectionStatus(int num) {
        if(num==1){
            Toast.makeText(requireContext(), "Fan Tab Data Service connected", Toast.LENGTH_SHORT).show();
        }
        else if(num==0){
            Toast.makeText(requireContext(), "Fan Tab Data Service Disconnected", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void updateFromDatabase(String num) {
        fanSpeedText.setText(num);
    }

    @Override
    public void onStop() {
        super.onStop();
        mFanTabFragmentPresenter.updateDatabase(getContext());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mFanTabFragmentPresenter.updateServiceConnectionStatus(getContext());
    }
}