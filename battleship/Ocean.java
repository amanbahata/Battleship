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

    public void placeAllShipsRandomly() {
        Random positionGenerator = new Random();
        Ship[] shipsContainer = {
                new BattleShip(),
                new Cruiser(), new Cruiser(),
                new Destroyer(), new Destroyer(), new Destroyer(),
                new Submarine(), new Submarine(), new Submarine(), new Submarine()
        };

        for (Ship ship : shipsContainer){
            boolean placed = false;
            while(!placed){
                ship.setBowRow(positionGenerator.nextInt(ships.length));
                ship.setBowColumn(positionGenerator.nextInt(ships[0].length));
                ship.setHorizontal(positionGenerator.nextBoolean());

                if (ship.isHorizontal()){
                    // check if there is room horizontally to place the ship
                    boolean thereIsSpace = true;
                    for (int i = 0; i < ship.getLength(); i ++){
                        if (ship.getBowColumn() + i >= ships[0].length){
                            thereIsSpace = false;
                            break;
                        }
                        //check if there is room vertically to place the ship
                        if (isOccupied(ship.getBowRow(), ship.getBowColumn() + i)) {
                            thereIsSpace = false;
                            break;
                        }
                    }
                    if (!thereIsSpace){
                        //there is no room to place the ship so let's start over
                        continue;
                    }
                    for (int i = 0; i < ship.getLength(); i ++){
                        ships[ship.getBowRow()][ship.getBowColumn() + i] = ship;
                    }
                    placed = true;
                }else{
                    //we will check when the ship is vertically oriented
                    boolean thereIsSpace = true;
                    for (int i = 0; i < ship.getLength(); i ++){
                        if (ship.getBowRow() + i >= ships.length){
                            thereIsSpace = false;
                            break;
                        }
                        if (isOccupied(ship.getBowRow() + i, ship.getBowColumn())){
                            thereIsSpace = false;
                            break;
                        }
                    }
                    if (!thereIsSpace){
                        continue;
                    }
                    for (int i = 0; i < ship.getLength(); i ++){
                        ships[ship.getBowRow() + i][ship.getBowColumn()] = ship;
                    }
                    placed = true;
                }
            }
        }
    }


    public boolean isOccupied(int row, int column){
        if ( ships[row][column].getShipType().equals("Empty sea")){
            return false;
        }
        return true;
    }

    public boolean hasSunkShipAt(int row, int column){
        if (ships[row][column].isSunk()){
            return true;
        }
        return false;
    }

    public String getShipTypeAt(int row, int column){
        return ships[row][column].getShipType();
    }

    public boolean shootAt(int row, int column){
        this.shotsFired += 1;
        if (ships[row][column].isRealShip() && !ships[row][column].isSunk()){
            this.hitCount += 1;
            return ships[row][column].shootAt(row, column);
        }
        return false;
    }


    public int getShotsFired() {
        return shotsFired;
    }

    public int getHitCount() {
        return hitCount;
    }

    public int getShipsSunk() {
        return shipsSunk;
    }

    public boolean isGameOver() {
        int numberOfShips = 10;
        return shipsSunk == numberOfShips;
    }

    public void print(){
        String locationIndication = ".";
        System.out.print(" ");
        for (int k = 0; k < ships[0].length; k ++){
            System.out.print(k);
        }
        System.out.println();
        for (int i = 0; i < ships.length; i ++){
            System.out.print(i);
            for (int j = 0; j < ships[0].length; j ++){


             // ============ TO DO ================
                if (ships[i][j].){
                    locationIndication = ""
                }




                System.out.print(locationIndication);

            }
            System.out.println();
        }
    }



    public Ship[][] getShipArray(){
        return this.ships;
    }
}
