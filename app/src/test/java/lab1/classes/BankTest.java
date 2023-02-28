package lab1.classes;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

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
        Assert.assertEquals(0, bank.getFireproofCashbox());
    }

    @Test
    public void testEquals() {
        Bank twinBank = new Bank("test_bank",
                new Employee("test_employee1", 100, BankPost.GUARD),
                new Employee("test_employee2", 100, BankPost.PROGRAMMER));

        Assert.assertEquals(bank, twinBank);
    }

    @Test
    public void testNotEquals() {
        Bank twinBank = new Bank("test_bank",
                new Employee("test_employee1", 100, BankPost.GUARD),
                new Employee("test_employee2", 42, BankPost.PROGRAMMER));
        Assert.assertNotEquals(bank, twinBank);

        twinBank = new Bank("test_bank",
                new Employee("test_employee3", 100, BankPost.GUARD),
                new Employee("test_employee2", 100, BankPost.PROGRAMMER));
        Assert.assertNotEquals(bank, twinBank);

        twinBank = new Bank("test_bank@23",
                new Employee("test_employee1", 100, BankPost.GUARD),
                new Employee("test_employee2", 100, BankPost.PROGRAMMER));
        Assert.assertNotEquals(bank, twinBank);

        twinBank = new Bank("test_bank",
                new Employee("test_employee1", 100, BankPost.GUARD),
                new Employee("test_employee2", 100, BankPost.LAWYER));
        Assert.assertNotEquals(bank, twinBank);
    }

    @Test
    public void testHashCodeEqual() {
        Bank twinBank = new Bank("test_bank",
                new Employee("test_employee1", 100, BankPost.GUARD),
                new Employee("test_employee2", 100, BankPost.PROGRAMMER));

        Assert.assertEquals(bank, twinBank);
    }

    @Test
    public void testHashCodeNotEqual() {
        Bank twinBank = new Bank("test_bank",
                new Employee("test_employee1", 100, BankPost.GUARD),
                new Employee("test_employee2", 42, BankPost.PROGRAMMER));
        Assert.assertNotEquals(bank.hashCode(), twinBank.hashCode());

        twinBank = new Bank("test_bank",
                new Employee("test_employee3", 100, BankPost.GUARD),
                new Employee("test_employee2", 100, BankPost.PROGRAMMER));
        Assert.assertNotEquals(bank.hashCode(), twinBank.hashCode());

        twinBank = new Bank("test_bank#@",
                new Employee("test_employee1", 100, BankPost.GUARD),
                new Employee("test_employee2", 100, BankPost.PROGRAMMER));
        Assert.assertNotEquals(bank.hashCode(), twinBank.hashCode());

        twinBank = new Bank("test_bank",
                new Employee("test_employee1", 100, BankPost.GUARD),
                new Employee("test_employee2", 100, BankPost.LAWYER));
        Assert.assertNotEquals(bank.hashCode(), twinBank.hashCode());
    }

}
