package com.example.categories_2ndattempt;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CategoryAdapterTop extends RecyclerView.Adapter<CategoryAdapterTop.newViewHolder>{

    private ArrayList<HomeCats> cats;
    sendonitemclicktop activity;

    public interface sendonitemclicktop{
        void sendonclicktop(int i);
    }



    public CategoryAdapterTop(Context context, ArrayList<HomeCats> list){

        cats=list;
        activity = (sendonitemclicktop) context;
    }

    public class newViewHolder extends RecyclerView.ViewHolder {
        public ImageView iwdisp;
        public TextView title;

        public newViewHolder(@NonNull View itemView) {
            super(itemView);

            iwdisp = itemView.findViewById(R.id.iw1);
            title = itemView.findViewById(R.id.twTitle);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    activity.sendonclicktop( cats.indexOf(view.getTag()));
                }
            });

        };

    }




    @NonNull
    @Override
    public CategoryAdapterTop.newViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_top,parent,false);
        return new newViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapterTop.newViewHolder holder, int position) {

        holder.itemView.setTag(cats.get(position));
        holder.iwdisp.setImageResource(cats.get(position).getIwDisp());
        holder.title.setText(cats.get(position).getCat_title());
    }

    @Override
    public int getItemCount() {
        return cats.size();
    }
}

