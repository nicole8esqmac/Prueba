package com.example.proyecto_final;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }
    public void TeoriaCola(View view) {
        Intent ventana=new Intent(Menu.this,Teoria_Cola.class);
        startActivity(ventana);
    }

    public void ProgramcionLineal(View view) {
        Intent ventana=new Intent(Menu.this,Progra_Lineal.class);
        startActivity(ventana);
    }
    public void ModeloTransporte(View view) {
        Intent ventana=new Intent(Menu.this,Grafica_PL.class);
        startActivity(ventana);
    }
}