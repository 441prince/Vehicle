// IFanTabDataInterface.aidl
package com.example.vehicleservice;

// Declare any non-default types here with import statements

/**
 * Created by Prince Joel
 */

interface ISeatHeaterTabDataInterface {

    int driverSeatButtonOn(int num);
    int driverSeatButtonOff(int num);

    int pillionSeatButtonOn(int num);
    int pillionSeatButtonOff(int num);

    int thirdSeatButtonOn(int num);
    int thirdSeatButtonOff(int num);

    int fourthSeatButtonOn(int num);
    int fourthSeatButtonOff(int num);

    int fifthSeatButtonOn(int num);
    int fifthSeatButtonOff(int num);

    int allOffButton(int num);

}