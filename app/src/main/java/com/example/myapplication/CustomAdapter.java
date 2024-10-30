package com.example.myapplication;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myapplication.R;

public class CustomAdapter extends ArrayAdapter<String>{

    Activity context;
    String[] nama;
    String[] hp;
    int[] img;

    public CustomAdapter(Activity context, String[] nama, String[] hp, int[] img) {
        super(context, R.layout.list_item, nama);

        this.context = context;
        this.nama = nama;
        this.hp = hp;
        this.img = img;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        LayoutInflater inflater = context.getLayoutInflater();

        View rowView = inflater.inflate(R.layout.list_item, null, true);

        ImageView iv_list_item = (ImageView) rowView.findViewById(R.id.im_list_item);
        TextView tv_nama = (TextView) rowView.findViewById(R.id.tv_nama);
        TextView tv_hp = (TextView) rowView.findViewById(R.id.tv_hp);

        iv_list_item.setImageResource(img[position]);
        tv_nama.setText(nama[position]);
        tv_hp.setText(hp[position]);

        return rowView;
            }
}