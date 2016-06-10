package com.svalero.pc.loginbusiness;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.svalero.pc.loginbusiness.datos.RunningData;

/**
 * Created by PC on 11/02/2016.
 */
public class empleado2 extends AppCompatActivity {
    private TextView txtConfig;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actionadmin);

        //Tengo que recibir el valor seleccionado
        //en la primera pantalla
        String estado= RunningData.getEstado();
        //config
        txtConfig=(TextView)findViewById(R.id.txtConfig);
        txtConfig.setText(txtConfig.getText().toString()+estado);
    }

}

