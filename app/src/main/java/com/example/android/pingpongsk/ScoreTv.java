package com.example.android.pingpongsk;

import android.widget.TextView;

/**
 * Created by wisemo on 3/15/2018.
 * This class is to control "By its public methods" the both player/s side scores TextViews,
 * The ScoreTv constructor "object" is created by adding 2 TextView arrays of 9 indexes as @Params,
 * ScoreTv class have 2 public methods To add an element inside each side array index aadToLeftArray & addToRightArray,
 * Also ScoreTv class have 2 getters & setters for each TextView array instance.
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
