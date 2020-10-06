package edu.up.cs301.pig;

import edu.up.cs301.game.infoMsg.GameState;

public class PigGameState extends GameState {
    private int turn;
    private int p1Score;
    private int p2Score;
    private int runningTotal;
    private int diceValue;

    public PigGameState() {
        turn = 0;
        p1Score = 0;
        p2Score = 0;
        runningTotal = 0;
        diceValue = 0;
    }

    private PigGameState copy()
}
