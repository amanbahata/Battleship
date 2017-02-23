package battleship;

/**
 * Created by aman1 on 15/01/2017.
 */
public abstract class Ship {

    /**
     * A ships instance variables
     * @bowRow the row (0 to 9) which contains the bow (front) of the ship.
     * @bowColumn the column (0 to 9) which contains the bow of the ship.
     * @length the number of squares occupied by the ship.
     * @horizontal set to true if the ship occupies a single row.
     * @hit an array of booleans telling whether that part of the ship has been hit.
     */

    private int bowRow;
    private int bowColumn;
    private int length;
    private boolean horizontal;
    private boolean [] hit;


    /**
     *  Ship constructor
     *
     * @param length the number of squares occupied by the ship.
     */

    public Ship(int length){
        this.length = length;
        this.hit = new boolean[length];
    }

    /**
     * Marks the part of the hit array to indicate that the ship has been hit
     * at the position the ship is occupying
     * @param row  the horizontal position of the ship
     * @param column vertical position of the ship
     * @return true if is marked as hit, false otherwise
     */

    public boolean shootAt(int row, int column){
        int hitPosition;                            // location in the hit array
        if (isHorizontal()) {
            hitPosition = column - bowColumn;
            hit[hitPosition] = true;
            return true;
        }else if (!isHorizontal()) {
            hitPosition = row - bowRow;
            hit[hitPosition] = true;
            return true;
        }
        return false;
    }

    /**
     * Check checks if every part of the ship has been hit
     * @return boolean.
     */

    public boolean isSunk(){
        for (int i=0; i< hit.length; i++){
            if (!hit[i]){
                return false;
            }
        }
        return true;
    }


    /**
     * Checks if the ship is real ship. This method eases the development of
     * of classes for real ships.
     * @return true
     */

    public boolean isRealShip(){
        return true;
    }

    /**
     * Abstract method that returns the type of the ship
     * (to be implemented by sub classes)
     */

    public abstract String getShipType();

    /**
     * Instance methods for accessing instance variables.
     * @return horizontal
     */

    public boolean isHorizontal(){
        return horizontal;
    }

    /**
     * @return bowRow.
     */

    public int getBowRow() {
        return bowRow;
    }

    /**
     * @return bowColumn.
     */

    public int getBowColumn() {
        return bowColumn;
    }

    /**
     * @return length number of squares the ship occupies.
     */

    public int getLength() {
        return length;
    }

    /**
     * Instance methods for mutating instance variables.
     * @param row horizontal value to set the front of the ship.
     */

    public void setBowRow(int row) {
        this.bowRow = row;
    }

    /**
     * @param column vertical value to set the front of the ship.
     */

    public void setBowColumn(int column) {
        this.bowColumn = column;
    }

    /**
     * @param horizontal orientation of the ship.
     */

    public void setHorizontal(boolean horizontal) {
        this.horizontal = horizontal;
    }

    /**
     * Determines if the ship has been hit at the location
     * @param row horizontal position of the target.
     * @param column vertical position of the target.
     * @return true has been hit, false otherwise.
     */

    public boolean isHitAt(int row , int column){
        if (isHorizontal()){
            return hit[column - bowColumn];
        }
        return hit[row - bowRow];
    }

}
