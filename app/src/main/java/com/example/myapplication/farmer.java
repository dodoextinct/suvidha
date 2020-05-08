package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class farmer extends AppCompatActivity {


    EditText mobile;
    TextView button;
    String no;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmer);
            getSupportActionBar().hide();
        mobile = (EditText) findViewById(R.id.mobile);

        button = (TextView) findViewById(R.id.button);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                no = mobile.getText().toString();
                validNo(no);
            }
        });


    }

    private void validNo(String no) {
        if (no.isEmpty() || no.length() < 10) {
            mobile.setError("Enter a valid mobile");
            mobile.requestFocus();
            return;
        }
        else{
            Intent intent = new Intent(farmer.this, farmer_otp.class);
            intent.putExtra("mobile", no);
            startActivity(intent);
            Animatoo.animateSwipeLeft(farmer.this);
        }
    }
}