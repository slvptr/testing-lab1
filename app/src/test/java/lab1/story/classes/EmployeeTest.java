package lab1.story.classes;

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
    public void testTakeCashFromCashbox() {
        Bank testBank = new Bank("test_bank", employee);
        employee.takeCashFromCashbox(testBank);
        assertEquals(0, testBank.getFireproofCashbox());
    }

    @Test
    public void testEquals() {
        Employee twinEmployee = new Employee("test_employee", 100, BankPost.CASHIER);
        assertEquals(employee, twinEmployee);
    }

    @Test
    public void testNotEquals() {
        Employee twinEmployee = new Employee("test_employee123", 100, BankPost.CASHIER);
        assertNotEquals(employee, twinEmployee);

        twinEmployee = new Employee("test_employee", 666, BankPost.CASHIER);
        assertNotEquals(employee, twinEmployee);

        twinEmployee = new Employee("test_employee", 100, BankPost.PROGRAMMER);
        assertNotEquals(employee, twinEmployee);
    }

    @Test
    public void testHashCodeEquals() {
        Employee twinEmployee = new Employee("test_employee", 100, BankPost.CASHIER);
        assertEquals(employee.hashCode(), twinEmployee.hashCode());
    }

    @Test
    public void testHashCodeNotEquals() {
        Employee twinEmployee = new Employee("test_employee123", 100, BankPost.CASHIER);
        assertNotEquals(employee.hashCode(), twinEmployee.hashCode());

        twinEmployee = new Employee("test_employee", 666, BankPost.CASHIER);
        assertNotEquals(employee.hashCode(), twinEmployee.hashCode());

        twinEmployee = new Employee("test_employee", 100, BankPost.PROGRAMMER);
        assertNotEquals(employee.hashCode(), twinEmployee.hashCode());
    }
}