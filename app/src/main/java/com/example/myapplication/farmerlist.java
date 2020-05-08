package com.example.myapplication;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;

import com.google.firebase.database.ValueEventListener;

import java.util.List;
import java.util.jar.Attributes;

public class farmerlist extends ArrayAdapter<farmer_data> {
    Context context;

    public farmerlist(Context context, int resourceId,
                      List<farmer_data> items) {
        super(context, resourceId, items);
        this.context = context;
    }

    private class ViewHolder {
        TextView Name;
        TextView Add;
        TextView Phone;
        TextView Veg;
        TextView Quantity;
        TextView Time;
        TextView Type;
        ImageView Img;
        LinearLayout Layout;
        CardView Card;
        Button Map;
        Button Call;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder = null;
        final farmer_data farmers = getItem(position);
        LayoutInflater mInflater = (LayoutInflater) context
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {

            convertView = LayoutInflater.from(getContext()).inflate(R.layout.mylist, parent, false);
            convertView = mInflater.inflate(R.layout.mylist, null);
            holder = new ViewHolder();
            holder.Name = (TextView) convertView.findViewById(R.id.farmername);
            holder.Add = (TextView) convertView.findViewById(R.id.farmercontact);
            holder.Phone = (TextView) convertView.findViewById(R.id.farmerphone);
            holder.Veg = (TextView) convertView.findViewById(R.id.types);
            holder.Quantity = (TextView) convertView.findViewById(R.id.quantity);
            holder.Time = (TextView) convertView.findViewById(R.id.times);
            holder.Type = (TextView)convertView.findViewById(R.id.type);
            holder.Img = (ImageView)convertView.findViewById(R.id.img);
            holder.Layout = (LinearLayout)convertView.findViewById(R.id.layout);
            holder.Card = (CardView)convertView.findViewById(R.id.card);
            holder.Map = (Button)convertView.findViewById(R.id.map);
            holder.Call = (Button)convertView.findViewById(R.id.call);
            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.Name.setText(farmers.getName());
        holder.Name.setTextColor(Color.parseColor("#ffffff"));
        holder.Add.setText(" : "+farmers.getAdd());
        holder.Add.setTextColor(Color.parseColor("#ffffff"));
        holder.Phone.setText(" : "+farmers.getPhone());
        holder.Phone.setTextColor(Color.parseColor("#ffffff"));
        holder.Veg.setText(" : "+farmers.getVeg());
        holder.Veg.setTextColor(Color.parseColor("#ffffff"));
        holder.Quantity.setText(" : "+farmers.getQuant() + " " + context.getString(R.string.kg));
        holder.Quantity.setTextColor(Color.parseColor("#ffffff"));
        holder.Time.setText(" : "+farmers.getTime() + " " + context.getString(R.string.days));
        holder.Time.setTextColor(Color.parseColor("#ffffff"));
        holder.Type.setText(farmers.getType());
        holder.Type.setTextColor(Color.parseColor("#ffffff"));
        holder.Img.setImageResource(farmers.getImg());
        holder.Layout.setBackgroundColor(Color.parseColor(farmers.getBack()));
        holder.Card.setCardBackgroundColor(Color.parseColor(farmers.getCards()));
        holder.Map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                        Uri.parse("google.navigation:q=" + farmers.getAdd()));
                context.startActivity(intent);
            }
        });
        holder.Map.setBackgroundColor(Color.parseColor(farmers.getBack()));
        holder.Call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+farmers.getPhone()));
                context.startActivity(intent);
            }
        });
        holder.Call.setBackgroundColor(Color.parseColor(farmers.getBack()));
        return convertView;
    }
}
