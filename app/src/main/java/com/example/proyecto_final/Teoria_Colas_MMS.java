package com.example.proyecto_final;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class Teoria_Colas_MMS extends AppCompatActivity {

    DecimalFormat num = new DecimalFormat("0.00");
    DecimalFormat num1 = new DecimalFormat("0");
    EditText n1;
    EditText n2;
    EditText n3;
    EditText n4;
    Button btn1calcular;
    LinearLayout desp1, desp2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teoria__colas__m_m_s);

        btn1calcular = (Button) findViewById(R.id.btncalculo);

        n1 = (EditText) findViewById(R.id.caja1);
        n2 = (EditText) findViewById(R.id.caja2);
        n3 = (EditText) findViewById(R.id.caja3);
        n4 = (EditText) findViewById(R.id.caja4);



        desp1 = (LinearLayout) findViewById(R.id.despliegue1);
        desp2 = (LinearLayout) findViewById(R.id.despliegue2);


    }

    public void calcular (View View){
        validar();


    }


    private void operacion() {

        TextView resLambda = (TextView) findViewById(R.id.txt_lamb);
        TextView resMu = (TextView) findViewById(R.id.txt_mu);
        TextView resN_S = (TextView) findViewById(R.id.txt_n_serv);
        TextView resP = (TextView) findViewById(R.id.txt_P);
        TextView resP0 = (TextView) findViewById(R.id.txt_P0);
        TextView resPn = (TextView) findViewById(R.id.txt_Pn);
        TextView resLq = (TextView) findViewById(R.id.txt_Lq);
        TextView resLs = (TextView) findViewById(R.id.txt_Ls);
        TextView resWq = (TextView) findViewById(R.id.txt_Wq);
        TextView resWs = (TextView) findViewById(R.id.txt_Ws);
        TextView resProm_Ws = (TextView) findViewById(R.id.txt_Promed_Ws);

        TextView res_Min1 = (TextView) findViewById(R.id.txt_Min1);
        TextView res_Min2 = (TextView) findViewById(R.id.txt_Min2);
        TextView res_Min3 = (TextView) findViewById(R.id.txt_Min3);

        TextView res_Seg1 = (TextView) findViewById(R.id.txt_Seg1);
        TextView res_Seg2 = (TextView) findViewById(R.id.txt_Seg2);
        TextView res_Seg3 = (TextView) findViewById(R.id.txt_Seg3);



        double re1 = Double.parseDouble(n1.getText().toString());
        double re2 = Double.parseDouble(n2.getText().toString());
        int res3 = Integer.parseInt(n3.getText().toString());
        int res4 = Integer.parseInt(n4.getText().toString());

        //Probabilidad de vagancia
        double resulP0 =  Nfactorial()+((Math.pow((re1/re2),res3))/factorial(res3))*(1/(1-(re1/(2*re2))));
        double resultado_sinPorcentaje = (1 / resulP0);// pendiente
        //double resultadoPo = (resultado_sinPorcentaje*100);


        //Probabilidad de que el Sistema tenga N elementos
        double resultado_sinPorcentaje2 = (1-(re1/re2))*(Math.pow((re1/re2),res4));
        //double resultadoPn = (resultado_sinPorcentaje2*100);


        double resul1 = Double.parseDouble(n1.getText().toString());
        double resul2 = Double.parseDouble(n2.getText().toString());
        double resul3 = Double.parseDouble(n3.getText().toString());


        double resultado1 = Double.parseDouble(num.format((re1/(res3*re2))));
        double resultado2 = Double.parseDouble(num.format(resultado_sinPorcentaje * 100));
        double resultado3 = Double.parseDouble(num.format(resultado_sinPorcentaje2*100));
        double resultado4 = Double.parseDouble(num.format(resultado_sinPorcentaje * ((Math.pow((re1/re2),res3+1))/(factorial(res3-1)*(Math.pow(res3-(re1/re2),2))))));
        double resultado5 = Double.parseDouble(num.format(resultado4+re1/re2));
        double resultado6 = Double.parseDouble(num.format(resultado5/re1));
        double resultado7 = Double.parseDouble(num.format(resultado4/re1));
        double resultado8 = Double.parseDouble(num.format(resultado7-(1/re2)));



        double result_Min1 = Double.parseDouble(num1.format(resultado6 * 60));
        double result_Min2 = Double.parseDouble(num1.format(resultado7 * 60));
        double result_Min3 = Double.parseDouble(num1.format(resultado7 * 60));

        double result_Seg1 = Double.parseDouble(num1.format(result_Min1 * 60));
        double result_Seg2 = Double.parseDouble(num1.format(result_Min2 * 60));
        double result_Seg3 = Double.parseDouble(num1.format(result_Min3 * 60));


        resLambda.setText(String.valueOf(resul1));
        resMu.setText(String.valueOf(resul2));
        resN_S.setText(String.valueOf(resul3));
        resP.setText(String.valueOf(resultado1));
        resP0.setText(resultado2 + "%");
        resPn.setText(resultado3 + "%");
        resLq.setText(String.valueOf(resultado4));
        resLs.setText(String.valueOf(resultado5));
        resWq.setText(resultado6 + " h");
        resWs.setText(resultado7 + " h");
        resProm_Ws.setText(resultado8 + " h");


        res_Min1.setText(String.valueOf(result_Min1));
        res_Min2.setText(String.valueOf(result_Min2));
        res_Min3.setText(String.valueOf(result_Min3));

        res_Seg1.setText(String.valueOf(result_Seg1));
        res_Seg2.setText(String.valueOf(result_Seg2));
        res_Seg3.setText(String.valueOf(result_Seg3));

        n1.setText("");
        n2.setText("");
        n3.setText("");
        n4.setText("");
    }

    // calculo de factorial
    public  int factorial(int num){
        int aux=1;
        for(int i=2; i<=num; i++)
            aux = aux*i;
        return aux;
    }

    public int factorial2(int num){
        if(num==0)
            return 1;
        else
            return  num*factorial2(num=1);
    }

    //numero de factorial dependiendo el numero del servidor

    public double Nfactorial(){
        double num1 = Double.parseDouble(n1.getText().toString());
        double num2 = Double.parseDouble(n2.getText().toString());
        int num_servidor = Integer.parseInt(n3.getText().toString());
        int serv_actualizado = num_servidor-1;



        int n =0;

        double sumatoria=0;

        while(n<=serv_actualizado){
            double numerador = 0;
            double denominaor = 0;

            numerador = (Math.pow((num1/num2),n));
            denominaor = factorial(n);

            sumatoria = sumatoria+(numerador/denominaor);

            n++;

        }

        return sumatoria;

    }



    public void showToast() {
        LayoutInflater layoutInflater = getLayoutInflater();

        View customToastView = layoutInflater.inflate(R.layout.toast_layout, null);

        ((TextView)customToastView.findViewById(R.id.msg)).setText("Datos Ingresados");

        Toast toast = Toast.makeText(customToastView.getContext(), "", Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setView(customToastView);
        toast.show();
    }



    private void validar(){
        n1.setError(null);
        n2.setError(null);
        n3.setError(null);
        n4.setError(null);

        String caja1 = n1.getText().toString();
        String caja2 = n2.getText().toString();
        String caja3 = n3.getText().toString();
        String caja4 = n4.getText().toString();



        if (TextUtils.isEmpty(caja1)){
            n1.setError(getString(R.string.error_campo_obligatorio));
            return;
        }
        if (TextUtils.isEmpty(caja2)){
            n2.setError(getString(R.string.error_campo_obligatorio));
            return;
        }
        if (TextUtils.isEmpty(caja3)){
            n3.setError(getString(R.string.error_campo_obligatorio));
            return;
        }
        if (TextUtils.isEmpty(caja4)){
            n4.setError(getString(R.string.error_campo_obligatorio));
            return;
        }
        val_camp();

    }

    private void val_camp(){
        double num1 = Double.parseDouble(n1.getText().toString());
        double num2 = Double.parseDouble(n2.getText().toString());

        if (num1!=0 && num2!=0 ){
            showToast();
            expandir();
            operacion();
        }else {
            mostrarDialogoPersonalizado();
        }
    }

    private void expandir() {
        desp1.setVisibility(View.VISIBLE);
        desp2.setVisibility(View.VISIBLE);
    }


    private void mostrarDialogoPersonalizado(){

        AlertDialog.Builder  bulder = new AlertDialog.Builder(Teoria_Colas_MMS.this);
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.advertencia2, null);
        bulder.setView(view);



        final AlertDialog dialog =  bulder.create();
        dialog.show();

        TextView txt = view.findViewById(R.id.text_dialog);
        txt.setText("Número 0 es invalido");

        Button btnAceptar = view.findViewById(R.id.btnAceptar);
        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

    }



}