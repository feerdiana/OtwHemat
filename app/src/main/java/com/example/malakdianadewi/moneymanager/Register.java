package com.example.malakdianadewi.moneymanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    EditText edtEmail, edtPassword,edtUser, edtPass;
    DatabaseHelper dbcenter;
    Button tonReg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        dbcenter = new DatabaseHelper(this); //membuat object dari datahelper
        edtEmail = (EditText) findViewById(R.id.editemail);
        edtPassword = (EditText) findViewById(R.id.editpassword);
        edtPass = (EditText) findViewById(R.id.editkonfpass);
        edtUser =(EditText) findViewById(R.id.edituser);
        tonReg=(Button) findViewById(R.id.buttonregister);
        tonReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = edtUser.getText().toString();
                String email = edtEmail.getText().toString();
                String password = edtPassword.getText().toString();
                String konfPass = edtPass.getText().toString(); //menyimpan nilai inputan dalam variable
                if(email.equals("") || email.trim().isEmpty() || password.equals("") || password.trim().isEmpty() ||
                        username.equals("") || username.trim().isEmpty() || konfPass.equals("") || konfPass.trim().isEmpty())//cek kondisi agar kolom tidak kosong
                {
                    Toast.makeText(Register.this,"Semua kolom harus diisi",Toast.LENGTH_LONG).show();
                }else if(!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()){//cek format email
                    Toast.makeText(Register.this,"Masukkan format email yang benar",Toast.LENGTH_LONG).show();

                }else if(!konfPass.equals(password)){//memastikan password yang dimasukkan sama
                    Toast.makeText(Register.this,"Konfirmasi password salah",Toast.LENGTH_LONG).show();
                }else{//jika semua kondisi terpenuhi maka berhasil

                    dbcenter.addUser(email,username,password); //menjalankan method untuk menambah data user
                    Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_LONG).show();
                    Intent mIntent = new Intent(getApplicationContext(),Login.class);
                    startActivity(mIntent);}//berpindah ke halaman login
            }

        });
    }

}
