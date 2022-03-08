package com.project.challenge.mobile.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.project.challenge.mobile.R;
import com.project.challenge.mobile.common.Common;
import com.project.challenge.mobile.model.User;
import com.project.challenge.mobile.model.UserRequest;
import com.project.challenge.mobile.model.UserResponse;
import com.project.challenge.mobile.network.RetrofitInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "LoginActivity";
    private EditText txtEmail, txtPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtEmail = findViewById(R.id.txt_email);
        txtPassword = findViewById(R.id.txt_password);
        btnLogin = findViewById(R.id.button);

            btnLogin.setOnClickListener(view -> {
                if(TextUtils.isEmpty(txtEmail.getText().toString()) || TextUtils.isEmpty(txtPassword.getText().toString())){
                    Toast.makeText(LoginActivity.this, "Email / Senha são obrigatórios", Toast.LENGTH_LONG).show();
                } else {
                    if(Common.isConnectedInternet(this)){
                        String email = txtEmail.getText().toString();
                        String password = txtPassword.getText().toString();
                        postLogin(email, password);
                    } else {
                        Toast.makeText(LoginActivity.this, "Por favor verifique a conexão!", Toast.LENGTH_LONG).show();
                    }
                }
            });

    }

    public void postLogin(String email, String password){
        UserRequest userRequest = new UserRequest(email, password);
        Call<UserResponse> login = RetrofitInstance.getUserService().getAuthTokenLogin(userRequest.getEmail(), userRequest.getPassword());
        login.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                if(response.isSuccessful()){
                    Toast.makeText(LoginActivity.this, "Login efetuado com sucesso!", Toast.LENGTH_LONG).show();
                    UserResponse userResponse = response.body();
                    new Handler().postDelayed((Runnable) () -> {
                        startActivity(new Intent(LoginActivity.this, MainActivity.class).putExtra("data", userResponse));
                        finish();
                    }, 700);
                } else {
                    Toast.makeText(LoginActivity.this, "Erro ao efetuar login", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "Erro ao efetuar login: " + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}