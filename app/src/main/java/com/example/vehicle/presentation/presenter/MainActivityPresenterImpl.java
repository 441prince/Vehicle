package com.example.vehicle.presentation.presenter;

import android.content.Context;

import com.example.vehicle.domain.model.IMainActivityModel;
import com.example.vehicle.domain.model.MainActivityModelImpl;
import com.example.vehicle.presentation.view.IMainActivityView;


public class MainActivityPresenterImpl implements IMainActivityPresenter {
    IMainActivityView mMainActivityView;
    IMainActivityModel mMainActivityModel;

    public MainActivityPresenterImpl(IMainActivityView view) {
        mMainActivityView = view;
        mMainActivityModel = new MainActivityModelImpl(this);
    }

    @Override
    public void updateIcons(Context context) {
        mMainActivityModel.updateIcons(context);
    }
    @Override
    public void init(Context context) {
        mMainActivityModel.init(context);
    }
}
