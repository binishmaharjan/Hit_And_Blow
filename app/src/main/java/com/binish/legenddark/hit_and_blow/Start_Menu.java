package com.binish.legenddark.hit_and_blow;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.purplebrain.adbuddiz.sdk.AdBuddiz;

public class Start_Menu extends AppCompatActivity implements View.OnClickListener{

    Button start;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start__menu);

        AdBuddiz.setPublisherKey("c8094f7a-6938-4946-98f4-2ec05b12ee8e");
        AdBuddiz.cacheAds(this); // this = current Activity
        AdBuddiz.showAd(this); // this = current Activity

        start  = (Button) findViewById(R.id.btn_start);
        start.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this,GamePlay.class);
        startActivity(intent);
    }
}
