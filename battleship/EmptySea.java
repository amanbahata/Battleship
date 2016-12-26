package battleship;

/**
 * Created by aman1 on 26/12/2016.
 */
public class EmptySea extends Ship {
    public EmptySea(){
        super(1);
    }

    @Override
    public boolean shootAt(int row, int column){
        return false;
    }

    @Override
    public boolean isSunk(){
        return false;
    }

    @Override
    public boolean isRealShip(){
        return false;
    }

    @Override
    public String getShipType() {
        return "empty sea";
    }
}
