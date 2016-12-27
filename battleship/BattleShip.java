package battleship;

/**
 * @author  Aman Enghida on 26/12/2016.
 */
public class BattleShip extends Ship {

    public BattleShip(){
        super(4);
    }

    @Override
    public String getShipType() {
        return "Battle ship";
    }
}
