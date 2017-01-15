package battleship;

import java.util.Random;

/**
 * Created by aman1 on 15/01/2017.
 */
public class Ocean {
    private Ship [][] ships;
    private int shotsFired;
    private int hitCount;
    private int shipsSunk;

    public Ocean(){
        this.shotsFired = 0;
        this.hitCount = 0;
        this.shipsSunk = 0;
        this.ships = new Ship[10][10];
        fillShipsArrayWithEmptySeas(this.ships);
    }

    public void fillShipsArrayWithEmptySeas(Ship[][] ships){
        for (int i=0; i<ships.length; i++){
            for (int j=0; j<ships[i].length; j++){
                ships[i][j] = new EmptySea();
            }
        }

    }

    public Ship getShipLocation(){
        return ships[5][0];
    }

    public int getShotsFired() {
        return shotsFired;
    }


//    public void placeAllShipsRandomly(){
//        Random random = new Random();
//
//    }

    public boolean hasSunkShipAt(int row, int column){
        if (ships[row][column].isRealShip()){
            return true;
        }
        return false;
    }



    public boolean shootAt(int row, int column){
        this.shotsFired += 1;
        if (ships[row][column].isRealShip() && !ships[row][column].isSunk()){
            this.hitCount += 1;
            ships[row][column].shootAt(row, column);
            return true;
        }
        return false;
    }

    public String getShipTypeAt(int row, int column){
        return ships[row][column].getShipType();
    }

    public boolean isOccupied(int row, int column){
        if (isEqual(this.ships[row][column])){
            return true;
        }
        return false;
    }


// Provides an implementation of equals()
    private boolean isEqual(Object obj){
        if (!(obj instanceof EmptySea)){
            return false;
        }
        return true;
    }

    public int getHitCount() {
        return hitCount;
    }

    public int getShipsSunk() {
        return shipsSunk;
    }

    public Ship[][] getShipArray(){
        return this.ships;
    }
}
