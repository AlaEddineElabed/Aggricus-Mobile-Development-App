package com.example.mobilejava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class SubscriptionActivity extends AppCompatActivity {

    private ImageView imgLogo, imgLikedItems , imgBasket ,imgMenu;
    private EditText edtSearchBar;
    private RelativeLayout expandableLayout;
    private Button btnPacks, btnCategories, btnRegister1, btnRegister2, btnRegister3;
    private boolean isExpanded = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subscription);

        InitializeViewsSA();

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

        btnRegister1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SubscriptionActivity.this , FormActivity.class);
                startActivity(intent);
            }
        });

        btnRegister2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SubscriptionActivity.this , FormActivity.class);
                startActivity(intent);
            }
        });

        btnRegister3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SubscriptionActivity.this , FormActivity.class);
                startActivity(intent);
            }
        });



    }

    private void InitializeViewsSA(){
        imgLogo = findViewById(R.id.imgLogo);
        imgLikedItems = findViewById(R.id.imgLikedItems);
        imgBasket = findViewById(R.id.imgBasket);
        imgMenu = findViewById(R.id.imgMenu);
        edtSearchBar = findViewById(R.id.edtSearchBar);
        btnPacks = findViewById(R.id.btnPacks);
        btnCategories = findViewById(R.id.btnCategories);
        btnRegister1 = findViewById(R.id.btnRegister1);
        btnRegister2 = findViewById(R.id.btnRegister2);
        btnRegister3 = findViewById(R.id.btnRegister3);
        expandableLayout=findViewById(R.id.expandableLayout);
    }

}