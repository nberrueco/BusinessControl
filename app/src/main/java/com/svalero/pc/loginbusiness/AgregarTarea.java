package com.svalero.pc.loginbusiness;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class AgregarTarea extends Activity implements OnClickListener {
    EditText et;
    Button btnAgregar, read_bt;
    SQLControlador dbconeccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.agregar_tarea);
        et = (EditText) findViewById(R.id.et_tarea_id);
        btnAgregar = (Button) findViewById(R.id.btnAgregarId);

        dbconeccion = new SQLControlador(this);
        dbconeccion.abrirBaseDeDatos();
        btnAgregar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        switch (v.getId()) {
            case R.id.btnAgregarId:
                String name = et.getText().toString();
                dbconeccion.insertarDatos(name);
                Intent main = new Intent(AgregarTarea.this, MyActivity.class)
                        .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(main);
                break;

            default:
                break;
        }
    }
}