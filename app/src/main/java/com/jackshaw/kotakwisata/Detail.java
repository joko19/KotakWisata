package com.jackshaw.kotakwisata;

import android.content.Intent;
import android.preference.TwoStatePreference;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class Detail extends AppCompatActivity  implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        String nama = getIntent().getStringExtra("tv_name");
        String lokasi = getIntent().getStringExtra("location");
        String inirating = getIntent().getStringExtra("rating");
        String kategori = getIntent().getStringExtra("category");
        String tanda1 = getIntent().getStringExtra("tag1");
        String tanda2 = getIntent().getStringExtra("tag2");
        String tanda3 = getIntent().getStringExtra("tag3");
        String konten = getIntent().getStringExtra("content");
        TextView location = findViewById(R.id.tv_location);
        TextView rating = findViewById(R.id.tv_rating);
        TextView category = findViewById(R.id.tv_category);
        TextView tag1 = findViewById(R.id.tag1);
        TextView tag2 = findViewById(R.id.tag2);
        TextView tag3 = findViewById(R.id.tag3);
        TextView name = findViewById(R.id.tv_name);
        TextView content = findViewById(R.id.tv_content);
        TextView judul = findViewById(R.id.judul);
        name.setText(nama);
        location.setText(lokasi);
        rating.setText(inirating);
        category.setText(kategori);
        tag1.setText(tanda1);
        tag2.setText(tanda2);
        tag3.setText(tanda3);
        content.setText(konten);
        judul.setText(nama);
        //gambar
        String gambar = getIntent().getStringExtra("imgmain");
        String gambar1 = getIntent().getStringExtra("img1");
        String gambar2 = getIntent().getStringExtra("img2");
        String gambar3 = getIntent().getStringExtra("img3");
        ImageView image = findViewById(R.id.img_main);
        ImageView image1 = findViewById(R.id.img1);
        ImageView image2 = findViewById(R.id.img2);
        ImageView image3 = findViewById(R.id.img3);
        Glide.with(Detail.this)
                .load(gambar1)
                .into(image1);
        Glide.with(Detail.this)
                .load(gambar2)
                .into(image2);
        Glide.with(Detail.this)
                .load(gambar3)
                .into(image3);
        Glide.with(Detail.this)
                .load(gambar)
                .into(image);
    }

    @Override
    public void onClick(View v) {

    }
}
