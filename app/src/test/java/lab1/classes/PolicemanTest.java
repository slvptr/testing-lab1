package lab1.classes;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PolicemanTest {

    private Policeman policeman1;
    private Policeman policeman2;
    private Policeman policeman3;
    private Gangster gangster1;

    @Before
    public void setUp() throws Exception {
        policeman1 = new Policeman("Alex", 100);
        gangster1 = new Gangster("Max", 100, WeaponType.GUN);
        policeman2 = new Policeman("Oleg", 100);
        policeman3 = new Policeman("Alex", 100);
    }

    @Test
    public void shootAtHuman() {
        policeman1.shootAtHuman(gangster1);
        assertEquals("Policemen is not a human, he is a GOD", gangster1.getHP(), 70);
    }

    @Test
    public void testEquals() {
        assertTrue("Equals does not work!", policeman1.equals(policeman3));
        assertFalse("Equals does not work!", policeman1.equals(policeman2));
    }

    @Test
    public void testHashCode() {
        assertEquals("Hash code is different for the same object", policeman1.hashCode(), policeman3.hashCode());
        assertNotEquals("Hash code is different for the same object", policeman1.hashCode(), policeman2.hashCode());
    }
}