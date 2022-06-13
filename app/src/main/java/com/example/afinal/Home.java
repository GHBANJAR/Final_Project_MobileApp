package com.example.afinal;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_home);
    }


    public void uni(View view) {
        Intent intent = new Intent(this, university.class);
        startActivity(intent);
    }

    public void exam(View view) {
        Intent intent = new Intent(this, exam.class);
        startActivity(intent);
    }

    public void grow(View view) {
        Intent intent = new Intent(this, grow.class);
        startActivity(intent);
    }

    public void v2030(View view) {
        Intent intent = new Intent(this, v2030.class);
        startActivity(intent);
    }
}