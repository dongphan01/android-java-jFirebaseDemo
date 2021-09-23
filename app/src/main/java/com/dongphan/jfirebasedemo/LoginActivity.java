package com.dongphan.jfirebasedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private EditText edtEmail;
    private EditText edtPassword;
    private Button btnLogin;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtEmail = findViewById(R.id.editEmailLogin);
        edtPassword = findViewById(R.id.editPassWordLogin);
        btnLogin = findViewById(R.id.btnLogin);

        firebaseAuth = FirebaseAuth.getInstance();

        btnLogin.setOnClickListener((View view) -> {
            String email = edtEmail.getText().toString();
            String password = edtPassword.getText().toString();
            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Empty credentials !", Toast.LENGTH_SHORT).show();
            } else {
                loginUser(email, password);
            }
        });
    }

    private void loginUser(String email, String password) {
        firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener((Task<AuthResult> authResult) -> {
            if (authResult.isSuccessful()) {
                Toast.makeText(this, "Login successful !", Toast.LENGTH_LONG).show();
                startActivity(new Intent(this, MainActivity.class));
                finish();
            } else {
                Toast.makeText(this, "Login fail !", Toast.LENGTH_SHORT).show();
            }
        });
    }
}