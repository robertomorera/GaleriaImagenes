package com.roberto.galeriafotografica.listeners;


import android.util.Log;
import android.view.View;
import com.roberto.galeriafotografica.activities.MainActivity;
import com.roberto.galeriafotografica.R;

/**
 * Created by PCCasa on 12/03/2017.
 * Listener para los floating buttons de la app.
 */

public class ListenerFloatingButton implements View.OnClickListener {


    private MainActivity mainActivity;

    public ListenerFloatingButton(MainActivity mainActivity) {

        this.mainActivity = mainActivity;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.fabLike:
                Log.d(getClass().getCanonicalName(),"El usuario ha pulsado el botón de me gusta");
                mainActivity.apuntarMeGusta();
                break;
            case R.id.fabDislike:
                Log.d(getClass().getCanonicalName(),"El usuario ha pulsado el botón de no me gusta");
                mainActivity.apuntarNoMeGusta();
                break;
        }
    }
}
