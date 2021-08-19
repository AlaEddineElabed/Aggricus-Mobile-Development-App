package com.example.mobilejava;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.provider.ContactsContract;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity  {


private ViewPager viewPager;
private ArrayList<MyModel> modelArrayList;
private CardViewAdapter adapter ;
SliderView sliderView;


int[]images={R.drawable.image1,R.drawable.image2,R.drawable.image3,R.drawable.image4};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        DrawerLayout drawerLayout=findViewById(R.id.drawer_layout) ;
        sliderView=findViewById(R.id.image_slider);
        SliderAdapter sliderAdapter = new SliderAdapter(images);


        NavigationView navigationView = (NavigationView) findViewById(R.id.nav);
        View headerview = navigationView.getHeaderView(0);
        TextView profilename = (TextView) headerview.findViewById(R.id.textView5);
        headerview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Main2Activity.this,AboutUsActivity.class));
            }
        });

        sliderView.setSliderAdapter(sliderAdapter);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM);
        sliderView.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION);
        sliderView.startAutoCycle();
        ImageView img;
        img=findViewById(R.id.imageView2);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)  {
                startActivity(new Intent(Main2Activity.this,RegisterUser.class));
            }
        });




        viewPager=findViewById(R.id.viewerpage);
        loadcard();
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        findViewById(R.id.imageview5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }

        });
        

}

    private void loadcard() {
        modelArrayList =new ArrayList<>();
        modelArrayList.add(new MyModel("xxx","fsdf",R.drawable.image1));
        modelArrayList.add(new MyModel("xxx","esgsfdsfs",R.drawable.image2));
        modelArrayList.add(new MyModel("xsgx","dsfs",R.drawable.image3));
        adapter=new CardViewAdapter(this,modelArrayList);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(100,0,100,0);
    }
}