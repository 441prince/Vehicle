// IFanTabDataInterface.aidl
package com.example.vehicleservice;

// Declare any non-default types here with import statements

/**
 * Created by Prince Joel
 */


interface IFanTabDataInterface {

        int faceDirectionButtonOn(int num);
        int faceDirectionButtonOff(int num);

        int feetDirectionButtonOn(int num);
        int feetDirectionButtonOff(int num);

        int faceFeetDirectionButtonOn(int num);
        int faceFeetDirectionButtonOff(int num);

        int faceFeetWindShieldDirectionButtonOn(int num);
        int faceFeetWindShieldDirectionButtonOff(int num);

        int maxAcButtonOn(int num);
        int maxAcButtonOff(int num);

        int airCirculateButtonOn(int num);
        int airCirculateButtonOff(int num);

        int bioHazardButtonOn(int num);
        int bioHazardButtonOff(int num);

        int rearFanButtonOn(int num);
        int rearFanButtonOff(int num);

        int fanSpeed(int num);

    }