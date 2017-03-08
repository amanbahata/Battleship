package battleship;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for The Ship class
 *
 * @author Aman Enghida
 */

class ShipTest {


    /**
     * It isn't sunk because it hasn't been shot.
     */

    @Test
    void testIsSunk() {
        assertFalse((new Destroyer()).isSunk());
    }

    /**
     * Shoot the ship ar hit[2].
     * The test should return true when the hit[2] is checked if it has been hit.
     */

    @Test
    void testShootAt() {
        Ship ship = new BattleShip();
        ship.shootAt(2, 0);
        assertTrue(ship.isHitAt(2,0));
    }


    /**
     * It's false because an empty sea is not a ship
     */

    @Test
    void testIsRealShip() {
        assertFalse((new EmptySea()).isRealShip());
    }

    /**
     * It should be true because  a BattleShip() is a "Battleship" type of ship
     */

    @Test
    void testGetShipType() {
        assertEquals("Battleship", (new BattleShip()).getShipType());

    }

    /**
     * The created ship object is vertical by default.
     *  It should be false when checked if is horizontal
     */

    @Test
    void testIsHorizontal() {
        assertFalse((new BattleShip()).isHorizontal());
    }

    /**
     * The new ship has bowRow value of 0 when created,
     * set that to 3. Now the ships' bowRow should be 3.
     */

    @Test
    void testGetBowRow() {
        Ship ship = new BattleShip();
        ship.setBowRow(3);
        assertEquals(3, ship.getBowRow());
    }

    /**
     * The new ship has bowColumn value of 0 when created,
     * set that to 5. Now the ships' bowRow should be 5.
     */

    @Test
    void testGetBowColumn() {
        Ship ship = new BattleShip();
        ship.setBowColumn(5);
        assertEquals(5, ship.getBowColumn());
    }

    /**
     * A BattleShip should have length 4
     */

    @Test
    void testGetLength() {
        assertEquals(4, (new BattleShip()).getLength());
    }

    /**
     * The bowRow should be 2 after setting it to 2
     */

    @Test
    void testSetBowRow() {
        Ship ship = new BattleShip();
        ship.setBowRow(2);
        assertEquals(2, ship.getBowRow());
    }


    /**
     * The bowColumn should be 4 after setting it to 4
     */

    @Test
    void testSetBowColumn() {
        Ship ship = new BattleShip();
        ship.setBowColumn(4);
        assertEquals(4, ship.getBowColumn());
    }

    /**
     * Should be true because the orientation of the ship has been changed from vertical to horizontal
     */

    @Test
    void testSetHorizontal() {
        Ship ship = new Cruiser();
        ship.setHorizontal(true);
        assertTrue(ship.isHorizontal());
    }

    /**
     * Should be true because the ship has been hit at position 3
     */

    @Test
    void testIsHitAt() {
        Ship ship = new BattleShip();
        ship.shootAt(3,0);
        assertTrue(ship.isHitAt(3,0));
    }

    @Test
    void testGetShipArray(){

    }

}