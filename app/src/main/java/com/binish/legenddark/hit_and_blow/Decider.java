package com.binish.legenddark.hit_and_blow;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by legenddark on 2016/01/13.
 */
public class Decider extends DialogFragment {
    LayoutInflater inflater;
    View view;
    int[] numberInOrder;
    LinearLayout ans_layout;
    GamePlay gamePlay;
    String title;
    TextView titleView;



    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        gamePlay = (GamePlay)getActivity();
        this.numberInOrder = gamePlay.numberInOrder;
        this.title = gamePlay.gameStatus;
        inflater = getActivity().getLayoutInflater();
        view = inflater.inflate(R.layout.decider_layout, null);
        ans_layout = (LinearLayout) view.findViewById(R.id.lost_ans_layout);
        titleView = (TextView) view.findViewById(R.id.titleView);
        titleView.setText(title);
        if(ans_layout != null){
            ans_layout.removeAllViews();
        }
        for(int i = 0;i<numberInOrder.length;i++){
            ImageView img = new ImageView(getActivity());
            if(numberInOrder[i]==1){
                img.setImageResource(R.drawable.display_fire);
                img.setPadding(5, 5, 5, 5);
                ans_layout.addView(img);
            }
            else if(numberInOrder[i] == 2){
                img.setImageResource(R.drawable.display_water);
                img.setPadding(5, 5, 5, 5);
                ans_layout.addView(img);
            }
            else if(numberInOrder[i] == 3){
                img.setImageResource(R.drawable.display_wind);
                img.setPadding(5, 5, 5, 5);
                ans_layout.addView(img);
            }
            else if(numberInOrder[i] == 4){
                img.setImageResource(R.drawable.display_land);
                img.setPadding(5, 5, 5, 5);
                ans_layout.addView(img);
            }
            else if(numberInOrder[i] == 5){
                img.setImageResource(R.drawable.display_thunder);
                img.setPadding(5, 5, 5, 5);
                ans_layout.addView(img);
            }
            else if(numberInOrder[i] == 6){
                img.setImageResource(R.drawable.display_tree);
                img.setPadding(5, 5, 5, 5);
                ans_layout.addView(img);
            }
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(view);
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        return builder.create();

    }
}
