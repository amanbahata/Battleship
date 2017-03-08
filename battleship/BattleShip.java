package battleship;

/**
 * Represents a BattleShip type of Ship
 *
 * @author Aman Enghida
 */
public class BattleShip extends Ship {

    /**
     * Length of a BattleShip
     */

    private static int LENGTH = 4;

    /**
     *  BattleShip constructor.
     *  Calls Ship superclass with length 4, length of a battleship.
     */

    public BattleShip() {
        super(LENGTH);
    }

    /**
     * Describes specific ship type.
     * @return string describing specific ship type
     */

    @Override
    public String getShipType() {
        return "Battleship";
    }
}
