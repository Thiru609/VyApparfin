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
                    if(SearchAlgo(temp.getTitle().toLowerCase(),charSequence.toString()))
                    {
                        filteredlist.add(temp);
                    }
                }
            }
            filteredlist=SortAlgo(filteredlist,charSequence.toString());
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




    private ArrayList<SearchResultsCats> SortAlgo(ArrayList<SearchResultsCats> example, String seq)
    {
        seq=seq.toLowerCase().trim();

        for(int i=0;i<example.size();i++)
        {
            for(int j=i+1;j<example.size();j++)
            {
                int[] var1=new int[seq.length()];
                int[] var2=new int[seq.length()];

                for(int l=0;l<seq.length();l++)
                {
                    var1[l]=example.get(i).getTitle().indexOf(seq.substring(l,l+1));
                    var2[l]=example.get(j).getTitle().indexOf(seq.substring(l,l+1));

                }
                if(variance(var1,seq.length())>variance(var2,seq.length()))
                {
                    SearchResultsCats temp= example.get(i);
                    example.set(i,example.get(j));
                    example.set(j,temp);

                }

            }


        }
        return example;


    }

    public double variance(int a[], int n)
    {
        // Compute mean (average of elements)
        int sum = 0;
        for (int i = 0; i < n; i++)
            sum += a[i];
        double mean = (double)sum /
                (double)n;

        // Compute sum squared
        // differences with mean.
        double sqDiff = 0;
        for (int i = 0; i < n; i++)
            sqDiff += (a[i] - mean) *
                    (a[i] - mean);
        return sqDiff / n;
    }
    private boolean SearchAlgo(String example, String seq)

    {
        example = example.toLowerCase().trim();
        seq = seq.toLowerCase().trim();
        int i;
        if(seq.length()==1)
        {
            if(example.contains(seq))
                return true;
            else
                return false;
        }
        else
        {

            if (example.contains(seq.substring(0,1)))
            {
                return (SearchAlgo(example.substring(example.indexOf(seq.substring(0,1))), seq.substring(1)));
            }
            else
            {
                return (false);
            }
        }
    }

}


