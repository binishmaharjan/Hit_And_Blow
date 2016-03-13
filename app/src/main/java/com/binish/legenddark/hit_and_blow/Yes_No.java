package com.binish.legenddark.hit_and_blow;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

/**
 * Created by legenddark on 2016/01/14.
 */
public class Yes_No extends DialogFragment {
    LayoutInflater inflater;
    View view;
    GamePlay main;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        main=(GamePlay)getActivity();
        inflater = getActivity().getLayoutInflater();
        view = inflater.inflate(R.layout.yes_no_layout, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(view);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

               main.newGame();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });

        return  builder.create();
    }


}
