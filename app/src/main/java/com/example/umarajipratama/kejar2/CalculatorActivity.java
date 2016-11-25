package com.example.umarajipratama.kejar2;

import android.content.DialogInterface;
import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CalculatorActivity extends AppCompatActivity {

    //deklarasi variabel
    public String str = "";
    Character op = 'q';
    float i,numberInput,numberTemp;

    //widget
    EditText showResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        getSupportActionBar().setTitle("Kalkulator");

        //mengambil id dari result id
        showResult = (EditText) findViewById(R.id.resultId);
    }
    
    //insert data
    public void btn0Clicked(View view){
        inputData(0);
    }

    public void btn1Clicked(View view){
        inputData(1);
    }

    public void btn2Clicked(View view){
        inputData(2);
    }

    public void btn3Clicked(View view){
        inputData(3);
    }

    public void btn4Clicked(View view){
        inputData(4);
    }

    public void btn5Clicked(View view){
        inputData(5);
    }

    public void btn6Clicked(View view){
        inputData(6);
    }

    public void btn7Clicked(View view){
        inputData(7);
    }

    public void btn8Clicked(View view){
        inputData(8);
    }

    public void btn9Clicked(View view){
        inputData(9);
    }

    //operation

    public void btnplusClicked(View view){
        tampilAngka();
        op = '+';
    }

    public void btnminusClicked(View view){
        tampilAngka();
        op = '-';
    }

    public void btnperkalianClicked(View view){
        tampilAngka();
        op = '*';
    }

    public void btnpembagianClicked(View view){
        tampilAngka();
        op = '/';
    }

    public void btnmodulusClicked(View view){
        tampilAngka();
        op = '%';
    }

    public void btnequalsClicked(View view){
        hitungAngka();

    }

    public void btnclearClicked(View view){
        resetButton();
    }

    public void btnbackClicked(View view){
        keluarButton();
    }

    private void tampilAngka(){
        str = "";
        hitungHidden();
        numberTemp = numberInput;
    }

    private void hitungAngka(){  if (op == '+')
        numberInput = numberTemp + numberInput;
    else if (op == '-')
        numberInput = numberTemp - numberInput;
    else if (op == '/')
        numberInput = numberTemp / numberInput;
    else if (op == '%')
        numberInput = numberTemp % numberInput;
    else if (op == '*')
        numberInput = numberTemp * numberInput;

     showResult.setText("" + numberInput);

    }

    private void hitungHidden(){

        if (op == '+')
            numberInput = numberTemp + numberInput;
        else if (op == '-')
            numberInput = numberTemp - numberInput;
        else if (op == '/')
            numberInput = numberTemp / numberInput;
        else if (op == '%')
            numberInput = numberTemp % numberInput;
        else if (op == '*')
            numberInput = numberTemp * numberInput;

    }

    public void keluarButton(){
        Toast.makeText(CalculatorActivity.this, "Oke kambali ke manu !", Toast.LENGTH_SHORT).show();
       Intent kembaliKeMenu = new Intent(CalculatorActivity.this,MainActivity.class);
        startActivity(kembaliKeMenu);

    }

    private void resetButton(){
        str = "";
        op = 'q';
        numberInput = 0;
        numberTemp = 0;

        showResult.setText("");

    }



    private void inputData(int j) {
        str = str + Integer.toString(j);
        numberInput = Integer.valueOf(str).intValue();
        showResult.setText(str);
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        //tombol konfirm
        builder.setMessage("Ingin keluar aplikasi ?").setCancelable(false)
                //button keluar
            .setPositiveButton("Keluar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int id) {
                    finish();
                    moveTaskToBack(true);
                        System.exit(0);
                }
            })
                //batal tetap di aplikasi
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
