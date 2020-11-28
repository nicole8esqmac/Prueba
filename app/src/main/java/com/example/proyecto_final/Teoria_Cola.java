package com.example.proyecto_final;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Teoria_Cola extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teoria__cola);





    }
    public void Formula_MM1(View view) {
        Intent ventana=new Intent(Teoria_Cola.this,Teoria_Cola2.class);
        startActivity(ventana);
    }
    public void Formula_MMS(View view) {
        Intent ventana=new Intent(Teoria_Cola.this,Teoria_Cola3.class);
        startActivity(ventana);
    }

    public void MM1(View view) {
        Intent ventana=new Intent(Teoria_Cola.this,Teoria_Colas_MM1.class);
        startActivity(ventana);
    }
    public void MMS(View view) {
        Intent ventana=new Intent(Teoria_Cola.this,Teoria_Colas_MMS.class);
        startActivity(ventana);
    }


}