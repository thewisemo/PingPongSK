package com.example.android.pingpongsk;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * Created by wisemo on 3/9/2018.
 */

public class Standings extends MainActivity {
    LinearLayout standings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.standings_popup);


//        standings = findViewById(R.id.standings_parent_lv);
//        standings.setGravity(View.MEASURED_HEIGHT_STATE_SHIFT);
        // Back Button object and code to close the Standings view.
        Button back = findViewById(R.id.back_btn);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    // Overriding the onBackPressed method to finish this class to Background and back to MainActivity.class.
    @Override
    public void onBackPressed() {
        finish();
    }
}
