package com.dicoding.picodiploma.zulfikarakbar.indonesiafood;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class DetailActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail2);

//        String url1,url2,url3,url4,url5,url6,url7,url8,url9,url10,url11;
//
//        url1=
        String gbr = getIntent().getExtras().getString("img");
        String nama = getIntent().getExtras().getString("nama");
        String bahan = getIntent().getExtras().getString("bahan");
        String cara = getIntent().getExtras().getString("cara");


        ImageView gbr_imv = findViewById(R.id.img_detail);
        TextView nama_tv = findViewById(R.id.namamakanan);nama_tv.setText(nama);
        TextView bahan_tv = findViewById(R.id.detail1);bahan_tv.setText(bahan);
        TextView cara_tv = findViewById(R.id.detail2);cara_tv.setText(cara);

        Glide.with(gbr_imv)
                .load(gbr)
                .apply(new RequestOptions().override(800, 800))
                .into(gbr_imv);

        assert getSupportActionBar() != null;   //null check
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);   //show back button
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
