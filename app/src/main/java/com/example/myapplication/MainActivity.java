package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton farmer;
    private FloatingActionButton buyer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        farmer = (FloatingActionButton)findViewById(R.id.farmer);
        farmer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, farmer.class);

                startActivity(i);
                Animatoo.animateFade(MainActivity.this);
            }
        });
        buyer = (FloatingActionButton)findViewById(R.id.buyer);
        buyer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, buyer.class);
                startActivity(i);
                Animatoo.animateFade(MainActivity.this);
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            finishAffinity();
        }
        finish();
        super.onBackPressed();
    }
}
