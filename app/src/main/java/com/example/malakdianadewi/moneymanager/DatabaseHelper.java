package com.example.malakdianadewi.moneymanager;

/**
 * Created by Malak Diana Dewi on 05/12/2018.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    //mendeklarasikan semua kolom yang diperlukan di datasabe
    public static String DATABASE_NAME = "money_manager";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_USER = "user";
    private static final String TABLE_TRANSAKSI= "transaksi";
    private static final String KEY_ID_USER = "id_user";
    private static final String KEY_ID_TRANSAKSI = "id_transaksi";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_PASSWORD = "password";
    private static final String KEY_TANGGAL ="tanggal";
    private static final String KEY_JUMLAH ="jumlah";
    private static final String KEY_KATEGORI ="kategori";
    private static final String KEY_JENIS = "jenis";
    private static final String KEY_KETERANGAN = "keterangan";

    //mendeklarasikan perintah create tabel user untuk sqlite
    private static final String CREATE_TABLE_USER = "CREATE TABLE "
            + TABLE_USER + "("
            + KEY_ID_USER + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + KEY_EMAIL + " TEXT ,"
            + KEY_USERNAME+" TEXT,"
            + KEY_PASSWORD+" TEXT );";
    //mendeklarasikan perintah create tabel transaksi untuk sqlite
    private static final String CREATE_TABLE_TRANSAKSI = "CREATE TABLE "
            + TABLE_TRANSAKSI + "("
            + KEY_ID_TRANSAKSI+ " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + KEY_TANGGAL + " DATE ,"
            + KEY_JENIS+" TEXT ,"
            + KEY_KATEGORI+ " TEXT,"
            + KEY_ID_USER+" INTEGER,"
            + KEY_JUMLAH+" INTEGER,"

            + KEY_KETERANGAN+" TEXT );";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.d("table", CREATE_TABLE_USER);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //mengeksekusi perintah create tabel user dan transaksi
        db.execSQL(CREATE_TABLE_USER);
        db.execSQL(CREATE_TABLE_TRANSAKSI);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_USER + "'");
        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_TRANSAKSI + "'");
        onCreate(db);
    }

    //method untuk insert ke tabel user
    public void addUser(String email, String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        //data yang akan diinsertkan akan disimpan divariabel values sesuai kolom tabel
        values.put(KEY_EMAIL, email);
        values.put(KEY_USERNAME, username);
        values.put(KEY_PASSWORD, password);

        db.insert(TABLE_USER, null, values); //data vyang ada di values di insert kan ke database user
    }



    //method untuk menambah transaksi
    public void addTransaksi(String tanggal, String jenis, String kategori, int id_user ,int jumlah, String keterangan) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_TANGGAL, tanggal);
        values.put(KEY_JENIS, jenis);
        values.put(KEY_KATEGORI,kategori);
        values.put(KEY_ID_USER, id_user);
        values.put(KEY_JUMLAH,jumlah);
        values.put(KEY_KETERANGAN, keterangan);


        db.insert(TABLE_TRANSAKSI, null, values);
    }

    //method untuk update transaksi
    public void updateTransaksi(int id, String tanggal, String jenis, String kategori, int id_user ,int jumlah, String keterangan) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_TANGGAL, tanggal);
        values.put(KEY_JENIS, jenis);
        values.put(KEY_KATEGORI,kategori);
        values.put(KEY_ID_USER, id_user);
        values.put(KEY_JUMLAH,jumlah);
        values.put(KEY_KETERANGAN, keterangan);
        db.update(TABLE_TRANSAKSI, values, KEY_ID_TRANSAKSI + " = ?", new String[]{String.valueOf(id)});
    }






}
