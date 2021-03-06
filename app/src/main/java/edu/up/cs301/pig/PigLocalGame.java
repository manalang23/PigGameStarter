package edu.up.cs301.pig;

import edu.up.cs301.game.GamePlayer;
import edu.up.cs301.game.LocalGame;
import edu.up.cs301.game.actionMsg.GameAction;
import edu.up.cs301.game.infoMsg.GameState;
import java.util.Random;

import android.util.Log;

// dummy comment, to see if commit and push work from srvegdahl account
// test to see if commit and push work -lindsey

/**
 * class PigLocalGame controls the play of the game
 *
 * @author Andrew M. Nuxoll, modified by Steven R. Vegdahl
 * @version February 2016
 */
public class PigLocalGame extends LocalGame {

    private PigGameState official;

    /**
     * This ctor creates a new game state
     */
    public PigLocalGame() {
        official = new PigGameState();
    }

    /**
     * can the player with the given id take an action right now?
     */
    @Override
    protected boolean canMove(int playerIdx) {
        return official.getTurn() == playerIdx;
    }

    /**
     * This method is called when a new action arrives from a player
     *
     * @return true if the action was taken or false if the action was invalid/illegal.
     */
    @Override
    protected boolean makeMove(GameAction action) {
        if (action instanceof PigHoldAction) {
            if (official.getTurn() == 1) {
                official.setP1Score(official.getP1Score() + official.getRunningTotal());
                if (this.players.length > 1) {
                    official.setTurn(2);
                }
            } else { // if player 2's turn
                official.setP2Score(official.getP2Score() + official.getRunningTotal());
                official.setTurn(1);
            }
            official.setRunningTotal(0);
            return true;

        } else if (action instanceof PigRollAction) {
            Random rand = new Random();
            official.setDiceValue(rand.nextInt(6) +1 );
            if (official.getDiceValue() != 1) {
                official.setRunningTotal(official.getRunningTotal()+official.getDiceValue());
                return true;
            } else {
                official.setRunningTotal(0);
                if (official.getTurn() == 1) {
                    if (this.players.length > 1) {
                        official.setTurn(2);
                    }
                } else { // if player 2's turn
                    official.setTurn(1);
                }
                return true;
            }
        }
        return false;
    }//makeMove

    /**
     * send the updated state to a given player
     */
    @Override
    protected void sendUpdatedStateTo(GamePlayer p) {
        PigGameState copy = new PigGameState(official);
        p.sendInfo(copy);
    }//sendUpdatedSate

    /**
     * Check if the game is over
     *
     * @return
     * 		a message that tells who has won the game, or null if the
     * 		game is not over
     */
    @Override
    protected String checkIfGameOver() {
        if(official.getP1Score() >= 50) {
            return (this.playerNames[0] + " wins with a score of " + official.getP1Score());
        }
        if (official.getP2Score() >= 50) {
            return (this.playerNames[1] + " wins with a score of " + official.getP2Score());
        }
        return null;
    }

}// class PigLocalGame