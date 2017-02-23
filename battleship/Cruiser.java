package battleship;

/**
 * Created by aman1 on 18/01/2017.
 */
public class Cruiser extends Ship {

    /**
     *
     */
    public Cruiser(){
        super(3);
    }

    /**
     *
     * @return
     */

    @Override
    public String getShipType() {
        return "Cruiser";
    }
}
