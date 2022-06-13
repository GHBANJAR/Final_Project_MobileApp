package com.example.afinal;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ebtkr extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_ebtkr);
        //Get data to varibles
        final EditText nameofintent = findViewById(R.id.editTextTextPersonName4);
        final EditText duration = findViewById(R.id.editTextTextPersonName8);
        final EditText description = findViewById(R.id.editTextTextPersonName9);
        final Button sendintent = findViewById(R.id.button22);
        sendintent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String name = nameofintent.getText().toString();
                final String durat = duration.getText().toString();
                final String descrip =description.getText().toString();

                if(name.isEmpty()||durat.isEmpty()||descrip.isEmpty()){
                    Toast.makeText(ebtkr.this, "Please enter the required information", Toast.LENGTH_SHORT).show();
                }else{
                    //insert data
                    startActivity(new Intent(ebtkr.this, Home.class));
                }
            }
        });


    }


    public void back(View view) {
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }

}