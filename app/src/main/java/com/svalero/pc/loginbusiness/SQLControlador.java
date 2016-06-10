package com.svalero.pc.loginbusiness;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class SQLControlador {

    private DBhelper dbhelper;
    private Context ourcontext;
    private SQLiteDatabase database;

    public SQLControlador(Context c) {
        ourcontext = c;
    }

    public SQLControlador abrirBaseDeDatos() throws SQLException {
        dbhelper = new DBhelper(ourcontext);
        database = dbhelper.getWritableDatabase();
        return this;
    }

    public void cerrar() {
        dbhelper.close();
    }

    public void insertarDatos(String name) {
        ContentValues cv = new ContentValues();
        cv.put(DBhelper.TAREA_NOMBRE, name);
        database.insert(DBhelper.TABLE_TAREA, null, cv);
    }

    public Cursor leerDatos() {
        String[] todasLasColumnas = new String[] {
                DBhelper.TAREA_ID,
                DBhelper.TAREA_NOMBRE
        };
        Cursor c = database.query(DBhelper.TABLE_TAREA, todasLasColumnas, null,
                null, null, null, null);
        if (c != null) {
            c.moveToFirst();
        }
        return c;
    }

    public int actualizarDatos(long tareaID, String tareaName) {
        ContentValues cvActualizar = new ContentValues();
        cvActualizar.put(DBhelper.TAREA_NOMBRE, tareaName);
        int i = database.update(DBhelper.TABLE_TAREA, cvActualizar,
                DBhelper.TAREA_ID + " = " + tareaID, null);
        return i;
    }

    public void deleteData(long tareaID) {
        database.delete(DBhelper.TABLE_TAREA, DBhelper.TAREA_ID + "="
                + tareaID, null);
    }
}