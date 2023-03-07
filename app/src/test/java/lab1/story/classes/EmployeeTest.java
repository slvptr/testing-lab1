package lab1.story.classes;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
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
    @Parameters({
            "test_employee123, 100, CASHIER",
            "test_employee, 99, CASHIER",
            "test_employee, 100, PROGRAMMER",
    })
    public void testNotEquals(String name, int HP, BankPost post) {
        Employee twinEmployee = new Employee(name, HP, post);
        assertNotEquals(employee, twinEmployee);
    }

    @Test
    public void testHashCodeEquals() {
        Employee twinEmployee = new Employee("test_employee", 100, BankPost.CASHIER);
        assertEquals(employee.hashCode(), twinEmployee.hashCode());
    }

    @Test
    @Parameters({
            "test_employee123, 100, CASHIER",
            "test_employee, 99, CASHIER",
            "test_employee, 100, PROGRAMMER",
    })
    public void testHashCodeNotEquals(String name, int HP, BankPost post) {
        Employee twinEmployee = new Employee(name, HP, post);
        assertNotEquals(employee.hashCode(), twinEmployee.hashCode());
    }
}