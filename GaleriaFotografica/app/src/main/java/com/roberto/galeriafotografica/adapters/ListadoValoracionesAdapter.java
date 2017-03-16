package com.roberto.galeriafotografica.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.roberto.galeriafotografica.R;
import com.roberto.galeriafotografica.utils.Constantes;

/**
 * Created by PCCasa on 12/03/2017.
 */

public class ListadoValoracionesAdapter extends BaseAdapter {
    /**
     * Atributo que representa el  contexto de la app.
     */
    private Context context;

    /** Galeria de fotos**/
    private final int[] galeriaFotos={R.drawable.imagen_ny,R.drawable.imagen_londres,R.drawable.imagen_paris,R.drawable.imagen_roma,R.drawable.imagen_praga,R.drawable.imagen_madrid,
            R.drawable.imagen_amsterdam,R.drawable.imagen_barcelona,R.drawable.imagen_berlin,R.drawable.imagen_kyoto,R.drawable.imagen_bruselas,R.drawable.imagen_budapest,R.drawable.imagen_pekin,
            R.drawable.imagen_edimburgo,R.drawable.imagen_habana,R.drawable.imagen_dubai,R.drawable.imagen_copenhague,R.drawable.imagen_lisboa,R.drawable.imagen_cartagena,R.drawable.imagen_viena,
            R.drawable.imagen_estambul,R.drawable.imagen_moscu};

    /**
     * Constructor de la clase ListadoValoracionesAdapter
     * @param context
     */
    public ListadoValoracionesAdapter(Context context){

        this.context=context;
    }

    @Override
    public int getCount() {
        return Constantes.NUM_FOTOGRAFIAS;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
         View filaInflada=null;
        Activity activity=(Activity)context;
        Log.d(getClass().getCanonicalName(),"Entrada al método getView() se añade el elemento en la posición "+position);
        if(convertView==null){
            Log.d(getClass().getCanonicalName(),"Creamos la vista de nuevo");
            LayoutInflater layoutInflater=activity.getLayoutInflater();
            //Inflamos la vista.
            filaInflada=layoutInflater.inflate(R.layout.fila,parent,false);
        }else{
            Log.d(getClass().getCanonicalName(),"Reciclamos la vista");
            filaInflada=convertView;
        }
        //Obtenemos los elementos de la fila inflada para personalizarlos.
        TextView  textoFoto=(TextView)filaInflada.findViewById(R.id.txtFoto);
        ImageView imagenValoracion=(ImageView)filaInflada.findViewById(R.id.imagenValoracion);
        //Ponemos el nombre de la fotografía.
        textoFoto.setText(Constantes.NOMBRES_FOTOGRAFIAS[position]);
        //Obtenemos las valoración del usuario asociada a la foto.
        SharedPreferences sp=activity.getSharedPreferences("resultadosValoracion", Context.MODE_PRIVATE);
        String valoracion=sp.getString("valoracion"+position,"");
        //Ponemos la imagen asociada a cada tipo de valoración del usuario.
        if(valoracion.equals(Constantes.VALORACION_POSITIVA)) {
            imagenValoracion.setImageResource(R.drawable.valoracion_positiva);
        }else if(valoracion.equals(Constantes.VALORACION_NEGATIVA)){
            imagenValoracion.setImageResource(R.drawable.valoracion_negativa);

        }else{
            imagenValoracion.setImageResource(R.drawable.ic_remove_black_24dp);
        }

        return filaInflada;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
}
