package com.example.mobilejava;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.provider.ContactsContract;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    private ImageView imgLogo,imgMenu,imgLikedItems,imgBasket;
    private TextView aromAndMedcPlants, handyCrafts, craftProducts;
    private Button btnPacks,btnCategories;
    private RelativeLayout expandableLayout;
    private boolean isExpanded = false;

    private ViewPager viewPager;
    private ViewPager viewPager2;
    private ArrayList<MyModel> modelArrayList;
    private CardViewAdapter adapter;
    RecyclerView mostViewedRecycler;
    RecyclerView.Adapter adapterr;
    private GradientDrawable gradient1, gradient2, gradient3, gradient4;
    SliderView sliderView;


    int[] images = {R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        sliderView = findViewById(R.id.image_slider);
        SliderAdapter sliderAdapter = new SliderAdapter(images);
        TextView more;
        more = findViewById(R.id.more);
        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Main2Activity.this, FirstCategorieLayout.class));

            }
        });

        InitializeViewsMA();


        btnPacks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this , SubscriptionActivity.class);
                startActivity(intent);
            }
        });


        btnCategories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isExpanded) {
                    expandableLayout.setVisibility(View.GONE);
                    isExpanded = false;
                } else if (!(isExpanded)) {
                    expandableLayout.setVisibility(View.VISIBLE);
                    isExpanded = true;
                }
            }
        });

        aromAndMedcPlants.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main2Activity.this , AromAndMedcPlantsActivity.class);
                startActivity(intent);
            }

        });
        Button outlinedButton;
        Button outlinedButton2;
        outlinedButton2 = findViewById(R.id.outlinedButton);
        outlinedButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setVisibility(View.VISIBLE);
                viewPager2.setVisibility(View.GONE);
            }
        });
        outlinedButton = findViewById(R.id.outlinedButton2);
        outlinedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setVisibility(View.GONE);

                viewPager2.setVisibility(View.VISIBLE);
            }
        });

        mostViewedRecycler = findViewById(R.id.most_viewed_recycler);
        mostViewedRecycler();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav);
        View headerview = navigationView.getHeaderView(0);
        TextView aboutus = (TextView) headerview.findViewById(R.id.textView5);
        TextView register = (TextView) headerview.findViewById(R.id.textView4);
        TextView login = (TextView) headerview.findViewById(R.id.textView3);
        //todo principal w bestsellers click listenener
        TextView principal = (TextView) headerview.findViewById(R.id.textView7);
        TextView bestsellers = (TextView) headerview.findViewById(R.id.textView6);
        ImageView twitter = (ImageView) headerview.findViewById(R.id.imageView);
        ImageView facebook = (ImageView) headerview.findViewById(R.id.imageView5);
        ImageView youtube = (ImageView) headerview.findViewById(R.id.imageView8);
        ImageView instagram = (ImageView) headerview.findViewById(R.id.imageView7);
        ImageView google = (ImageView) headerview.findViewById(R.id.imageView6);
        FloatingActionButton button = headerview.findViewById(R.id.floating_action_button);


        principal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Main2Activity.this, Main2Activity.class));
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.closeDrawer(GravityCompat.START);
            }
        });


        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoURL("https://www.facebook.com/aggricus");
            }
        });
        aboutus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Main2Activity.this, AboutUsActivity.class));
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Main2Activity.this, RegisterUser.class));
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Main2Activity.this, LogInActivity.class));
            }
        });

        sliderView.setSliderAdapter(sliderAdapter);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM);
        sliderView.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION);
        sliderView.startAutoCycle();



        imgLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Main2Activity.this, Main2Activity.class));
            }
        });


        viewPager2 = findViewById(R.id.viewerpage2);
        viewPager = findViewById(R.id.viewerpage);
        loadcard();
        loadcard2();
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


        imgMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }

        });


    }
    private void InitializeViewsMA(){
        imgLogo =findViewById(R.id.imgLogo);
        imgMenu =findViewById(R.id.imgMenu);
        imgLogo = findViewById(R.id.imgLogo);
        imgLikedItems = findViewById(R.id.imgLikedItems);
        imgBasket = findViewById(R.id.imgBasket);
        imgMenu = findViewById(R.id.imgMenu);
        btnPacks = findViewById(R.id.btnPacks);
        btnCategories = findViewById(R.id.btnCategories);
        expandableLayout=findViewById(R.id.expandableLayout);
        aromAndMedcPlants=findViewById(R.id.aromAndMedcPlants);
        handyCrafts=findViewById(R.id.handyCrafts);
        craftProducts=findViewById(R.id.craftProducts);
    }

    private void gotoURL(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW, uri));
    }

    private void loadcard() {
        modelArrayList = new ArrayList<>();
        modelArrayList.add(new MyModel("xxx", "fsdf", R.drawable.image1));
        modelArrayList.add(new MyModel("xxx", "esgsfdsfs", R.drawable.image2));
        modelArrayList.add(new MyModel("xsgx", "dsfs", R.drawable.image3));
        adapter = new CardViewAdapter(this, modelArrayList);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(60, 0, 100, 0);
    }

    private void loadcard2() {
        modelArrayList = new ArrayList<>();
        modelArrayList.add(new MyModel("piwpiwww", "20000", R.drawable.image4));
        modelArrayList.add(new MyModel("skaaaaaaaaa3", "esgsfdsfs", R.drawable.image3));
        modelArrayList.add(new MyModel("xsgx", "dsfs", R.drawable.image1));
        adapter = new CardViewAdapter(this, modelArrayList);
        viewPager2.setAdapter(adapter);
        viewPager2.setPadding(60, 0, 100, 0);
    }

    private void mostViewedRecycler() {

        mostViewedRecycler.setHasFixedSize(true);
        mostViewedRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<MostViewedHelperClass> mostViewedLocations = new ArrayList<>();
        mostViewedLocations.add(new MostViewedHelperClass(R.drawable.image2, "McDonald's", "20.000", " blaalalalallalalal"));
        mostViewedLocations.add(new MostViewedHelperClass(R.drawable.image1, "Edenrobe", "20.000", " blaalalalallalalal"));
        mostViewedLocations.add(new MostViewedHelperClass(R.drawable.image3, "J.", "20.000", " blaalalalallalalal"));
        mostViewedLocations.add(new MostViewedHelperClass(R.drawable.image4, "Walmart", "20.000", " blaalalalallalalal"));

        adapterr = new MostViewedAdpater(mostViewedLocations);
        mostViewedRecycler.setAdapter(adapterr);
        mostViewedRecycler.setPadding(60, 0, 100, 0);

    }
}