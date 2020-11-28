package com.example.proyecto_final;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;


public class Progra_Lineal3 extends AppCompatActivity {

    RadioButton min, max, rb3, rb4, rb5,rb6;
    EditText caja1, caja2, valor1, valor2, valor3, valor4, res1, res2;


    private LineGraphSeries<DataPoint>series;
    private GraphView graf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progra__lineal3);


        min = (RadioButton) findViewById(R.id.rb1);
        max = (RadioButton) findViewById(R.id.rb2);

         rb3 = (RadioButton) findViewById(R.id.rb3);
         rb4 = (RadioButton) findViewById(R.id.rb4);
         rb5 = (RadioButton) findViewById(R.id.rb5);
         rb6 = (RadioButton) findViewById(R.id.rb6);


        caja1 = (EditText) findViewById(R.id.caja1);
        caja2 = (EditText) findViewById(R.id.caja2);

        valor1 = (EditText) findViewById(R.id.Edit_1);
        valor2 = (EditText) findViewById(R.id.Edit_2);
        valor3 = (EditText) findViewById(R.id.Edit_3);
        valor4 = (EditText) findViewById(R.id.Edit_4);

        res1 = (EditText) findViewById(R.id.Edit_r1);
        res2 = (EditText) findViewById(R.id.Edit_r2);



    }

    public void calcular (View View){

        validar();


    }





    private void validar(){
        caja1.setError(null);
        caja2.setError(null);
        valor1.setError(null);
        valor2.setError(null);
        valor3.setError(null);
        valor4.setError(null);
        res1.setError(null);
        res2.setError(null);


        String n1 = caja1.getText().toString();
        String n2 = caja2.getText().toString();
        String n3 = valor1.getText().toString();
        String n4 = valor2.getText().toString();
        String n5 = valor3.getText().toString();
        String n6 = valor4.getText().toString();
        String n7 = res1.getText().toString();
        String n8 = res2.getText().toString();





        if (TextUtils.isEmpty(n1)){
            caja1.setError(getString(R.string.error_campo_obligatorio));
            return;
        }
        if (TextUtils.isEmpty(n2)){
            caja2.setError(getString(R.string.error_campo_obligatorio));
            return;
        }
        if (TextUtils.isEmpty(n3)){
            valor1.setError(getString(R.string.error_campo_obligatorio));
            return;
        }
        if (TextUtils.isEmpty(n4)){
            valor2.setError(getString(R.string.error_campo_obligatorio));
            return;
        }
        if (TextUtils.isEmpty(n5)){
            valor3.setError(getString(R.string.error_campo_obligatorio));
            return;
        }
        if (TextUtils.isEmpty(n6)){
            valor4.setError(getString(R.string.error_campo_obligatorio));
            return;
        }
        if (TextUtils.isEmpty(n7)){
            res1.setError(getString(R.string.error_campo_obligatorio));
            return;
        }
        if (TextUtils.isEmpty(n8)){
            res2.setError(getString(R.string.error_campo_obligatorio));
            return;
        }
        /*FUNCION_OBJETIVO();
        Ecu1();
        Ecu2();*/
        LIMPIAR();
        grafica();



    }




    public void operacion(){

        int y1, y2;
        int x1, x2;
        double ec_x1, ec_x2;
        double ec_y1, ec_y2;


        double val1 = Double.parseDouble(valor1.getText().toString());
        double val2 = Double.parseDouble(valor2.getText().toString());
        double val3 = Double.parseDouble(valor3.getText().toString());
        double val4 = Double.parseDouble(valor4.getText().toString());

        double r1 = Double.parseDouble(res1.getText().toString());
        double r2 = Double.parseDouble(res2.getText().toString());

       ec_x1=0;
       ec_x2=0;

       ec_y1=0;
       ec_y2=0;


        x1= (int) ((r1-val2)*(ec_y1)/(val1));
        x2= (int) ((r1-val4)*(ec_y2)/(val3));

        y1= (int) ((r1-val1)*(ec_x1)/(val2));
        y2= (int) ((r2-val3)*(ec_x2)/(val4));


        valor1.setText("");
        valor2.setText("");
        valor3.setText("");
        valor4.setText("");
        res1.setText("");
        res2.setText("");
        caja1.setText("");
        caja2.setText("");

    }

    public void LIMPIAR(){
        valor1.setText("");
        valor2.setText("");
        valor3.setText("");
        valor4.setText("");
        res1.setText("");
        res2.setText("");
        caja1.setText("");
        caja2.setText("");

    }

    public void FUNCION_OBJETIVO(){
        String n1 = caja1.getText().toString();
        String n2 = caja2.getText().toString();


        if(min.isChecked()==true){
            String MININO = "MINIMO: Z = "+n1+"x"+"+"+n2+"y";
        }
        if (max.isChecked()==true){
            String MAXIMO = "MAXIMO: Z = "+n1+"x"+"+"+n2+"y";
        }
    }

    public void Ecu1(){
        String val1 = valor1.getText().toString();
        String val2 = valor2.getText().toString();
        String r1 = res1.getText().toString();

        if(rb3.isChecked()==true){
            String ecu1_menor = val1+ "x"+"+" +val2+"y"+ "<=" +r1;
        }
        if (rb4.isChecked()==true){
           String ecu1_mayor = val1+ "x"+"+" +val2+"y"+ ">=" +r1;
        }

    }

    public void Ecu2(){
        String val3 = valor3.getText().toString();
        String val4 = valor4.getText().toString();
        String r2 = res2.getText().toString();

        if(rb5.isChecked()==true){
            String ecu2_menor = val3+ "x"+"+" +val4+"y"+ "<=" +r2;
        }
        if (rb6.isChecked()==true){
            String ecu2_mayor = val3+ "x"+"+" +val4+"y"+ ">=" +r2;
        }

    }

    public double EC_X1(){


        int x1;
        double ec_y1;

        double val1 = Double.parseDouble(valor1.getText().toString());
        double val2 = Double.parseDouble(valor2.getText().toString());
        double r2 = Double.parseDouble(res2.getText().toString());

        ec_y1=0;


        x1= (int) ((r2-val2)*(ec_y1)/(val1));

        return x1;

    }

    public double EC_x2(){
        int x2;
        double ec_y2;

        double val3 = Double.parseDouble(valor3.getText().toString());
        double val4 = Double.parseDouble(valor4.getText().toString());

        double r2 = Double.parseDouble(res2.getText().toString());

        ec_y2=0;

        x2= (int) ((r2-val4)*(ec_y2)/(val3));
        return x2;

    }

    public double EC_Y1(){

        int y1;
        double ec_x1;


        double val1 = Double.parseDouble(valor1.getText().toString());
        double val2 = Double.parseDouble(valor2.getText().toString());

        double r1 = Double.parseDouble(res1.getText().toString());

        ec_x1=0;


        y1= (int) ((r1-val1)*(ec_x1)/(val2));

        return y1;

    }

    public double EC_Y2(){
        int y2;
        double ec_x2;


        double val3 = Double.parseDouble(valor3.getText().toString());
        double val4 = Double.parseDouble(valor4.getText().toString());

        double r2 = Double.parseDouble(res2.getText().toString());

        ec_x2=0;


        y2= (int) ((r2-val3)*(ec_x2)/(val4));

        return y2;

    }




    public void grafica(){
        String n1 = caja1.getText().toString();
        String n2 = caja2.getText().toString();

        String val1 = valor1.getText().toString();
        String val2 = valor2.getText().toString();
        String val3 = valor3.getText().toString();
        String val4 = valor4.getText().toString();

        String r1 = res1.getText().toString();
        String r2 = res2.getText().toString();


        String minimo = min.toString();
        String maximo = max.toString();

        String rbtn1 = rb3.toString();
        String rbtn2 = rb4.toString();
        String rbtn3 = rb5.toString();
        String rbtn4 = rb6.toString();


        //FUNCION OBJETIVO
        String MININO = "MINIMO: Z = "+n1+"x"+"+"+n2+"y";
        String MAXIMO = "MAXIMO: Z = "+n1+"x"+"+"+n2+"y";

        //MENOR
        String ecu1_menor, ecu2_menor;
        //MAYOR
        String ecu1_mayor, ecu2_mayor;

        //MENOR
        ecu1_menor = val1+ "x"+"+" +val2+"y"+ "<=" +r1;
        ecu2_menor = val3+ "x"+"+" +val4+"y"+ "<=" +r2;

        //MAYOR
        ecu1_mayor = val1+ "x"+"+" +val2+"y"+ ">=" +r1;
        ecu2_mayor = val3+ "x"+"+" +val4+"y"+ ">=" +r2;


        int x1,y1;
        x1=0;
        y1=0;

        int x2,y2;
        x2=0;
        y2=0;




        AlertDialog.Builder  bulder = new AlertDialog.Builder(Progra_Lineal3.this);
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.grafica, null);
        bulder.setView(view);

        TextView txt1 = view.findViewById(R.id.texto1);
        TextView txt2 = view.findViewById(R.id.texto2);
        TextView txt3 = view.findViewById(R.id.texto3);

        txt1.setText(MININO);
        txt2.setText(ecu1_menor);
        txt3.setText(ecu2_menor);


     /*    //MOVERSE EN LA GRAFICA
        graf = findViewById(R.id.GRFICA);

        graf.getViewport().setScrollable(true);
        graf.getViewport().setScrollableY(true);

        graf.getViewport().setScrollable(false);
        graf.getViewport().setScrollableY(true);

        graf.getViewport().setXAxisBoundsManual(true);
        graf.getViewport().setMinX(-50);
        graf.getViewport().setMaxX(50);



       series = new LineGraphSeries<DataPoint>();
        for (int i=0;i<500;i++){
            x1= (int) EC_X1();
            y1= (int) EC_Y1();

            series.appendData(new DataPoint(x1,y1),true, 500);
        }
        graf.addSeries(series);


        series = new LineGraphSeries<DataPoint>();
        for (int i=0;i<500;i++){
            x2= (int) EC_x2();
            y2= (int) EC_Y2();
            series.appendData(new DataPoint(x2,y2),true, 500);
        }
        graf.addSeries(series);*/


        final AlertDialog dialog =  bulder.create();
        dialog.show();


        Button btnVolver = view.findViewById(R.id.btnVolver);
        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

    }
}