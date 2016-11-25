package com.example.umarajipratama.kejar2;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView formButton,calculatorButton,listViewButton;
    Button likeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Home");

        formButton = (ImageView) findViewById(R.id.btn_form);
        calculatorButton = (ImageView) findViewById(R.id.btn_calculator);
        listViewButton = (ImageView) findViewById(R.id.btn_list);
        likeButton = (Button) findViewById(R.id.btn_like);


        formButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent keForm = new Intent(MainActivity.this,FormActivity.class);
                startActivity(keForm);
            }
        });

        calculatorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent keCalculator = new Intent(MainActivity.this,CalculatorActivity.class);
                startActivity(keCalculator);
            }
        });

        listViewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Hallo List View", Toast.LENGTH_SHORT).show();
                Intent keList = new Intent(MainActivity.this,listViewActivity.class);
                startActivity(keList);
            }
        });

        likeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Thanks you like this app !", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        //Pesan dialog
        builder.setMessage("Ingin keluar dari aplikasi ?").setCancelable(false)
                .setPositiveButton("Keluar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                        moveTaskToBack(true);
                        System.exit(0);
                    }
                })
                //button batal
                .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();

    }
}
