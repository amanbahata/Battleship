package battleship;

/**
 * Created by aman1 on 15/01/2017.
 */
public abstract class Ship {

    /**
     *
     */

    private int bowRow;
    private int bowColumn;
    private int length;
    private boolean horizontal;
    private boolean [] hit;


    /**
     *
     * @param length
     */

    public Ship(int length){
        this.length = length;
        this.hit = new boolean[length];
    }

    /**
     *
     * @param row
     * @param column
     * @return
     */

    public boolean shootAt(int row, int column){
        int hitPosition;
        if (isHorizontal()) {
            hitPosition = column - bowColumn;
            hit[hitPosition] = true;
            return true;
        }
        hitPosition = row - bowRow;
        hit[hitPosition] = true;
        return true;
    }

    /**
     *
     * @return
     */

    public boolean isSunk(){
        for (int i=0; i< hit.length; i++){
            if (!hit[i]){
                return false;
            }
        }
        return true;
    }

    /**
     *
     * @return
     */

    public boolean isRealShip(){
        return true;
    }

    /**
     *
     * @return
     */

    public abstract String getShipType();

    /**
     *
     * @return
     */

    public boolean isHorizontal(){
        return horizontal;
    }

    /**
     *
     * @return
     */

    public int getBowRow() {
        return bowRow;
    }

    /**
     *
     * @param row
     */

    public void setBowRow(int row) {
        this.bowRow = row;
    }

    /**
     *
     * @return
     */

    public int getBowColumn() {
        return bowColumn;
    }

    /**
     *
     * @param column
     */

    public void setBowColumn(int column) {
        this.bowColumn = column;
    }

    /**
     *
     * @return
     */

    public int getLength() {
        return length;
    }

    /**
     *
     * @param horizontal
     */

    public void setHorizontal(boolean horizontal) {
        this.horizontal = horizontal;
    }

    /**
     *
     * @param row
     * @param column
     * @return
     */

    public boolean isHitAt(int row , int column){
        if (isHorizontal()){
            return hit[column - bowColumn];
        }
        return hit[row - bowRow];
    }

}
