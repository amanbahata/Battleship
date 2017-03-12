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
    void placeAllShipsRandomly(){
        Ocean ocean = new Ocean();
        ocean.placeAllShipsRandomly();

        //Use the getShipArray method to retrieve the locations of all the ships
        Ship[][] ships = ocean.getShipArray();
        assertEquals(ocean.getShipTypeAt(0,0), ships[0][0].getShipType());
    }

    @Test
    void isOccupied() {
        Ocean ocean = new Ocean();
        assertFalse(ocean.isOccupied(5,5));  //should return false because all the ships haven't
                                                            // been place randomly yet
    }

    @Test
    void hasSunkShipAt() {
        Ocean ocean = new Ocean();
        ocean.placeAllShipsRandomly();

        ocean.shootAt(6,5);

        if (ocean.isOccupied(6,5) && ocean.getShipTypeAt(6,5) != "Submarine"){
            ocean.shootAt(6,5);
            assertTrue(ocean.hasSunkShipAt(6,5));
        }else{
            assertFalse(ocean.hasSunkShipAt(6,5));
        }
    }

    @Test
    void getShipTypeAt() {
        Ocean ocean = new Ocean();
        ocean.placeAllShipsRandomly();
        Ship[][] ships = ocean.getShipArray();
        assertEquals(ships[8][8].getShipType(), ocean.getShipTypeAt(8,8));
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
        Ocean ocean = new Ocean();
        ocean.placeAllShipsRandomly();
        ocean.shootAt(5,5);
        assertFalse(ocean.isGameOver());
    }

    @Test
    void print() {

    }

}