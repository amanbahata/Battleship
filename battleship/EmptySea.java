package battleship;

/**
 * Created by aman1 on 15/01/2017.
 */
public class EmptySea extends Ship {

    /**
     * Cruiser constructor
     *
     * Calls Ship superclass with length 1, length of an empty ship.
     */

    public EmptySea() {
        super(1);
    }

    /**
     *
     * @return
     */

    @Override
    public boolean isRealShip(){
        return false;
    }

    /**
     *
     * @return
     */

    @Override
    public boolean isSunk(){
        return false;
    }

    /**
     * Describes specific ship type.
     *
     * @return string describing specific ship type
     */

    @Override
    public String getShipType() {
        return "Empty sea";
    }

}
