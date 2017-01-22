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


    public int getShotsFired() {
        return shotsFired;
    }

    private boolean placeSingleShip(Ship ship, int row, int column){

        if (!isOccupied(row, column)) {
            ship.setBowRow(row);
            ship.setBowColumn(column);

            if (ship.isHorizontal()){
                for (int i = column + 1; i<=ship.getLength(); i++) {
                    ships[row][i] = ship;
                }
            }else{
                for (int j= row + 1; j<=ship.getLength(); j++){
                    ships[j][column] = ship;
                }
            }

            return true;
        }
        return false;
    }


    public void placeAllShipsRandomly(){
        int index = 0;
        Ship[] shipTypes = {
                new BattleShip(),
                new Cruiser(), new Cruiser(),
                new Destroyer(),new Destroyer(),new Destroyer(),
                new Submarine(), new Submarine(), new Submarine(), new Submarine()
        };

        Random random = new Random();
        int row, column;

        while (index < shipTypes.length){

            shipTypes[index].setHorizontal(random.nextBoolean());
            row = random.nextInt(10);
            column = random.nextInt(11 - shipTypes[index].getLength());

            if (shipTypes[index].isHorizontal() && placeSingleShip(shipTypes[index], row, column)) {
                index++;
            }else if (!shipTypes[index].isHorizontal() && placeSingleShip(shipTypes[index], column, row)){
                index++;
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
        if ( ships[row][column].getShipType().equals("Empty sea")){
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
