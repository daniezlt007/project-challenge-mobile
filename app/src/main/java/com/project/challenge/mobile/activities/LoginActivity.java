package com.project.challenge.mobile.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.project.challenge.mobile.R;

public class LoginActivity extends AppCompatActivity {

    private EditText txtInputEmail;
    private EditText txtInputPassword;
    private ImageView imageView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        imageView = findViewById(R.id.imageView);
        txtInputEmail = findViewById(R.id.txt_email);
        txtInputPassword = findViewById(R.id.txt_password);
        button = findViewById(R.id.button);

        button.setOnClickListener(view -> {
            Toast.makeText(LoginActivity.this, "Teste", Toast.LENGTH_LONG).show();
        });

    }
}