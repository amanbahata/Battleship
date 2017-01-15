package battleship;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by aman1 on 15/01/2017.
 */
class OceanTest {

    Ocean ocean = new Ocean();


    @Test
    public void testOceanConstructor1(){
        assertEquals("Empty sea", ocean.getShipLocation().toString());
    }

    @Test
    public void testIsOccupied(){
        assertEquals(true, ocean.isOccupied(5,0));
    }

    @Test
    public void testGetShipTypeAt(){
        String emptySea = "Empty sea";
        assertEquals(emptySea, ocean.getShipTypeAt(0,0));
    }

    @Test
    public void testShootAt(){
        assertEquals(false, ocean.shootAt(0,3));
    }




}