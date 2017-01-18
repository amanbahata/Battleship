package battleship;

/**
 * Created by aman1 on 18/01/2017.
 */
public class Submarine extends Ship {

    public Submarine(){
        super(1);
    }

    @Override
    public String getShipType() {
        return "Submarine";
    }
}
