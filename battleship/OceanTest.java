package battleship;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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
        // create buffer in memory of all the sent
        ByteArrayOutputStream outputDots = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputDots));
        Ocean ocean = new Ocean();

        //shoot at the empty ocean in random coordinates
        ocean.shootAt(7,7);
        ocean.shootAt(5,5);
        ocean.shootAt(3,3);
        ocean.print();

        // It should show shots on above coordinates with "-" sign
        // since it is an empty ocean the sign should only be a "-" sign
        assertEquals(" 0123456789\n" +
                "0..........\n" +
                "1..........\n" +
                "2..........\n" +
                "3...-......\n" +
                "4..........\n" +
                "5.....-....\n" +
                "6..........\n" +
                "7.......-..\n" +
                "8..........\n" +
                "9..........\n", outputDots.toString());
    }

    @Test
    void getShotsFired() {
        Ocean ocean = new Ocean();
        ocean.shootAt(4,4);
        ocean.shootAt(4,7);
        ocean.shootAt(5,3);

        assertEquals(3, ocean.getShotsFired());
        assertNotEquals(5, ocean.getShotsFired());
    }

    @Test
    void getHitCount() {
        int totalLengthOfShipsInSquares = 4 + (3 * 2) + (2 * 3) + 4;
        int oceanLength = 10;
        int oceanHeight = 10;
        Ocean ocean = new Ocean();
        ocean.placeAllShipsRandomly();
        for(int i=0; i< oceanHeight; i++){
            for (int j=0; j< oceanLength; j++){
                ocean.shootAt(i,j);
            }
        }

        assertEquals(totalLengthOfShipsInSquares, ocean.getHitCount());

    }

    @Test
    void getShipsSunk() {
        int totalNumberOfShipsOnSea = 10;
        int oceanHeight = 10;
        int oceanLength = 10;
        Ocean ocean = new Ocean();
        ocean.placeAllShipsRandomly();

        for(int i=0; i< oceanHeight; i++){
            for (int j=0; j< oceanLength; j++){
                ocean.shootAt(i,j);
            }
        }

        assertEquals(totalNumberOfShipsOnSea, ocean.getShipsSunk());

    }

    @Test
    void isGameOver() {
        Ocean ocean = new Ocean();
        ocean.placeAllShipsRandomly();
        ocean.shootAt(5,5);
        assertFalse(ocean.isGameOver());   // should be false because only one shot has been fired

        Ocean ocean1  = new Ocean();
        ocean1.placeAllShipsRandomly();

        for(int i=0; i< 10; i++){
            for (int j=0; j< 10; j++){
                ocean.shootAt(i,j);
            }
        }
        assertTrue(ocean1.isGameOver());

    }


    @Test
    void print() {
        // create buffer in memory of all the sent
        ByteArrayOutputStream outputDots = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputDots));
        Ocean ocean = new Ocean();
        ocean.print();

        // Check that it prints the square correctly together with the dots and grid numbers
        assertEquals(" 0123456789\n" +
                "0..........\n" +
                "1..........\n" +
                "2..........\n" +
                "3..........\n" +
                "4..........\n" +
                "5..........\n" +
                "6..........\n" +
                "7..........\n" +
                "8..........\n" +
                "9..........\n", outputDots.toString());

    }

}