package battleship;

/**
 * Created by aman1 on 15/01/2017.
 */
public class EmptySea extends Ship {

    public EmptySea() {
        super(1);
    }

//    @Override
//    public boolean shootAt(int row, int column){
//
//    }

    @Override
    public boolean isRealShip(){
        return false;
    }

    @Override
    public boolean isSunk(){
        return false;
    }

    @Override
    public String getShipType() {
        return "Empty sea";
    }
}
