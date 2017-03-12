package battleship;

import java.util.Random;

/**
 * The ocean that holds all the ships
 *
 * @author Aman Enghida
 */

public class Ocean {

    /**
     * Instance variables
     *
     * - OCEANLENGTH row size of the ocean array.
     * - OCEANHEIGHT column size of the ocean array.
     * - NUMBEROFSHIPS the total number of ships.
     * - ships array to quickly determine which ship is at in any given location
     * - shotsFired the total numbers of shots fired by the user
     * - hitCount the number of times a shot hit a ship.
     * - shipsSunk the number of ships sunk
     */

    private final int OCEANLENGTH = 10;
    private final int OCEANHEIGHT = 10;
    private final int NUMBEROFSHIPS = 10;
    private Ship [][] ships;
    private int shotsFired;
    private int hitCount;
    private int shipsSunk;


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
     *  Places all ships randomly on the initially empty ocean.
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
     * Places all ten ships randomly on the on the ocean.
     * It places larger ships before smaller ones. It checks if the new ship
     * overlaps, touch another ship or sticks out of the defined array.
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

                //variable that keeps track of the presence of space
                boolean thereIsSpace = true;

                // check if a ship is assigned a horizontal position
                if (ship.isHorizontal()){
                    // check if there is room vertically to place the ship
                    for (int i = 0; i < ship.getLength(); i ++){
                        if (ship.getBowColumn() + i >= OCEANLENGTH){
                            thereIsSpace = false;
                            break;
                        }
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
                    for (int i = 0; i < ship.getLength(); i ++){
                        if (ship.getBowRow() + i >= OCEANHEIGHT){
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
     * Checks if the given location contains a ship
     * @param row horizontal position to check
     * @param column vertical position to check
     * @return  boolean true if the given location contains a ship, false otherwise
     */

    public boolean isOccupied(int row, int column){
        if ( ships[row][column].getShipType().equals("Empty sea")){
            return false;
        }
        return true;
    }

    /**
     * Checks weather the shot has sunk a ship or not
     * @param row horizontal position to check
     * @param column vertical position to check
     * @return true if the shot has sank the ship, false otherwise
     */

    public boolean hasSunkShipAt(int row, int column){
        if (ships[row][column].isSunk()){
            this.shipsSunk += 1;
            return true;
        }
        return false;
    }

    /**
     * Returns the ship type at a given location
     * @param row horizontal position to check
     * @param column vertical position to check
     * @return the ship type at the location
     */

    public String getShipTypeAt(int row, int column){
        return ships[row][column].getShipType();
    }

    /**
     * Shoots at the part of the ship at that location.
     * In addition the method updates the number of shots that have been fired and
     * the number of hits.
     * @param row location of the position
     * @param column location of the position
     * @return true if the given location contains a real ship and still afloat,
     * false otherwise.
     */

    public boolean shootAt(int row, int column) {
        this.shotsFired += 1;
        if (ships[row][column].isRealShip() && !ships[row][column].isSunk()) {
            this.hitCount += 1;
        }
        return ships[row][column].shootAt(row, column);
    }

    /**
     * Retrieves the number of the shots that have been by the user
     * @return number of the shots fired
     */

    public int getShotsFired() {
        return this.shotsFired;
    }

    /**
     * Retrieves the number of hits recorded. All hits are counted.
     * @return the number of hits
     */

    public int getHitCount() {
        return this.hitCount;
    }

    /**
     * Retrieves the number of ships that have been sunk by the user.
     * @return number of ships sunk
     */

    public int getShipsSunk() {
        return this.shipsSunk;
    }

    /**
     * Checks if all ships have been sunk by user and is game over
     * @return true if the number of sunk ships is equal to the available ships, false otherwise.
     */

    public boolean isGameOver() {
        return this.shipsSunk == this.NUMBEROFSHIPS;
    }

    /**
     * Returns the 10 x 10 array of ships.
     * This method is needed for testing and returns the actual array of
     * actual ships.
     * @return actual array of ships.
     */

    public Ship[][] getShipArray(){
        return this.ships;
    }

    /**
     * Prints the ocean in stdout.To aid the user
     * - row numbers are displayed along the left edge of the array.
     * - column numbers are displayed along the top.
     * - the top left corner is indicated as (0,0)
     * - "S" indicates a location fired upon where a real ship is hit.
     * - "-" indicates a location fired upon and nothing was found.
     * - "X" indicates a location containing a sunken ship.
     * - "." indicates a location never fired upon.
     */

    public void print(){
        System.out.print(" ");

        // Display the top numbers
        for (int k = 0; k < ships[0].length; k ++){
            System.out.print(k);
        }
        System.out.println();

        // Display the side numbers together with the indicators
        for (int i = 0; i < ships.length; i ++){
            System.out.print(i);
                for (int j = 0; j < ships[0].length; j++) {
                    Ship ship1 = ships[i][j];
                    if (ship1.isRealShip()){         // check first if there is a real ship at that position
                        if (ship1.isSunk()){
                            System.out.print("X");
                        }else
                            System.out.print(ship1.isHitAt(i,j) ? "S" : ".");   // check if that position has been hit and display accordingly
                    }else
                        System.out.print(ship1.isHitAt(i, j) ? "-" : ".");  // check if there is nothing there and display accordingly
                }
            System.out.println();
        }
    }
}
