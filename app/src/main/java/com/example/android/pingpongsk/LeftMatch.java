package com.example.android.pingpongsk;

import android.widget.TextView;

/**
 * Created by wisemo on 2/27/2018.
 */

public class LeftMatch extends LeftScore {
    private int mLeftMatchScore;
    private boolean mLeftWonMatch = false;
    private TextView mLeftCurrentMatchScoreTV, mLeftMatchScoreTV;

    public LeftMatch(int leftMatchScore, boolean leftIsMatchWinner){
        setmLeftMatchScore(leftMatchScore);
        setmLeftWonMatch(leftIsMatchWinner);
    }

    @Override
    public void incScore() {
        if (getmLeftMatchScore() == maxLeftMatchScore){
            setmLeftWonMatch(true);
        } else if (ismLeftWonMatch()){
            setmLeftMatchScore(getmLeftMatchScore() + 1);
        }
    }

    @Override
    public void decScore() {
        if (getmLeftMatchScore() > 0){
            setmLeftMatchScore(getmLeftMatchScore() - 1);
        }
    }

    public int getmLeftMatchScore() {
        return mLeftMatchScore;
    }

    public void setmLeftMatchScore(int mLeftMatchScore) {
        this.mLeftMatchScore = mLeftMatchScore;
    }

    public boolean ismLeftWonMatch() {
        return mLeftWonMatch;
    }

    public void setmLeftWonMatch(boolean mLeftWonMatch) {
        this.mLeftWonMatch = mLeftWonMatch;
    }

    public void displayLeftCurrentScore (int leftCurrentScore){

    }

    public void displayLeftMatchScore (int leftMatchScore){

    }
}
