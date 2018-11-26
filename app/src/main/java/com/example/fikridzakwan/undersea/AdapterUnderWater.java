package com.example.fikridzakwan.undersea;

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

public class AdapterUnderWater extends RecyclerView.Adapter<AdapterUnderWater.ViewHolder> {

    Context context;
    String[] namaUnderWater,detailUnderWater;
    int[] gambarUnderWater;


    public AdapterUnderWater(Context context, String[] namaUnderWater, String[] detailUnderWater, int[] gambarUnderWater) {
        this.context = context;
        this.namaUnderWater = namaUnderWater;
        this.detailUnderWater = detailUnderWater;
        this.gambarUnderWater = gambarUnderWater;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_underwater, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        viewHolder.txtNamaUnderWater.setText(namaUnderWater[i]);
        Glide.with(context).load(gambarUnderWater[i]).into(viewHolder.imgGambarUnderWater);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("NU", namaUnderWater[i]);
                intent.putExtra("DU", detailUnderWater[i]);
                intent.putExtra("GU", gambarUnderWater[i]);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return gambarUnderWater.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtNamaUnderWater;
        ImageView imgGambarUnderWater;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNamaUnderWater = itemView.findViewById(R.id.txtNamaUnderWater);
            imgGambarUnderWater = itemView.findViewById(R.id.imgGambarUnderWater);
        }
    }
}
