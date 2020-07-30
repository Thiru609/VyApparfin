package com.example.VyAppar;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class Fragment_Cart_PARENT extends Fragment {
    FragmentManager fragmentManager;
    Toolbar toolbar;
    Button btn;
    View view;
    BottomNavigationView bnw;
    RecyclerView l1;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<Class_Cart> cart;


    public Fragment_Cart_PARENT() {
        //empty constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_cart_parent, container, false);
        fragmentManager=getActivity().getSupportFragmentManager();
        toolbar=view.findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_ios_24);
        btn=view.findViewById(R.id.button2);

        cart=new ArrayList<Class_Cart>();
        cart.add(new Class_Cart("Margerita Pizza","Extra Cheese and Jalepenos","Rs.200","2",R.drawable.piza));
        cart.add(new Class_Cart("Margerita Pizza","Extra Cheese and Jalepenos","Rs.200","2",R.drawable.piza));
        cart.add(new Class_Cart("Margerita Pizza","Extra Cheese and Jalepenos","Rs.200","2",R.drawable.piza));
        l1=view.findViewById(R.id.l1);
        layoutManager=new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false);
        adapter=new Adapter_Cart(getContext(),cart);
        l1.setLayoutManager(layoutManager);
        l1.setAdapter(adapter);



        return view;
    }


}