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

    public PigGameState (PigGameState pigGameState) {
        PigGameState instance = new PigGameState();
        this.turn = pigGameState.turn;
        this.p1Score = pigGameState.p1Score;
        this.p2Score = pigGameState.p2Score;
        this.runningTotal = pigGameState.runningTotal;
        this.diceValue = pigGameState.diceValue;
    }

    private int getTurn() {
        return this.turn;
    }

    private int getP1Score() {
        return this.p1Score;
    }

    private int getP2Score() {
        return this.p2Score;
    }

    private int getRunningTotal() {
        return this.runningTotal;
    }

    private int getDiceValue() {
        return this.diceValue;
    }

    private void setTurn(int turn) {
        this.turn = turn;
    }

    private void setP1Score(int p1Score) {
        this.p1Score = p1Score;
    }

    private void setP2Score(int p2Score) {
        this.p2Score = p2Score;
    }

    private void setRunningTotal(int runningTotal) {
        this.runningTotal = runningTotal;
    }

    private void setDiceValue(int diceValue) {
        this.diceValue = diceValue;
    }
}
