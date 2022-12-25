package org.example.Client.Model.Rules.FigureRules.FigureMoves;
import org.example.Client.Model.Board.Board;
import org.example.Client.Model.Tile;
import org.example.Client.Model.TileState;
import org.example.Vector2;

public abstract class FigureMove {

    protected Vector2[] normalizedDirections;

    protected FigureMove(Vector2[] normalizedDirections) {
        this.normalizedDirections = normalizedDirections;
    }

    public FigureMove(Vector2 direction){
        this.normalizedDirections= new Vector2[]{direction};
    }

    public boolean canMove(Vector2 chosenPos, Board board){
        Vector2 pickedPos = board.getPickedPos();
        Vector2 direction = new Vector2(chosenPos.getX() - pickedPos.getX(), chosenPos.getY() - pickedPos.getY());
        return  validDirection(direction.normalized()) && board.foundEmpty(chosenPos);
    }

    public void move(Vector2 chosenPos, Board board){
        Tile picked = board.getPicked();
        board.getTile(chosenPos).setState(picked.getState());
        picked.setPicked(false);
        picked.setState(TileState.EMPTY);
    }

    protected boolean validDirection(Vector2 direction){
        return validDestination(direction.normalized());
    }

    protected boolean validDestination(Vector2 destination){
        for(int i=0; i<normalizedDirections.length; i++){
            if(normalizedDirections[i].isEqual(destination)) return true;
        }
        return false;
    }
}
