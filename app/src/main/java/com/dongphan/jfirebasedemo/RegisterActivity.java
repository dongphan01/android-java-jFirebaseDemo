package com.dongphan.jfirebasedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {
    private EditText editEmail;
    private EditText editPassword;
    private Button btnSubmitRegister;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        editEmail = findViewById(R.id.editEmail);
        editPassword = findViewById(R.id.editPassWord);
        btnSubmitRegister = findViewById(R.id.btnSubmitRegister);

        firebaseAuth = FirebaseAuth.getInstance();

        btnSubmitRegister.setOnClickListener((View view)-> {
            String txtEmail = editEmail.getText().toString();
            String txtPassword = editPassword.getText().toString();

            if(TextUtils.isEmpty(txtEmail) || TextUtils.isEmpty(txtPassword)) {
                Toast.makeText(this, "Empty Credentials", Toast.LENGTH_SHORT).show();
            }
            else if(txtPassword.length() < 6) {
                Toast.makeText(this, "Password is too short!", Toast.LENGTH_SHORT).show();
            }
            else {
                registerUser(txtEmail, txtPassword);
            }
        });
    }

    private void registerUser(String _txtEmail, String _txtPassword) {
        firebaseAuth.createUserWithEmailAndPassword(_txtEmail, _txtPassword).addOnCompleteListener(this,
            (Task<AuthResult> task)-> {
                if(task.isSuccessful()) {
                    Toast.makeText(this, "Registering user successful!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(this, MainActivity.class));
                    finish();
                }
                else {
                    Toast.makeText(this, "Registration fail!", Toast.LENGTH_SHORT).show();
                }
            });
    }
}