package com.example.android.pingpongsk;

import android.widget.TextView;

/**
 * Created by wisemo on 3/15/2018.
 */

public class ScoreTv {
    private TextView[] leftMatchesScoresTvs = new TextView[9];
    private TextView[] rightMatchesScoresTvs = new TextView[9];


    public ScoreTv(TextView[] left, TextView[] right) {
        leftMatchesScoresTvs = left;
        rightMatchesScoresTvs = right;
    }

    public void addToLeftArray(int index, TextView leftMatchScoreTv) {
        leftMatchesScoresTvs[index] = leftMatchScoreTv;
    }

    public void addToRightArray(int index, TextView rightMatchScoreTv) {
        rightMatchesScoresTvs[index] = rightMatchScoreTv;
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
