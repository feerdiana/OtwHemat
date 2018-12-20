package com.example.malakdianadewi.moneymanager;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText edtEmail, edtPassword;
    TextView tvEmail;
    Button buttonLogin, buttonRegis;
    SessionManagement sessionManagement;
    DatabaseHelper dbcenter;
    protected Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        sessionManagement = new SessionManagement(Login.this); //membuat objek dari SessionManagememnt
        edtEmail = findViewById(R.id.email);
        edtPassword = findViewById(R.id.password);
        buttonLogin = findViewById(R.id.btnlogin);
        buttonRegis = findViewById(R.id.signup);
        dbcenter = new DatabaseHelper(this);
        if(sessionManagement.isLoggedIn()){ //jika sudah login maka menjalankan function goToActivity
            goToActivity();;
        }
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = edtEmail.getText().toString();
                String password = edtPassword.getText().toString();
                if(email.equals("") || email.trim().isEmpty() || password.equals("") || password.trim().isEmpty()  ) {
                    //memastikan agar email tidak kosong
                    Toast.makeText(Login.this,"Username Password harus diisi",Toast.LENGTH_LONG).show();
                }else if(!(email.contains("@"))){
                    //memastikan email sesuai format
                    Toast.makeText(Login.this,"Masukkan format email yang benar",Toast.LENGTH_LONG).show();
                }
                else
                {
                    SQLiteDatabase db = dbcenter.getReadableDatabase();
                    cursor = db.rawQuery("SELECT * FROM user WHERE email = '" + email + "' AND password = '"+ password+ "'",null);
                    cursor.moveToFirst();
                    if(cursor.getCount()>0){
                        //membuat session
                        sessionManagement.createLoginSession(cursor.getString(0).toString(),cursor.getString(1).toString(),cursor.getString(2).toString(), password);
                        goToActivity();
                    }else {
                        //membuat peringatan jika data user tidak ada di database
                        Toast.makeText(Login.this, "Username Password harus ada di database", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
        buttonRegis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(getApplicationContext(),Register.class);
                startActivity(mIntent);
            }
        });
    }
    private void goToActivity(){
        Intent mIntent = new Intent(getApplicationContext(),menu.class);
        startActivity(mIntent);
    }

}
