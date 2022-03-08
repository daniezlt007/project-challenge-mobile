package com.project.challenge.mobile.activities;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.project.challenge.mobile.R;
import com.project.challenge.mobile.adapter.UserAdapter;
import com.project.challenge.mobile.common.Common;
import com.project.challenge.mobile.model.Order;
import com.project.challenge.mobile.model.StatusUse;
import com.project.challenge.mobile.model.User;
import com.project.challenge.mobile.model.UserResponse;
import com.project.challenge.mobile.network.RetrofitInstance;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private TextView txtNomeUser, txtCidadeUser,txtcarModel;
    private CircleImageView imageViewUser;
    private UserResponse userResponse;
    private ProgressBar progressBar;
    private RecyclerView recyclerView;
    private UserAdapter userAdapter;
    private Button forward;
    private Button backward;

    //Armazena os dados do user.
    private User user;
    //Armazena os indice da lista de status para navegação.
    private int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        initComponentes();

        progressBar.setVisibility(View.VISIBLE);

        Intent intent = getIntent();
        if(intent.getExtras() != null){

            userResponse = new UserResponse();
            Common.userCurrentResponse = (UserResponse) getIntent().getSerializableExtra("data");
            userResponse = Common.userCurrentResponse;
            txtNomeUser.setText(userResponse.getUserName());
            txtCidadeUser.setText(userResponse.getCity());
            Glide.with(this)
                    .load(userResponse.getAvatarUrl())
                    .centerCrop()
                    .into(imageViewUser);



        } else{
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
            finish();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
            i = 0;
            new Handler().postDelayed((Runnable) () -> {
                getOrders(userResponse.getToken());
            }, 1200);
        }


    private void updateListandAdapter(){
        List<StatusUse> status = user.getOrders().get(i).getStatuses();
        txtcarModel.setText(user.getOrders().get(i).getSubmodelName());
        //2
        userAdapter = new UserAdapter(status);

        //3
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        recyclerView.setAdapter(userAdapter);
    }

    private void getOrders(String token){
        Call<User> call = RetrofitInstance.getUserService().getProfile(token);
        call.enqueue(new Callback<User>() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(response.isSuccessful()){
                    progressBar.setVisibility(View.GONE);
                    user = response.body();
                    updateListandAdapter();

                }else{

                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
    }

    public void initComponentes(){
        progressBar = findViewById(R.id.progressBar);
        imageViewUser = findViewById(R.id.image_view_user);
        txtNomeUser = findViewById(R.id.txt_nome_user);
        txtCidadeUser = findViewById(R.id.txt_cidade_user);
        txtcarModel   = findViewById(R.id.carModel);
        forward  = findViewById(R.id.forward);
        backward = findViewById(R.id.backward);

        //1
        recyclerView = findViewById(R.id.recyclerView);


    }

    public void setupOnclickForward(View view) {
        //verificar se o próximo índice é maior que o tamanho da lista.
        if(i == user.getOrders().size() -1){
            i = 0;
        }else{
            i++;
        }

        updateListandAdapter();

    }
    public void setupOnclickBackward(View view) {
        //verificar se o ind
        if(i-1 < 0){
            i = 0;
        }else{
            i--;
        }

        updateListandAdapter();

    }

}