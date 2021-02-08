package com.example.vehicle.presentation.presenter;

import android.content.Context;

/**
 * Created by Prince Joel
 */

public interface IFanTabFragmentPresenter {

    void init(Context context);

    void updateFaceDirectionButtonStatus(Context context);
    void updateFeetDirectionButtonStatus(Context context);
    void updateFaceFeetDirectionButtonStatus(Context context);
    void updateFaceFeetWindShieldDirectionButtonStatus(Context context);
    void updateMaxAcButtonStatus(Context context);
    void updateAirCirculateButtonStatus(Context context);
    void updateBioHazardButtonStatus(Context context);
    void updateRearFanButtonStatus(Context context);
    void updateFanIncreaseSpeedStatus(Context context);
    void updateFanDecreaseSpeedStatus(Context context);
    void updateServiceConnectionStatus(Context context);
    void updateDatabase(Context context);


    void notifyFaceDirectionButtonStatus(int num);
    void notifyFeetDirectionButtonStatus(int num);
    void notifyFaceFeetDirectionButtonStatus(int num);
    void notifyFaceFeetWindShieldDirectionButtonStatus(int num);
    void notifyMaxAcButtonStatus(int num);
    void notifyAirCirculateButtonStatus(int num);
    void notifyBioHazardButtonStatus(int num);
    void notifyRearFanButtonStatus(int num);
    void notifyFanIncreaseSpeedStatus(String num);
    void notifyFanDecreaseSpeedStatus(String num);
    void notifyServiceConnectionStatus(int num);
    void updateFromDatabase(String num);
}
