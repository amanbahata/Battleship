package battleship;

/**
 * Created by aman1 on 26/12/2016.
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

    public int getBowRow(){
        return this.bowRow;
    }

    public int getBowColumn(){
        return this.bowColumn;
    }

    public boolean isHorizontal(){
        return this.horizontal;
    }
    public int getLength(){
        return this.length;
    }

    public abstract String getShipType();

    public void setBowRow(int row){
        this.bowRow = row;
    }

    public void setBowColumn(int column){
        this.bowColumn = column;
    }

    public void setHorizontal(boolean horizontal){
        this.horizontal = horizontal;
    }

    public boolean shootAt(int row, int column){
        if (Ocean.isOccupied(row,column) && !isSunk()){
            return true;
        }
        return false;
    }

    public boolean isRealShip(){
        return true;
    }

    public boolean isSunk(){
        for (int i = 0; i< hit.length; i++){
            if (!hit[i]){
                return false;
            }
        }
        return true;
    }

}
