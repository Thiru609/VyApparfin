package com.example.VyAppar;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class Fragment_Home extends Fragment {

    public RecyclerView l1,l2,l3;
    public ImageView iwPromo;
    RecyclerView.Adapter adapter1,adapter2,adapter3;
    RecyclerView.LayoutManager layoutManager1,layoutManager2,layoutManager3;
    View view;
    ArrayList<Class_Home_Category> home_data1,home_data2;
    SearchView sw;
    Toolbar toolbar;

    public Fragment_Home() {
        // Required empty public constructor
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        home_data1=new ArrayList<Class_Home_Category>();
        home_data2=new ArrayList<Class_Home_Category>();
        home_data1.add(new Class_Home_Category("Food", R.drawable.foodplaceholder));
        home_data1.add(new Class_Home_Category("Food", R.drawable.foodplaceholder));
        home_data1.add(new Class_Home_Category("Food", R.drawable.foodplaceholder));
        home_data1.add(new Class_Home_Category("Food", R.drawable.foodplaceholder));
        home_data1.add(new Class_Home_Category("Food", R.drawable.foodplaceholder));
        home_data1.add(new Class_Home_Category("Food", R.drawable.foodplaceholder));

        home_data2.add(new Class_Home_Category("Mallu Joint", R.drawable.pizza));
        home_data2.add(new Class_Home_Category("Mallu Joint", R.drawable.pizza));
        home_data2.add(new Class_Home_Category("Mallu Joint", R.drawable.pizza));
        home_data2.add(new Class_Home_Category("Mallu Joint", R.drawable.pizza));
        home_data2.add(new Class_Home_Category("Mallu Joint", R.drawable.pizza));
        home_data2.add(new Class_Home_Category("Mallu Joint", R.drawable.pizza));

        iwPromo=view.findViewById(R.id.iwPromo);
        iwPromo.setImageResource(R.drawable.banner);

        l1=view.findViewById(R.id.lw1);
        l2=view.findViewById(R.id.lw2);
        l3=view.findViewById(R.id.lw3);
        l1.setHasFixedSize(true);
        l2.setHasFixedSize(true);
        l3.setHasFixedSize(true);
        adapter1=new Adapter_Home_Bottom(this.getActivity(),home_data1);
        adapter2=new Adapter_Home_Top(this.getActivity(),home_data2);
        adapter3=new Adapter_Home_Top(this.getActivity(),home_data2);
        layoutManager1=new LinearLayoutManager(this.getActivity(),RecyclerView.HORIZONTAL,false);
        layoutManager2=new LinearLayoutManager(this.getActivity(),RecyclerView.HORIZONTAL,false);
        layoutManager3=new LinearLayoutManager(this.getActivity(),RecyclerView.HORIZONTAL,false);
        l1.setAdapter(adapter1);
        l1.setLayoutManager(layoutManager1);
        l2.setAdapter(adapter2);
        l2.setLayoutManager(layoutManager2);
        l3.setAdapter(adapter3);
        l3.setLayoutManager(layoutManager3);

        toolbar= view.findViewById(R.id.toolbarhome);
        toolbar.setNavigationIcon(R.drawable.ic_baseline_shopping_cart_24);
        toolbar.inflateMenu(R.menu.menu_toolbar);
        sw=(SearchView)toolbar.getMenu().findItem(R.id.succbar).getActionView();
        sw.setIconifiedByDefault(false);
        sw.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Toast.makeText(getContext(),"BIG SUCC",Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_home, container, false);
        setHasOptionsMenu(true);
        return view;
    }

}