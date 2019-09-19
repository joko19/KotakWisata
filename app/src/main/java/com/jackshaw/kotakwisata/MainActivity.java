package com.jackshaw.kotakwisata;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{

    private RecyclerView rvWisata;
    private ArrayList list = new ArrayList<>();

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Membaca file menu dan menambahkan isinya ke action bar jika ada.
        getMenuInflater().inflate(R.menu.about, menu);
        return true;
    }

    public void onComposeAction(MenuItem mi) {
        Intent AboutIntent = new Intent(MainActivity.this, About.class);
        startActivity(AboutIntent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvWisata = findViewById(R.id.rv_wisata);
        rvWisata.setHasFixedSize(true);

        list.addAll(DataWisata.getListPlace());
         showRecycleList();

        //listView.setOnClickListener((View.OnClickListener) this);
    }
    private void showRecycleList() {
        rvWisata.setLayoutManager(new LinearLayoutManager(this));
        AdapterWisata iniadapterwisata = new AdapterWisata(list);
        rvWisata.setAdapter(iniadapterwisata);
        //uji coba
        final AdapterWisata tes = new AdapterWisata(list);
        rvWisata.setAdapter(tes);
        ListView listView = findViewById(R.id.rv_wisata);
    }

}