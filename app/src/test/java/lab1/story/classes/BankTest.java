package lab1.story.classes;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
public class BankTest {
    private Bank bank;

    @Before
    public void setUp() {
        bank = new Bank("test_bank",
                new Employee("test_employee1", 100, BankPost.GUARD),
                new Employee("test_employee2", 100, BankPost.PROGRAMMER));

    }

    @Test
    public void testGetAllCash() {
        bank.getAllCash();
        assertEquals(0, bank.getFireproofCashbox());
    }

    @Test
    public void testEquals() {
        Bank twinBank = new Bank("test_bank",
                new Employee("test_employee1", 100, BankPost.GUARD),
                new Employee("test_employee2", 100, BankPost.PROGRAMMER));

        assertEquals(bank, twinBank);
    }

    @Test
    @Parameters({
            "test_bank, test_employee1, 100, GUARD, test_employee2, 42, PROGRAMMER",
            "test_bank, test_employee3, 100, GUARD, test_employee2, 100, PROGRAMMER",
            "test_bank@23, test_employee1, 100, GUARD, test_employee2, 100, PROGRAMMER",
            "test_bank, test_employee1, 100, GUARD, test_employee2, 100, LAWYER",

    })
    public void testNotEquals(String bankName, String employee1Name, int employee1HP, BankPost employee1PostName,
                              String employee2Name, int employee2HP, BankPost employee2PostName) {

        Bank twinBank = new Bank(bankName,
                new Employee(employee1Name, employee1HP, employee1PostName),
                new Employee(employee2Name, employee2HP, employee2PostName));
        assertNotEquals(bank, twinBank);
    }

    @Test
    public void testHashCodeEquals() {
        Bank twinBank = new Bank("test_bank",
                new Employee("test_employee1", 100, BankPost.GUARD),
                new Employee("test_employee2", 100, BankPost.PROGRAMMER));

        assertEquals(bank, twinBank);
    }

    @Test
    @Parameters({
            "test_bank, test_employee1, 100, GUARD, test_employee2, 42, PROGRAMMER",
            "test_bank, test_employee3, 100, GUARD, test_employee2, 100, PROGRAMMER",
            "test_bank@23, test_employee1, 100, GUARD, test_employee2, 100, PROGRAMMER",
            "test_bank, test_employee1, 100, GUARD, test_employee2, 100, LAWYER",

    })
    public void testHashCodeNotEquals(String bankName, String employee1Name, int employee1HP, BankPost employee1PostName,
                                      String employee2Name, int employee2HP, BankPost employee2PostName) {

        Bank twinBank = new Bank(bankName,
                new Employee(employee1Name, employee1HP, employee1PostName),
                new Employee(employee2Name, employee2HP, employee2PostName));
        assertNotEquals(bank.hashCode(), twinBank.hashCode());
    }

}
