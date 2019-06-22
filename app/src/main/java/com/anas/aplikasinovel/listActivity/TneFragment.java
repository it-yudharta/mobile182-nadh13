package com.anas.aplikasinovel.listActivity;


import android.app.Activity;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.anas.aplikasinovel.R;
import com.anas.aplikasinovel.adapter.ViewPagerAdapter;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;

/**
 * A simple {@link Fragment} subclass.
 */
public class TneFragment extends AppCompatActivity {

    private TabLayout tabLayout;
    private AppBarLayout appBarLayout;
    private ViewPager viewPager;

//    public TneFragment() {
//        // Required empty public constructor
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_tne);
        tabLayout = (TabLayout)findViewById(R.id.tabLayout1);
        appBarLayout =(AppBarLayout)findViewById(R.id.appBar1);
        viewPager = (ViewPager)findViewById(R.id.viewPager1);

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.AddFragment(new DetailFragment(), "Detail");
        adapter.AddFragment(new ChapterFragment(), "Chapter");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }


    //    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_tne, container, false);
//    }

}
