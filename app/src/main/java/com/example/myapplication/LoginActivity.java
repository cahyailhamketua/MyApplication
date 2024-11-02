package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText et_username = findViewById(R.id.et_username);
        EditText et_password = findViewById(R.id.et_password);
        Button btn_login = findViewById(R.id.btn_login);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (et_username.getText().equals("") || et_password.getText().equals("")) {
                    if (et_username.getText().equals("")) {
                        et_username.setError("Username harus diisi");
                    }

                    if (et_password.getText().equals("")) {
                        et_password.setError("password harus diisi");
                    }
                }
//                else if(et_username.getText().toString().equals("Admin") && et_password.getText().toString().equals("123")) {
//                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
//
//                    intent.putExtra("username", et_username.getText().toString());
//
//                    startActivity(intent);
//
//                    finish();
//                }
                else {
                    Retrofit retrofit = new Retrofit.Builder()
                            .baseUrl("https://ap-southeast-1.aws.data.mongodb-api.com/app/application-0-ayiufkj/endpoint/")
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();

                    PenggunaService service = retrofit.create(PenggunaService.class);

                    Call<Pengguna> call = service.signin(et_username.getText().toString(), et_password.getText().toString());

                    call.enqueue(new Callback<Pengguna>() {
                        @Override
                        public void onResponse(Call<Pengguna> call, Response<Pengguna> response) {
                            Pengguna data = response.body();

                            if(data == null){
                                Toast.makeText(getApplicationContext(),"Pengguna tidak terdaftar", Toast.LENGTH_SHORT).show();
                            } else {
                                Intent intent = new Intent(LoginActivity.this, MainActivity.class);

                            }

                        }

                        @Override
                        public void onFailure(Call<Pengguna> call, Throwable throwable) {

                        }
                    });

//                    call.enqueue(new Callback<List<Pengguna>>() {
//                        @Override
//                        public void onResponse(Call<List<Pengguna>> call, Response<List<Pengguna>> response) {
//                            Pengguna data = response.body();
//                        }
//
//                        @Override
//                        public void onFailure(Call<List<Pengguna>> call, Throwable throwable) {
//
//                        }
//                    });
                    //Toast.makeText(getApplicationContext(), "Pengguna tidak terdaftar", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}