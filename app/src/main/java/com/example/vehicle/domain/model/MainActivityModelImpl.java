package com.example.vehicle.domain.model;

import android.content.Context;
import android.util.Log;
import android.widget.ImageView;
import com.example.vehicle.MainActivity;
import com.example.vehicle.R;
import com.example.vehicle.domain.HmiMainDataServiceInterface;
import com.example.vehicle.presentation.presenter.IMainActivityPresenter;

public class MainActivityModelImpl implements IMainActivityModel {
    IMainActivityPresenter mPlayingPresenter;
    HmiMainDataServiceInterface mHmiServiceInterface;

    public MainActivityModelImpl(IMainActivityPresenter presenter) {
        mPlayingPresenter = presenter;
    }

    @Override
    public void init(Context context) {
        Log.d("Hmi", "init");
        mHmiServiceInterface = new HmiMainDataServiceInterface(context);
    }

    @Override
    public void updateIcons(Context context) {
        ImageView frontDefrostImageButton= ((MainActivity)context).findViewById(R.id.frontDefrostImageButton);
        frontDefrostImageButton.setImageResource(R.drawable.defroston);
    }

    @Override
    public void checkButtonStatus(Context context) {

    }
}
