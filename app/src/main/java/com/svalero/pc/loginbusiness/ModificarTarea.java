package com.svalero.pc.loginbusiness;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class ModificarTarea extends Activity implements OnClickListener {

    EditText et;
    Button btnActualizar, btnEliminar;

    long tarea_id;

    SQLControlador dbcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modificar_tarea);

        dbcon = new SQLControlador(this);
        dbcon.abrirBaseDeDatos();

        et = (EditText) findViewById(R.id.et_tarea_id);
        btnActualizar = (Button) findViewById(R.id.btnActualizar);
        btnEliminar = (Button) findViewById(R.id.btnEliminar);

        Intent i = getIntent();
        String tareaID = i.getStringExtra("tareaId");
        String tareaName = i.getStringExtra("tareaNombre");

        tarea_id = Long.parseLong(tareaID);

        et.setText(tareaName);

        btnActualizar.setOnClickListener(this);
        btnEliminar.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        switch (v.getId()) {
            case R.id.btnActualizar:
                String memName_upd = et.getText().toString();
                dbcon.actualizarDatos(tarea_id, memName_upd);
                this.returnHome();
                break;

            case R.id.btnEliminar:
                dbcon.deleteData(tarea_id);
                this.returnHome();
                break;
        }
    }

    public void returnHome() {

        Intent home_intent = new Intent(getApplicationContext(),
                MyActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        startActivity(home_intent);
    }
}