package com.example.pedrojimenez.calculadorabinaria2;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Stack;

public class Operation extends AppCompatActivity implements View.OnClickListener  {
    public Button sumar;
    public Button multiplicar,complemento;
    public Button paridad;
    public Button restar;
    public EditText numero1;
    public EditText numero2;
    public TextView resultado,resultado2;
    TextView binario, binario1, decimal, rotar2,rotar3,rotar4,complemento1,complemento2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_operation);

        if (getSupportActionBar()!=null){

            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        sumar=(Button) findViewById(R.id.sumar);
                multiplicar=(Button) findViewById(R.id.multiplicar);
                restar=(Button) findViewById(R.id.restar);
                complemento=(Button) findViewById(R.id.complemento);
                paridad=(Button) findViewById(R.id.paridad);
                numero1=(EditText) findViewById(R.id.numero1);
                numero2=(EditText) findViewById(R.id.numero2);
                resultado=(TextView) findViewById(R.id.resultado);
                resultado2=(TextView) findViewById(R.id.resultado2);
                binario=(TextView) findViewById(R.id.binario);
                binario1=(TextView) findViewById(R.id.binario1);
                rotar4=(TextView) findViewById(R.id.rotar4);
                rotar3=(TextView) findViewById(R.id.rotar3);
                sumar.setOnClickListener(this);
                multiplicar.setOnClickListener(this);
                restar.setOnClickListener(this);
                paridad.setOnClickListener(this);
                decimal=(TextView)findViewById(R.id.decimal);
                complemento1=(TextView)findViewById(R.id.complemento1);
                complemento2=(TextView)findViewById(R.id.complemento2);
                rotar2=(TextView)findViewById(R.id.rotar2);

        numero1.setFilters(new InputFilter[] {
                new InputFilter() {
                    String numericCharacters = "0123456789";
                    @Override
                    public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
                        if (source != null && !numericCharacters.contains((source.toString()))) {
                            return "";
                        }
                        return null;
                    }
                }
        });
        numero2.setFilters(new InputFilter[] {
                new InputFilter() {
                    String numericCharacters = "0123456789";
                    @Override
                    public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
                        if (source != null && !numericCharacters.contains((source.toString()))) {
                            return "";
                        }
                        return null;
                    }
                }
        });
    }


    public void sumar(){
        String num1= numero1.getText().toString();
        String num2= numero2.getText().toString();
        int entero1=Integer.parseInt(num1);
        int entero2=Integer.parseInt(num2);
        String numero12;
        String klk="...........";
        String klk2="..........";
        int residuo=entero1%2;
        boolean esBinario;
        if (TextUtils.isEmpty(num1)|| TextUtils.isEmpty(num2)){
            //email is empty
            Toast.makeText(this,"Please introduzca su numero entero",Toast.LENGTH_SHORT).show();
            return;

        }else {
            if(entero1<5 || entero1>10000|| entero2<5 || entero2>10000) {
                Toast.makeText(this,"Please introduzca un numero entre 5 y 10000",Toast.LENGTH_SHORT).show();
                return;
            }else{
                num1=(Integer.toBinaryString(entero1));
                num2=(Integer.toBinaryString(entero2));
                mostrarBinario(num1,num2);
                mostrarResultado2(klk);
                mostrarRotard(klk,klk2);
                mostrarRotar(klk);

            }
        }


        if(residuo==0) {
            int sum = entero1 + entero2;
            numero12=(Integer.toBinaryString(sum));
            mostrar(sum);
            mostrarResultado(numero12);
        }else{
            mostrarResultado(klk);
            Toast.makeText(this, "El primer decimal introducido no es par para hacer la Suma",Toast.LENGTH_SHORT).show();
            return;
        }
    }
    public void multiplicar(){
        String num1= numero1.getText().toString();
        String num2= numero2.getText().toString();
        long entero1=Long.parseLong(num1);
        long entero2=Long.parseLong(num2);
        String numero12,cadena,a,b,c;
        Long decimal7;
        String klk="...........";
        String klk2="..........";
        long decimal,exponente,digito;
        long residuo;
        if (TextUtils.isEmpty(num1)|| TextUtils.isEmpty(num2)){

            Toast.makeText(this,"Please introduzca su numero entero",Toast.LENGTH_SHORT).show();
            return;

        }else {
            if(entero1<5 || entero1>10000|| entero2<5 || entero2>10000) {
                Toast.makeText(this,"Please introduzca un numero entre 5 y 10000",Toast.LENGTH_SHORT).show();
                return;
            }else{
                num1=(Long.toBinaryString(entero1));
                num2=(Long.toBinaryString(entero2));
                mostrarBinario(num1,num2);
                mostrarResultado2(klk);
                mostrarRotard(klk,klk2);
                mostrarComplemento(klk,klk2);

            }
        }
        cadena = String.valueOf(num2);
        a=cadena.substring(0,2);
        b=cadena.substring(2,num2.length());
        c=b+a;
        mostrarRotar(c);

        decimal7=Long.parseLong(c);
        exponente = 0;
        decimal = 0; //será el equivalente en base decimal
        while (decimal7 != 0) {

            digito = decimal7 % 10;
            decimal = decimal + digito * (int) Math.pow(2, exponente);
            exponente++;
            decimal7 = decimal7 / 10;
        }
        residuo=decimal%2;

        if(residuo==0) {
            Toast.makeText(this, "No procederemos a multiplicar, El numero rotado no es impar seguiremos con el programa",Toast.LENGTH_SHORT).show();
            return;
        }else{
            long sum = entero1 * decimal;
            numero12=(Long.toBinaryString(sum));
            mostrar(sum);
            mostrarResultado(numero12);

        }
    }
    public void complemento(){
        String num1= numero1.getText().toString();
        String num2= numero2.getText().toString();
        long entero1=Long.parseLong(num1);
        long entero2=Long.parseLong(num2);
        String cadena3,cadena2,d,e,f,j,g,h,i,k;
        long decimal7, decimal8,suma;
        String klk="...........";
        long decimal,exponente,digito,decimal1,digito1,exponente1;
        if (TextUtils.isEmpty(num1)|| TextUtils.isEmpty(num2)){
            //email is empty
            Toast.makeText(this,"Please introduzca su numero entero",Toast.LENGTH_SHORT).show();
            return;

        }else {
            if(entero1<5 || entero1>10000|| entero2<5 || entero2>10000) {
                Toast.makeText(this,"Please introduzca un numero entre 5 y 10000",Toast.LENGTH_SHORT).show();
                return;
            }else{
                num1=(Long.toBinaryString(entero1));
                num2=(Long.toBinaryString(entero2));
                mostrarBinario(num1,num2);
                mostrarRotar(klk);
                mostrarResultado(klk);
                mostrarResultado2(klk);

            }
        }
        cadena2 = String.valueOf(num1);
        g=cadena2.substring(num1.length()-1,num1.length());
        h=cadena2.substring(0,num1.length()-1);
        i=g+h;
        k=i;

        cadena3 = String.valueOf(num2);
        d=cadena3.substring(num2.length()-1,num2.length());
        e=cadena3.substring(0,num2.length()-1);

        f=d+e;
        j=f;

       mostrarRotard(i,f);

        decimal7=Long.parseLong(i);
        exponente = 0;
        decimal = 0; //será el equivalente en base decimal
        while (decimal7 != 0) {

            digito = decimal7 % 10;
            decimal = decimal + digito * (long) Math.pow(2, exponente);
            exponente++;
            decimal7 = decimal7 / 10;
        }

        decimal8=Long.parseLong(f);
        exponente1 = 0;
        decimal1 = 0; //será el equivalente en base decimal
        while (decimal8 != 0) {

            digito1 = decimal8 % 10;
            decimal1 = decimal1 + digito1 * (long) Math.pow(2, exponente1);
            exponente1++;
            decimal8 = decimal8 / 10;
        }
        suma=decimal+decimal1;
        mostrar(suma);

        if(suma<12) {
            Toast.makeText(this, "No procederemos a encontrar el complemento, la suma de los decimales es menor que 12,seguiremos con el programa",Toast.LENGTH_SHORT).show();
            return;
        }else{
            k= k.replace('1', 'a').replace('0', 'b').replace('a','0').replace('b', '1');
            j= j.replace('1', 'a').replace('0', 'b').replace('a','0').replace('b', '1');
            mostrarComplemento(k,j);

        }

    }
    public void restar(){
        String num1= numero1.getText().toString();
        String num2= numero2.getText().toString();
        long entero1=Long.parseLong(num1);
        long entero2=Long.parseLong(num2);
        String numero12;
        String cadena3,cadena2,d,e,f,j,g,h,i,k;
        long decimal7, decimal8,suma;
        String klk="...........";
        long contador=0,aumento=0,aumento1=0,contador1=0;
        long decimal,exponente,digito,decimal1,digito1,exponente1;

        boolean esBinario;
        if (TextUtils.isEmpty(num1)|| TextUtils.isEmpty(num2)){
            //email is empty
            Toast.makeText(this,"Please introduzca su numero entero",Toast.LENGTH_SHORT).show();
            return;

        }else {
            if(entero1<5 || entero1>10000|| entero2<5 || entero2>10000) {
                Toast.makeText(this,"Please introduzca un numero entre 5 y 10000",Toast.LENGTH_SHORT).show();
                return;
            }else{
                num1=(Long.toBinaryString(entero1));
                num2=(Long.toBinaryString(entero2));
                mostrarBinario(num1,num2);


            }
        }
        cadena2 = String.valueOf(num1);
        g=cadena2.substring(num1.length()-1,num1.length());
        h=cadena2.substring(0,num1.length()-1);
        i=g+h;
        k=i;

        cadena3 = String.valueOf(num2);
        d=cadena3.substring(num2.length()-1,num2.length());
        e=cadena3.substring(0,num2.length()-1);

        f=d+e;
        j=f;
        mostrarRotard(klk,klk);

        k= k.replace('1', 'a').replace('0', 'b').replace('a','0').replace('b', '1');
        j= j.replace('1', 'a').replace('0', 'b').replace('a','0').replace('b', '1');
        mostrarComplemento(k,j);

        decimal7=Long.parseLong(k);
        exponente = 0;
        decimal = 0; //será el equivalente en base decimal
        while (decimal7 != 0) {

            digito = decimal7 % 10;
            decimal = decimal + digito * (long) Math.pow(2, exponente);
            exponente++;
            decimal7 = decimal7 / 10;
        }

        decimal8=Long.parseLong(j);
        exponente1 = 0;
        decimal1 = 0; //será el equivalente en base decimal
        while (decimal8 != 0) {

            digito1 = decimal8 % 10;
            decimal1 = decimal1 + digito1 * (long) Math.pow(2, exponente1);
            exponente1++;
            decimal8 = decimal8 / 10;
        }
        long residuo1=decimal1%2;
        mostrar(decimal1);
        if (residuo1==0) {
          long restar=decimal-decimal1;
            String res4;
            res4=(Long.toBinaryString(restar));
            mostrarResultado(res4);

        }else{
            Toast.makeText(this, "No procederemos a encontrar la sustracion, el complemento del numero 2 no es par,seguiremos con el programa",Toast.LENGTH_SHORT).show();
            return;
        }
    }
    public void paridad(){
        String num1= numero1.getText().toString();
        String num2= numero2.getText().toString();
        long entero1=Long.parseLong(num1);
        long entero2=Long.parseLong(num2);
        String cadena3,cadena2,d,e,f,j,g,h,i,k;
        long decimal7, decimal8,suma;
        String klk="...........";
        int contador=0,aumento=0,aumento1=0,contador1=0;
        long decimal,exponente,digito,decimal1,digito1,exponente1;
        if (TextUtils.isEmpty(num1)|| TextUtils.isEmpty(num2)){
            //email is empty
            Toast.makeText(this,"Please introduzca su numero entero",Toast.LENGTH_SHORT).show();
            return;

        }else {
            if(entero1<5 || entero1>10000|| entero2<5 || entero2>10000) {
                Toast.makeText(this,"Please introduzca un numero entre 5 y 10000",Toast.LENGTH_SHORT).show();
                return;
            }else{
                num1=(Long.toBinaryString(entero1));
                num2=(Long.toBinaryString(entero2));
                mostrarBinario(num1,num2);
                mostrarRotar(klk);
                mostrarRotard(klk,klk);

            }
        }
        cadena2 = String.valueOf(num1);
        g=cadena2.substring(num1.length()-1,num1.length());
        h=cadena2.substring(0,num1.length()-1);
        i=g+h;
        k=i;

        cadena3 = String.valueOf(num2);
        d=cadena3.substring(num2.length()-1,num2.length());
        e=cadena3.substring(0,num2.length()-1);

        f=d+e;
        j=f;
         mostrarRotard(i,f);

            k= k.replace('1', 'a').replace('0', 'b').replace('a','0').replace('b', '1');
            j= j.replace('1', 'a').replace('0', 'b').replace('a','0').replace('b', '1');
        mostrarComplemento(k,j);

        decimal7=Long.parseLong(k);
        exponente = 0;
        decimal = 0; //será el equivalente en base decimal
        while (decimal7 != 0) {

            digito = decimal7 % 10;
            decimal = decimal + digito * (long) Math.pow(2, exponente);
            exponente++;
            decimal7 = decimal7 / 10;
        }

        decimal8=Long.parseLong(j);
        exponente1 = 0;
        decimal1 = 0; //será el equivalente en base decimal
        while (decimal8 != 0) {

            digito1 = decimal8 % 10;
            decimal1 = decimal1 + digito1 * (long) Math.pow(2, exponente1);
            exponente1++;
            decimal8 = decimal8 / 10;
        }
        long suma4=decimal+decimal1;
        mostrar(suma4);
        long sumarr=suma4%4;
           if (sumarr==0){
               while (contador < num1.length()){
                   if (num1.substring(contador,contador+1) .equals("1")){
                       aumento=aumento+1;
                   }else{
                       aumento=aumento+0;
                   }
                   contador = contador + 1;}

               //siguiendo con la paridad
               if(aumento%2==0){
                 mostrarResultado3(k);
               }else{
                   mostrarResultado(k);
               }

               while (contador1 < num2.length()){
                   if (num2.substring(contador1,contador1+1) .equals("1")){
                       aumento1=aumento1+1;
                   }else{
                       aumento1=aumento1+0;
                   }
                   contador1 = contador1 + 1;}

               //siguiendo con la paridad
               if(aumento1%2==0){
                   mostrarResultado4(j);
               }else{
                   mostrarResultado2(j);
               }


           }else{
               Toast.makeText(this, "No procederemos a encontrar la paridad, la suma de los decimales no es multiplo de 4,seguiremos con el programa",Toast.LENGTH_SHORT).show();
               return;
           }

    }

    public void mostrar(long resultado1){
        decimal.setText(""+resultado1);
    }

    public void mostrarBinario(String resultado44, String resultado45){
        binario.setText(""+resultado44);
        binario1.setText(""+resultado45);
    }
    public void mostrarResultado(String numero35){
        resultado.setText(""+numero35);
    }
    public void mostrarResultado2(String numero35){
        resultado2.setText(""+numero35);
    }
    public void mostrarRotar(String rotar){
        rotar2.setText(""+rotar);
    }
    public void mostrarResultado3(String numero35){
        resultado.setText(""+numero35+1);
    }
    public void mostrarResultado4(String numero35){
        resultado2.setText(""+numero35+1);
    }
    public void mostrarRotard(String resultado45, String resultado46){
        rotar3.setText(""+resultado45);
        rotar4.setText(""+resultado46);}
    public void mostrarComplemento(String resultado44, String resultado45){
        complemento1.setText(""+resultado44);
        complemento2.setText(""+resultado45);}
    @Override
    public void onClick(View v) {

        if (v==sumar){
            sumar();
        }
        if (v==restar){
            restar();
        }
        if (v==multiplicar){
            multiplicar();
        }
        if (v==complemento){
            complemento();
        }
        if (v==paridad){
            paridad();
        }

    }
    public boolean onOptionsItemSelected(MenuItem item){
        if (item.getItemId()==android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);

    }
}

