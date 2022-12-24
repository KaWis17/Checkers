package org.example.Client.Model.Rules;

import java.util.ArrayList;
import java.util.List;
import org.example.Client.Model.Board.Board;
import org.example.Client.Model.Rules.FigureRules.Figure;
import org.example.Client.Model.Rules.FigureRules.FigureMoves.FigureMove;
import org.example.Client.Model.Rules.FigureRules.FigureMoves.Pon.PonAttack;
import org.example.Client.Model.Rules.FigureRules.FigureMoves.Pon.PonMove;
import org.example.Client.Model.Rules.FigureRules.FigureMoves.Queens.QueenMove;
import org.example.Client.Model.TileState;
import org.example.Vector2;

public class ClassicRules implements Rules {
    Figure pon;
    Figure queen;

    public ClassicRules() {
        // POPRAWIC
        List<FigureMove> ponMoves = new ArrayList<>();
        ponMoves.add(new PonAttack());
        ponMoves.add(new PonMove());
        pon = new Figure(ponMoves);
        List<FigureMove> queenMoves = new ArrayList<>();
        queenMoves.add(new QueenMove());
        queen = new Figure(queenMoves);
    }

    @Override
    public void pick(Vector2 chosen, Board board) {
        if(board.getTiles()[chosen.getX()][chosen.getY()].getState() == TileState.EMPTY)
            return;
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                board.getTiles()[i][j].setPicked( (chosen.getX() == i && chosen.getY() == j) );
            }
        }
    }

    @Override
    public void put(Vector2 chosenPos, Board board) {
        TileState picked = board.getPicked().getState();
        switch (picked) {
            case PON_1,PON_2 -> {
                pon.move(chosenPos,board);
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
