package battleship;

/**
 * Created by aman1 on 15/01/2017.
 */
public class EmptySea extends Ship {

    /**
     *
     */

    public EmptySea() {
        super(1);
    }

    /**
     *
     * @return
     */

    @Override
    public boolean isRealShip(){
        return false;
    }

    /**
     *
     * @return
     */

    @Override
    public boolean isSunk(){
        return false;
    }

    /**
     *
     * @return
     */

    @Override
    public String getShipType() {
        return "Empty sea";
    }
}
