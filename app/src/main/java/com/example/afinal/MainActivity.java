package com.example.afinal;

import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    EditText username,password;
     Button signin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

     username = findViewById(R.id.editTextTextPersonName2);
     password = findViewById(R.id.editTextTextPersonName);
     signin = findViewById(R.id.button);

        mAuth = FirebaseAuth.getInstance();


                signin.setOnClickListener( new View.OnClickListener(){
                    @Override
                    public void onClick  (View view){
                        String usernameTxt = username.getText().toString().trim();
                        String passwordTxt =password.getText().toString().trim();

                        if (usernameTxt.isEmpty() || passwordTxt.isEmpty()){
                            Toast.makeText(MainActivity.this, "Please Enter your username or password", Toast.LENGTH_SHORT).show();
                        }else{
                        // Authantication process from database
                          mAuth.signInWithEmailAndPassword(usernameTxt,passwordTxt).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                                                                                              @Override
                                                                                                              public void onComplete(@NonNull Task<AuthResult> task) {
                                                                                                                  if (task.isSuccessful()) {
                                                                                                                      Toast.makeText(MainActivity.this, "Logged in Successfully.", Toast.LENGTH_SHORT).show();
                                                                                                                      startActivity(new Intent(getApplicationContext(), Home.class));
                                                                                                                  } else {
                                                                                                                      Toast.makeText(MainActivity.this, "Falied!!!" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                                                                                                  }
                                                                                                              }
                                                                                                          });
                        }
                    }
                });


    }


    public void go(View view) {
        Intent intent = new Intent(this, login.class);
        startActivity(intent);
    }
}