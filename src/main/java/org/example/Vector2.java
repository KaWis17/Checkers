package org.example;

public class Vector2 {
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

}
