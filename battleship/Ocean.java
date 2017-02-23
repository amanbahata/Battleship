package battleship;

import java.util.Random;

/**
 * Created by aman1 on 15/01/2017.
 */
public class Ocean {

    // Size of the ocean horizontally and vertically
    private final int OCEANLENGTH = 10;
    private final int OCEANHEIGHT = 10;


    private Ship [][] ships;    // the ocean represented as and array of 10 x 10
    private int shotsFired;     // contains the total number of shots fired during the game
    private int hitCount;       // contains the total of successful hits
    private int shipsSunk;      // contains the number sunk ships


    /**
     * Constructs an empty ocean, fills the ships array with EmptySeas
     * it initializes the game variables
     */

    public Ocean(){
        this.shotsFired = 0;
        this.hitCount = 0;
        this.shipsSunk = 0;
        this.ships = new Ship[OCEANLENGTH][OCEANHEIGHT];
        fillShipsArrayWithEmptySeas();
    }

    /**
     *  Places all ships randomly on the ocean.
     */

    private void fillShipsArrayWithEmptySeas(){
        for (int row = 0; row < ships.length; row++){
            for (int column = 0; column < ships[row].length; column++){
                Ship ship = new EmptySea();

                // place EmptySeas in every square in the aray
                ship.setBowRow(row);
                ship.setBowColumn(column);
                ship.setHorizontal(true);
                this.ships[row][column] = ship;
            }
        }
    }


    /**
     * Places all ten ships randomly on the initially empty ocean.
     * It places larger ships before smaller ones
     */

    public void placeAllShipsRandomly() {
        Random positionGenerator = new Random();

        // Create all the needed ships to be placed
        Ship[] shipsContainer = {
                new BattleShip(),
                new Cruiser(), new Cruiser(),
                new Destroyer(), new Destroyer(), new Destroyer(),
                new Submarine(), new Submarine(), new Submarine(), new Submarine()
        };

        for (Ship ship : shipsContainer){

            // initially a ship is not placed
            boolean placed = false;
            while(!placed){

                //set the game variables of a single ship
                ship.setBowRow(positionGenerator.nextInt(ships.length - 1));
                ship.setBowColumn(positionGenerator.nextInt(ships[0].length - 1));
                ship.setHorizontal(positionGenerator.nextBoolean());

                // check if a ship is assigned a horizontal position
                if (ship.isHorizontal()){
                    // check if there is room vertically to place the ship
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

    /**
     *  Checks if the given location contains a ship
     * @param row
     * @param column
     * @return  boolean
     */

    public boolean isOccupied(int row, int column){
        if ( ships[row][column].getShipType().equals("Empty sea")){
            return false;
        }
        return true;
    }

    /**
     *
     * @param row
     * @param column
     * @return
     */

    public boolean hasSunkShipAt(int row, int column){
        if (ships[row][column].isSunk()){
            this.shipsSunk += 1;
            return true;
        }
        return false;
    }

    /**
     *
     * @param row
     * @param column
     * @return
     */

    public String getShipTypeAt(int row, int column){
        return ships[row][column].getShipType();
    }

    public boolean shootAt(int row, int column) {
        this.shotsFired += 1;
        if (ships[row][column].isRealShip() && !ships[row][column].isSunk()) {
            this.hitCount += 1;
            return ships[row][column].shootAt(row, column);
        }
        ships[row][column].shootAt(row, column);
        return false;
    }

    /**
     *
     * @return
     */

    public int getShotsFired() {
        return shotsFired;
    }

    /**
     *
     * @return
     */

    public int getHitCount() {
        return hitCount;
    }

    /**
     *
     * @return
     */

    public int getShipsSunk() {
        return shipsSunk;
    }

    /**
     *
     * @return
     */

    public boolean isGameOver() {
        int numberOfShips = 10;
        return this.shipsSunk == numberOfShips;
    }

    /**
     *
     */

    public void print(){
      //  String locationIndication = ".";
        System.out.print(" ");
        for (int k = 0; k < ships[0].length; k ++){
            System.out.print(k);
        }
        System.out.println();
        for (int i = 0; i < ships.length; i ++){
            System.out.print(i);
                for (int j = 0; j < ships[0].length; j++) {
                    Ship ship1 = ships[i][j];

                    if (ship1.isRealShip()){
                        if (ship1.isSunk()){
                            System.out.print("X");
                        }else
                            System.out.print(ship1.isHitAt(i,j) ? "S" : ".");
                    }else
                        System.out.print(ship1.isHitAt(i, j) ? "-" : ".");
                }
            System.out.println();
        }
    }


    /**
     *
     * @return
     */

    public Ship[][] getShipArray(){
        return this.ships;
    }
}
