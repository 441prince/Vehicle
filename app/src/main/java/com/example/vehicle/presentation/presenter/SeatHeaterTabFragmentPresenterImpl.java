package com.example.vehicle.presentation.presenter;

import android.content.Context;
import com.example.vehicle.domain.model.ISeatHeaterTabFragmentModel;
import com.example.vehicle.domain.model.SeatHeaterTabFragmentModelImpl;
import com.example.vehicle.presentation.view.ISeatHeaterTabFragmentView;

/**
 * Created by Prince Joel
 */

public class SeatHeaterTabFragmentPresenterImpl implements ISeatHeaterTabFragmentPresenter {
    ISeatHeaterTabFragmentView mSeatHeaterTabFragmentView;
    ISeatHeaterTabFragmentModel mSeatHeaterTabFragmentModel;

    public SeatHeaterTabFragmentPresenterImpl(ISeatHeaterTabFragmentView view) {
        mSeatHeaterTabFragmentView = view;
        mSeatHeaterTabFragmentModel = new SeatHeaterTabFragmentModelImpl(this);
    }


    @Override
    public void init(Context context) {
        mSeatHeaterTabFragmentModel.init(context);
    }

    @Override
    public void updateDriverSeatButtonStatus(Context context) {
        mSeatHeaterTabFragmentModel.updateDriverSeatButtonStatus(context);
    }

    @Override
    public void updatePillionSeatButtonStatus(Context context) {
        mSeatHeaterTabFragmentModel.updatePillionSeatButtonStatus(context);
    }

    @Override
    public void updateThirdSeatButtonStatus(Context context) {
        mSeatHeaterTabFragmentModel.updateThirdSeatButtonStatus(context);
    }

    @Override
    public void updateFourthSeatButtonStatus(Context context) {
        mSeatHeaterTabFragmentModel.updateFourthSeatButtonStatus(context);
    }

    @Override
    public void updateFifthSeatButtonStatus(Context context) {
        mSeatHeaterTabFragmentModel.updateFifthSeatButtonStatus(context);
    }

    @Override
    public void updateAllOffButtonStatus(Context context) {
        mSeatHeaterTabFragmentModel.updateAllOffButtonStatus(context);
    }

    @Override
    public void updateServiceConnectionStatus(Context context) {
        mSeatHeaterTabFragmentModel.updateServiceConnectionStatus(context);
    }

    @Override
    public void updateDatabase(Context context) {
        mSeatHeaterTabFragmentModel.updateDatabase(context);
    }


    @Override
    public void notifyDriverSeatButtonStatus(int num) {
        mSeatHeaterTabFragmentView.notifyDriverSeatButtonStatus(num);
    }

    @Override
    public void notifyPillionSeatButtonStatus(int num) {
        mSeatHeaterTabFragmentView.notifyPillionSeatButtonStatus(num);
    }

    @Override
    public void notifyThirdSeatButtonStatus(int num) {
        mSeatHeaterTabFragmentView.notifyThirdSeatButtonStatus(num);
    }

    @Override
    public void notifyFourthSeatButtonStatus(int num) {
        mSeatHeaterTabFragmentView.notifyFourthSeatButtonStatus(num);
    }

    @Override
    public void notifyFifthSeatButtonStatus(int num) {
        mSeatHeaterTabFragmentView.notifyFifthSeatButtonStatus(num);
    }

    @Override
    public void notifyAllOffButtonStatus(int num) {
        mSeatHeaterTabFragmentView.notifyAllOffButtonStatus(num);
    }

    @Override
    public void notifyServiceConnectionStatus(int num) {
        mSeatHeaterTabFragmentView.notifyServiceConnectionStatus(num);
    }
    @Override
    public void updateFromDatabase(String num) {
        mSeatHeaterTabFragmentView.updateFromDatabase(num);
    }

}
