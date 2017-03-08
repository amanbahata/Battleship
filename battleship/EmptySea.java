package battleship;

/**
 * Represents
 */
public class EmptySea extends Ship {

    /**
     * Cruiser constructor
     * Calls Ship superclass with length 1, length of an empty ship.
     */

    public EmptySea() {
        super(1);
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

}
