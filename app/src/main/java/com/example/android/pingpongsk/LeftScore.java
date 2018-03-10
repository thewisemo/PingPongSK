package com.example.android.pingpongsk;

/**
 * Created by wisemo on 2/27/2018.
 */

public abstract class LeftScore {
    static int maxLeftMatchScore = 5;
    static int maxLeftSetScore = 2;
    static int maxLeftGameScore = 1;
    public LeftScore(){}
    public abstract void incScore();
    public abstract void decScore();
}
