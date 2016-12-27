package battleship;

/**
 * @author Aman Enghida on 26/12/2016.
 */
public class Ocean {
    private Ship [][] ships;
    private int shotsFired;
    private int hitCount;
    private int shipsSunk;

    public Ocean(){
        ships = new Ship[10][10];
        fillShips();
        shotsFired = 0;
        hitCount = 0;
        shipsSunk = 0;
    }

    private void fillShips(){
        for (int i = 0; i < ships.length; i++){        // i = row
            for (int j = 0; j<ships.length; j++){      // j = columns
                ships[i][j] = new EmptySea();
            }
        }
    }

    public void placeAllShipsRandomly(){

    }

    public boolean isOccupied(int row, int column){
        return false;
    }

    public boolean hasSunkShipAt(int row, int column){
        return false;
    }

    public String getShipTypeAt(int row, int column){return "";}

    public boolean shootAt(int row, int column){ return false; }

    public int getShotsFired(){ return this.shotsFired; }

    public int getHitCount(){ return this.hitCount; }

    public int getShipsSunk(){ return this.shipsSunk; }

    public boolean isGameOver(){
        int totalNoOfShips = 10 ;
        if (this.shipsSunk == totalNoOfShips){
            return true;
        }
        return false;
    }

}
