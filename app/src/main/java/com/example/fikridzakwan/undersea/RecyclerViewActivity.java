package com.example.fikridzakwan.undersea;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerViewActivity extends AppCompatActivity {

    int[] gambarUnderwater;
    String[] detailUnderwater, namaunderWater;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        ButterKnife.bind(this);

        namaunderWater = getResources().getStringArray(R.array.nama_undersea);
        detailUnderwater = getResources().getStringArray(R.array.detail_underwater);
        gambarUnderwater = new int[]{R.drawable.p1, R.drawable.p2, R.drawable.p3, R.drawable.p4, R.drawable.p5,
        R.drawable.p6, R.drawable.p7, R.drawable.p8, R.drawable.p9, R.drawable.p10};

        AdapterUnderWater adapterUnderWater = new AdapterUnderWater(this, namaunderWater,detailUnderwater,gambarUnderwater);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapterUnderWater);
    }
}
