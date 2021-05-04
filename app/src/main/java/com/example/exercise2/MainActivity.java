package com.example.exercise2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.example.exercise2.adapter.TemanAdapter;
import com.example.exercise2.database.DBController;
import com.example.exercise2.database.Teman;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rv;
    private TemanAdapter adapter;
    private ArrayList<Teman> temanArrayList;
    private FloatingActionButton fab;
    DBController dbc = new DBController(this);
    String id,nm,tlp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv = findViewById(R.id.recyclerView);
        fab = findViewById(R.id.floatingBtn);
        readData();
        adapter = new TemanAdapter(temanArrayList);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(MainActivity.this);
        rv.setLayoutManager(lm);
        rv.setAdapter(adapter);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,TemanBaru.class);
                startActivity(i);
            }
        });
    }

//    ----Membaca data----
    public void readData(){
        ArrayList<HashMap<String,String>> listTeman = dbc.getAllTeman();
        temanArrayList = new ArrayList<>();


        for (int i = 0; i < listTeman.size(); i++){
            Teman t = new Teman();
            t.setId(listTeman.get(i).get("id").toString());
            t.setNama(listTeman.get(i).get("nama").toString());
            t.setTelp(listTeman.get(i).get("telp").toString());


            temanArrayList.add(t);
        }
    }
}