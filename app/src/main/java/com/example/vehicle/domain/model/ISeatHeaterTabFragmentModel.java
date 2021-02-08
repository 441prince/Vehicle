package com.example.vehicle.domain.model;

import android.content.Context;

/**
 * Created by Prince Joel
 */

public interface ISeatHeaterTabFragmentModel {

    void init(Context context);
    void updateDriverSeatButtonStatus(Context context);
    void updatePillionSeatButtonStatus(Context context);
    void updateThirdSeatButtonStatus(Context context);
    void updateFourthSeatButtonStatus(Context context);
    void updateFifthSeatButtonStatus(Context context);
    void updateAllOffButtonStatus(Context context);
    void updateServiceConnectionStatus(Context context);
    void updateDatabase(Context context);

}
