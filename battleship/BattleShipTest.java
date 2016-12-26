package battleship;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by aman1 on 26/12/2016.
 */
class BattleShipTest {

    @Test
    public void test(){
        Ship ship = new BattleShip();
        int result = ship.getLength();
        assertEquals(4,result);
    }


}