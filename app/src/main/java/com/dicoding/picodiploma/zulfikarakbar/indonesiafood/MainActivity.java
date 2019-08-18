package com.dicoding.picodiploma.zulfikarakbar.indonesiafood;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvMasakan;
    private ArrayList<Masakan> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvMasakan = findViewById(R.id.rv_masakan);
        rvMasakan.setHasFixedSize(true);

        list.addAll(DataMasakan.getDaftarMasakan());
        showRecyclerList();
    }
    private void showRecyclerList(){
        rvMasakan.setLayoutManager(new LinearLayoutManager(this));
        DaftarMasakanAdapter a = new DaftarMasakanAdapter(list,this);
        rvMasakan.setAdapter(a);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    private void onClickProfile(){
        Intent moveIntent = new Intent(MainActivity.this, ProfilActivity.class);
        startActivity(moveIntent);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item_menu){
        switch (item_menu.getItemId()){
            case R.id.profil:
                onClickProfile();
                return true;
            default:
                return super.onOptionsItemSelected(item_menu);
        }
    }
}
