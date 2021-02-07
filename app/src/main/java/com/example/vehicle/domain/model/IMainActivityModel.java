package com.example.vehicle.domain.model;

import android.content.Context;

public interface IMainActivityModel extends IBaseModel{

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
}
