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


    public void placeAllShipsRandomly(){

        Ship[] shipType = {new BattleShip(), new BattleShip()};
        int shipTypeCounter = 0;
        Random random = new Random();

        while(shipTypeCounter < shipType.length){

            shipType[shipTypeCounter].setHorizontal(random.nextBoolean());


            if (shipType[shipTypeCounter].isHorizontal()){

                System.out.println(shipType[shipTypeCounter] + " is horizontal");

                shipType[shipTypeCounter].setBowRow(random.nextInt(10));
                shipType[shipTypeCounter].setBowColumn(random.nextInt(7));


            }else{
                System.out.println(shipType[shipTypeCounter] + " is vertical");


            }
        }

        // placing a battle ship
        Ship battleShip1 = new BattleShip();
        battleShip1.setHorizontal(random.nextBoolean());

        if (battleShip1.isHorizontal()){
            System.out.println("Battle ship is horizontal");

            battleShip1.setBowRow(random.nextInt(10));
            battleShip1.setBowColumn(random.nextInt(7));

            int row = battleShip1.getBowRow();
            int column = battleShip1.getBowColumn();


            for (int i=0; i<battleShip1.getLength(); i++) {
                ships[row][column + i] = battleShip1;
            }

            System.out.println("row: " + battleShip1.getBowRow());
            System.out.println("column: " + battleShip1.getBowColumn());

//            battleShip1.setBowRow(random.nextInt(10));
//            battleShip1.setBowColumn(random.nextInt(7));
//
//            for (int i=battleShip1.getBowColumn(); i< battleShip1.getLength(); i++){
//                System.out.println(battleShip1.getBowRow() + " " + i);
//                ships[battleShip1.getBowRow()][i] = battleShip1 ;
//            }
        }
        else {
            System.out.println("Battle ship is vertical");


            battleShip1.setBowRow(random.nextInt(7));
            battleShip1.setBowColumn(random.nextInt(10));


            int row = battleShip1.getBowRow();
            int column = battleShip1.getBowColumn();

             for (int i = 0; i< battleShip1.getLength(); i++) {
                 ships[row + i][column] = battleShip1;
             }

            System.out.println("row: " + battleShip1.getBowRow());
            System.out.println("column: " + battleShip1.getBowColumn());

//            battleShip1.setBowRow(random.nextInt(7));
//            battleShip1.setBowColumn(random.nextInt(10));
//            for (int i = battleShip1.getBowRow(); i < battleShip1.getLength(); i++) {
//
//                System.out.println(i + " " + battleShip1.getBowColumn());
//
//                ships[i][battleShip1.getBowColumn()] = battleShip1;
//            }
        }
    }


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
