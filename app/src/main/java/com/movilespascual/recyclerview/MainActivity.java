package com.movilespascual.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<ListaElementos> elementos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init(); 
    }

    public void  init(){
        elementos = new ArrayList<>();
        elementos.add(new ListaElementos("#7B1FA2","Pedro","Medellín","Leido"));
        elementos.add(new ListaElementos("#CA3BEB","Danilo","Bucaramanga","No leido"));
        elementos.add(new ListaElementos("#3DA3F5","Estefania","Manizales","Leido"));
        elementos.add(new ListaElementos("#43DE48","Darney","España","No leido"));
        elementos.add(new ListaElementos("#EB634D","Elvis","Ciudad de México","Leido"));

        ListAdapter listAdapter = new ListAdapter(elementos,this);
        RecyclerView recyclerView = findViewById(R.id.listRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdapter);
    }

}