package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class workspace extends AppCompatActivity {

    String name_;
    String add_;
    String phone_;
    EditText veg;
    EditText quant;
    EditText time;
    TextView create;
    TextView more;
    TextView move;
    Spinner spin;


    //a list to store all the artist from firebase database
    List<farmer_data> data;

    //our database reference object
    DatabaseReference database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workspace);
        getSupportActionBar().hide();
        Intent i = getIntent();
        Bundle bo = i.getExtras();
        database = FirebaseDatabase.getInstance().getReference("farmers");

        veg = (EditText)findViewById(R.id.type);
        quant = (EditText)findViewById(R.id.quan);
        time = (EditText)findViewById(R.id.time);
        create = (TextView) findViewById(R.id.data);
        more = (TextView)findViewById(R.id.more);
        move = (TextView)findViewById(R.id.move);
        spin = (Spinner)findViewById(R.id.spinner);
        String[] items = new String[]{this.getString(R.string.type), this.getString(R.string.green),
                this.getString(R.string.root), this.getString(R.string.marrow)};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.spin, items);
        spin.setAdapter(adapter);

        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = getIntent();
                finish();
                startActivity(i);
                overridePendingTransition(R.anim.no_anim, R.anim.no_anim);
            }
        });

        move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(workspace.this, marketplace.class);
                startActivity(i);
                Animatoo.animateSlideDown(workspace.this);
            }
        });

        name_ = (String)bo.get("name");
        add_ = (String)bo.get("add");
        phone_ = (String)bo.get("contact");
        data= new ArrayList<>();

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                add_farmer();
            }
        });
    }
    private void add_farmer() {
        //getting the values to save

        String veg_ = veg.getText().toString().trim();
        String quant_ = quant.getText().toString().trim();
        String time_ = time.getText().toString().trim();
        Integer a = spin.getSelectedItemPosition();
        String back_="#ffffff";
        String card_="#ffffff";
        String type_ = "";
        int img = 0;
        if (a == 1){
            img = R.drawable.leafy;
            back_ = "#229954";
            card_ = "#52be80";
            type_ = this.getString(R.string.green);
        }
        else if(a == 2){
            img = R.drawable.roots;
            card_ = "#f7dc6f";
            back_ = "#f1c40f";
            type_ = this.getString(R.string.root);
        }
        else if(a == 3){
            img = R.drawable.marrow;
            back_ = "#dc7633";
            card_ = "#e59866";
            type_ = this.getString(R.string.marrow);
        }

        //checking if the value is provided
        if (!TextUtils.isEmpty(veg_) && !TextUtils.isEmpty(quant_) && !TextUtils.isEmpty(time_)) {

            //getting a unique id using push().getKey() method
            //it will create a unique id and we will use it as the Primary Key for our Artist
            String id = database.push().getKey();


            //creating an Artist Object
            farmer_data farm = new farmer_data(id, name_, add_, phone_, veg_, quant_, time_, type_, img, back_, card_);

            //Saving the Artist
            database.child(id).setValue(farm);
            //displaying a success toast
            Toast.makeText(this, workspace.this.getString(R.string.vegadd), Toast.LENGTH_LONG).show();
        } else {
            //if the value is not given displaying a toast
            Toast.makeText(this, "Fields can't be empty!!", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(workspace.this, infofarmer.class);
        startActivity(i);
        Animatoo.animateSwipeRight(workspace.this);
        super.onBackPressed();
    }
}
