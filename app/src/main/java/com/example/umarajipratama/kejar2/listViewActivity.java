package com.example.umarajipratama.kejar2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class listViewActivity extends AppCompatActivity {

    ListView lvItem;
    String[] arrProgram = new String[]{
        //mendeklarasikan listview dan membuat data listnya
            "C",
            "C++",
            "C#",
            "Php",
            "Java",
            "Javascript",
            "Phyton",
            "Assembly",
            "R",
            "Visual Basic",
            "SQL",
            "ASP.NET",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        getSupportActionBar().setTitle("Bahasa Pemrograman");

        lvItem = (ListView) findViewById(R.id.list_view);

        //membinding data menggunakan array adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(listViewActivity.this,android.R.layout.simple_list_item_1,android.R.id.text1,arrProgram);

        //menset data ke listview
        lvItem.setAdapter(adapter);

        lvItem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(listViewActivity.this, "Anda memilih " + arrProgram[position], Toast.LENGTH_SHORT).show();

                //memanggil set on Item ClickListener untuk Listview, jadi jika salah satu item list view diklik akan
                //akan bereaksi menampilkan toast atau aksi lainya.
                //Step 4
            }
        });

    }
}
