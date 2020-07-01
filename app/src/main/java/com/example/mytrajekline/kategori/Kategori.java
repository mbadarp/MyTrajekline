package com.example.mytrajekline.kategori;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.mytrajekline.R;

public class Kategori  extends AppCompatActivity {
    LinearLayout pantai, gunung, taman, pendidikan, semua;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kategori);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.back);
        Intent data = getIntent();
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        pantai = findViewById(R.id.pantai);
        pantai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Temp_Wisata.getInstance(getBaseContext()).SetKategori("pantai");
                startActivity(new Intent(getBaseContext(), Wisata.class));
            }
        });
        gunung = findViewById(R.id.gunung);
        gunung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Temp_Wisata.getInstance(getBaseContext()).SetKategori("gunung");
                startActivity(new Intent(getBaseContext(), Wisata.class));
            }
        });
        taman = findViewById(R.id.taman);
        taman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Temp_Wisata.getInstance(getBaseContext()).SetKategori("tamanbermain");
                startActivity(new Intent(getBaseContext(), Wisata.class));
            }
        });
        pendidikan = findViewById(R.id.pendidikan);
        pendidikan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Temp_Wisata.getInstance(getBaseContext()).SetKategori("wisatapendidikan");
                startActivity(new Intent(getBaseContext(), Wisata.class));
            }
        });
        semua = findViewById(R.id.semua);
        semua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Temp_Wisata.getInstance(getBaseContext()).SetKategori("semua");
                startActivity(new Intent(getBaseContext(), Wisata.class));
            }
        });
    }
}

