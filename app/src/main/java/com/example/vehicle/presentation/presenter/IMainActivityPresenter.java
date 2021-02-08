package com.example.vehicle.presentation.presenter;

import android.content.Context;

/**
 * Created by Prince Joel
 */

public interface IMainActivityPresenter {

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

    void notifyAutoButtonStatus(int num);
    void notifyAcButtonStatus(int num);
    void notifyLeft_seatButtonStatus(int num);
    void notifyFanButtonStatus(int num);
    void notifyRight_seatButtonStatus(int num);
    void notifyFrontDefrostButtonStatus(int num);
    void notifyRearDefrostButtonStatus(int num);
    void notifyDogModeButtonStatus(int num);
    void notifyCampModeButtonStatus(int num);
    void notifyUserModeButtonStatus(int num);
    void notifyServiceConnectionStatus(int num);

}
