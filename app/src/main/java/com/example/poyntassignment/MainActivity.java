package com.example.poyntassignment;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    TransactionAdapter transactionAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        recyclerView = findViewById(R.id.recylerView);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        init();
    }

    private void init() {
        linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        transactionAdapter = new TransactionAdapter(populateDummyData());
        recyclerView.setAdapter(transactionAdapter);
    }
    private List<Object> populateDummyData()
    {
        List<Object> list = new ArrayList<>();
        list.add(new String("Food"));
        list.add(new TransationModel("Dinner at Momo's","7/28/2017","$18"));
        list.add(new TransationModel("Dinner at Momo's","7/28/2017","$18"));
        list.add(new TransationModel("Dinner at Momo's","7/28/2017","$18"));
        list.add(new String("Transpostation"));
        list.add(new TransationModel("Dinner at Momo's","7/28/2017","$18"));
        list.add(new TransationModel("Dinner at Momo's","7/28/2017","$18"));
        list.add(new TransationModel("Dinner at Momo's","7/28/2017","$18"));
        list.add(new String("Grroceries"));
        list.add(new TransationModel("Dinner at Momo's","7/28/2017","$18"));
        list.add(new TransationModel("Dinner at Momo's","7/28/2017","$18"));
        list.add(new TransationModel("Dinner at Momo's","7/28/2017","$18"));
        return list;
    }
}
