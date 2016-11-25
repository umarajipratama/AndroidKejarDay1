package com.example.umarajipratama.kejar2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.MissingFormatArgumentException;

public class PesanDetail extends AppCompatActivity {

    TextView namaValue,emailValue,alamatValue,pesanValue,jkValue;
    Button btnSelesai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesan_detail);

        getSupportActionBar().setTitle("Detail Pesan");

        Bundle TerimaData = getIntent().getExtras();

        //buat objek

        namaValue = (TextView) findViewById(R.id.value_nama);
        emailValue = (TextView) findViewById(R.id.value_email);
        alamatValue = (TextView) findViewById(R.id.value_alamat);
        pesanValue = (TextView) findViewById(R.id.value_pesan);
        jkValue = (TextView) findViewById(R.id.value_jk);


        //set nilainya
        namaValue.setText(TerimaData.getCharSequence("nama"));
        emailValue.setText(TerimaData.getCharSequence("email"));
        alamatValue.setText(TerimaData.getCharSequence("alamat"));
        jkValue.setText(TerimaData.getCharSequence("jeniskelamin"));
        pesanValue.setText(TerimaData.getCharSequence("pesan"));


        btnSelesai = (Button) findViewById(R.id.btn_back_menu);

        btnSelesai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PesanDetail.this, "Thanks !", Toast.LENGTH_SHORT).show();
                Intent keManu = new Intent(PesanDetail.this, MainActivity.class);
                startActivity(keManu);
            }
        });


    }
}
