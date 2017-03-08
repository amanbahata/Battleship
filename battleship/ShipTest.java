package battleship;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by aman1 on 23/02/2017.
 */
class ShipTest {

    Ship ship = new Ship(4) {
        @Override
        public String getShipType() {
            return "Battleship";
        }
    };

    @Test
    void shootAt() {
        ship.setHorizontal(true);
        ship.shootAt(0, 1);
        assertTrue(ship.isHitAt(0,1));
        assertFalse(ship.isHitAt(0,2));


    }

    @Test
    void isSunk() {
        assertFalse(ship.isSunk());
    }

    @Test
    void isRealShip() {
        assertTrue(ship.isRealShip());
        assertFalse(!ship.isRealShip());
    }

    @Test
    void getShipType() {
        assertEquals("Battleship", ship.getShipType());

    }

    @Test
    void isHorizontal() {
        ship.setHorizontal(false);
        assertEquals(false, ship.isHorizontal());
    }

    @Test
    void getBowRow() {
        ship.setBowRow(0);
        assertEquals(0, ship.getBowRow());
    }

    @Test
    void getBowColumn() {
        ship.setBowColumn(0);
        assertEquals(0, ship.getBowColumn());
    }

    @Test
    void getLength() {
        assertEquals(4, ship.getLength());
    }

    @Test
    void setBowRow() {
        ship.setBowRow(2);
        assertEquals(2, ship.getBowRow());
    }

    @Test
    void setBowColumn() {
        ship.setBowColumn(2);
        assertEquals(2, ship.getBowColumn());
    }

    @Test
    void setHorizontal() {
        ship.setHorizontal(true);
        assertTrue(ship.isHorizontal());
    }

    @Test
    void isHitAt() {
        ship.shootAt(0,0);
        assertTrue(ship.isHitAt(0,0));
    }

}