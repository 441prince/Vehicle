package com.example.vehicle.domain.hmidata;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME ="vehicle.db";

    public static final String TABLE_MAIN ="main";
    private static final String COLUMN_Auto = "auto";
    private static final String COLUMN_AC = "ac";
    private static final String COLUMN_LEFT_SEAT = "left_seat";
    private static final String COLUMN_FAN = "fan";
    private static final String COLUMN_RIGHT_SEAT = "right_seat";
    private static final String COLUMN_FRONT_DEFROST = "front_defrost";
    private static final String COLUMN_REAR_DEFROST= "rear_defrost";
    private static final String COLUMN_DOG_MODE = "dog_mode";
    private static final String COLUMN_CAMP_MODE = "camp_mode";
    private static final String COLUMN_USER_MODE= "user_mode";

    public static final String TABLE_NAME1 ="fan";
    private static final String COLUMN_AC_DIRECTION = "ac_direction";
    private static final String COLUMN_MAX_AC = "max_ac";
    private static final String COLUMN_AIR_CIRCULATE = "air_circulate";
    private static final String COLUMN_BIO_HAZARD = "bio_hazard";
    private static final String COLUMN_REAR_FAN = "rear_fan";
    private static final String COLUMN_FAN_SPEED = "fan_speed";

    public static final String TABLE_NAME2 ="seat_tab_data_table";
    private static final String COLUMN_DRIVER_SEAT = "driver_seat";
    private static final String COLUMN_PILLION_SEAT = "pillion_seat";
    private static final String COLUMN_THIRD_SEAT = "third_seat";
    private static final String COLUMN_FOURTH_SEAT = "fourth_seat";
    private static final String COLUMN_FIFTH_SEAT = "fifth_seat";

    /*private static final String TABLE_NAME4 ="preset_data_table";
    public static final String COL_1 ="ID";
    public static final String COL_2 ="FANSPEED";
    public static final String COL_3 ="ACSTATE";
    public static final String COL_4 ="TEMPERATURE";*/

    private String MAIN_DATA_TABLE = "CREATE TABLE main(main_id INTEGER PRIMARY KEY AUTOINCREMENT,auto TEXT,ac TEXT,left_seat TEXT,fan TEXT,right_seat TEXT,front_defrost TEXT,rear_defrost TEXT,dog_mode TEXT,camp_mode TEXT,user_mode TEXT)";
    private String CREATE_FAN_TAB_DATA_TABLE = "CREATE TABLE fan(first_tab_id INTEGER PRIMARY KEY AUTOINCREMENT,ac_direction TEXT,max_ac TEXT,air_circulate TEXT,bio_hazard TEXT,rear_fan TEXT,fan_speed TEXT)";
    private String CREATE_SEAT_TAB_DATA_TABLE = "CREATE TABLE seat(second_tab_id INTEGER PRIMARY KEY AUTOINCREMENT,driver_seat TEXT ,pillion_seat TEXT,third_seat TEXT,fourth_seat TEXT,fifth_seat TEXT)";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db=this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(MAIN_DATA_TABLE);
        db.execSQL(CREATE_FAN_TAB_DATA_TABLE);
        db.execSQL(CREATE_SEAT_TAB_DATA_TABLE );
        //db.execSQL("create table "+TABLE_NAME4 +"(ID INTEGER PRIMARY KEY AUTOINCREMENT,FANSPEED INTEGER,ACSTATE TEXT,TEMPERATURE INTEGER)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_MAIN);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME1);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME2);
        //db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME4);
        onCreate(db);
    }

    public boolean insertMainData(String auto, String ac, String left_seat, String fan, String right_seat, String front_defrost, String rear_defrost, String dog_mode, String camp_mode, String user_mode){

        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COLUMN_Auto ,auto);
        contentValues.put(COLUMN_AC,ac);
        contentValues.put(COLUMN_LEFT_SEAT ,left_seat);
        contentValues.put(COLUMN_FAN,fan);
        contentValues.put(COLUMN_RIGHT_SEAT ,right_seat);
        contentValues.put(COLUMN_FRONT_DEFROST,front_defrost);
        contentValues.put(COLUMN_REAR_DEFROST ,rear_defrost);
        contentValues.put(COLUMN_DOG_MODE,dog_mode);
        contentValues.put(COLUMN_CAMP_MODE ,camp_mode);
        contentValues.put(COLUMN_USER_MODE,user_mode);
        long inserted=db.insert(TABLE_MAIN,null,contentValues);
        if(inserted == -1)
            return false;
        else
            return true;
    }

    public boolean insertFanTabData(String ac_direction, String max_ac, String air_circulate, String bio_hazard, String rear_fan, String fan_speed){

        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COLUMN_AC_DIRECTION ,ac_direction);
        contentValues.put(COLUMN_MAX_AC,max_ac);
        contentValues.put(COLUMN_AIR_CIRCULATE ,air_circulate);
        contentValues.put(COLUMN_BIO_HAZARD,bio_hazard);
        contentValues.put(COLUMN_REAR_FAN ,rear_fan);
        contentValues.put(COLUMN_FAN_SPEED,fan_speed);
        long inserted=db.insert(TABLE_NAME1,null,contentValues);
        if(inserted == -1)
            return false;
        else
            return true;
    }
    public boolean insertSeatTabData(String driver_seat,String pillion_seat,String third_seat, String fourth_seat, String fifth_seat){

        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(COLUMN_DRIVER_SEAT,driver_seat);
        values.put(COLUMN_PILLION_SEAT ,pillion_seat);
        values.put(COLUMN_THIRD_SEAT,third_seat);
        values.put(COLUMN_FOURTH_SEAT ,fourth_seat);
        values.put(COLUMN_FIFTH_SEAT,fifth_seat);
        long inserted=db.insert(TABLE_NAME2, null, values);
        if(inserted == -1)
            return false;
        else
            return true;
    }

    /*public Cursor getAllData(){

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res =db.rawQuery("select * from "+TABLE_NAME4,null);
        return res;
    }*/

    public Cursor getMainData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res =db.rawQuery("select * from "+TABLE_NAME1,null);
        return res;
    }

    public Cursor getFanTabData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res =db.rawQuery("select * from "+TABLE_NAME1,null);
        return res;
    }
    public Cursor getSeatTabData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res =db.rawQuery("select * from "+TABLE_NAME1,null);
        return res;
    }
}
