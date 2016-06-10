package com.svalero.pc.loginbusiness;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.svalero.pc.loginbusiness.datos.RunningData;

/**
 * Created by PC on 11/02/2016.
 */
public class empleado extends AppCompatActivity {
    private Button btnRutas;
    private Button btnEnviarGastos;
    private Button btnAverias;
    private Button btnEventos;
    private Button btnMensajeria;
    private Button btnChat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empleado);
        //
        btnEnviarGastos = (Button) findViewById(R.id.btnGastosEmple);
        btnEnviarGastos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RunningData.setEstado(btnEnviarGastos.getText().toString());
                //para navegar entre pantallas INTENT
                Intent navegar = new Intent(getBaseContext(),administrador2.class);
                startActivity(navegar);
            }
        });
        //
        btnAverias = (Button) findViewById(R.id.btnAveriasemple);
        btnAverias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RunningData.setEstado(btnAverias.getText().toString());
                Intent navegar = new Intent(getBaseContext(),administrador2.class);
                startActivity(navegar);
            }
        });
        //
        btnEventos = (Button) findViewById(R.id.btnEventosemple);
        btnEventos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RunningData.setEstado(btnEventos.getText().toString());
                Intent navegar = new Intent(getBaseContext(), administrador2.class);
                startActivity(navegar);
            }
        });
        //
        btnMensajeria = (Button) findViewById(R.id.btnMensajeriaEmple);
        btnMensajeria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RunningData.setEstado(btnMensajeria.getText().toString());
                Intent navegar = new Intent(getBaseContext(), administrador2.class);
                startActivity(navegar);
            }
        });
        //
        btnChat = (Button) findViewById(R.id.btnChatemple);
        btnChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RunningData.setEstado(btnChat.getText().toString());
                Intent navegar = new Intent(getBaseContext(), administrador2.class);
                startActivity(navegar);
            }
        });
        //
        btnRutas = (Button) findViewById(R.id.btnCalcularRutasemple);
        btnRutas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RunningData.setEstado(btnRutas.getText().toString());
                Intent navegar = new Intent(getBaseContext(), administrador2.class);
                startActivity(navegar);
            }
        });
    }}

