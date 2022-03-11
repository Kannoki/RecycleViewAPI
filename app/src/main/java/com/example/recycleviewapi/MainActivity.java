package com.example.recycleviewapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    public ArrayList<Article> articleArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        articleArrayList = new ArrayList<>();
        RecyclerView recyclerView = findViewById(R.id.recycleView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        /**/
        RecycleAdaptor recycleAdaptor = new RecycleAdaptor(this, articleArrayList);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(recycleAdaptor);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.6/testapi/public/api/newsapi/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        apiInterface.getNews().enqueue(new Callback<List<Article>>() {
            @Override
            public void onResponse(Call<List<Article>> call, Response<List<Article>> response) {
                if (response.body() != null) {
                    articleArrayList.addAll(response.body());
                    Log.d("tag", "a " + articleArrayList.get(1).toString());
                    recycleAdaptor.setItemData(articleArrayList);
                }
                recycleAdaptor.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Article>> call, Throwable t) {
                System.out.println("DM cuộc đời, dcm cuộc đời, djt mẹ thằng bomman");
                Log.d("TAG","Response = "+t.toString());
            }
        });



    }
}