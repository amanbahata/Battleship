package battleship;

/**
 * Created by aman1 on 26/12/2016.
 */
public class Submarine extends Ship{
    public Submarine(){
        super(1);
    }

    @Override
    public String getShipType() {
        return "Submarine";
    }
}
