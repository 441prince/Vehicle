package com.example.vehicle.presentation.presenter;

import android.content.Context;

/**
 * Created by Prince Joel
 */

public interface ISeatHeaterTabFragmentPresenter {

    void init(Context context);
    void updateDriverSeatButtonStatus(Context context);
    void updatePillionSeatButtonStatus(Context context);
    void updateThirdSeatButtonStatus(Context context);
    void updateFourthSeatButtonStatus(Context context);
    void updateFifthSeatButtonStatus(Context context);
    void updateAllOffButtonStatus(Context context);
    void updateServiceConnectionStatus(Context context);
    void updateDatabase(Context context);

    void notifyDriverSeatButtonStatus(int num);
    void notifyPillionSeatButtonStatus(int num);
    void notifyThirdSeatButtonStatus(int num);
    void notifyFourthSeatButtonStatus(int num);
    void notifyFifthSeatButtonStatus(int num);
    void notifyAllOffButtonStatus(int num);
    void notifyServiceConnectionStatus(int num);
    void updateFromDatabase(String num);

}
