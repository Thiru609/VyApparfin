package com.example.VyAppar;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Activity_MAIN extends AppCompatActivity implements Adapter_Home_Top.sendonitemclicktop, Adapter_Home_Bottom.sendonItemclickbottom,Adapter_Cart.CountandPrice {

    FragmentManager fragmentManager;
    BottomNavigationView bnw;
    FrameLayout fl;
    TextView TotalCost, TotalQuantity;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fl = findViewById(R.id.main_frame);
        fragmentManager = this.getSupportFragmentManager();
        SetFragment(new Fragment_Home());
        bnw = findViewById(R.id.bottomnw);
        bnw.setOnNavigationItemSelectedListener(navListener);


    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new
            BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                    switch (item.getItemId()) {
                        case (R.id.homebottom):
                            SetFragment(new Fragment_Home());
                            break;

                        case (R.id.searchbottom):
                            SetFragment(new Fragment_Search());
                            break;
                        case (R.id.cartbottom):
                            SetFragment(new Fragment_Cart());
                            break;
                        case (R.id.profilebottom):
                            break;


                    }

                    return true;
                }
            };

    @Override
    public void sendonclicktop(int i) {
        bnw.setSelectedItemId(R.id.searchbottom);
    }

    @Override
    public void sendonclickbottom(int i) {
        bnw.setSelectedItemId(R.id.searchbottom);

    }

    private void SetFragment(Fragment fragment) {
        fragmentManager.beginTransaction().replace(fl.getId(), fragment).commit();

    }


    @Override
    public void getTotalCountandPrice(String totalcount, String totalprice) {
        TotalCost = findViewById(R.id.thevidiya);
        TotalQuantity = findViewById(R.id.total);
        TotalCost.setText(totalprice);
        TotalQuantity.setText(totalcount);


    }

}