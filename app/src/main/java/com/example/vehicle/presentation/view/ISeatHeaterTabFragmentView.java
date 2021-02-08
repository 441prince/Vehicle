package com.example.vehicle.presentation.view;

/**
 * Created by Prince Joel
 */

public interface ISeatHeaterTabFragmentView {

    void notifyDriverSeatButtonStatus(int num);
    void notifyPillionSeatButtonStatus(int num);
    void notifyThirdSeatButtonStatus(int num);
    void notifyFourthSeatButtonStatus(int num);
    void notifyFifthSeatButtonStatus(int num);
    void notifyAllOffButtonStatus(int num);
    void notifyServiceConnectionStatus(int num);
    void updateFromDatabase(String num);

}
