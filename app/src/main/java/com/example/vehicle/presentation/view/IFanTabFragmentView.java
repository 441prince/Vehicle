package com.example.vehicle.presentation.view;


/**
 * Created by Prince Joel
 */

public interface IFanTabFragmentView {

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
