package com.dicoding.picodiploma.zulfikarakbar.indonesiafood;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.target.ViewTarget;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

import static java.security.AccessController.getContext;

public class DaftarMasakanAdapter extends RecyclerView.Adapter<DaftarMasakanAdapter.ListViewHolder> {
    private ArrayList<Masakan>listMasakan;private Context context;
    public DaftarMasakanAdapter(ArrayList<Masakan>list, Context context ){
        this.context=context;
        this.listMasakan=list;
    }
    @NonNull
    @Override
    public DaftarMasakanAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.daftar_resep, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final DaftarMasakanAdapter.ListViewHolder holder, int position) {
        final Masakan m = listMasakan.get(position);
        Glide.with(holder.itemView.getContext())
                .load(m.getGambar())
                .apply(new RequestOptions().override(55, 55))
                .into(holder.img);
        holder.tvNama.setText(m.getNama());
        holder.tvBahan.setText(m.getBahan());
        holder.tvCara.setText(m.getCara());

        holder.itemView.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                Toast.makeText(context, "Kamu memilih "+m.getNama(), Toast.LENGTH_SHORT).show();
                Intent i = new Intent(context,DetailActivity2.class);
                Bundle bundle = new Bundle();


                bundle.putString("img", m.getGambar());
                bundle.putString("nama",holder.tvNama.getText().toString());
                bundle.putString("bahan",holder.tvBahan.getText().toString());
                bundle.putString("cara",holder.tvCara.getText().toString());
                i.putExtras(bundle);
                context.startActivity(i);


            }
        });

    }

    @Override
    public int getItemCount() {
        return listMasakan.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView tvNama, tvBahan, tvCara;
//        LinearLayout layout;
        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
//            layout = itemView.findViewById(R.id.lin_detail);
            img = itemView.findViewById(R.id.img_item_photo);
            tvNama = itemView.findViewById(R.id.tv_item_name);
            tvBahan = itemView.findViewById(R.id.tv_item_ingredients);
            tvCara = itemView.findViewById(R.id.tv_item_howto);
        }
    }
}