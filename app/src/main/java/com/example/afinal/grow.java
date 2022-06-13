package com.example.afinal;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class grow extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_grow);
    }

    public void back(View view) {
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }

    public void ebtkr(View view) {
        Intent intent = new Intent(this, ebtkr.class);
        startActivity(intent);
    }

    public void e3(View view) {
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }

    public void e4(View view) {
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }

    public void e2(View view) {
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }

    public void e1(View view) {
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }
}