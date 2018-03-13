package com.example.android.pingpongsk;

/**
 * Created by wisemo on 2/27/2018.
 */

public abstract class Score {
    static int maxGameScore = 1;
    static int maxSetScore = 2;
    static int maxMatchScore = 5;
    static int leftSideScore, rightSideScore;
    static boolean leftWonMatch, leftWonSet, leftWonGame, rightWonMatch, rightWonSet, rightWonGame;

    public Score() {
    }
//    public abstract void incScore();
}
