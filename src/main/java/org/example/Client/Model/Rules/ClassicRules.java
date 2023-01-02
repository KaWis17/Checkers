package org.example.Client.Model.Rules;

import java.util.ArrayList;
import java.util.List;
import org.example.Client.Model.Board.Board;
import org.example.Client.Model.Rules.FigureRules.Figure;
import org.example.Client.Model.Rules.FigureRules.FigureMoves.FigureMove;
import org.example.Client.Model.Rules.FigureRules.FigureMoves.Pon.PonAttack;
import org.example.Client.Model.Rules.FigureRules.FigureMoves.Pon.PonMove;
import org.example.Client.Model.Rules.FigureRules.FigureMoves.Queens.LineMove;
import org.example.Client.Model.Board.TileState;
import org.example.Vector2;

public class ClassicRules implements Rules {
    Figure pon1;
    Figure pon2;
    Figure queen;

    public ClassicRules() {
        List<FigureMove> pon1Moves = new ArrayList<>();
        pon1Moves.add(new PonAttack(new Vector2[]{new Vector2(2,2),new Vector2(2,-2),new Vector2(-2,-2),new Vector2(-2,2)}));
        pon1Moves.add(new PonMove(new Vector2[]{new Vector2(1,1),new Vector2(1,-1)}));
        pon1 = new Figure(pon1Moves);

        List<FigureMove> pon2Moves = new ArrayList<>();
        pon2Moves.add(new PonAttack(new Vector2[]{new Vector2(2,2),new Vector2(2,-2),new Vector2(-2,-2),new Vector2(-2,2)}));
        pon2Moves.add(new PonMove(new Vector2[]{new Vector2(-1,-1),new Vector2(-1,1)}));
        pon2 = new Figure(pon2Moves);

        List<FigureMove> queenMoves = new ArrayList<>();
        queenMoves.add(new LineMove(Vector2.crossDirections));
        queen = new Figure(queenMoves);
    }

    @Override
    public void pick(Vector2 chosen, Board board) {
        board.setAllTilesNotPossible();
        if(board.getTile(chosen).getState() == TileState.EMPTY)
            return;
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                board.getTiles()[i][j].setPicked( (chosen.getX() == i && chosen.getY() == j) );
            }
        }
        TileState picked = board.getPicked().getState();
        switch (picked) {
            case PON_1 -> {
                pon1.setPossibleMoves(board);
            }
            case PON_2 -> {
                pon2.setPossibleMoves(board);
            }
            case QUEEN_1,QUEEN_2 -> {
                queen.setPossibleMoves(board);
            }
        }
    }

    @Override
    public void put(Vector2 chosenPos, Board board) {
        TileState picked = board.getPicked().getState();
        switch (picked) {
            case PON_1 -> {
                pon1.move(chosenPos,board);
            }
            case PON_2 -> {
                pon2.move(chosenPos,board);
            }
            case QUEEN_1,QUEEN_2 -> {
                queen.move(chosenPos,board);
            }
            case EMPTY -> {
                board.getPicked().setPicked(false);
            }
        }
    }
}
