package com.binish.legenddark.hit_and_blow;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private Thread mSplashThread;
    private int Duration = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSplashThread = new Thread(){
            @Override
            public void run() {
                synchronized (this){
                    try{
                        wait(Duration);
                    }catch (InterruptedException e){

                    }
                    finally {
                        finish();
                        Intent intent = new Intent(getBaseContext(),Start_Menu.class);
                        startActivity(intent);
                    }
                }
            }
        };
        mSplashThread.start();
        ImageView splashView = (ImageView) findViewById(R.id.splash_view);
        splashView.animate().alpha(1f).setDuration(3000);
    }
}
