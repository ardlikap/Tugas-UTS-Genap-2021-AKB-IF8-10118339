package com.becek39studio.catatanharian_10118339.model;

//Tanggal Pengerjaan 3 Juni 2021, 10118339, MUHAMMAD AL ARDLIKA PRIHASISWANA, IF8

import android.content.ContentValues;
import android.database.Cursor;

import com.becek39studio.catatanharian_10118339.database.table.TableNote;

public class Note {
    private int id;
    private String judul;
    private String kategori;
    private String isi_catatan;
    private String tanggal;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getIsi_catatan() {
        return isi_catatan;
    }

    public void setIsi_catatan(String isi_catatan) {
        this.isi_catatan = isi_catatan;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public Note fromCursor(Cursor c){
        this.setId(c.getInt(c.getColumnIndex(TableNote.FIELD_ID)));
        this.setJudul(c.getString(c.getColumnIndex(TableNote.FIELD_JUDUL)));
        this.setIsi_catatan(c.getString(c.getColumnIndex(TableNote.FIELD_ISICATATAN)));
        this.setKategori(c.getString(c.getColumnIndex(TableNote.FIELD_KATEGORI)));
        this.setTanggal(c.getString(c.getColumnIndex(TableNote.FIELD_TANGGAL)));
        return this;
    }

    public ContentValues toValues(){
        ContentValues cv = new ContentValues();
        if (this.getId() > 0){
            cv.put(TableNote.FIELD_ID, this.getId());
        }
        cv.put(TableNote.FIELD_JUDUL, this.getJudul());
        cv.put(TableNote.FIELD_KATEGORI, this.getKategori());
        cv.put(TableNote.FIELD_ISICATATAN, this.getIsi_catatan());
        cv.put(TableNote.FIELD_TANGGAL, this.getTanggal());
        return cv;
    }

    public String toString(){
        return this.getJudul();
    }
}
