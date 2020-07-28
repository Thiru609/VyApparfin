package com.example.categories_2ndattempt;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class CustomerHomePageActivity extends AppCompatActivity implements CategoryAdapterTop.sendonitemclicktop,CategoryAdapterBottom.sendonItemclickbottom {

    FragmentManager fragmentManager;
    BottomNavigationView bnw;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer_homepage);
        fragmentManager=this.getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .show(fragmentManager.findFragmentById(R.id.homefragment))
                .hide(fragmentManager.findFragmentById(R.id.searchfrag))
                .addToBackStack(null)
                .commit();
        bnw=findViewById(R.id.bottomnw);
        bnw.setOnNavigationItemSelectedListener(navListener);


    }

private BottomNavigationView.OnNavigationItemSelectedListener navListener= new
        BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId())
                {
                    case(R.id.homebottom):
                        fragmentManager.beginTransaction()
                                .hide(fragmentManager.findFragmentById(R.id.searchfrag))
                                .show(fragmentManager.findFragmentById(R.id.homefragment))
                                .addToBackStack(null)
                                .commit();
                        break;

                    case(R.id.searchbottom):
                        fragmentManager.beginTransaction()
                                .hide(fragmentManager.findFragmentById(R.id.homefragment))
                                .show(fragmentManager.findFragmentById(R.id.searchfrag))
                                .addToBackStack(null)
                                .commit();
                        break;
                    case(R.id.cartbottom):
                        break;
                    case(R.id.profilebottom):
                        break;


                }

                return true;
            }
        };

    @Override
    public void sendonclicktop(int i) {
        fragmentManager.beginTransaction()
                .hide(fragmentManager.findFragmentById(R.id.homefragment))
                .show(fragmentManager.findFragmentById(R.id.searchfrag))
                .addToBackStack(null)
                .commit();

    }

    @Override
    public void sendonclickbottom(int i) {
        fragmentManager.beginTransaction()
                .hide(fragmentManager.findFragmentById(R.id.homefragment))
                .show(fragmentManager.findFragmentById(R.id.searchfrag))
                .addToBackStack(null)
                .commit();


    }




}