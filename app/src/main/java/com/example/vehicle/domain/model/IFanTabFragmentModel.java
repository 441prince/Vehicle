package com.example.vehicle.domain.model;

import android.content.Context;

/**
 * Created by Prince Joel
 */

public interface IFanTabFragmentModel {

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

}
