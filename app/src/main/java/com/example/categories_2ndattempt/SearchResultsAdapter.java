package com.example.categories_2ndattempt;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SearchResultsAdapter extends RecyclerView.Adapter<SearchResultsAdapter.newViewHolder> {

    private ArrayList<SearchResultsCats> cats;

    public SearchResultsAdapter(Context context, ArrayList<SearchResultsCats> list){
        cats = list;
    }

    public class newViewHolder extends RecyclerView.ViewHolder {

        public ImageView iwdisp;
        public TextView title,desc,misc,rating;

        public newViewHolder(@NonNull View itemView) {
            super(itemView);

            iwdisp=itemView.findViewById(R.id.iw1);
            title=itemView.findViewById(R.id.twTitle);
            desc=itemView.findViewById(R.id.twDesc);
            misc=itemView.findViewById(R.id.tvMisc);
            rating=itemView.findViewById(R.id.tvRating);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //CLICK TO SEND INTENT
                }
            });

        }

    }


    @NonNull
    @Override
    public SearchResultsAdapter.newViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_searchresults,parent,false);
        return new newViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchResultsAdapter.newViewHolder holder, int position) {

        holder.itemView.setTag(cats.get(position));
        holder.iwdisp.setImageResource(cats.get(position).getIwDisp());

        holder.title.setText(cats.get(position).getTitle());
        holder.desc.setText(cats.get(position).getDesc());
        holder.misc.setText(cats.get(position).getMisc());
        holder.rating.setText(cats.get(position).getRating());



    }

    @Override
    public int getItemCount() {
        return cats.size();
    }
}


