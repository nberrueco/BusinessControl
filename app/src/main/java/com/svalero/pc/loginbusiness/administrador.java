package com.svalero.pc.loginbusiness;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.svalero.pc.loginbusiness.datos.RunningData;

public class administrador extends AppCompatActivity {

    private Button btnGeolocalizar;
    private Button btnEnviarGastos;
    private Button btnAverias;
    private Button btnEventos;
    private Button btnMensajeria;
    private Button btnRegistro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administrador);
        //
       btnEnviarGastos = (Button) findViewById(R.id.btnGastos);
        btnEnviarGastos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RunningData.setEstado(btnEnviarGastos.getText().toString());

                //para navegar entre pantallas INTENT
                Intent navegar = new Intent(getBaseContext(),GastosadminActivity.class);
                startActivity(navegar);

            }
        });
        //
        btnAverias = (Button) findViewById(R.id.btnAverias);
        btnAverias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //work
                RunningData.setEstado(btnAverias.getText().toString());
                Intent navegar = new Intent(getBaseContext(),AveriasAdminActivity.class);
                startActivity(navegar);
            }
        });
        //
        btnEventos = (Button) findViewById(R.id.btnEventos);
        btnEventos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RunningData.setEstado(btnEventos.getText().toString());
                Intent navegar = new Intent(getBaseContext(), MyActivity.class);
                startActivity(navegar);
            }
        });
        //work
        btnMensajeria = (Button) findViewById(R.id.btnMensajeria);
        btnMensajeria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RunningData.setEstado(btnMensajeria.getText().toString());
                Intent navegar = new Intent(getBaseContext(), mensajeriaAdminActivity.class);
                startActivity(navegar);
            }
        });
        //wrk
        btnRegistro = (Button) findViewById(R.id.btnRegistro);
        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RunningData.setEstado(btnRegistro.getText().toString());
                Intent navegar = new Intent(getBaseContext(), SignUp.class);
                startActivity(navegar);

                /*
                *
                * Intent i = new Intent(MainActivity.this, SignUp.class);
            startActivity(i);*/
            }
        });
        //
        btnGeolocalizar = (Button) findViewById(R.id.btnGeolocalizar);
        btnGeolocalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RunningData.setEstado(btnGeolocalizar.getText().toString());
                Intent navegar = new Intent(getBaseContext(), MainActivity.class);
                startActivity(navegar);
            }
        });
    }}