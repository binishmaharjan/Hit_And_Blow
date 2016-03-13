package com.binish.legenddark.hit_and_blow;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class GamePlay extends AppCompatActivity {

    int level;
    boolean declaration;
    String gameStatus;

    int numberInOrder[];//Stores Computer Generated Numbers
    int[] userInputNumber;//Stores User Inputted Numbers

    ArrayList<Integer> userInput;//Stores UserInputted Numers n ArrayList


    int count;//Count of The Matching Symbols
    int turnCount;
    int rightOrder;
    int rightNumber;

    Button btn_fire, btn_water, btn_wind, btn_land, btn_thunder, btn_tree;
    Button btn_enter, btn_del, btn_newGame, btn_lvl, btn_help;

    ImageView display_1, display_2, display_3, display_4, display_5;

    TextView rn_1, rn_2, rn_3, rn_4, rn_5, rn_6, rn_7, rn_8, rn_9, rn_10;
    TextView ro_1, ro_2, ro_3, ro_4, ro_5, ro_6, ro_7, ro_8, ro_9, ro_10;

    TextView title_view;

    LinearLayout hint_1, hint_2, hint_3, hint_4, hint_5, hint_6, hint_7, hint_8, hint_9, hint_10;

    LinearLayout display_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        level = 3;
        turnCount = 0;
        userInput = new ArrayList<>();
        declaration = false;
        gameStatus = "";


        btn_fire = (Button) findViewById(R.id.btn_fire);
        btn_water = (Button) findViewById(R.id.btn_water);
        btn_wind = (Button) findViewById(R.id.btn_wind);
        btn_land = (Button) findViewById(R.id.btn_land);
        btn_thunder = (Button) findViewById(R.id.bnt_thunder);
        btn_tree = (Button) findViewById(R.id.bnt_tree);


        display_layout = (LinearLayout) findViewById(R.id.display_layout);
        btn_del = (Button) findViewById(R.id.btn_del);
        btn_enter = (Button) findViewById(R.id.btn_enter);
        btn_newGame = (Button) findViewById(R.id.btn_newGame);
        btn_lvl = (Button) findViewById(R.id.btn_lvl);
        btn_help = (Button) findViewById(R.id.btn_help);

        DisplayButtonAction action = new DisplayButtonAction();
        UserAction userAction = new UserAction();

        btn_fire.setOnClickListener(action);
        btn_water.setOnClickListener(action);
        btn_wind.setOnClickListener(action);
        btn_thunder.setOnClickListener(action);
        btn_land.setOnClickListener(action);
        btn_tree.setOnClickListener(action);
        btn_del.setOnClickListener(userAction);
        btn_enter.setOnClickListener(userAction);


        ro_1 = (TextView) findViewById(R.id.ro_1);
        ro_2 = (TextView) findViewById(R.id.ro_2);
        ro_3 = (TextView) findViewById(R.id.ro_3);
        ro_4 = (TextView) findViewById(R.id.ro_4);
        ro_5 = (TextView) findViewById(R.id.ro_5);
        ro_6 = (TextView) findViewById(R.id.ro_6);
        ro_7 = (TextView) findViewById(R.id.ro_7);
        ro_8 = (TextView) findViewById(R.id.ro_8);
        ro_9 = (TextView) findViewById(R.id.ro_9);
        ro_10 = (TextView) findViewById(R.id.ro_10);

        rn_1 = (TextView) findViewById(R.id.rn_1);
        rn_2 = (TextView) findViewById(R.id.rn_2);
        rn_3 = (TextView) findViewById(R.id.rn_3);
        rn_4 = (TextView) findViewById(R.id.rn_4);
        rn_5 = (TextView) findViewById(R.id.rn_5);
        rn_6 = (TextView) findViewById(R.id.rn_6);
        rn_7 = (TextView) findViewById(R.id.rn_7);
        rn_8 = (TextView) findViewById(R.id.rn_8);
        rn_9 = (TextView) findViewById(R.id.rn_9);
        rn_10 = (TextView) findViewById(R.id.rn_10);

        hint_1 = (LinearLayout) findViewById(R.id.hint_1);
        hint_2 = (LinearLayout) findViewById(R.id.hint_2);
        hint_3 = (LinearLayout) findViewById(R.id.hint_3);
        hint_4 = (LinearLayout) findViewById(R.id.hint_4);
        hint_5 = (LinearLayout) findViewById(R.id.hint_5);
        hint_6 = (LinearLayout) findViewById(R.id.hint_6);
        hint_7 = (LinearLayout) findViewById(R.id.hint_7);
        hint_8 = (LinearLayout) findViewById(R.id.hint_8);
        hint_9 = (LinearLayout) findViewById(R.id.hint_9);
        hint_10 = (LinearLayout) findViewById(R.id.hint_10);

        title_view = (TextView) findViewById(R.id.title_view1);

        /*
        Generating The Number For The Game
         */
        GenerateNumbers theCode = new GenerateNumbers();
        theCode.Generate(level);
        theCode.DeleteRepetation();
        numberInOrder = theCode.getNumber();

        btn_newGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Yes_No dialog = new Yes_No();
                dialog.show(getFragmentManager(), "yes_no");
            }
        });

        btn_lvl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LevelChooser chooser = new LevelChooser();
                chooser.show(getFragmentManager(),"lvl_chooser");
            }
        });

        btn_help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GamePlay.this,help.class);
                startActivity(intent);
            }
        });
    }

    class DisplayButtonAction implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            if (count < level) {
                if (v.getId() == R.id.btn_fire) {
                    ImageView img = new ImageView(GamePlay.this);
                    img.setImageResource(R.drawable.display_fire);
                    img.setPadding(5, 5, 5, 5);
                    display_layout.addView(img);
                    userInput.add(1);
                    count++;
                } else if (v.getId() == R.id.btn_water) {
                    ImageView img = new ImageView(GamePlay.this);
                    img.setImageResource(R.drawable.display_water);
                    img.setPadding(5, 5, 5, 5);
                    display_layout.addView(img);
                    userInput.add(2);
                    count++;
                } else if (v.getId() == R.id.btn_wind) {
                    ImageView img = new ImageView(GamePlay.this);
                    img.setImageResource(R.drawable.display_wind);
                    img.setPadding(5, 5, 5, 5);
                    display_layout.addView(img);
                    userInput.add(3);
                    count++;
                } else if (v.getId() == R.id.btn_land) {
                    ImageView img = new ImageView(GamePlay.this);
                    img.setImageResource(R.drawable.display_land);
                    img.setPadding(5, 5, 5, 5);
                    display_layout.addView(img);
                    userInput.add(4);
                    count++;
                } else if (v.getId() == R.id.bnt_thunder) {
                    ImageView img = new ImageView(GamePlay.this);
                    img.setImageResource(R.drawable.display_thunder);
                    img.setPadding(5, 5, 5, 5);
                    display_layout.addView(img);
                    userInput.add(5);
                    count++;
                } else if (v.getId() == R.id.bnt_tree) {
                    ImageView img = new ImageView(GamePlay.this);
                    img.setImageResource(R.drawable.display_tree);
                    img.setPadding(5, 5, 5, 5);
                    display_layout.addView(img);
                    userInput.add(6);
                    count++;
                }

            }
        }
    }

    class UserAction implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.btn_del) {
                try {
                    display_layout.removeAllViews();
                    userInput.clear();
                    count = 0;
                } catch (Exception e) {
                }
            }

            if (v.getId() == R.id.btn_enter) {
                if (count == level) {
                    MainAction();
                } else {
                    Toast.makeText(getBaseContext(), "Input " + level + " symbols.", Toast.LENGTH_SHORT).show();
                }

                display_layout.removeAllViews();
                userInput.clear();
                count = 0;
            }
        }
    }

    public void MainAction() {
        /*
        Converting User Inputted ArrayList Into Simple Array
         */
        if (turnCount < 10 && declaration == false) {
            userInputNumber = new int[userInput.size()];
            for (int i = 0; i < userInput.size(); i++) {
                int temp = userInput.get(i);
                userInputNumber[i] = temp;
            }

            turnCount += 1;
            rightOrder = 0;
            rightNumber = 0;

            for (int i = 0; i < numberInOrder.length; i++) {
                if (numberInOrder[i] == userInputNumber[i]) {
                    rightOrder += 1;
                }
            }

            for (int j = 0; j < numberInOrder.length; j++) {
                int counterPerWord = 0;
                for (int k = 0; k < numberInOrder.length; k++) {
                    if (userInputNumber[k] == numberInOrder[j])
                        counterPerWord = counterPerWord + 1;//To Limit The Counter to 1 Per Number
                    if (counterPerWord > 0)
                        break;
                }
                rightNumber = rightNumber + counterPerWord;//Adding The Counter for Each Number
            }
        /*
        Calling For The HintFiller Method which Fills The HInt Layout
         */
            hintFiller(turnCount);

            if (rightOrder == level) {
                declaration = true;
            }

        }
        if (turnCount >= 10 && declaration == false) {
            Decider dialog = new Decider();
            this.gameStatus = "YOU LOST!!!";
            dialog.show(getFragmentManager(), "Decider");

        }
        if (declaration == true) {
            Decider dialog = new Decider();
            this.gameStatus = "YOU WON!!!";
            dialog.show(getFragmentManager(), "Decider");
        }


    }

    public String con(int[] num) {
        String ans = "";
        for (int i = 0; i < num.length; i++) {
            ans = ans + String.valueOf(num[i]);
        }
        return ans;
    }

    public void hintFiller(int turn) {
        switch (turn) {
            case 1:
                symbolConverter(userInputNumber, hint_1);
                ro_1.setText(String.valueOf(rightOrder));
                rn_1.setText(String.valueOf(rightNumber - rightOrder));
                break;
            case 2:
                symbolConverter(userInputNumber, hint_2);
                ro_2.setText(String.valueOf(rightOrder));
                rn_2.setText(String.valueOf(rightNumber - rightOrder));
                break;
            case 3:
                symbolConverter(userInputNumber, hint_3);
                ro_3.setText(String.valueOf(rightOrder));
                rn_3.setText(String.valueOf(rightNumber - rightOrder));
                break;
            case 4:
                symbolConverter(userInputNumber, hint_4);
                ro_4.setText(String.valueOf(rightOrder));
                rn_4.setText(String.valueOf(rightNumber - rightOrder));
                break;
            case 5:
                symbolConverter(userInputNumber, hint_5);
                ro_5.setText(String.valueOf(rightOrder));
                rn_5.setText(String.valueOf(rightNumber - rightOrder));
                break;
            case 6:
                symbolConverter(userInputNumber, hint_6);
                ro_6.setText(String.valueOf(rightOrder));
                rn_6.setText(String.valueOf(rightNumber - rightOrder));
                break;
            case 7:
                symbolConverter(userInputNumber, hint_7);
                ro_7.setText(String.valueOf(rightOrder));
                rn_7.setText(String.valueOf(rightNumber - rightOrder));
                break;
            case 8:
                symbolConverter(userInputNumber, hint_8);
                ro_8.setText(String.valueOf(rightOrder));
                rn_8.setText(String.valueOf(rightNumber - rightOrder));
                break;
            case 9:
                symbolConverter(userInputNumber, hint_9);
                ro_9.setText(String.valueOf(rightOrder));
                rn_9.setText(String.valueOf(rightNumber - rightOrder));
                break;
            case 10:
                symbolConverter(userInputNumber, hint_10);
                ro_10.setText(String.valueOf(rightOrder));
                rn_10.setText(String.valueOf(rightNumber - rightOrder));
                break;
            default:
                break;
        }
    }

    public void symbolConverter(int[] num, LinearLayout layout) {
        ImageView img;
        for (int i = 0; i < num.length; i++) {
            int temp = num[i];
            if (temp == 1) {
                img = new ImageView(this);
                img.setImageResource(R.drawable.hint_fire);
                img.setPadding(5, 0, 5, 0);
                layout.addView(img);
            } else if (temp == 2) {
                img = new ImageView(this);
                img.setImageResource(R.drawable.hint_water);
                img.setPadding(5, 0, 5, 0);
                layout.addView(img);
            } else if (temp == 3) {
                img = new ImageView(this);
                img.setImageResource(R.drawable.hint_wind);
                img.setPadding(5, 0, 5, 0);
                layout.addView(img);
            } else if (temp == 4) {
                img = new ImageView(this);
                img.setImageResource(R.drawable.hint_land);
                img.setPadding(5, 0, 5, 0);
                layout.addView(img);
            } else if (temp == 5) {
                img = new ImageView(this);
                img.setImageResource(R.drawable.hint_thunder);
                img.setPadding(5, 0, 5, 0);
                layout.addView(img);
            } else if (temp == 6) {
                img = new ImageView(this);
                img.setImageResource(R.drawable.hint_tree);
                img.setPadding(5, 0, 5, 0);
                layout.addView(img);
            }
        }

    }

    public void newGame() {
        count = 0;
        turnCount = 0;
        userInput.clear();
        GenerateNumbers theCode = new GenerateNumbers();
        theCode.Generate(level);
        theCode.DeleteRepetation();
        numberInOrder = theCode.getNumber();
        declaration = false;
        rightNumber = 0;
        rightOrder = 0;
        hint_1.removeAllViews();
        hint_2.removeAllViews();
        hint_3.removeAllViews();
        hint_4.removeAllViews();
        hint_5.removeAllViews();
        hint_6.removeAllViews();
        hint_7.removeAllViews();
        hint_8.removeAllViews();
        hint_9.removeAllViews();
        hint_10.removeAllViews();
        display_layout.removeAllViews();
        ro_1.setText("");
        ro_2.setText("");
        ro_3.setText("");
        ro_4.setText("");
        ro_5.setText("");
        ro_6.setText("");
        ro_7.setText("");
        ro_8.setText("");
        ro_9.setText("");
        ro_10.setText("");
        rn_1.setText("");
        rn_2.setText("");
        rn_3.setText("");
        rn_4.setText("");
        rn_5.setText("");
        rn_6.setText("");
        rn_7.setText("");
        rn_8.setText("");
        rn_9.setText("");
        rn_10.setText("");
    }
}
