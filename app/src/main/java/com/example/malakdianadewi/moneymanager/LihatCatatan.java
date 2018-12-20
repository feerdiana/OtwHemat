package com.example.malakdianadewi.moneymanager;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;

public class LihatCatatan extends AppCompatActivity {
    DatabaseHelper dbcenter;
    Cursor cursor;
    TextView text1, text2, text3, text4, text5, text6, text7;
    private SessionManagement sessionManagement;
    String idtran ="", jenis="", jml= "", tanggal="", keterangan="",kategori="";
    Button del,upd,back;
    private ImageView imgnote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_catatan);
        sessionManagement = new SessionManagement(LihatCatatan.this);
        dbcenter = new DatabaseHelper(this); //membuat object dari datahelper
        text1 = (TextView) findViewById(R.id.lhtKategori);
        text2 = (TextView) findViewById(R.id.cat);
        text3 = (TextView) findViewById(R.id.mon);
        text4 = (TextView) findViewById(R.id.date);
        text5 = (TextView) findViewById(R.id.not);
        imgnote = (ImageView) findViewById(R.id.imgnote);
        del = (Button) findViewById(R.id.delete);
        upd = (Button) findViewById(R.id.update);
        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), menu.class);
                startActivity(i);
            }
        });
        final HashMap<String, String> user = sessionManagement.getUserInformation();

        SQLiteDatabase db = dbcenter.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM transaksi WHERE id_transaksi = '" + getIntent().getStringExtra("id") + "'",null);
        cursor.moveToFirst();
        if (cursor.getCount()>0) //jika hasil query tidak kosong
        {
            //isi variabel textview dengan hasil query sesuai indeks
            cursor.moveToPosition(0);
            idtran = cursor.getString(0).toString();
            tanggal =  cursor.getString(1).toString();
            jenis = cursor.getString(2).toString();
            kategori = cursor.getString(3).toString();
            jml = cursor.getString(5).toString();
            keterangan =  cursor.getString(6).toString();

            text1.setText(cursor.getString(3).toString());
            text2.setText(cursor.getString(2).toString());
            text3.setText(cursor.getString(5).toString());
            text4.setText(cursor.getString(1).toString());
            text5.setText(cursor.getString(6).toString());

        }

        upd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent m = new Intent(getApplicationContext(), UpdateCatatan.class);
                //melewatkan data dari class ini ke class UpdateCatatan
                m.putExtra("idTran",idtran);
                m.putExtra("jenis",jenis);
                m.putExtra("kategori",kategori);
                m.putExtra("jumlah", jml);
                m.putExtra("tanggal", tanggal);
                m.putExtra("keterangan",keterangan);
                startActivity(m);
            }
        });




    }

//membuat alert konfirmasi jika ingin menhapus catatan
    public void delete(View view){
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alert= new AlertDialog.Builder(LihatCatatan.this);
                alert.setTitle("Delete"); //mengatur judul
                alert.setMessage("Are you sure you want to delete this one?"); //mengatur isi pesan
                alert.setPositiveButton("Yes", new DialogInterface.OnClickListener(){ //jika memilih Yes maka data akan terhapus

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        SQLiteDatabase db = dbcenter.getWritableDatabase();
                        db.execSQL("delete from transaksi where id_transaksi = "+idtran);
                        Intent m = new Intent(getApplicationContext(), menu.class);
                        startActivity(m);
                    }
                });
                alert.setNegativeButton("No", new DialogInterface.OnClickListener(){ //jika memilih tidak akan menutup kotak dialog

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();

                    }
                });

                AlertDialog ale = alert.create();
                ale.show();;

            }
        });

    }
}
