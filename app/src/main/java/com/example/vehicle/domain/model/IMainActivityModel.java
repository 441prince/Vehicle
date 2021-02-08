package com.example.vehicle.domain.model;

import android.content.Context;

/**
 * Created by Prince Joel
 */

public interface IMainActivityModel {

    void init(Context context);
    void updateAutoButtonStatus(Context context);
    void updateAcButtonStatus(Context context);
    void updateLeft_seatButtonStatus(Context context);
    void updateFanButtonStatus(Context context);
    void updateRight_seatButtonStatus(Context context);
    void updateFrontDefrostButtonStatus(Context context);
    void updateRearDefrostButtonStatus(Context context);
    void updateDogModeButtonStatus();
    void updateCampModeButtonStatus();
    void updateUserModeButtonStatus();
    void updateServiceConnectionStatus(Context context);
    void updateDatabase(Context context);

}
