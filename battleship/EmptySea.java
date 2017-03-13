package battleship;

/**
 * Represents
 */
public class EmptySea extends Ship {

    /**
     * Length of each empty sea.
     */

    private static int LENGTH = 1;



    /**
     * Cruiser constructor
     * Calls Ship superclass with length 1, length of an empty ship.
     */

    public EmptySea() {
        super(LENGTH);
    }

    /**
     * This method overrides isRealShip() that is inherited from Ship.
     * Checks if it is a real ship.
     * @return false. The empty sea is not a real ship.
     */

    @Override
    public boolean isRealShip(){
        return false;
    }

    /**
     * This method overrides isSunk() that is inherited from Ship.
     * @return false indication that nothing was sunk.
     */

    @Override
    public boolean isSunk(){
        return false;
    }

    /**
     * Describes specific ship type.
     * @return string describing specific ship type.
     */

    @Override
    public String getShipType() {
        return "Empty sea";
    }

    /**
     * Overrides shootAt method inherited from Ship
     * @param row  the horizontal position of the ship
     * @param column vertical position of the ship
     * @return false to indicate that nothing was hit
     */

    @Override
    public boolean shootAt(int row, int column){
        super.shootAt(row,column);
        return false;
    }

}
