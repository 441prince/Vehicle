package com.example.vehicle.presentation.presenter;

import android.content.Context;
import com.example.vehicle.domain.model.FanTabFragmentModelImpl;
import com.example.vehicle.domain.model.IFanTabFragmentModel;
import com.example.vehicle.presentation.view.IFanTabFragmentView;

/**
 * Created by Prince Joel
 */

public class FanTabFragmentPresenterImpl implements IFanTabFragmentPresenter {
    IFanTabFragmentView mFanTabFragmentView;
    IFanTabFragmentModel mFanTabFragmentModel;

    public FanTabFragmentPresenterImpl(IFanTabFragmentView view) {
        mFanTabFragmentView = view;
        mFanTabFragmentModel = new FanTabFragmentModelImpl(this);
    }

    @Override
    public void init(Context context) {
        mFanTabFragmentModel.init(context);
    }

    @Override
    public void updateFaceDirectionButtonStatus(Context context) {
        mFanTabFragmentModel.updateFaceDirectionButtonStatus(context);
    }

    @Override
    public void updateFeetDirectionButtonStatus(Context context) {
        mFanTabFragmentModel.updateFeetDirectionButtonStatus(context);
    }

    @Override
    public void updateFaceFeetDirectionButtonStatus(Context context) {
        mFanTabFragmentModel.updateFaceFeetDirectionButtonStatus(context);
    }

    @Override
    public void updateFaceFeetWindShieldDirectionButtonStatus(Context context) {
        mFanTabFragmentModel.updateFaceFeetWindShieldDirectionButtonStatus(context);
    }

    @Override
    public void updateMaxAcButtonStatus(Context context) {
        mFanTabFragmentModel.updateMaxAcButtonStatus(context);
    }

    @Override
    public void updateAirCirculateButtonStatus(Context context) {
        mFanTabFragmentModel.updateAirCirculateButtonStatus(context);
    }

    @Override
    public void updateBioHazardButtonStatus(Context context) {
        mFanTabFragmentModel.updateBioHazardButtonStatus(context);
    }

    @Override
    public void updateRearFanButtonStatus(Context context) {
        mFanTabFragmentModel.updateRearFanButtonStatus(context);
    }

    @Override
    public void updateFanIncreaseSpeedStatus(Context context) {
        mFanTabFragmentModel.updateFanIncreaseSpeedStatus(context);
    }
    @Override
    public void updateFanDecreaseSpeedStatus(Context context) {
        mFanTabFragmentModel.updateFanDecreaseSpeedStatus(context);
    }

    @Override
    public void updateServiceConnectionStatus(Context context) {
        mFanTabFragmentModel.updateServiceConnectionStatus(context);
    }

    @Override
    public void updateDatabase(Context context) {
        mFanTabFragmentModel.updateDatabase(context);
    }


    @Override
    public void notifyFaceDirectionButtonStatus(int num) {
        mFanTabFragmentView.notifyFaceDirectionButtonStatus(num);
    }

    @Override
    public void notifyFeetDirectionButtonStatus(int num) {
        mFanTabFragmentView.notifyFeetDirectionButtonStatus(num);
    }

    @Override
    public void notifyFaceFeetDirectionButtonStatus(int num) {
        mFanTabFragmentView.notifyFaceFeetDirectionButtonStatus(num);
    }

    @Override
    public void notifyFaceFeetWindShieldDirectionButtonStatus(int num) {
        mFanTabFragmentView.notifyFaceFeetWindShieldDirectionButtonStatus(num);
    }

    @Override
    public void notifyMaxAcButtonStatus(int num) {
        mFanTabFragmentView.notifyMaxAcButtonStatus(num);
    }

    @Override
    public void notifyAirCirculateButtonStatus(int num) {
        mFanTabFragmentView.notifyAirCirculateButtonStatus(num);
    }

    @Override
    public void notifyBioHazardButtonStatus(int num) {
        mFanTabFragmentView.notifyBioHazardButtonStatus(num);

    }

    @Override
    public void notifyRearFanButtonStatus(int num) {
        mFanTabFragmentView.notifyRearFanButtonStatus(num);
    }

    @Override
    public void notifyFanIncreaseSpeedStatus(String num) {
        mFanTabFragmentView.notifyFanIncreaseSpeedStatus(num);
    }
    @Override
    public void notifyFanDecreaseSpeedStatus(String num) {
        mFanTabFragmentView.notifyFanDecreaseSpeedStatus(num);
    }


    @Override
    public void notifyServiceConnectionStatus(int num) {
        mFanTabFragmentView.notifyServiceConnectionStatus(num);
    }
    @Override
    public void updateFromDatabase(String num) {
        mFanTabFragmentView.updateFromDatabase(num);
    }

}
