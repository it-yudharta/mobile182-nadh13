package com.anas.aplikasinovel.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.anas.aplikasinovel.MainActivity;
import com.anas.aplikasinovel.R;
import com.anas.aplikasinovel.listActivity.NovelList.TrashFragment;
import com.anas.aplikasinovel.listActivity.TneFragment;
import com.anas.aplikasinovel.recycleview.OurData;

public class ListAdapter extends RecyclerView.Adapter {

    private Context context;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_list_item, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((ListViewHolder) holder).bindView(position);
    }

    @Override
    public int getItemCount() {
        return OurData.title.length;
    }

    private class ListViewHolder extends RecyclerView.ViewHolder implements  View.OnClickListener {

        private TextView mItemText;
        private ImageView mItemImage;

        public ListViewHolder(View itemView){

            super(itemView);
            mItemText = (TextView) itemView.findViewById(R.id.itemText);
            mItemImage = (ImageView) itemView.findViewById(R.id.itemImage);
            itemView.setOnClickListener(this);

            context = itemView.getContext();

        }

        public void bindView (int position){
            mItemText.setText(OurData.title[position]);
            mItemImage.setImageResource(OurData.picturePath[position]);
        }

        public void onClick(View view){

            Toast.makeText(itemView.getContext(), "Click", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(view.getContext(), MainActivity.class);
            switch (getAdapterPosition()){

                case 0:
                intent = new Intent(context, TneFragment.class);
                break;

                case 1:
                    intent = new Intent(context, TrashFragment.class);

            }

            context.startActivity(intent);

//            Intent intent = new Intent(itemView.getContext(), TneFragment.class);
//            Bundle bundle = new Bundle();



            }

        }

    }


