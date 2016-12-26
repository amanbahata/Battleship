package battleship;

/**
 * Created by aman1 on 26/12/2016.
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
