package org.example;

public class Vector2 {
    public static final Vector2[] plusDirections = new Vector2[]{new Vector2(1,0),new Vector2(0,1),
                                                                new Vector2(-1,0), new Vector2(0,-1)};

    public static final Vector2[] crossDirections = new Vector2[]{new Vector2(1,1),new Vector2(-1,1),
                                                                new Vector2(-1,-1), new Vector2(1,-1)};
    private int x,y;

    public Vector2(int x, int y){
        this.x=x;
        this.y=y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int manhattanDistance(Vector2 pos){
        return Math.abs(this.getX()- pos.getX()) + Math.abs(this.getY()- pos.getY());
    }

    public boolean inStraightLine( Vector2 pos){
        return this.getX() == pos.getX() || this.getY() == pos.getY();
    }

    public boolean inDiagonal( Vector2 pos){
        return Math.abs(this.getX()- pos.getX()) == Math.abs(this.getY()- pos.getY());
    }

    public boolean areOnShortDiagonal(Vector2 pos){
        return this.manhattanDistance(pos) == 2 && this.inDiagonal(pos);
    }

    public Vector2 normalized() {
        //no support for not diagonal or vertical or horizontal
        if( getX() != 0 && getY() != 0 && Math.abs(getX()) != Math.abs(getY())){
            System.out.println("Not Normalized");
            return new Vector2(0,0);
        }
        // if support exits
        return new Vector2(getX() == 0 ? 0 : getSymbol(getX()),getY() == 0 ? 0 : getSymbol(getY()));
    }

    public int getSymbol(int x){
        return x>0 ? 1 : x<0 ? -1 : 0;
    }

    public void add(Vector2 otherVector) {
        setX(getX()+ otherVector.getX());
        setY(getY()+ otherVector.getY());
    }

    public boolean isEqual(Vector2 otherVector) {
        return getX() == otherVector.getX() && getY() == otherVector.getY();
    }

    private void setY(int i) {
        y=i;
    }

    private void setX(int i) {
        x=i;
    }
}
