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

    public PigGameState(PigGameState pigGameState) {
        PigGameState instance = new PigGameState();
        this.turn = pigGameState.turn;
        this.p1Score = pigGameState.p1Score;
        this.p2Score = pigGameState.p2Score;
        this.runningTotal = pigGameState.runningTotal;
        this.diceValue = pigGameState.diceValue;
    }

    public int getTurn() {
        return this.turn;
    }

    public int getP1Score() {
        return this.p1Score;
    }

    public int getP2Score() {
        return this.p2Score;
    }

    public int getRunningTotal() {
        return this.runningTotal;
    }

    public int getDiceValue() {
        return this.diceValue;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public void setP1Score(int p1Score) {
        this.p1Score = p1Score;
    }

    public void setP2Score(int p2Score) {
        this.p2Score = p2Score;
    }

    public void setRunningTotal(int runningTotal) {
        this.runningTotal = runningTotal;
    }

    public void setDiceValue(int diceValue) {
        this.diceValue = diceValue;
    }
}
