package battleship;

/**
 * Created by aman1 on 15/01/2017.
 */
public class BattleShip extends Ship {

    /**
     *  BattleShip constructor.
     *  Calls Ship superclass with length 4, length of a battleship.
     */

    public BattleShip() {
        super(4);
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
