package com.example.mobilejava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class AromAndMedcPlantsActivity extends AppCompatActivity {

    private RecyclerView aromAndMedcPlantsRecView;
    private aromAndMedcPlantsRecViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arom_and_medc_plants);

        adapter = new aromAndMedcPlantsRecViewAdapter(this);
        aromAndMedcPlantsRecView = findViewById(R.id.aromAndMedcPlantsRecView);
        aromAndMedcPlantsRecView.setAdapter(adapter);
        aromAndMedcPlantsRecView.setLayoutManager(new GridLayoutManager(this,1));

        ArrayList<MostViewedHelperClass> items = new ArrayList<>();
        items.add(new MostViewedHelperClass(R.drawable.image1,"i am new","100","short dsccc"));
        items.add(new MostViewedHelperClass(R.drawable.image1,"wiouu","200","sova maaain"));
        items.add(new MostViewedHelperClass(R.drawable.image1,"lineups","500","ace"));
        adapter.setItems1(items);
    }
}