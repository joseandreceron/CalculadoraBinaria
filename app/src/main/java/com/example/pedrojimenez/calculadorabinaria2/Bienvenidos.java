package com.example.pedrojimenez.calculadorabinaria2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Bienvenidos extends AppCompatActivity {

    public Button conectar;
    public Button btninfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenidos);
        conectar=(Button) findViewById(R.id.conectar);
        conectar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent J=new Intent(Bienvenidos.this,Operation.class);
                Bienvenidos.this.startActivity(J);
            }
        });

    }

}
