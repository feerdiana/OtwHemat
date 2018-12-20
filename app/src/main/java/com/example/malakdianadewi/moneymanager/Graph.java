package com.example.malakdianadewi.moneymanager;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import lecho.lib.hellocharts.model.PieChartData;
import lecho.lib.hellocharts.model.SliceValue;
import lecho.lib.hellocharts.view.PieChartView;

public class Graph extends AppCompatActivity {

    //deklarasi global
    Cursor cursor;
    PieChartView pieChartView;
    DatabaseHelper dbcenter;
    SessionManagement sessionManagement;
    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);

        back = findViewById(R.id.back);
        pieChartView = findViewById(R.id.chart);
        dbcenter = new DatabaseHelper(this);

        back.setOnClickListener(new View.OnClickListener() {//memberikan perintah jika button back di klik maka akan berpindah ke halaman menu
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), menu.class); //berpindah ke halaman menu
                startActivity(i);

            }
        });


        List pieData = new ArrayList<>(); //membuat variabel pieData yang berupa arraylist untuk menyimpan isi dari chart
        sessionManagement = new SessionManagement(Graph.this);
        if (sessionManagement.isLoggedIn()) {
            final HashMap<String, String> user = sessionManagement.getUserInformation(); 

            SQLiteDatabase db = dbcenter.getReadableDatabase();
            cursor = db.rawQuery("SELECT SUM(jumlah) as total, kategori FROM transaksi WHERE id_user = '" + user.get(sessionManagement.KEY_ID_USER) + "' and jenis = 'Income' group by kategori", null);
            cursor.moveToFirst();

            for (int cc = 0; cc < cursor.getCount(); cc++) {
                cursor.moveToPosition(cc);
                int jumlah = Integer.parseInt(cursor.getString(0).toString());
                String kategori = cursor.getString(1).toString();
                //agar warna berbeda , buat if else sehingga memiliki warna beda tiap indeks cursor
                if (cc == 0) {
                    pieData.add(new SliceValue(jumlah, Color.BLUE).setLabel(kategori+jumlah)); //atur warna dan teks
                } else if (cc == 1) {
                    pieData.add(new SliceValue(jumlah, Color.GRAY).setLabel(kategori+jumlah));
                } else if (cc == 2) {
                    pieData.add(new SliceValue(jumlah, Color.RED).setLabel(kategori+jumlah));
                } else if (cc == 3) {
                    pieData.add(new SliceValue(jumlah, Color.MAGENTA).setLabel(kategori+jumlah));
                } else if (cc == 4) {
                    pieData.add(new SliceValue(jumlah, Color.CYAN).setLabel(kategori+jumlah));
                }

            }

            PieChartData pieChartData = new PieChartData(pieData);
            pieChartData.setHasLabels(true).setValueLabelTextSize(14);
            pieChartData.setHasCenterCircle(true).setCenterText1("Income").setCenterText1FontSize(20).setCenterText1Color(Color.parseColor("#0097A7"));
            pieChartView.setPieChartData(pieChartData);
        }

    }
}