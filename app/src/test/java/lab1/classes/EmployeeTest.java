package lab1.classes;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeeTest {

    private Employee employee;

    @Before
    public void setUp() {
        employee = new Employee("test_employee", 100, BankPost.CASHIER);
    }

    @Test
    public void takeCashFromCashbox() {
        Bank testBank = new Bank("test_bank", employee);
        employee.takeCashFromCashbox(testBank);
        Assert.assertEquals(0, testBank.getFireproofCashbox());
    }

    @Test
    public void testEquals() {
        Employee twinEmployee = new Employee("test_employee", 100, BankPost.CASHIER);
        Assert.assertEquals(employee, twinEmployee);
    }

    @Test
    public void testNotEquals() {
        Employee twinEmployee = new Employee("test_employee123", 100, BankPost.CASHIER);
        Assert.assertNotEquals(employee, twinEmployee);

        twinEmployee = new Employee("test_employee", 666, BankPost.CASHIER);
        Assert.assertNotEquals(employee, twinEmployee);

        twinEmployee = new Employee("test_employee", 100, BankPost.PROGRAMMER);
        Assert.assertNotEquals(employee, twinEmployee);
    }

    @Test
    public void testHashCode() {
    }
}