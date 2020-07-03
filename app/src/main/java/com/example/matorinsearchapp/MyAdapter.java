package com.example.matorinsearchapp;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.matorinsearchapp.models.SearchItem;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Home home;
    private List<SearchItem> mData;

    private LayoutInflater layoutInflater;
    Context mContext;
    private int mPage;
    private String mType;



    public void notifyUpdate(List<SearchItem> newList,int page, String type){
        this.mPage = page;
        this.mData =newList;
        Log.d("api", "is List empty " + mData.isEmpty());
        this.notifyDataSetChanged();
        this.mType = type;
    }



    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView titleTV;
        TextView linkTV;
        TextView snippetTV;



        public MyViewHolder(View itemView) {
            super(itemView);
            titleTV = itemView.findViewById(R.id.titleTV);
            linkTV = itemView.findViewById(R.id.linkTV);
            snippetTV =itemView.findViewById(R.id.snippetTV);
        }

        void bind (final int i){

            String strTitle = mData.get(i).getTitle();
            String strLink = mData.get(i).getLink();
            String strSnippet = mData.get(i).getSnippet();
            Log.d("adapter", "omdb");

            titleTV.setText(strTitle);
            linkTV.setText(strLink);
            snippetTV.setText(strSnippet);
        }


    }

    public MyAdapter(Context context, List<SearchItem> thmdbString){
        this.mData = thmdbString;
        this.mContext = context;
    }

    public void setData(List<SearchItem> mData) {
        this.mData = mData;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View v = layoutInflater.inflate(R.layout.list_item, viewGroup, false);
        return new MyViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.bind(i);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
