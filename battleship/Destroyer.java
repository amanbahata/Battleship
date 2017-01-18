package battleship;

/**
 * Created by aman1 on 18/01/2017.
 */
public class Destroyer extends Ship {

    public Destroyer(){
        super(2);
    }

    @Override
    public String getShipType() {
        return "Destroyer";
    }
}
