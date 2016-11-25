package com.example.umarajipratama.kejar2;

import android.content.DialogInterface;
import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class FormActivity extends AppCompatActivity {

    EditText edtNama,edtEmail,edtAlamat,edtPesan;
    RadioGroup jenisKelamin;
    Button btnKirim,btnKembali;

    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_form);

        getSupportActionBar().setTitle("Form Pesan");

            /*Edit text*/
            edtNama = (EditText) findViewById(R.id.edt_nama);
            edtEmail = (EditText) findViewById(R.id.edt_email);
            edtAlamat = (EditText) findViewById(R.id.edt_alamat);
            edtPesan = (EditText) findViewById(R.id.edt_pesan);

            /*Radio Group*/
            jenisKelamin = (RadioGroup) findViewById(R.id.jenis_kelamin);

            /*Button*/
            btnKirim = (Button) findViewById(R.id.btn_kirim);
            btnKembali = (Button) findViewById(R.id.btn_kembali);


            btnKirim.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(FormActivity.this, "Pesan telah dikirim !", Toast.LENGTH_SHORT).show();
                    Intent KirimData = new Intent(FormActivity.this,PesanDetail.class);

                    //tampat data di ambil
                    Bundle TempatData = new Bundle();

                    TempatData.putString("nama",edtNama.getText().toString());
                    TempatData.putString("email",edtEmail.getText().toString());
                    TempatData.putString("alamat",edtAlamat.getText().toString());
                    TempatData.putString("pesan",edtPesan.getText().toString());

                    int id = jenisKelamin.getCheckedRadioButtonId();
                    RadioButton radioButton = (RadioButton) findViewById(id);
                    TempatData.putString("jeniskelamin",radioButton.getText().toString());

                    //Kirim Data

                    KirimData.putExtras(TempatData);
                    startActivity(KirimData);

                }
            });

            btnKembali.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   /* Toast.makeText(FormActivity.this, "Kembali Bro", Toast.LENGTH_SHORT).show();*/
                    Intent Kembali = new Intent(FormActivity.this,MainActivity.class);
                    startActivity(Kembali);
                }
            });

        }

    @Override
    public void onBackPressed() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        //pesan keluar
        builder.setMessage("Keluar dari aplikasi ?").setCancelable(false).setPositiveButton("Keluar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                finish();
                moveTaskToBack(true);
                System.exit(0);
            }
        }).setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();




    }
}
