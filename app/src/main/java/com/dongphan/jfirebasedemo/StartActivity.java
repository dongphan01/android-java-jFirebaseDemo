package com.dongphan.jfirebasedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartActivity extends AppCompatActivity {

    private Button btnRegister;
    private Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        btnRegister = findViewById(R.id.btnRegister);
        btnLogin = findViewById(R.id.btnLogin);

        btnRegister.setOnClickListener((View v)->{
                startActivity(new Intent(this, RegisterActivity.class));
                finish();
            }
        );

        btnLogin.setOnClickListener((View view)-> {
                startActivity(new Intent(this, LoginActivity.class));
                finish();
            }
        );
    }
}