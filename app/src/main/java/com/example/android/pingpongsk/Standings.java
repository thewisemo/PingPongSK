package com.example.android.pingpongsk;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.TextView;

/**
 * Created by wisemo on 3/9/2018.
 */
public class Standings extends AppCompatActivity {
    // Declaring the include views objects.
    FrameLayout setOneView;
    FrameLayout setTwoView;
    FrameLayout setThreeView;
    // Declaring TVs objects that refers to the First set matches scores.
    TextView leftFirstSetFirstMatchTv;
    TextView leftFirstSetSecondMatchTv;
    TextView leftFirstSetThirdMatchTv;
    TextView rightFirstSetFirstMatchTv;
    TextView rightFirstSetSecondMatchTv;
    TextView rightFirstSetThirdMatchTv;
    // Declaring TVs objects that refers to the Second set matches scores.
    TextView leftSecondSetFirstMatchTv;
    TextView leftSecondSetSecondMatchTv;
    TextView leftSecondSetThirdMatchTv;
    TextView rightSecondSetFirstMatchTv;
    TextView rightSecondSetSecondMatchTv;
    TextView rightSecondSetThirdMatchTv;
    // Declaring TVs objects that refers to the Third set matches scores.
    TextView leftThirdSetFirstMatchTv;
    TextView leftThirdSetSecondMatchTv;
    TextView leftThirdSetThirdMatchTv;
    TextView rightThirdSetFirstMatchTv;
    TextView rightThirdSetSecondMatchTv;
    TextView rightThirdSetThirdMatchTv;
    // Declaring 2 String arrays with 9 incidents for 9 matches for each player side.
    TextView[] leftMatchesScoresTvs = new TextView[9];
    TextView[] rightMatchesScoresTvs = new TextView[9];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.standings_popup);
        //Assigning the include views objects
        setOneView = findViewById(R.id.set_one_view);
        setTwoView = findViewById(R.id.set_two_view);
        setThreeView = findViewById(R.id.set_three_view);
        // Adding to leftMatchesScoresTvs & Assigning TVs objects Values that refers to the Left Side First set matches scores.
        leftMatchesScoresTvs[0] = leftFirstSetFirstMatchTv = setOneView.findViewById(R.id.left_first_set_first_match_tv);
        leftMatchesScoresTvs[1] = leftFirstSetSecondMatchTv = setOneView.findViewById(R.id.left_first_set_second_match_tv);
        leftMatchesScoresTvs[2] = leftFirstSetThirdMatchTv = setOneView.findViewById(R.id.left_first_set_third_match_tv);
        // Adding to leftMatchesScoresTvs & Assigning TVs objects Values that refers to the Left Side Second set matches scores.
        leftMatchesScoresTvs[3] = leftSecondSetFirstMatchTv = setTwoView.findViewById(R.id.left_second_set_first_match_tv);
        leftMatchesScoresTvs[4] = leftSecondSetSecondMatchTv = setTwoView.findViewById(R.id.left_second_set_second_match_tv);
        leftMatchesScoresTvs[5] = leftSecondSetThirdMatchTv = setTwoView.findViewById(R.id.left_second_set_third_match_tv);
        // Adding to leftMatchesScoresTvs & Assigning TVs objects Values that refers to the Left Side Third set matches scores.
        leftMatchesScoresTvs[6] = leftThirdSetFirstMatchTv = setThreeView.findViewById(R.id.left_third_set_first_match_tv);
        leftMatchesScoresTvs[7] = leftThirdSetSecondMatchTv = setThreeView.findViewById(R.id.left_third_set_second_match_tv);
        leftMatchesScoresTvs[8] = leftThirdSetThirdMatchTv = setThreeView.findViewById(R.id.left_third_set_third_match_tv);
        // Adding to leftMatchesScoresTvs & Assigning TVs objects Values that refers to the Left Side First set matches scores.
        rightMatchesScoresTvs[0] = rightFirstSetFirstMatchTv = setOneView.findViewById(R.id.right_first_set_first_match_tv);
        rightMatchesScoresTvs[1] = rightFirstSetSecondMatchTv = setOneView.findViewById(R.id.right_first_set_second_match_tv);
        rightMatchesScoresTvs[2] = rightFirstSetThirdMatchTv = setOneView.findViewById(R.id.right_first_set_third_match_tv);
        // Adding to leftMatchesScoresTvs & Assigning TVs objects Values that refers to the Left Side Second set matches scores.
        rightMatchesScoresTvs[3] = rightSecondSetFirstMatchTv = setTwoView.findViewById(R.id.right_second_set_first_match_tv);
        rightMatchesScoresTvs[4] = rightSecondSetSecondMatchTv = setTwoView.findViewById(R.id.right_second_set_second_match_tv);
        rightMatchesScoresTvs[5] = rightSecondSetThirdMatchTv = setTwoView.findViewById(R.id.right_second_set_third_match_tv);
        // Adding to leftMatchesScoresTvs & Assigning TVs objects Values that refers to the Left Side Third set matches scores.
        rightMatchesScoresTvs[6] = rightThirdSetFirstMatchTv = setThreeView.findViewById(R.id.right_third_set_first_match_tv);
        rightMatchesScoresTvs[7] = rightThirdSetSecondMatchTv = setThreeView.findViewById(R.id.right_third_set_second_match_tv);
        rightMatchesScoresTvs[8] = rightThirdSetThirdMatchTv = setThreeView.findViewById(R.id.right_third_set_third_match_tv);
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
