package com.example.categories_2ndattempt;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class SearchResultsFragment extends Fragment {

    View view;
    RecyclerView.Adapter adapter;
    LinearLayoutManager linearLayoutManager;
    RecyclerView l1;
    private ArrayList<SearchResultsCats> data;



    public SearchResultsFragment() {
        // Required empty public constructor
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        data=new ArrayList<SearchResultsCats>();
        data.add(new SearchResultsCats("Malayalam Foods","Tasty homemade Malayalam","Yo mama so fat","Not available", R.drawable.foodplaceholder));
        data.add(new SearchResultsCats("Malayalam Foods","Tasty homemade Malayalam","Yo mama so fat","Not available", R.drawable.foodplaceholder));
        data.add(new SearchResultsCats("Malayalam Foods","Tasty homemade Malayalam","Yo mama so fat","Not available", R.drawable.foodplaceholder));
        data.add(new SearchResultsCats("Malayalam Foods","Tasty homemade Malayalam","Yo mama so fat","Not available", R.drawable.foodplaceholder));
        data.add(new SearchResultsCats("Malayalam Foods","Tasty homemade Malayalam","Yo mama so fat","Not available", R.drawable.foodplaceholder));
        data.add(new SearchResultsCats("Malayalam Foods","Tasty homemade Malayalam","Yo mama so fat","Not available", R.drawable.foodplaceholder));
        data.add(new SearchResultsCats("Malayalam Foods","Tasty homemade Malayalam","Yo mama so fat","Not available", R.drawable.foodplaceholder));

        l1=view.findViewById(R.id.l1);
        l1.setHasFixedSize(true);
        adapter=new SearchResultsAdapter(this.getActivity(),data);
        linearLayoutManager=new LinearLayoutManager(this.getActivity(),RecyclerView.VERTICAL,false);
        l1.setAdapter(adapter);
        l1.setLayoutManager(linearLayoutManager);

        Toolbar toolbar= view.findViewById(R.id.toolbarsearch);
        toolbar.inflateMenu(R.menu.homemenu);
        toolbar.setNavigationIcon(R.drawable.ic_baseline_search_24);


        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),"Search",Toast.LENGTH_SHORT).show();
                Log.d("Home","Back");
            }
        });

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.cart:
                        Toast.makeText(getActivity(), "CART BITCH", Toast.LENGTH_SHORT).show();
                        Log.d("Home","cart");
                        break;

                }
                return false;
            }
        });




    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.fragment_search_results, container, false);
        setHasOptionsMenu(true);
        return view;


    }

}