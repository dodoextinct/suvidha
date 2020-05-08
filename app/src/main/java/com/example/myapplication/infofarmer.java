package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;

public class infofarmer extends AppCompatActivity {

    EditText name;
    EditText contact;
    EditText add;
    TextView next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infofarmer);
        getSupportActionBar().hide();
        name = (EditText)findViewById(R.id.name);
        add = (EditText)findViewById(R.id.add);
        contact = (EditText)findViewById(R.id.contact);
        next = (TextView) findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(infofarmer.this, workspace.class);
                i.putExtra("name", name.getText().toString().trim());
                i.putExtra("contact", contact.getText().toString().trim());
                i.putExtra("add", add.getText().toString().trim());
                startActivity(i);
                Animatoo.animateSwipeLeft(infofarmer.this);
            }
        });

    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(infofarmer.this, MainActivity.class);
        startActivity(i);
        Animatoo.animateFade(infofarmer.this);
        super.onBackPressed();
    }
}
