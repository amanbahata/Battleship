package battleship;

/**
 * Represents a Cruiser type of Ship
 * @author Aman Enghida
 */
public class Cruiser extends Ship {

    /**
     * Length of a Cruiser
     */

    private static int LENGTH = 3;


    /**
     * Cruiser constructor
     * Calls Ship superclass with length 3, length of a cruiser ship.
     */

    public Cruiser(){
        super(LENGTH);
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
