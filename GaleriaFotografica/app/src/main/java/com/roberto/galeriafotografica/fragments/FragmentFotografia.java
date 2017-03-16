package com.roberto.galeriafotografica.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.roberto.galeriafotografica.activities.MainActivity;
import com.roberto.galeriafotografica.R;
import com.roberto.galeriafotografica.listeners.ListenerFloatingButton;

/**
 * Created by PCCasa on 12/03/2017.
 * Fragment que representa una fotografia del carrusel
 * con los botones de valoracion para el usuario.
 */

public class FragmentFotografia extends Fragment {

    /**
     * Referencia a la fotografia.
     */
    private int fotografia;
    /**
     * Regferencia a la actividad principal de la app
     */
    private MainActivity mainActivity;
    /**
     * Nombre de la fotografía.
     */
    private String nombreFoto;

    public FragmentFotografia(){}

    /**
     * Constructor de la clase FragmentFotografia
     * @param fotografia
     * @param mainActivity
     * @param nombreFoto
     */
    public FragmentFotografia(int fotografia,MainActivity mainActivity,String nombreFoto){
        super();
        this.fotografia=fotografia;
        this.mainActivity=mainActivity;
        this.nombreFoto=nombreFoto;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_fotografia,container,false);
        //Obtenemos la referencia del ImageView del fragment.
        ImageView imagenFotografia=(ImageView)view.findViewById(R.id.fotografia);
        //Obtenemos la referencia de los Floating Buttons.
        FloatingActionButton fabLike=(FloatingActionButton)view.findViewById(R.id.fabLike);
        fabLike.setBackgroundTintList(getResources().getColorStateList(R.color.colorFabLike));
        FloatingActionButton fabDislike=(FloatingActionButton)view.findViewById(R.id.fabDislike);
        fabDislike.setBackgroundTintList(getResources().getColorStateList(R.color.colorFabDislike));
        //Seteamos la fotografia.
        imagenFotografia.setImageResource(fotografia);
        //Obtenemos la referencias del TextView.
        TextView txtNombreFoto=(TextView)view.findViewById(R.id.txtNombreFoto);
        txtNombreFoto.setText(nombreFoto);
        return view;
    }

    /**
     * Se ejecuta la actividad cuando se recrea la actividad donde se pinta
     * el FramgmentFotografia.
     * @param savedInstanceState
     */
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //Recuperamos los floating button para permitir al usuario dar su opinion
        FloatingActionButton fabLike=(FloatingActionButton)getView().findViewById(R.id.fabLike);
        FloatingActionButton fabDislike=(FloatingActionButton)getView().findViewById(R.id.fabDislike);
        //Asociamos el listener a los botones.
        fabLike.setOnClickListener(new ListenerFloatingButton(mainActivity));
        fabDislike.setOnClickListener(new ListenerFloatingButton(mainActivity));

    }


}
