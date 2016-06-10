package com.svalero.pc.loginbusiness;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class MyActivity extends ActionBarActivity {

    Button btnAgregarTarea;
    ListView lista;
    SQLControlador dbconeccion;
    TextView tv_miemID, tv_miemNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        dbconeccion = new SQLControlador(this);
        dbconeccion.abrirBaseDeDatos();
        btnAgregarTarea = (Button) findViewById(R.id.btnAgregarTarea);
        lista = (ListView) findViewById(R.id.listViewTareas);

        //acción del boton agregar TAREA
        btnAgregarTarea.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iagregar = new Intent(MyActivity.this, AgregarTarea.class);
                startActivity(iagregar);
            }
        });

        // Tomar los datos desde la base de datos para poner en el curso y después en el adapter
        Cursor cursor = dbconeccion.leerDatos();

        String[] from = new String[] {
                DBhelper.TAREA_ID,
                DBhelper.TAREA_NOMBRE
        };
        int[] to = new int[] {
                R.id.tarea_id,
                R.id.tarea_nombre
        };

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(
                MyActivity.this, R.layout.formato_fila, cursor, from, to);

        adapter.notifyDataSetChanged();
        lista.setAdapter(adapter);

        // acción cuando hacemos click en item para poder modificarlo o eliminarlo
        lista.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View view, int position, long id) {

                tv_miemID = (TextView) view.findViewById(R.id.tarea_id);
                tv_miemNombre = (TextView) view.findViewById(R.id.tarea_nombre);

                String aux_tareaId = tv_miemID.getText().toString();
                String aux_tareaNombre = tv_miemNombre.getText().toString();

                Intent modify_intent = new Intent(getApplicationContext(), ModificarTarea.class);
                modify_intent.putExtra("tareaId", aux_tareaId);
                modify_intent.putExtra("tareaNombre", aux_tareaNombre);
                startActivity(modify_intent);
            }
        });
    }  //termina el onCreate
} //termina clase