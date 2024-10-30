package com.example.myapplication;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface PenggunaService {
    @GET("getallpenggunaBypassword")
    Call<Pengguna> signin(@Query("username") String username, @Path("password") String password);
}
