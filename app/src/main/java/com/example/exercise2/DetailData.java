package com.example.exercise2;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DetailData extends AppCompatActivity {
    static TextView tvnama,tvtelp;
    String nm,id,tlp;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        tvnama = findViewById(R.id.tvNamaKontak);
        tvtelp = findViewById(R.id.tvNoTel);


        id = getIntent().getStringExtra("id");
        nm = getIntent().getStringExtra("nama");
        tlp = getIntent().getStringExtra("telp");


        setTitle("Detail Data");
        tvnama.setText(nm);
        tvtelp.setText(tlp);
    }
}
