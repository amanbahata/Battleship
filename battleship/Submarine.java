package battleship;

/**
 * The Submarine type of ship
 *
 * @author Aman Enghida
 */
public class Submarine extends Ship {

    /**
     * Length of a Submarine
     */

    private static int LENGTH = 4;


    /**
     *  Submarine constructor.
     *  Calls Ship superclass with length 1, length of a submarine.
     */

    public Submarine(){
        super(LENGTH);
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
