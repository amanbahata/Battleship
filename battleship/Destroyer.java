package battleship;

/**
 * @author Aman Enghida on 26/12/2016.
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
