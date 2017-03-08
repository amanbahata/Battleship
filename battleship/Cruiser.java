package battleship;

/**
 * Represents a Cruiser type of Ship
 * @author Aman Enghida
 */
public class Cruiser extends Ship {

    /**
     * Cruiser constructor
     * Calls Ship superclass with length 3, length of a cruiser ship.
     */

    public Cruiser(){
        super(3);
    }

    /**
     * Describes specific ship type.
     * @return string describing specific ship type
     */

    @Override
    public String getShipType() {
        return "Cruiser";
    }
}
