package battleship;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for The Ocean class
 *
 * @author Aman Enghida
 */
class OceanTest {


    @Test
    void testOceanConstructor(){
        Ocean ocean = new Ocean();

        // Should check that all game variables are set to 0
        assertEquals(0, ocean.getShotsFired());
        assertEquals(0, ocean.getHitCount());
        assertEquals(0,ocean.getShipsSunk());
    }


    @Test
    void placeAllShipsRandomly() {
        Ocean ocean = new Ocean();

        System.out.println(ocean.getShipArray());

    }

    @Test
    void isOccupied() {

    }

    @Test
    void hasSunkShipAt() {

    }

    @Test
    void getShipTypeAt() {

    }

    @Test
    void shootAt() {

    }

    @Test
    void getShotsFired() {

    }

    @Test
    void getHitCount() {

    }

    @Test
    void getShipsSunk() {

    }

    @Test
    void isGameOver() {

    }

    @Test
    void print() {

    }

    @Test
    void getShipArray(){

    }

}