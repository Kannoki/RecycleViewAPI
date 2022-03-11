package com.example.recycleviewapi;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class RecycleAdaptor extends RecyclerView.Adapter<RecycleAdaptor.ArticleAdaptor>{
    Context context;
    List<Article> articleArrayList;

    public RecycleAdaptor(Context context, ArrayList<Article> articleArrayList) {
        this.context = context;
        this.articleArrayList = articleArrayList;
    }


    @SuppressLint("NotifyDataSetChanged")
    public void setItemData(ArrayList<Article> articleArrayList){
        this.articleArrayList = articleArrayList;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public ArticleAdaptor onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.article_layout,parent,false);
        return new ArticleAdaptor(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleAdaptor holder, int position) {
        Article article = articleArrayList.get(position);
        if(article==null){
            return;
        }
        holder.tvArticle.setText(articleArrayList.get(position).getTitle().toString());
        holder.tvDescription.setText(articleArrayList.get(position).getDescription());
        holder.tvDate.setText(articleArrayList.get(position).getPub_day());
        Picasso.get().load(articleArrayList.get(position).getThumbnail()).into(holder.thumbnail);

    }

    @Override
    public int getItemCount() {
        if (articleArrayList !=
                null){
            return articleArrayList.size();
        }
        return 0;
    }

    public static class ArticleAdaptor extends RecyclerView.ViewHolder{

        private ImageView thumbnail;
        private  TextView tvArticle;
        private  TextView tvDescription;
        private  TextView tvDate;
        public ArticleAdaptor(@NonNull View itemView) {
            super(itemView);
            thumbnail = itemView.findViewById(R.id.thumbnail);
            tvArticle = itemView.findViewById(R.id.tvArticle);
            tvDescription = itemView.findViewById(R.id.tvDescrpition);
            tvDate = itemView.findViewById(R.id.tvDate);

        }
    }
}
