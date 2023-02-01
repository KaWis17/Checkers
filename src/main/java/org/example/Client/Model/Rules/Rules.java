package org.example.Client.Model.Rules;

import org.example.Client.Model.Board.Board;
import org.example.Client.Model.Board.TileState;
import org.example.Client.Model.Rules.FigureRules.Figure;
import org.example.Client.Model.Rules.FigureRules.FiguresRuleSet;
import org.example.Vector2;

/**
 * class that represent movement rules overall
 */
public class Rules {
    /**
     * pon1 movements
     */
    Figure pon1;
    /**
     * pon2 movements
     */
    Figure pon2;
    /**
     * queen movements
     */
    Figure queen;

    /**
     * sets chosen figure rules
     * @param figuresRuleSet figures rule set
     */
    public void initRules(FiguresRuleSet figuresRuleSet) {
        pon1 = figuresRuleSet.initPon1Rules();
        pon2 = figuresRuleSet.initPon2Rules();
        queen = figuresRuleSet.initQueenRules();
    }

    //TODO : relocate some of this function to board

    /**
     * picks figure
     * @param chosen chosen
     * @param board board
     */
    public void pick(Vector2 chosen, Board board) {
        board.setAllTilesNotPossible();
        if(board.getTile(chosen).getState() == TileState.EMPTY)
            return;
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                board.getTiles()[i][j].setIsPicked( (chosen.getX() == i && chosen.getY() == j) );
            }
        }
        TileState picked = board.getPicked().getState();
        switch (picked) {
            case PON_1 -> pon1.setPossibleMoves(board);
            case PON_2 -> pon2.setPossibleMoves(board);
            case QUEEN_1,QUEEN_2 -> queen.setPossibleMoves(board);
        }
    }

    /**
     * puts figure
     * @param chosenPos chosen position
     * @param board board
     */
    public void put(Vector2 chosenPos, Board board) {
        TileState picked = board.getPicked().getState();
        switch (picked) {
            case PON_1 -> pon1.move(chosenPos,board);
            case PON_2 -> pon2.move(chosenPos,board);
            case QUEEN_1,QUEEN_2 -> queen.move(chosenPos,board);
            case EMPTY -> board.getPicked().setIsPicked(false);
        }
    }
}
