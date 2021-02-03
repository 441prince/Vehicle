// IMainDataInterface.aidl
package com.example.vehicleservice;

interface IMainDataInterface
{
    int autoButtonOn(int num);
    int autoButtonOff(int num);
    int acButtonOn(int num);
    int acButtonOff(int num);
    int left_seatButtonOn(int num);
    int left_seatButtonOff(int num);
    int fanButtonOn(int num);
    int fanButtonOff(int num);
    int right_seatButtonOn(int num);
    int right_seatButtonOff(int num);
    int frontDefrostButtonOn(int num);
    int frontDefrostButtonOff(int num);
    int rearDefrostButtonOn(int num);
    int rearDefrostButtonOff(int num);
    int dogModeButtonOn(int num);
    int dogModeButtonOff(int num);
    int campModeButtonOn(int num);
    int campModeButtonOff(int num);
    int userModeButtonOn(int num);
    int userModeButtonOff(int num);

}