package battleship;

/**
 * Created by aman1 on 15/01/2017.
 */
public class BattleShip extends Ship {

    /**
     *
     */

    public BattleShip() {
        super(4);
    }

    /**
     *
     * @return
     */

    @Override
    public String getShipType() {
        return "Battleship";
    }
}
