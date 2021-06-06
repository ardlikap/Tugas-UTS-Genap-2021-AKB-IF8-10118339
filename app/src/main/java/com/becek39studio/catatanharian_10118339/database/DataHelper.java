package com.becek39studio.catatanharian_10118339.database;

//Tanggal Pengerjaan 3 Juni 2021, 10118339, MUHAMMAD AL ARDLIKA PRIHASISWANA, IF8

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.becek39studio.catatanharian_10118339.database.table.TableNote;

public class DataHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "catatan_harian_10118339";
    private static final int DATABASE_VERSION = 1;
    public DataHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(TableNote.CREATE_STATEMENT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

    }
}
