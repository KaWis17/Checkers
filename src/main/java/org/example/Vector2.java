package org.example;

/**
 * Vector class helps to send information about position of object on board
 */
public class Vector2 {
    /**
     * Directions that crete "+" shape without the middle
     */
    public static final Vector2[] plusDirections = new Vector2[]{new Vector2(1,0),new Vector2(0,1),
                                                                 new Vector2(-1,0), new Vector2(0,-1)};
    /**
     * Directions that crete "x" shape without the middle
     */
    public static final Vector2[] crossDirections = new Vector2[]{new Vector2(1,1),new Vector2(-1,1),
                                                                  new Vector2(-1,-1), new Vector2(1,-1)};
    /**
     * positions of vector
     */
    private int x,y;

    /**
     * Vector constructor
     * @param x x
     * @param y y
     */
    public Vector2(int x, int y){
        this.x=x;
        this.y=y;
    }

    /**
     * getter for x
     * @return x
     */
    public int getX() {
        return x;
    }

    /**
     * getter for y
     * @return y
     */
    public int getY() {
        return y;
    }

    /**
     * function that normalizes the vector if this vector is on straight line from pon
     * @return normalized vector
     */
    public Vector2 normalized() {
        //no support for not diagonal or vertical or horizontal
        if( getX() != 0 && getY() != 0 && Math.abs(getX()) != Math.abs(getY())){
            System.out.println("Not Normalized");
            return new Vector2(0,0);
        }
        // if support exits
        return new Vector2(getX() == 0 ? 0 : getSymbol(getX()),getY() == 0 ? 0 : getSymbol(getY()));
    }

    /**
     * function that returns symbol of integer
     * @param x number
     * @return symbol
     */
    private int getSymbol(int x){
        return Integer.compare(x, 0);
    }

    /**
     * function that adds other vector to this vector
     * @param otherVector other vector
     */
    public void add(Vector2 otherVector) {
        setX(getX()+ otherVector.getX());
        setY(getY()+ otherVector.getY());
    }

    public int manhattanDistance(Vector2 otherVector){
        return Math.abs(getX()- otherVector.getX())+Math.abs(getY()- otherVector.getY());
    }

    /**
     * function that checks if other vector has equal coordinates to this vector
     * @param otherVector other vector
     * @return answer
     */
    public boolean isEqual(Vector2 otherVector) {
        return getX() == otherVector.getX() && getY() == otherVector.getY();
    }

    /**
     * setter for y
     * @param i i
     */
    private void setY(int i) {
        y=i;
    }

    /**
     * setter for x
     * @param i i
     */
    private void setX(int i) {
        x=i;
    }
}
