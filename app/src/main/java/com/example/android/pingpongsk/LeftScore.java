package com.example.android.pingpongsk;

import static com.example.android.pingpongsk.MainActivity.maxMatchScore;

/**
 * Created by wisemo on 2/27/2018.
 */

public class LeftScore {

    private int mLeftSideScore;
    private boolean mLeftWon;

    public LeftScore(int left, boolean leftIsWinner) {
        mLeftSideScore = left;
        mLeftWon = leftIsWinner;
    }

    // abstract left score "Increment & Decrement" methods that will be override in Left left Match, Set, Game classes.
    public int incLeftScore() {
        if (mLeftSideScore == maxMatchScore) {
            mLeftWon = true;
        } else mLeftSideScore++;
        return mLeftSideScore;
    }

    public int decLeftScore() {
        if (mLeftSideScore < 0) {
            return mLeftSideScore;
        }
        mLeftSideScore--;
        return mLeftSideScore;
    }

    public int resetLeftScore() {
        mLeftSideScore = 0;
        return mLeftSideScore;
    }
}
