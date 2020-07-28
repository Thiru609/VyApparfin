package com.example.categories_2ndattempt;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;

public class SearchResultsAdapter extends RecyclerView.Adapter<SearchResultsAdapter.newViewHolder> implements Filterable {

    private ArrayList<SearchResultsCats> cats=new ArrayList<>();
    private ArrayList<SearchResultsCats> FULL_LIST=new ArrayList<>();

    public SearchResultsAdapter(Context context, ArrayList<SearchResultsCats> list){
        cats = list;
        FULL_LIST=list;
    }

    @Override
    public Filter getFilter() {
        return filter;
    }

    Filter filter=new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            ArrayList<SearchResultsCats> filteredlist= new ArrayList<SearchResultsCats>();
            if(charSequence.toString().isEmpty())
            {filteredlist.addAll(FULL_LIST);}
            else
            {
                for(SearchResultsCats temp: FULL_LIST)
                {
                    if(temp.getTitle().toLowerCase().contains(charSequence.toString().toLowerCase()))
                    {
                        filteredlist.add(temp);
                    }
                }
            }
            FilterResults filterResults=new FilterResults();
            filterResults.values=filteredlist;
            Log.d("Search Logic","Processing");

            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            cats= (ArrayList<SearchResultsCats>) filterResults.values;
            notifyDataSetChanged();
            Log.d("The Publish","Of results ");

        }
    };

    public class newViewHolder extends RecyclerView.ViewHolder {

        public ImageView iwdisp;
        public TextView title,desc,misc,rating;

        public newViewHolder(@NonNull View itemView) {
            super(itemView);

            iwdisp=itemView.findViewById(R.id.iw1);
            title=itemView.findViewById(R.id.twTitle);
            desc=itemView.findViewById(R.id.twDesc);
            misc=itemView.findViewById(R.id.tvMisc);
            rating=itemView.findViewById(R.id.tvrating);

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


