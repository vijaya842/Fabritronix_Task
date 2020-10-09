package com.example.task;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import java.io.IOException;
import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String Credentials = "Basic " + Base64.encodeToString(("vijaytest@gmail.com:Vijay@123").getBytes(),Base64.NO_WRAP);
    private static final String BASE_URL = "https://devtest.fueblabs.com/rest/";
    private Retrofit retrofit;
    RecyclerView lv;
    RecyclerAdapter recyclerAdapter;
    List<TaskDTO> Objects;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (RecyclerView) findViewById(R.id.recycler_main);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        lv.setLayoutManager(layoutManager);


        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(
                        new Interceptor() {
                            @Override
                            public Response intercept(Chain chain) throws IOException {
                                Request request =  chain.request();

                                Request.Builder reqbuilder = request.newBuilder()
                                        .addHeader("Authorization",Credentials)
                                        .method(request.method(),request.body());

                                Request req = reqbuilder.build();
                                return  chain.proceed(req);
                            }
                        }


                ).build();

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();

        API api= retrofit.create(API.class);

        Call<List<TaskDTO>> call = api.getObjects();

        call.enqueue(new Callback<List<TaskDTO>>() {
            @Override
            public void onResponse(Call<List<TaskDTO>> call, retrofit2.Response<List<TaskDTO>> response) {
                Objects = response.body();
                recyclerAdapter = new RecyclerAdapter(getApplicationContext(),Objects);
                lv.setAdapter(recyclerAdapter);
                recyclerAdapter.setItems(Objects);
            }
            @Override
            public void onFailure(Call<List<TaskDTO>> call, Throwable t) {
                Log.e("\task","Failed");
                Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}