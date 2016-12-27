package battleship;

/**
 * @author Aman Enghida on 26/12/2016.
 */
public class Cruiser extends Ship {
    public Cruiser(){
        super(3);
    }

    @Override
    public String getShipType() {
        return "Cruiser";
    }
}
