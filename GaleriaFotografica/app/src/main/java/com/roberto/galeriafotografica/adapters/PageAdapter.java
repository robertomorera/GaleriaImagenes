package com.roberto.galeriafotografica.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.roberto.galeriafotografica.activities.MainActivity;
import com.roberto.galeriafotografica.fragments.FragmentFotografia;
import com.roberto.galeriafotografica.utils.Constantes;

/**
 * Created by PCCasa on 12/03/2017.
 */

public class PageAdapter extends FragmentStatePagerAdapter {

    /**
     * Atributo que representa la galeria de fotos.
     */
    private int[] galeriaFotos;

    /**
     * Referencia a la actividad principal de la app.
     */
    private MainActivity mainActivity;

    /**
     * Constructor de la clase PageAdapter
     * @param fm
     * @param galeriaFotos
     * @param mainActivity
     */
    public PageAdapter(FragmentManager fm,int[] galeriaFotos,MainActivity mainActivity){
        super(fm);
        this.galeriaFotos=galeriaFotos;
        this.mainActivity=mainActivity;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment=null;
       //Construye los items que le proporciona al ViewPager.
        switch(position){
            case 0: fragment=new FragmentFotografia(galeriaFotos[0],mainActivity, Constantes.NOMBRES_FOTOGRAFIAS[0]);
                             break;
            case 1: fragment=new FragmentFotografia(galeriaFotos[1],mainActivity,Constantes.NOMBRES_FOTOGRAFIAS[1]);
                break;
            case 2: fragment=new FragmentFotografia(galeriaFotos[2],mainActivity,Constantes.NOMBRES_FOTOGRAFIAS[2]);
                break;
            case 3: fragment=new FragmentFotografia(galeriaFotos[3],mainActivity,Constantes.NOMBRES_FOTOGRAFIAS[3]);
                break;
            case 4: fragment=new FragmentFotografia(galeriaFotos[4],mainActivity,Constantes.NOMBRES_FOTOGRAFIAS[4]);
                break;
            case 5: fragment=new FragmentFotografia(galeriaFotos[5],mainActivity,Constantes.NOMBRES_FOTOGRAFIAS[5]);
                break;
            case 6: fragment=new FragmentFotografia(galeriaFotos[6],mainActivity,Constantes.NOMBRES_FOTOGRAFIAS[6]);
                break;
            case 7: fragment=new FragmentFotografia(galeriaFotos[7],mainActivity,Constantes.NOMBRES_FOTOGRAFIAS[7]);
                break;
            case 8: fragment=new FragmentFotografia(galeriaFotos[8],mainActivity,Constantes.NOMBRES_FOTOGRAFIAS[8]);
                break;
            case 9: fragment=new FragmentFotografia(galeriaFotos[9],mainActivity,Constantes.NOMBRES_FOTOGRAFIAS[9]);
                break;
            case 10: fragment=new FragmentFotografia(galeriaFotos[10],mainActivity,Constantes.NOMBRES_FOTOGRAFIAS[10]);
                break;
            case 11: fragment=new FragmentFotografia(galeriaFotos[11],mainActivity,Constantes.NOMBRES_FOTOGRAFIAS[11]);
                break;
            case 12: fragment=new FragmentFotografia(galeriaFotos[12],mainActivity,Constantes.NOMBRES_FOTOGRAFIAS[12]);
                break;
            case 13: fragment=new FragmentFotografia(galeriaFotos[13],mainActivity,Constantes.NOMBRES_FOTOGRAFIAS[13]);
                break;
            case 14: fragment=new FragmentFotografia(galeriaFotos[14],mainActivity,Constantes.NOMBRES_FOTOGRAFIAS[14]);
                break;
            case 15: fragment=new FragmentFotografia(galeriaFotos[15],mainActivity,Constantes.NOMBRES_FOTOGRAFIAS[15]);
                break;
            case 16: fragment=new FragmentFotografia(galeriaFotos[16],mainActivity,Constantes.NOMBRES_FOTOGRAFIAS[16]);
                break;
            case 17: fragment=new FragmentFotografia(galeriaFotos[17],mainActivity,Constantes.NOMBRES_FOTOGRAFIAS[17]);
                break;
            case 18: fragment=new FragmentFotografia(galeriaFotos[18],mainActivity,Constantes.NOMBRES_FOTOGRAFIAS[18]);
                break;
            case 19: fragment=new FragmentFotografia(galeriaFotos[19],mainActivity,Constantes.NOMBRES_FOTOGRAFIAS[19]);
                break;
            case 20: fragment=new FragmentFotografia(galeriaFotos[20],mainActivity,Constantes.NOMBRES_FOTOGRAFIAS[20]);
                break;
            case 21: fragment=new FragmentFotografia(galeriaFotos[21],mainActivity,Constantes.NOMBRES_FOTOGRAFIAS[21]);
                break;
            case 22: fragment=new FragmentFotografia(galeriaFotos[22],mainActivity,Constantes.NOMBRES_FOTOGRAFIAS[22]);
                break;
        }


        return fragment;
    }

    @Override
    public int getCount() {
        return Constantes.NUM_FOTOGRAFIAS;
    }
}

