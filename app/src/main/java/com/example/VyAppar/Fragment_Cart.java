package com.example.VyAppar;

import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.VyAppar.Adapter_Cart.CountandPrice;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class Fragment_Cart extends Fragment {
    FragmentManager fragmentManager;
    Toolbar toolbar;
    Button btn;
    View view;
    BottomNavigationView bnw;
    RecyclerView l1;
    Adapter_Cart adapter;
    RecyclerView.LayoutManager layoutManager;
    TextView tc,tp;


    public Fragment_Cart() {
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
        view= inflater.inflate(R.layout.fragment_cart, container, false);
        fragmentManager=getActivity().getSupportFragmentManager();
        toolbar=view.findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_ios_24);
        btn=view.findViewById(R.id.button2);
        tc=view.findViewById(R.id.total);
        tp=view.findViewById(R.id.thevidiya);
        l1=view.findViewById(R.id.l1);
        layoutManager=new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false);
        adapter=new Adapter_Cart(getContext(),APPLICATION_CLASS.cart);
        l1.setLayoutManager(layoutManager);
        l1.setAdapter(adapter);


        return view;
    }



}