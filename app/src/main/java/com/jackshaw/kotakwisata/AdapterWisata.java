package com.jackshaw.kotakwisata;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.security.AccessController;
import java.util.ArrayList;

import static android.support.v4.content.ContextCompat.startActivity;
import static android.widget.AdapterView.*;


public class AdapterWisata extends RecyclerView.Adapter<AdapterWisata.ListViewHolder>{

    public ArrayList<Wisata> dataWisata;
    private OnItemClickListener detail;


    public AdapterWisata(ArrayList<Wisata> list){
        this.dataWisata = list;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.baris_wisata, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        final Wisata wisata = dataWisata.get(position);
        Glide.with(holder.itemView.getContext())
                .load(wisata.getGambar())
                .apply(new RequestOptions().override(200, 200))
                .into(holder.img_place);
        holder.tvPlace.setText(wisata.getWisata());
        holder.tvDeskripsi.setText(wisata.getDeskripsi());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent inidetail = new Intent(context, Detail.class);
                inidetail.putExtra("tv_name", wisata.getWisata());
                inidetail.putExtra("location", wisata.getAlamat());
                inidetail.putExtra("rating", wisata.getRating());
                inidetail.putExtra("category", wisata.getCategory());
                inidetail.putExtra("imgmain", wisata.getGambar());
                inidetail.putExtra("img1", wisata.getImg1());
                inidetail.putExtra("img2", wisata.getImg2());
                inidetail.putExtra("img3", wisata.getImg3());
                inidetail.putExtra("nameImg1", wisata.getNameImg1());
                inidetail.putExtra("nameImg2", wisata.getNameImg2());
                inidetail.putExtra("nameImg3", wisata.getNameImg3());
                inidetail.putExtra("tag1", wisata.getTag1());
                inidetail.putExtra("tag2", wisata.getTag2());
                inidetail.putExtra("tag3", wisata.getTag3());
                inidetail.putExtra("content" ,wisata.getContent());
                context.startActivity(inidetail);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataWisata.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
//
        ImageView img_place;
        TextView tvPlace, tvDeskripsi;
        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
                img_place = itemView.findViewById(R.id.img_place);
                tvPlace = itemView.findViewById(R.id.tv_name_place);
                tvDeskripsi = itemView.findViewById(R.id.tv_deskripsi);
        }
    }
}
