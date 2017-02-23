package battleship;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by aman1 on 16/02/2017.
 */
class OceanTest {


    @Test
    void fillShipsArrayWithEmptySeas() {
        Ocean ocean = new Ocean();
        Ship sea = new EmptySea();
        Ship[][] array = ocean.getShipArray();
        assertEquals(array[0][0].getShipType(),sea.getShipType());
    }

//    @Test
//    void placeAllShipsRandomly() {
//        Ocean ocean = new Ocean();
//        fillShipsArrayWithEmptySeas();
//        placeAllShipsRandomly();
//
//    }

    @Test
    void isOccupied() {
        Ocean ocean = new Ocean();
        Ship[][] shipArray = ocean.getShipArray();
        assertFalse(ocean.isOccupied(0,0));
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
    void getShipArray() {

    }

}