package lab1.classes;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GangsterTest {

    private Gangster gangster1;

    private Gangster gangster2;

    private Gangster gangster3;

    private Policeman policeman;

    @Before
    public void setUp() throws Exception {
        gangster1 = new Gangster("Max", 100, WeaponType.GUN);
        gangster2 = new Gangster("Alex", 80, WeaponType.GUN);
        gangster3 = new Gangster("Max", 100, WeaponType.GUN);
        policeman = new Policeman("Oleg", 100);
    }

    @Test
    public void shootAtHuman() {
        gangster1.shootAtHuman(policeman);
        assertEquals("Policemen is not a human, he is a GOD", policeman.getHP(), 70);
    }

    @Test
    public void testEquals() {
        assertTrue("Equals does not work!", gangster1.equals(gangster3));
        assertFalse("Equals does not work!", gangster1.equals(gangster2));
    }

    @Test
    public void testHashCode() {
        assertEquals("Hash code is different for the same object", gangster1.hashCode(), gangster3.hashCode());
        assertNotEquals("Hash code is different for the same object", gangster1.hashCode(), gangster2.hashCode());
    }
}