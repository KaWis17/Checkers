package org.example.Client.Model.Rules.FigureRules.FigureMoves.Queens;

import org.example.Client.Model.Board.Board;
import org.example.Client.Model.Rules.FigureRules.FigureMoves.FigureMove;
import org.example.Vector2;

public class LineMove extends FigureMove {
    
    public LineMove(Vector2[] directions){
        super(directions);
    }
    
    @Override
    public boolean canMove(Vector2 chosenPos, Board board) {
        Vector2 pickedPos = board.getPickedPos();
        Vector2 direction = new Vector2(chosenPos.getX() - pickedPos.getX(), chosenPos.getY() - pickedPos.getY());
        return  validDirection(direction.normalized()) &&
                board.emptyLine(pickedPos,chosenPos,direction) &&
                !board.sameTeam(pickedPos,chosenPos);
    }
}
