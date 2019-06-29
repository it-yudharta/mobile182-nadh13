package com.anas.komikapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.anas.komikapp.ChaptersActivity;
import com.anas.komikapp.Common.Common;
import com.anas.komikapp.Interface.IRecyclerClickListener;
import com.anas.komikapp.Model.Comic;
import com.anas.komikapp.R;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.zip.Inflater;

public class MyComicAdapter extends RecyclerView.Adapter<MyComicAdapter.MyViewHolder> {

    Context context;
    List<Comic> comicList;
    LayoutInflater inflater;

    public MyComicAdapter(Context context, List<Comic> comicList) {
        this.context = context;
        this.comicList = comicList;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.comic_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Picasso.get().load(comicList.get(position).Image).into(holder.comic_image);
        holder.comic_name.setText(comicList.get(position).Name);

        //event
        holder.setRecyclerClickListener(new IRecyclerClickListener() {
            @Override
            public void onClick(View view, int position) {
                //menyimpan komik terpilih
                Common.comicSelected = comicList.get(position);
                context.startActivity(new Intent(context, ChaptersActivity.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return comicList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

         TextView comic_name;
         ImageView comic_image;

         IRecyclerClickListener recyclerClickListener;

        public void setRecyclerClickListener(IRecyclerClickListener recyclerClickListener) {
            this.recyclerClickListener = recyclerClickListener;
        }

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            comic_image = (ImageView)itemView.findViewById(R.id.image_comic);
            comic_name = (TextView)itemView.findViewById(R.id.comic_name);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            recyclerClickListener.onClick(view, getAdapterPosition());
        }
    }


//    Context context;
//    List<Comic> comicList;
//    LayoutInflater inflater;
//
//    public MyComicAdapter(Context context, List<Comic> comicList) {
//        this.context = context;
//        this.comicList = comicList;
//        inflater = LayoutInflater.from(context);
//
//    }
//
//    @NonNull
//    @Override
//    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
//        View itemView = inflater.inflate(R.layout.comic_item, viewGroup, false);
//        return new MyViewHolder(itemView);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
//        Picasso.get().load(comicList.get(i).Image).into(ViewHolder.comic_image);
//       ViewHolder.comic_name.setText(comicList.get(i).Name);
//    }
//
////    @Override
////    public void onBindViewHolder( MyViewHolder ViewHolder, int i) {
////        Picasso.get().load(comicList.get(i).Image).into(ViewHolder.comic_image);
////        ViewHolder.comic_name.setText(comicList.get(i).Name);
////    }
//
//    @Override
//    public int getItemCount() {
//        return comicList.size();
//    }
//
//    public class MyViewHolder extends RecyclerView.ViewHolder {
//
//        TextView comic_name;
//        ImageView comic_image;
//
//        public MyViewHolder(@NonNull View itemView) {
//            super(itemView);
//
//            comic_image = (ImageView)itemView.findViewById(R.id.image_comic);
//            comic_name = (TextView)itemView.findViewById(R.id.text_comic);
//        }
//    }
}
