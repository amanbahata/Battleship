package battleship;

/**
 * Created by aman1 on 26/12/2016.
 */
public class EmptySea extends Ship {
    public EmptySea(){
        super(1);
    }

    @Override
    public String getShipType() {
        return "Empty sea";
    }
}
