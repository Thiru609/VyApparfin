package com.example.categories_2ndattempt;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
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
    SearchResultsAdapter adapter;
    LinearLayoutManager linearLayoutManager;
    RecyclerView l1;
    private ArrayList<SearchResultsCats> data;
    SearchView sw;




    public SearchResultsFragment() {
        // Required empty public constructor
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        data=new ArrayList<SearchResultsCats>();


        data.add(new SearchResultsCats("Malayalam Foods","Tasty homemade Malayalam","Alandur","4/5", R.drawable.pizza));
        data.add(new SearchResultsCats("Thiru Foods","Tasty homemade Malayalam","Alandur","4/5", R.drawable.pizza));
        data.add(new SearchResultsCats("Amuthan Foods","Tasty homemade Malayalam","Alandur","4/5", R.drawable.pizza));
        data.add(new SearchResultsCats("Kanni Babu Foods","Tasty homemade Malayalam","Alandur","4/5", R.drawable.pizza));
        data.add(new SearchResultsCats("Bob dylan Foods","Tasty homemade Malayalam","Alandur","4/5", R.drawable.pizza));
        data.add(new SearchResultsCats("Malayalam Foods","Tasty homemade Malayalam","Alandur","4/5", R.drawable.pizza));
        data.add(new SearchResultsCats("Chinese Foods","Tasty homemade Malayalam","Alandur","4/5", R.drawable.pizza));
        data.add(new SearchResultsCats("Yo mamas Foods","Tasty homemade Malayalam","Alandur","4/5", R.drawable.pizza));



        l1=view.findViewById(R.id.l1);
        l1.setHasFixedSize(true);
        adapter=new SearchResultsAdapter(this.getActivity(),data);
        linearLayoutManager=new LinearLayoutManager(this.getActivity(),RecyclerView.VERTICAL,false);
        l1.setAdapter(adapter);
        l1.setLayoutManager(linearLayoutManager);

        sw=(SearchView) view.findViewById(R.id.sw);
        sw.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Toast.makeText(getContext(),"BIG SUCC",Toast.LENGTH_SHORT).show();
                adapter.getFilter().filter(newText);
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
    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.homemenu,menu);
        MenuItem item = menu.findItem(R.id.succbar);

    }


}