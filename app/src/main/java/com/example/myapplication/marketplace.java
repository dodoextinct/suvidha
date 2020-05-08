package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.Manifest;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.bluehomestudio.animationplus.animation.HeightAnimation;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import static java.sql.Types.TIME;

public class marketplace extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference reference;
    List<farmer_data> farmers;
    ListView listView;
    farmer_data farmer;
    ArrayList<farmer_data> list;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marketplace);
        getSupportActionBar().hide();
        listView = (ListView) findViewById(R.id.list);
        farmer = new farmer_data();
        database = FirebaseDatabase.getInstance();
        reference = database.getReference("farmers");
        list = new ArrayList<>();
        dialog = new ProgressDialog(marketplace.this);
        dialog.setMessage(marketplace.this.getString(R.string.load));
        dialog.show();
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    //getting artist
                    farmer = postSnapshot.getValue(farmer_data.class);
                    list.add(farmer);
                }


                //creating adapter
                farmerlist adapter = new farmerlist(marketplace.this, R.layout.mylist, list);
                //attaching adapter to the listview
                listView.setAdapter(adapter);
                dialog.dismiss();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(marketplace.this, MainActivity.class);
        startActivity(i);
        Animatoo.animateFade(marketplace.this);
        super.onBackPressed();
    }
}
