package com.example.mytrajekline;

import android.os.Bundle;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;

public class ProfilActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);
        Toolbar toolbar = null;
        toolbar = (Toolbar)  toolbar.findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    private void setSupportActionBar(Toolbar Toolbar) {
    }
}

    


