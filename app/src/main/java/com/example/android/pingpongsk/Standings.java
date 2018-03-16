package com.example.android.pingpongsk;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Standings extends AppCompatActivity {
    // Declaring the include views FrameLayout objects "Which contains the 18 scores TextViews - 9 for each player/s side".
    LinearLayout setOneView;
    LinearLayout setTwoView;
    LinearLayout setThreeView;
    // Declaring 2 static TextView arrays "To be combine the matches scores TVs
    TextView[] leftMatchesScoresTvs = new TextView[9];
    TextView[] rightMatchesScoresTvs = new TextView[9];
    // Declaring the player/s names TV objects.
    TextView standLeftName;
    TextView standRightName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standings);
        // Assigning the players names TV objects to their id "values".
        standLeftName = findViewById(R.id.standings_left_name_tv);
        standLeftName.setSelected(true);
        standRightName = findViewById(R.id.standings_right_name_tv);
        standRightName.setSelected(true);
        //Assigning the include views FrameLayout objects.
        setOneView = findViewById(R.id.set_one_view);
        setTwoView = findViewById(R.id.set_two_view);
        setThreeView = findViewById(R.id.set_three_view);
        // Adding to leftMatchesScoresTvs & Assigning TVs objects Values that refers to the -Left- Side (First) set matches scores.
        leftMatchesScoresTvs[0] = setOneView.findViewById(R.id.left_first_set_first_match_tv);
        leftMatchesScoresTvs[1] = setOneView.findViewById(R.id.left_first_set_second_match_tv);
        leftMatchesScoresTvs[2] = setOneView.findViewById(R.id.left_first_set_third_match_tv);
        // Adding to leftMatchesScoresTvs & Assigning TVs objects Values that refers to the -Left- Side (Second) set matches scores.
        leftMatchesScoresTvs[3] = setTwoView.findViewById(R.id.left_second_set_first_match_tv);
        leftMatchesScoresTvs[4] = setTwoView.findViewById(R.id.left_second_set_second_match_tv);
        leftMatchesScoresTvs[5] = setTwoView.findViewById(R.id.left_second_set_third_match_tv);
        // Adding to leftMatchesScoresTvs & Assigning TVs objects Values that refers to the -Left- Side (Third) set matches scores.
        leftMatchesScoresTvs[6] = setThreeView.findViewById(R.id.left_third_set_first_match_tv);
        leftMatchesScoresTvs[7] = setThreeView.findViewById(R.id.left_third_set_second_match_tv);
        leftMatchesScoresTvs[8] = setThreeView.findViewById(R.id.left_third_set_third_match_tv);
        // Adding to leftMatchesScoresTvs & Assigning TVs objects Values that refers to the -Right- Side (First) set matches scores.
        rightMatchesScoresTvs[0] = setOneView.findViewById(R.id.right_first_set_first_match_tv);
        rightMatchesScoresTvs[1] = setOneView.findViewById(R.id.right_first_set_second_match_tv);
        rightMatchesScoresTvs[2] = setOneView.findViewById(R.id.right_first_set_third_match_tv);
        // Adding to leftMatchesScoresTvs & Assigning TVs objects Values that refers to the -Right- Side (Second) set matches scores.
        rightMatchesScoresTvs[3] = setTwoView.findViewById(R.id.right_second_set_first_match_tv);
        rightMatchesScoresTvs[4] = setTwoView.findViewById(R.id.right_second_set_second_match_tv);
        rightMatchesScoresTvs[5] = setTwoView.findViewById(R.id.right_second_set_third_match_tv);
        // Adding to leftMatchesScoresTvs & Assigning TVs objects Values that refers to the -Right- Side (Third) set matches scores.
        rightMatchesScoresTvs[6] = setThreeView.findViewById(R.id.right_third_set_first_match_tv);
        rightMatchesScoresTvs[7] = setThreeView.findViewById(R.id.right_third_set_second_match_tv);
        rightMatchesScoresTvs[8] = setThreeView.findViewById(R.id.right_third_set_third_match_tv);
    }

    public TextView getLeftScoreTv(int index) {
        return leftMatchesScoresTvs[index];
    }

    public void setLeftScoreTv(int index, TextView leftScore) {
        leftMatchesScoresTvs[index] = leftScore;
    }

    public TextView getRightScoreTv(int index) {
        return rightMatchesScoresTvs[index];
    }

    public void setRightScoreTv(int index, TextView leftScore) {
        rightMatchesScoresTvs[index] = leftScore;
    }
}
