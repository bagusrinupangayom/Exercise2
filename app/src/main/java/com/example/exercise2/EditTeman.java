package com.example.exercise2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.example.exercise2.database.DBController;

import java.util.HashMap;

public class EditTeman extends AppCompatActivity {
    private TextInputEditText tNama,tTelp;
    private Button saveBtn;
    String nm,tlp,id;
    DBController controller = new DBController(this);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        tNama = findViewById(R.id.edNama);
        tTelp = findViewById(R.id.edTelp);
        saveBtn = findViewById(R.id.saveBtn);

        id = getIntent().getStringExtra("id");
        nm = getIntent().getStringExtra("nama");
        tlp = getIntent().getStringExtra("telp");


        setTitle("Edit Data");
        tNama.setText(nm);
        tTelp.setText(tlp);


        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tNama.getText().toString().equals("") || tTelp.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"Data belum lengkap!",Toast.LENGTH_LONG).show();
                }else{
                    nm = tNama.getText().toString();
                    tlp = tTelp.getText().toString();
                    HashMap<String,String> val = new HashMap<>();
                    val.put("id",id);
                    val.put("nama",nm);
                    val.put("telp",tlp);
                    controller.updateData(val);
                    callHome();
                }
            }
        });
    }
    public void callHome(){
        Intent i = new Intent(EditTeman.this,MainActivity.class);
        startActivity(i);
        finish();
    }
}
