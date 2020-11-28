package com.example.proyecto_final;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Teoria_Cola2 extends AppCompatActivity {


    private ExpandableListView expandableListView;
    private ExpandableListAdapter expandableListAdapter;
    private List<String> expandableListNombres;
    private HashMap<String, Formula> listaFormula;
    private int lastExpandedPosition = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teoria__cola2);

        init();

        expandableListView.setAdapter(expandableListAdapter);

        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                if(lastExpandedPosition != -1 && groupPosition != lastExpandedPosition){
                    expandableListView.collapseGroup(lastExpandedPosition);
                }
                lastExpandedPosition = groupPosition;
            }
        });

    }
    private void init() {
        this.expandableListView = findViewById(R.id.expandableListView);
        this.listaFormula = getFormula();
        this.expandableListNombres = new ArrayList<>(listaFormula.keySet());
        this.expandableListAdapter = new ListaExpandible(this,
                expandableListNombres, listaFormula);

    }


    private HashMap<String, Formula> getFormula() {
        HashMap<String, Formula> listaC = new HashMap<>();

        listaC.put("Longitud de sistema (Fila)", new Formula( R.drawable.mm1));
        listaC.put("Tiempo de espera en el sistema", new Formula( R.drawable.mm2));
        listaC.put("Tiempo promedio en el sistema de un cliente o elemento", new Formula( R.drawable.mm3));
        listaC.put("Longitud de la cola", new Formula( R.drawable.mm4));
        listaC.put("Tiempo de espera en la cola", new Formula( R.drawable.mm5));
        listaC.put("Probabilidad de uso del sistema", new Formula( R.drawable.mm6));
        listaC.put("Probabilidad de NO uso del sistema", new Formula( R.drawable.mm7));
        listaC.put("Probabilidad de que el Sistema tenga N elementos", new Formula( R.drawable.mm8));

        return listaC;
    }
}