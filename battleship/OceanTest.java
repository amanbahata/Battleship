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




}