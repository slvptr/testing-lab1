package lab1.story.classes;


import lab1.story.classes.Instruments.ArrayListFromArray;

import java.util.ArrayList;
import java.util.Objects;

public class Bank {

    private final String name;

    private int fireproofCashbox = 1000000;
    public Gang gangIntoBank = null;
    protected ArrayList<Employee> employees;
    protected ArrayList<Object> fireproofChest = new ArrayList<>();

    public Bank(String name, Employee ...employees) {
        this.name = name;
        this.employees = ArrayListFromArray.convert(employees);
    }

    public String getName() {
        return this.name;
    }

    protected void EmergencyButton() {
        if (gangIntoBank != null) gangIntoBank.setSpottedStatus(true);
    }

    protected int getAllCash() {
        int value = fireproofCashbox;
        fireproofCashbox = 0;
        return value;
    }

    public int getFireproofCashbox() {
        return fireproofCashbox;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public ArrayList<Object> getFireproofChest() {
        return fireproofChest;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof Bank)) return false;
        Bank bank = (Bank) o;
        return name.equals(bank.name) &&
                fireproofCashbox == bank.fireproofCashbox &&
                employees.equals(bank.employees);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(employees.size(), fireproofCashbox, name);
        result = 31 * result + employees.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Bank[" +
                "size=" + employees.size() +
                ", fireproofCashbox=" + fireproofCashbox + "$" +
                ", employees=" + employees +
                ']';
    }

}
