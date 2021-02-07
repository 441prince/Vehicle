package com.example.vehicle.presentation.presenter;

import android.content.Context;
import com.example.vehicle.domain.model.IMainActivityModel;
import com.example.vehicle.domain.model.MainActivityModelImpl;
import com.example.vehicle.presentation.view.IMainActivityView;

/**
 * Created by Prince Joel
 */

public class MainActivityPresenterImpl implements IMainActivityPresenter {
    IMainActivityView mMainActivityView;
    IMainActivityModel mMainActivityModel;

    public MainActivityPresenterImpl(IMainActivityView view) {
        mMainActivityView = view;
        mMainActivityModel = new MainActivityModelImpl(this);
    }


    @Override
    public void updateAutoButtonStatus(Context context) {
        mMainActivityModel.updateAutoButtonStatus(context);
    }

    @Override
    public void updateAcButtonStatus(Context context) {
        mMainActivityModel.updateAcButtonStatus(context);
    }

    @Override
    public void updateLeft_seatButtonStatus(Context context) {
        mMainActivityModel.updateLeft_seatButtonStatus(context);
    }

    @Override
    public void updateFanButtonStatus(Context context) {
        mMainActivityModel.updateFanButtonStatus(context);
    }

    @Override
    public void updateRight_seatButtonStatus(Context context) {
        mMainActivityModel.updateRight_seatButtonStatus(context);
    }

    @Override
    public void updateFrontDefrostButtonStatus(Context context) {
        mMainActivityModel.updateFrontDefrostButtonStatus(context);
    }

    @Override
    public void updateRearDefrostButtonStatus(Context context) {
        mMainActivityModel.updateRearDefrostButtonStatus(context);
    }

    @Override
    public void updateDogModeButtonStatus() {
        mMainActivityModel.updateDogModeButtonStatus();
    }

    @Override
    public void updateCampModeButtonStatus() {
        mMainActivityModel.updateCampModeButtonStatus();
    }

    @Override
    public void updateUserModeButtonStatus() {
        mMainActivityModel.updateUserModeButtonStatus();
    }

    @Override
    public void updateServiceConnectionStatus(Context context) {
        mMainActivityModel.updateServiceConnectionStatus(context);
    }

    @Override
    public void updateDatabase(Context context) {
        mMainActivityModel.updateDatabase(context);
    }


    @Override
    public void notifyAutoButtonStatus(int num) {
        mMainActivityView.notifyAutoButtonStatus(num);
    }

    @Override
    public void notifyAcButtonStatus(int num) {
        mMainActivityView.notifyAcButtonStatus(num);
    }

    @Override
    public void notifyLeft_seatButtonStatus(int num) {
        mMainActivityView.notifyLeft_seatButtonStatus(num);
    }

    @Override
    public void notifyFanButtonStatus(int num) {
        mMainActivityView.notifyFanButtonStatus(num);
    }

    @Override
    public void notifyRight_seatButtonStatus(int num) {
        mMainActivityView.notifyRight_seatButtonStatus(num);
    }

    @Override
    public void notifyFrontDefrostButtonStatus(int num) {
        mMainActivityView.notifyFrontDefrostButtonStatus(num);
    }

    @Override
    public void notifyRearDefrostButtonStatus(int num) {
        mMainActivityView.notifyRearDefrostButtonStatus(num);

    }

    @Override
    public void notifyDogModeButtonStatus(int num) {
        mMainActivityView.notifyDogModeButtonStatus(num);
    }

    @Override
    public void notifyCampModeButtonStatus(int num) {
        mMainActivityView.notifyCampModeButtonStatus(num);
    }

    @Override
    public void notifyUserModeButtonStatus(int num) {
        mMainActivityView.notifyUserModeButtonStatus(num);
    }

    @Override
    public void notifyServiceConnectionStatus(int num) {
        mMainActivityView.notifyServiceConnectionStatus(num);
    }

    @Override
    public void init(Context context) {
        mMainActivityModel.init(context);
    }


}
