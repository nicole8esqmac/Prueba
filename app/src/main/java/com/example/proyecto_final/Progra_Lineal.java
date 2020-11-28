package com.example.proyecto_final;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Progra_Lineal extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progra__lineal);


    }

    public void Explicacion(View view) {
        Intent ventana=new Intent(Progra_Lineal.this,Progra_Lineal2.class);
        startActivity(ventana);
    }

    public void MetodoPL(View view) {
        Intent ventana=new Intent(Progra_Lineal.this,Progra_Lineal3.class);
        startActivity(ventana);
    }

}