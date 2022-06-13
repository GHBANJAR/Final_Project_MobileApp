package com.example.afinal;

import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import java.util.Date;

public class login extends AppCompatActivity {
    private FirebaseAuth mAuth;
    EditText email,password,confirmpass,phone;
    EditText firstname, lname ;
    Button signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_login);

        //get values to varibles
        email = findViewById(R.id.editTextTextPersonName);
        password = findViewById(R.id.editTextTextPersonName1);
        confirmpass = findViewById(R.id.editTextTextPersonName2);
        phone = findViewById(R.id.editTextTextPersonName4);
        firstname = findViewById(R.id.editTextTextPersonName5);
        lname = findViewById(R.id.editTextTextPersonName6);
        signup = findViewById(R.id.button4);

        mAuth = FirebaseAuth.getInstance();

        if (mAuth.getCurrentUser() != null) {
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailTxt = email.getText().toString().trim();
                String passwotrdTxt = password.getText().toString().trim();

                if (emailTxt.isEmpty() || passwotrdTxt.isEmpty()) {
                    Toast.makeText(login.this, "Please Enter your  information", Toast.LENGTH_SHORT).show();
                }
                if (emailTxt.isEmpty()) {
                    email.setError("Email is required!");
                    email.requestFocus();
                    return;
                }
                if (!Patterns.EMAIL_ADDRESS.matcher(emailTxt).matches()) {
                    email.setError("Please provide valid email!");
                    email.requestFocus();
                    return;
                }
                if (passwotrdTxt.isEmpty()) {
                    password.setError("Password is required!");
                    password.requestFocus();
                    return;
                }
                mAuth.createUserWithEmailAndPassword(emailTxt, passwotrdTxt).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(login.this, "User Created.", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        } else {
                            Toast.makeText(login.this, "Falied!!!" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });

}
        });

    }
        public void back (View view){
            Intent intent = new Intent(this, Home.class);
            startActivity(intent);
        }
}
