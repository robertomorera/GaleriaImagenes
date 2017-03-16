package com.roberto.galeriafotografica.listeners;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.MenuItem;
import com.roberto.galeriafotografica.utils.Constantes;
import com.roberto.galeriafotografica.activities.MainActivity;
import com.roberto.galeriafotografica.R;

/**
 * Created by PCCasa on 13/03/2017.
 * Listener para los distintos menus de la app.
 */

public class ListenerMenuItem implements MenuItem.OnMenuItemClickListener {

    private Context context;

    public ListenerMenuItem(Context context) {
        this.context = context;
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch(item.getItemId()){
            case R.id.menuValoraciones:
                Log.d(getClass().getCanonicalName(),"El usuario ha pulsado el menu de reiniciar las valoraciones");
                //Reiniciamos las valoraciones del usuario.
                reiniciarValoraciones();
                //Lanzamos un Intent para el MainActivity y reiniciar el paso de las fotografías.
                Intent intent= new Intent(context,MainActivity.class);
                Activity activity=(Activity)context;
                //Ejecutamos el intent a la actividad principal.
                activity.startActivity(intent);
                break;
        }
        return true;
    }

    /**
     * Método que reiniciar las valoraciones proporcionadas por el
     * usuario.
     */
    public void reiniciarValoraciones(){
        //Recuperamos el SharedPreferences con las valoraciones del usuario.
        Activity activity=(Activity) context;
        SharedPreferences sp=activity.getSharedPreferences("resultadosValoracion", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sp.edit();
        //Recorremos todas las claves para reiniciar las valoraciones.
        for(int i = 0; i< Constantes.NUM_FOTOGRAFIAS; i++){
            editor.putString("valoracion"+i,"");
        }
        //Guardamos las valoraciones.
        editor.commit();
    }

}
