package com.example.myapplication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;

public class buyer extends AppCompatActivity {

    EditText buyer_phone;
    TextView buyer_button;
    String no;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buyer);
        getSupportActionBar().hide();
        getWindow().setStatusBarColor(Color.parseColor("#154360"));

        buyer_phone = (EditText)findViewById(R.id.mobile_buyer);
        buyer_button = (TextView)findViewById(R.id.button_buyer);

        buyer_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                no = buyer_phone.getText().toString();
                validNo(no);
                Toast.makeText(buyer.this, no, Toast.LENGTH_LONG).show();
            }
        });
    }
    private void validNo(String no) {
        if (no.isEmpty() || no.length() < 10) {
            buyer_phone.setError("Enter a valid mobile");
            buyer_phone.requestFocus();
            return;
        }
        else {
            Intent intent = new Intent(buyer.this, buyer_otp.class);
            intent.putExtra("mobile", no);
            startActivity(intent);
            Animatoo.animateSwipeLeft(buyer.this);
        }
    }
}
