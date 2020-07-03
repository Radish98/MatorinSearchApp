package com.example.matorinsearchapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.matorinsearchapp.dataBase.App;
import com.example.matorinsearchapp.dataBase.SaveDB;
import com.example.matorinsearchapp.dataBase.SaveDBDao;
import com.example.matorinsearchapp.models.SearchItem;
import com.example.matorinsearchapp.models.SearchModel;
import com.example.matorinsearchapp.services.GoogleApi;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Home extends Fragment implements View.OnClickListener {

    Button searchBTN;
    EditText searchET;



    private MyAdapter myAdapter;
    private RecyclerView myRecycler;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        searchBTN = view.findViewById(R.id.searchBTN);
        searchET = view.findViewById(R.id.searchET);
        myRecycler= view.findViewById(R.id.listV);
        searchBTN.setOnClickListener(this);
        return view;
    }


    @Override
    public void onClick(View v) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(GoogleApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        GoogleApi googleApi = retrofit.create(GoogleApi.class);
        final Call<SearchModel> gotResults = googleApi.getList(GoogleApi.API_KEY,GoogleApi.CX,searchET.getText().toString());

        gotResults.enqueue(new Callback<SearchModel>() {
            @Override
            public void onResponse(Call<SearchModel> call, final Response<SearchModel> response) {
                if(response.body().getItems() != null) {
                    Log.d("TAG", "msgAAAA" + response.body().getItems().get(0).getTitle());
                    List<SearchItem> sList = new ArrayList<>();
                    for (int i = 0; i < 10; i++) {
                        SearchItem sI = new SearchItem();
                        sI.setQueue(i);
                        sI.setTitle(response.body().getItems().get(i).getTitle());
                        sI.setSnippet(response.body().getItems().get(i).getSnippet());
                        sI.setLink(response.body().getItems().get(i).getLink());
                        sList.add(sI);
                    }

                    myAdapter = new MyAdapter(getActivity(), sList);

                    myRecycler.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
                    myRecycler.setAdapter(myAdapter);
                }else {
                    Toast.makeText(getContext(),"No Results", Toast.LENGTH_SHORT).show();
                }

//                final SaveDBDao mySaveDBDao = App.getInstance().getWatchListDB().saveDBDao();
//
//                AppExecutors.getInstance().diskIO().execute(new Runnable() {
//                    @Override
//                    public void run() {
//                        for(int i = 0; i < 10; i++){
//                            SaveDB sDB = new SaveDB();
//                            sDB.queue = i;
//                            sDB.link = response.body().getItems().get(i).getLink();
//                            sDB.title= response.body().getItems().get(i).getTitle();
//                            sDB.snippet = response.body().getItems().get(i).getSnippet();
//                            mySaveDBDao.insert(sDB);
//                        }
//                    }
//                });
            }
            @Override
            public void onFailure(Call<SearchModel> call, Throwable t) {

            }
        });

    }
}