package com.binish.legenddark.hit_and_blow;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RadioGroup;

/**
 * Created by 3586 on 2016/01/15.
 */
public class LevelChooser extends DialogFragment implements RadioGroup.OnCheckedChangeListener{

    RadioGroup level_chooser_group;
    LayoutInflater inflater;
    View view;
    GamePlay gamePlay;
    int lvl;


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        inflater = getActivity().getLayoutInflater();
        view = inflater.inflate(R.layout.level_chooser_layout, null);
        lvl = 3;
        level_chooser_group = (RadioGroup) view.findViewById(R.id.lvl_chooser_group);
        gamePlay=(GamePlay)getActivity();
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(view);
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                gamePlay.title_view.setText("LEVEL " + (lvl - 2));
                gamePlay.level = lvl;
                gamePlay.newGame();
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        level_chooser_group.setOnCheckedChangeListener(this);

        return builder.create();
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if(checkedId ==(R.id.lvl_1)){
            lvl = 3;
        }
        else if(checkedId == (R.id.lvl_2)){
            lvl = 4;
        }
        else if(checkedId == R.id.lvl_3){
            lvl = 5;
        }
    }
}
