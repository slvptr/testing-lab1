package lab1.story.classes;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FireFightTest {

    private FireFight fireFight;
    private Gangster gangster1, gangster2, gangster3;
    private Policeman policeman1, policeman2;

    @Before
    public void setUp() {
        Bank bank = new Bank("test_bank", new Employee("test_employee1", 100, BankPost.PROGRAMMER));

        gangster1 = new Gangster("Gangster 1", 100, WeaponType.RIFLE);
        gangster2 = new Gangster("Gangster 2", 100, WeaponType.GRENADE);
        gangster3 = new Gangster("Gangster 3", 100, WeaponType.MACHINE_GUN);
        Gang gang = new Gang("Grove Street Families", gangster1, gangster2, gangster3);

        policeman1 = new Policeman("Policeman 1", 100);
        policeman2 = new Policeman("Policeman 2", 100);
        Police police = new Police("DEA", policeman1, policeman2);

        gang.setTarget(bank);
        gang.burstIntoBank(BurstIntoTypes.LOUDLY);

        fireFight = new FireFight(gang, police);
    }

    @Test
    public void shoot() {
        int expectedHP = policeman1.getHP() - gangster1.weapon.damage;
        if (expectedHP < 0) expectedHP = 0;
        fireFight.shoot(gangster1, policeman1);
        assertEquals(expectedHP, policeman1.getHP());

        expectedHP = policeman1.getHP() - gangster2.weapon.damage;
        if (expectedHP < 0) expectedHP = 0;
        fireFight.shoot(gangster2, policeman1);
        assertEquals(expectedHP, policeman1.getHP());

        expectedHP = policeman2.getHP() - gangster3.weapon.damage;
        if (expectedHP < 0) expectedHP = 0;
        fireFight.shoot(gangster3, policeman2);
        assertEquals(expectedHP, policeman2.getHP());

        expectedHP = gangster1.getHP() - policeman2.weapon.damage;
        if (expectedHP < 0) expectedHP = 0;
        fireFight.shoot(policeman2, gangster1);
        assertEquals(expectedHP, gangster1.getHP());
    }
}