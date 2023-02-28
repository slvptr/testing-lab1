package lab1.classes;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GangTest {

    private Gang gang;
    private Policeman policeman;
    private Gangster gangster1;
    private Gangster gangster2;
    private Gangster gangster3;
    private Employee employee1;
    private Employee employee2;
    Gang.InBankActions inBankActions;
    private Bank bank;

    @Before
    public void setUp() throws Exception {
        policeman = new Policeman("Alex", 100);
        gangster1 = new Gangster("Max", 100, WeaponType.GRENADE);
        gangster2 = new Gangster("Oleg", 30, WeaponType.MACHINE_GUN);
        gangster3 = new Gangster("Max", 100, WeaponType.MACHINE_GUN);
        employee1 = new Employee("Victor", 100, BankPost.CASHIER);
        employee1 = new Employee("Victor", 100, BankPost.PROGRAMMER);
        gang = new Gang("Gang", gangster1, gangster2);
        inBankActions = gang.new InBankActions();
        bank = new Bank("Bank", employee1, employee2);
        gang.setTarget(bank);
    }

    @Test
    public void getSquadState() {
        assertEquals("Wrong number of policemen", gang.getSquadState(), 0);
        policeman.shootAtHuman(gangster2);
        assertEquals("Wrong number of policemen", gang.getSquadState(), 1);
        assertNotEquals("Wrong number of policemen", gang.getSquadState(), 0);
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

    @Test
    public void killEmployee() {
        gang.burstIntoBank(BurstIntoTypes.LOUDLY);
        assertEquals("Wrong number of employees", employee1.getHP(), 100);
        inBankActions.killEmployee(gangster1, employee1);
        assertEquals("Wrong number of employees", employee1.getHP(), 0);
        assertNotEquals("Wrong number of employees", employee1.getHP(), 100);
    }
}