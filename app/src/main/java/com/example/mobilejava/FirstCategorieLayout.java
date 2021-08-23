package com.example.mobilejava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class FirstCategorieLayout extends AppCompatActivity {



    private ArrayList<MyModel> modelArrayList;
    private FirstCategorieRecycleAdapter adapter ;
    private RecyclerView firstcategorie=findViewById(R.id.firstrecylce);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_categorie_layout);


onload();


    }
    public void onload() {
        modelArrayList = new ArrayList<>();
        modelArrayList.add(new MyModel("xxx", "fsdf", R.drawable.image1));
        modelArrayList.add(new MyModel("xxx", "esgsfdsfs", R.drawable.image2));
        modelArrayList.add(new MyModel("xsgx", "dsfs", R.drawable.image3));
        adapter = new FirstCategorieRecycleAdapter(modelArrayList, (FirstCategorieListener) this);
        firstcategorie.setAdapter(adapter);
        firstcategorie.setPadding(60, 0, 100, 0);
    }


}