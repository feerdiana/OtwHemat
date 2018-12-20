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

public class GraphExpenses extends AppCompatActivity {
    Cursor cursor;
    PieChartView pieChartView;
    DatabaseHelper dbcenter;
    SessionManagement sessionManagement;
    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);

        pieChartView = findViewById(R.id.chart);
        dbcenter = new DatabaseHelper(this);
        List pieData = new ArrayList<>();
        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), menu.class);
                startActivity(i);
            }
        });
        sessionManagement = new SessionManagement(GraphExpenses.this);
        if (sessionManagement.isLoggedIn()) {
            final HashMap<String, String> user = sessionManagement.getUserInformation();

            // pieData.add(new SliceValue(15, Color.BLUE).setLabel("Q1: $10"));
            // pieData.add(new SliceValue(25, Color.GRAY).setLabel("Q2: $4"));
            //pieData.add(new SliceValue(10, Color.RED).setLabel("Q3: $18"));
            // pieData.add(new SliceValue(60, Color.MAGENTA).setLabel("Q4: $28"));

            SQLiteDatabase db = dbcenter.getReadableDatabase();
            cursor = db.rawQuery("SELECT SUM(jumlah) as total, kategori FROM transaksi WHERE id_user = '" + user.get(sessionManagement.KEY_ID_USER) + "' and jenis = 'Expenses' group by kategori", null);
            cursor.moveToFirst();

            for (int cc = 0; cc < cursor.getCount(); cc++) {
                cursor.moveToPosition(cc);
                int jumlah = Integer.parseInt(cursor.getString(0).toString());
                String kategori = cursor.getString(1).toString();
                if (cc == 0) {
                    pieData.add(new SliceValue(jumlah, Color.BLUE).setLabel(kategori+jumlah));
                } else if (cc == 1) {
                    pieData.add(new SliceValue(jumlah, Color.GRAY).setLabel(kategori+jumlah));
                } else if (cc == 2) {
                    pieData.add(new SliceValue(jumlah, Color.RED).setLabel(kategori+jumlah));
                } else if (cc == 3) {
                    pieData.add(new SliceValue(jumlah, Color.MAGENTA).setLabel(kategori+jumlah));
                } else if (cc == 4) {
                    pieData.add(new SliceValue(jumlah, Color.CYAN).setLabel(kategori+jumlah));
                }else{
                    pieData.add(new SliceValue(jumlah, Color.GREEN).setLabel(kategori+jumlah));
                }

            }

            PieChartData pieChartData = new PieChartData(pieData);
            pieChartData.setHasLabels(true).setValueLabelTextSize(14);
            pieChartData.setHasCenterCircle(true).setCenterText1("Expenses").setCenterText1FontSize(20).setCenterText1Color(Color.parseColor("#0097A7"));
            pieChartView.setPieChartData(pieChartData);
        }

    }
}