package com.example.vehicle.presentation.view;


/**
 * Created by Prince Joel
 */

public interface IMainActivityView {

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
