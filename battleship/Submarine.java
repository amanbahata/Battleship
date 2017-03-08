package battleship;

/**
 * The Submarine type of ship
 *
 * @author Aman Enghida
 */
public class Submarine extends Ship {

    /**
     *  Submarine constructor.
     *  Calls Ship superclass with length 1, length of a submarine.
     */

    public Submarine(){
        super(1);
    }

    /**
     * Describes specific ship type.
     * @return string describing specific ship type
     */

    @Override
    public String getShipType() {
        return "Submarine";
    }
}
