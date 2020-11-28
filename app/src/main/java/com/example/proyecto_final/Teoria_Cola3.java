package com.example.proyecto_final;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Teoria_Cola3 extends AppCompatActivity {

    private ExpandableListView expandableListView;
    private ExpandableListAdapter expandableListAdapter;
    private List<String> expandableListNombres;
    private HashMap<String, Formula2> listaFormula;
    private int lastExpandedPosition = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teoria__cola3);

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
        this.listaFormula = getFormula2();
        this.expandableListNombres = new ArrayList<>(listaFormula.keySet());
        this.expandableListAdapter = new ListaExpandible2(this,
                expandableListNombres, listaFormula);

    }

    private HashMap<String, Formula2> getFormula2() {
        HashMap<String, Formula2> listaC = new HashMap<>();

        listaC.put("Probabilidad de vagancia", new Formula2( R.drawable.mms1));
        listaC.put("Longitud de cola", new Formula2( R.drawable.mms2));
        listaC.put("Longitud del sistema", new Formula2( R.drawable.mms3));
        listaC.put("Tiempo espera en la cola", new Formula2( R.drawable.mms4));
        listaC.put("Tiempo de espera en el sistema", new Formula2( R.drawable.mms5));
        listaC.put("Tiempo de espera en cola – fase especial", new Formula2( R.drawable.mms6));
        listaC.put("Probabilidad de NO uso del sistema", new Formula2( R.drawable.mms7));
        listaC.put("Probabilidad de que el Sistema tenga N elementos", new Formula2( R.drawable.mms8));

        return listaC;
    }


}