package com.roberto.galeriafotografica.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import com.roberto.galeriafotografica.adapters.ListadoValoracionesAdapter;
import com.roberto.galeriafotografica.R;
import com.roberto.galeriafotografica.listeners.ListenerMenuItem;

/**
 * Activity que representa las valoraciones del usuario
 */
public class ReporteValoracionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reporte_valoracion);
        //Obtenemos el ListView.
        ListView listadoValoraciones=(ListView)findViewById(R.id.listadoValoraciones);
        //Creamos el adaptador.
        ListadoValoracionesAdapter listadoValoracionesAdapter=new ListadoValoracionesAdapter(this);
        //Asignamos el adapter al ListView.
        listadoValoraciones.setAdapter(listadoValoracionesAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_layout,menu);
        //Obtenemos el item asociado al menu.
        MenuItem menuItem=menu.getItem(0);
        //Creamos su listener.
        ListenerMenuItem listenerMenuItem=new ListenerMenuItem(this);
        //Asociamos el listener del menu al item.
        menuItem.setOnMenuItemClickListener(listenerMenuItem);
        return true;
    }
}
