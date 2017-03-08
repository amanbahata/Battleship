package battleship;

/**
 * The Destroyer type of ship
 * @author Aman Enghida
 */
public class Destroyer extends Ship {

    /**
     * Destroyer constructor
     * Calls Ship superclass with length 2, length of a destroyer ship.
     */

    public Destroyer(){
        super(2);
    }

    /**
     * Describes specific ship type.
     * @return string describing specific ship type
     */

    @Override
    public String getShipType() {
        return "Destroyer";
    }
}
