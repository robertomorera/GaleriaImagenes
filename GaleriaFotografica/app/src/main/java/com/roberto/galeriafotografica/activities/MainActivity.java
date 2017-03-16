package com.roberto.galeriafotografica.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import com.roberto.galeriafotografica.utils.Constantes;
import com.roberto.galeriafotografica.adapters.PageAdapter;
import com.roberto.galeriafotografica.R;

/**
 * Activity que representa la galeria de fotografías
 */
public class MainActivity extends AppCompatActivity {

    /** Referencia al elemento que permitirá la animacion de la galeria de fotos.**/
    private ViewPager viewPager;

    /** Sumunistra las fotos al viewPager **/
    private PageAdapter pageAdapter;

    /** Galeria de fotos**/
    private final int[] galeriaFotos={R.drawable.imagen_ny,R.drawable.imagen_londres,R.drawable.imagen_paris,R.drawable.imagen_roma,R.drawable.imagen_praga,R.drawable.imagen_madrid,
    R.drawable.imagen_amsterdam,R.drawable.imagen_barcelona,R.drawable.imagen_berlin,R.drawable.imagen_kyoto,R.drawable.imagen_bruselas,R.drawable.imagen_budapest,R.drawable.imagen_pekin,
    R.drawable.imagen_edimburgo,R.drawable.imagen_habana,R.drawable.imagen_dubai,R.drawable.imagen_copenhague,R.drawable.imagen_lisboa,R.drawable.imagen_cartagena,R.drawable.imagen_viena,
            R.drawable.imagen_estambul,R.drawable.imagen_moscu};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Obtenemos la referencia del ViewPager.
        viewPager=(ViewPager)findViewById(R.id.pagerFotografias);
        //Creamos el adaptado para proporcionar al ViewPager los fragemnts del carrusel de fotos.
        FragmentManager fm=getSupportFragmentManager();
        pageAdapter=new PageAdapter(fm,galeriaFotos,this);
       //Asociamos el adapter al ViewPager.
        viewPager.setAdapter(pageAdapter);

    }

    /**
     * Método que apunta la valoración positiva de una foto
     * en el SharedPrefenrences de valoraciones de usuario.
     */
    public void apuntarMeGusta(){
        //Guardamos la valoración positiva del usuario.
        SharedPreferences sp=getSharedPreferences("resultadosValoracion", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sp.edit();
        editor.putString("valoracion"+viewPager.getCurrentItem(), Constantes.VALORACION_POSITIVA);
        Log.d(getClass().getCanonicalName(),"El usuario ha dado a me gusta a la foto de "+Constantes.NOMBRES_FOTOGRAFIAS[viewPager.getCurrentItem()]);
        editor.commit();
        if(viewPager.getCurrentItem()==Constantes.NUM_FOTOGRAFIAS-1) {
             //El usuario ha terminado de valorar el carrusel de fotografias se le mostraran los resultados.
            Intent intent=new Intent(this,ReporteValoracionActivity.class);
            //Lanzamos el intent del reporte de valoraciones del carrusel de fotos.
            startActivity(intent);
        }else{
            //Pasamos a la siguiente fotografia a valorar.
            viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
        }

    }

    /**
     * Método que apunta la valoración negativa de una foto
     * en el SharedPrefenrences de valoraciones de usuario.
     */

    public void apuntarNoMeGusta(){
        //Guardamos la valoración negativa del usuario.
        SharedPreferences sp=getSharedPreferences("resultadosValoracion", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sp.edit();
        editor.putString("valoracion"+viewPager.getCurrentItem(),Constantes.VALORACION_NEGATIVA);
        Log.d(getClass().getCanonicalName(),"El usuario ha dado a no me gusta a la foto de "+Constantes.NOMBRES_FOTOGRAFIAS[viewPager.getCurrentItem()]);
        editor.commit();
        if(viewPager.getCurrentItem()==Constantes.NUM_FOTOGRAFIAS-1) {
            //El usuario ha terminado de valorar el carrusel de fotografias se le mostraran los resultados.
            Intent intent=new Intent(this,ReporteValoracionActivity.class);
            //Lanzamos el intent del reporte de valoraciones del carrusel de fotos.
            startActivity(intent);
        }else{
            //Pasamos a la siguiente fotografia a valorar.
            viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
        }
    }


}
