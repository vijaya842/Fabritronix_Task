package com.example.task;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface API {
    String BASE_URL = "https://devtest.fueblabs.com/rest/";

    @GET("items")
    Call<List<TaskDTO>> getObjects();
}
