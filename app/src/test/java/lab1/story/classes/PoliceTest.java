package lab1.story.classes;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PoliceTest {

    Police police;

    Policeman policeman1;

    Policeman policeman2;

    Policeman policeman3;

    Gangster gangster;

    @Before
    public void setUp() throws Exception {
        gangster = new Gangster("Victor", 100, WeaponType.GRENADE);
        policeman1 = new Policeman("Alex", 100);
        policeman2 = new Policeman("Max", 100);
        policeman3 = new Policeman("Max", 100);
        police = new Police("Police", policeman1, policeman2, policeman3);
    }

    @Test
    public void getSquadState() {
        assertEquals("Wrong number of policemen", police.getSquadState(), 0);
        gangster.shootAtHuman(policeman1);
        assertEquals("Wrong number of policemen", police.getSquadState(), 1);
        assertNotEquals("Wrong number of policemen", police.getSquadState(), 0);
    }

    @Test
    public void testEquals() {
        assertEquals("Equals does not work!", policeman2, policeman3);
        assertNotEquals("Equals does not work!", policeman1, policeman2);
    }

    @Test
    public void testHashCode() {
        assertEquals("Hash code is different for the same object", policeman2.hashCode(), policeman3.hashCode());
        assertNotEquals("Hash code is different for the same object", policeman1.hashCode(), policeman2.hashCode());
    }
}