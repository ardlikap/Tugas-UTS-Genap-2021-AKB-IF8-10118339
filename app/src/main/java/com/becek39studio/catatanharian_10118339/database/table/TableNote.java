package com.becek39studio.catatanharian_10118339.database.table;

//Tanggal Pengerjaan 3 Juni 2021, 10118339, MUHAMMAD AL ARDLIKA PRIHASISWANA, IF8

public class TableNote {
    public static String TABLE_NAME = "catatan";

    public static String FIELD_ID = "id";
    public static String FIELD_JUDUL = "judul";
    public static String FIELD_KATEGORI = "kategori";
    public static String FIELD_ISICATATAN = "isi_catatan";
    public static String FIELD_TANGGAL = "tgl";

    public static String CREATE_STATEMENT =
            "CREATE TABLE "+TABLE_NAME+"(" +
                    ""+FIELD_ID+" AUTO_INCREMENT PRIMARY KEY," +
                    ""+FIELD_JUDUL+" VARCHAR(255) NULL," +
                    ""+FIELD_KATEGORI+" VARCHAR(255) NULL," +
                    ""+FIELD_ISICATATAN+" TEXT NULL," +
                    ""+FIELD_TANGGAL+" DATE NULL" +
                    ");";
}
