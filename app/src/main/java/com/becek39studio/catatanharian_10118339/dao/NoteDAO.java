package com.becek39studio.catatanharian_10118339.dao;

//Tanggal Pengerjaan 3 Juni 2021, 10118339, MUHAMMAD AL ARDLIKA PRIHASISWANA, IF8

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.becek39studio.catatanharian_10118339.database.DataHelper;
import com.becek39studio.catatanharian_10118339.database.table.TableNote;
import com.becek39studio.catatanharian_10118339.model.Note;

import java.util.ArrayList;

public class NoteDAO {

    DataHelper dataHelper;

    public NoteDAO(Context context){
        dataHelper = new DataHelper(context);
    }

    public ArrayList<Note> select(String where, String[] whereArgs){
        ArrayList<Note> catatan = new ArrayList<>();
        SQLiteDatabase db = dataHelper.getReadableDatabase();
        try {
            Cursor c = db.query(TableNote.TABLE_NAME, new String[]{"*"}, where, whereArgs, null, null, TableNote.FIELD_TANGGAL);
            if(c.getCount() > 0 && c.moveToFirst()){
                while (!c.isAfterLast()){
                    catatan.add(new Note().fromCursor(c));
                    c.moveToNext();
                }
                c.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        db.close();
        return catatan;
    }

    public long insert(Note c){
        long id = -1;
        SQLiteDatabase db = dataHelper.getWritableDatabase();
        try {
            ContentValues values;
            id = db.insert(TableNote.TABLE_NAME, null, c.toValues());
        }catch (Exception e){
            e.printStackTrace();
        }
        db.close();
        return id;
    }

    public int update(Note c){
        int rows = -1;
        SQLiteDatabase db = dataHelper.getWritableDatabase();
        try {
            ContentValues cv = c.toValues();
            rows = db.update(TableNote.TABLE_NAME, cv, TableNote.FIELD_ID,new String[]{String.valueOf(cv.getAsInteger(TableNote.FIELD_ID))} );
        }catch (Exception e){
            e.printStackTrace();
        }

        db.close();
        return rows;
    }

    public int delete(int id){
        int rows = -1;
        SQLiteDatabase db = dataHelper.getWritableDatabase();
        try {
            rows = db.delete(TableNote.TABLE_NAME, TableNote.FIELD_ID, new String[]{String.valueOf(id)});
        }catch (Exception e){
            e.printStackTrace();
        }
        db.close();
        return rows;
    }
}
