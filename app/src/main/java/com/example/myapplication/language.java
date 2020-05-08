package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.Animation;
import android.widget.TextView;
import android.widget.Toast;


import com.blogspot.atifsoftwares.animatoolib.Animatoo;

import java.util.Locale;

public class language extends AppCompatActivity {

    TextView english;
    TextView hindi;
    TextView gujrati;
    TextView marathi;
    TextView telugu;
    Locale myLocale;
    String currentLanguage = "en", currentLang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);
        getSupportActionBar().hide();


        english = (TextView)findViewById(R.id.english);
        english.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setLocale("en");
            }
        });
        hindi = (TextView)findViewById(R.id.hindi);
        hindi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setLocale("hi");
            }
        });
        gujrati = (TextView)findViewById(R.id.Gujrati);
        gujrati.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setLocale("gu");
            }
        });
        marathi = (TextView)findViewById(R.id.Marathi);
        marathi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setLocale("mr");
            }
        });
        telugu = (TextView)findViewById(R.id.Telugu);
        telugu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setLocale("te");
            }
        });

        currentLanguage = getIntent().getStringExtra(currentLang);

    }
    public void setLocale(String localeName) {
        if (!localeName.equals(currentLanguage)) {
            myLocale = new Locale(localeName);
            Resources res = getResources();
            DisplayMetrics dm = res.getDisplayMetrics();
            Configuration conf = res.getConfiguration();
            conf.locale = myLocale;
            res.updateConfiguration(conf, dm);
            Intent i = new Intent(language.this, MainActivity.class);
            i.putExtra(currentLang, localeName);

            startActivity(i);
            Animatoo.animateFade(language.this);
            
        } else {
            Toast.makeText(language.this, "Language already selected!", Toast.LENGTH_SHORT).show();
        }
    }
}
