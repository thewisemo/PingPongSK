package com.example.android.pingpongsk;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.TextView;

public class Standings extends AppCompatActivity {
    // Declaring the include views FrameLayout objects.
    FrameLayout setOneView;
    FrameLayout setTwoView;
    FrameLayout setThreeView;
    TextView[] leftTvs;
    TextView[] rightTvs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standings);
        //Assigning the include views FrameLayout objects.
        setOneView = findViewById(R.id.set_one_view);
        setTwoView = findViewById(R.id.set_two_view);
        setThreeView = findViewById(R.id.set_three_view);
        // Declare the 2 TextView arrays object.
        ScoreTv leftAndRightTvs = new ScoreTv(leftTvs, rightTvs);
        // Adding to leftMatchesScoresTvs & Assigning TVs objects Values that refers to the -Left- Side (First) set matches scores.
        leftAndRightTvs.addToLeftArray(0, (TextView) setOneView.findViewById(R.id.left_first_set_first_match_tv));
        leftAndRightTvs.addToLeftArray(1, (TextView) setOneView.findViewById(R.id.left_first_set_second_match_tv));
        leftAndRightTvs.addToLeftArray(2, (TextView) setOneView.findViewById(R.id.left_first_set_third_match_tv));
        // Adding to leftMatchesScoresTvs & Assigning TVs objects Values that refers to the -Left- Side (Second) set matches scores.
        leftAndRightTvs.addToLeftArray(3, (TextView) setTwoView.findViewById(R.id.left_second_set_first_match_tv));
        leftAndRightTvs.addToLeftArray(4, (TextView) setTwoView.findViewById(R.id.left_second_set_second_match_tv));
        leftAndRightTvs.addToLeftArray(5, (TextView) setTwoView.findViewById(R.id.left_second_set_third_match_tv));
        // Adding to leftMatchesScoresTvs & Assigning TVs objects Values that refers to the -Left- Side (Third) set matches scores.
        leftAndRightTvs.addToLeftArray(6, (TextView) setThreeView.findViewById(R.id.left_third_set_first_match_tv));
        leftAndRightTvs.addToLeftArray(7, (TextView) setThreeView.findViewById(R.id.left_third_set_second_match_tv));
        leftAndRightTvs.addToLeftArray(8, (TextView) setThreeView.findViewById(R.id.left_third_set_third_match_tv));
        // Adding to leftMatchesScoresTvs & Assigning TVs objects Values that refers to the -Right- Side (First) set matches scores.
        leftAndRightTvs.addToRightArray(0, (TextView) setOneView.findViewById(R.id.right_first_set_first_match_tv));
        leftAndRightTvs.addToRightArray(1, (TextView) setOneView.findViewById(R.id.right_first_set_second_match_tv));
        leftAndRightTvs.addToRightArray(2, (TextView) setOneView.findViewById(R.id.right_first_set_third_match_tv));
        // Adding to leftMatchesScoresTvs & Assigning TVs objects Values that refers to the -Right- Side (Second) set matches scores.
        leftAndRightTvs.addToRightArray(3, (TextView) setTwoView.findViewById(R.id.right_second_set_first_match_tv));
        leftAndRightTvs.addToRightArray(4, (TextView) setTwoView.findViewById(R.id.right_second_set_second_match_tv));
        leftAndRightTvs.addToRightArray(5, (TextView) setTwoView.findViewById(R.id.right_second_set_third_match_tv));
        // Adding to leftMatchesScoresTvs & Assigning TVs objects Values that refers to the -Right- Side (Third) set matches scores.
        leftAndRightTvs.addToRightArray(6, (TextView) setThreeView.findViewById(R.id.right_third_set_first_match_tv));
        leftAndRightTvs.addToRightArray(7, (TextView) setThreeView.findViewById(R.id.right_third_set_second_match_tv));
        leftAndRightTvs.addToRightArray(8, (TextView) setThreeView.findViewById(R.id.right_third_set_third_match_tv));
    }
}
