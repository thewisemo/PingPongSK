package com.example.android.pingpongsk;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by wisemo on 3/9/2018.
 */
public class Standings extends Activity {
    Button back = findViewById(R.id.back_btn);

    TextView leftFirstSetFirstMatchTv;

    String[] leftMatchesScoresTvs = new String[9];
    String[] rightMatchesScoresTvs = new String[9];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.standings_popup);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


}
