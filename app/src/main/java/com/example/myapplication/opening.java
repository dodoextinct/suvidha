package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;

public class opening extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opening);
        textView = (TextView)findViewById(R.id.teo);
        int secondsDelayed = 1;
        new Handler().postDelayed(new Runnable() {
            public void run() {
                startActivity(new Intent(opening.this, language.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
            }
        }, secondsDelayed * 2000);

        getSupportActionBar().hide();
    }
}
