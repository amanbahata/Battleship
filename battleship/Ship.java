package battleship;

/**
 * Created by aman1 on 15/01/2017.
 */
public abstract class Ship {
    private int bowRow;
    private int bowColumn;
    private int length;
    private boolean horizontal;
    private boolean [] hit;

    public Ship(int length){
        this.length = length;
        this.hit = new boolean[length];
    }

    public boolean shootAt(int row, int column){

        if (this.horizontal) {
            if ((row == this.bowRow) && column >= bowColumn & column <= (bowColumn + length)-1) {
                if(!isSunk()){
                    int hitPositionOfTheShip = (bowColumn + length - 1) - column ;
                    hit[hitPositionOfTheShip] = true;
                    return true;
                }
            }
        }
        else if (!this.horizontal) {
            if ((column == this.bowColumn) && row >= bowRow & row <= (bowRow + length)-1) {
                if(!isSunk()){
                    int hitPositionOfTheShip = (bowRow + length - 1) - row ;
                    hit[hitPositionOfTheShip] = true;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isSunk(){
        for (int i=0; i< hit.length; i++){
            if (!hit[i]){
                return false;
            }
        }
        return true;
    }

    public boolean isRealShip(){
        return true;
    }

    public abstract String getShipType();

    public boolean isHorizontal(){
        return horizontal;
    }

    public int getBowRow() {
        return bowRow;
    }

    public void setBowRow(int row) {
        this.bowRow = row;
    }

    public int getBowColumn() {
        return bowColumn;
    }

    public void setBowColumn(int column) {
        this.bowColumn = column;
    }

    public int getLength() {
        return length;
    }

    public void setHorizontal(boolean horizontal) {
        this.horizontal = horizontal;
    }
}
