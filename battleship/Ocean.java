package battleship;

import java.util.ArrayList;
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


    public void placeAllShipsRandomly() {


// List of ships to be placed randomly
        Ship[] shipType = {
                new BattleShip(),
                new Cruiser(), new Cruiser(),
                new Destroyer(), new Destroyer(), new Destroyer(),
                new Submarine(), new Submarine(), new Submarine(), new Submarine()
        };

        int shipTypeCounter = 0;               // keeps count of the ships that have been placed already
        Random random = new Random();           // it will be user to generate random positions

        while (shipTypeCounter < shipType.length) {

            shipType[shipTypeCounter].setHorizontal(random.nextBoolean());       // Give the ship a random orientation


            if (shipType[shipTypeCounter].isHorizontal()) {          // check the orientation of the ship

   //             System.out.println(shipType[shipTypeCounter].getShipType() + " is horizontal");

                shipType[shipTypeCounter].setBowRow(random.nextInt(10));        // assign random row
                shipType[shipTypeCounter].setBowColumn(random.nextInt(7));      //assign random column

                int xCoord = shipType[shipTypeCounter].getBowRow();
                int yCoord = shipType[shipTypeCounter].getBowColumn();

                for (int i = 0; i < shipType[shipTypeCounter].getLength(); i++) {       // place the created ship in the ships[][]
                    ships[xCoord][yCoord + i] = shipType[shipTypeCounter];
                }
                shipTypeCounter++;

            } else {
  //              System.out.println(shipType[shipTypeCounter].getShipType() + " is vertical");

                shipType[shipTypeCounter].setBowRow(random.nextInt(7));
                shipType[shipTypeCounter].setBowColumn(random.nextInt(10));


                int xCoord = shipType[shipTypeCounter].getBowRow();
                int yCoord = shipType[shipTypeCounter].getBowColumn();

                for (int i = 0; i < shipType[shipTypeCounter].getLength(); i++) {
                    ships[xCoord + i][yCoord] = shipType[shipTypeCounter];
                }
                shipTypeCounter++;


            }
        }
    }



    public boolean hasSunkShipAt(int row, int column){
        if (ships[row][column].isSunk()){
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
        if (this.ships[row][column].getShipType().equals("Empty sea")){
            return false;
        }
        return true;
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
