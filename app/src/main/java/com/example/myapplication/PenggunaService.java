package com.example.myapplication;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface PenggunaService {
    @GET("getallpenggunaBypassword")
    Call<List<Pengguna>> signin(@Path("username") String username, @Path("password") String password);
}
