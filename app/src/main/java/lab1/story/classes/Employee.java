package lab1.story.classes;

import java.util.Objects;

public class Employee extends Human {

    private BankPost post;

    public Employee(String name, int HP, BankPost post){
        super(name, HP);
        this.post = post;
    }

    public void pushEmergencyButton(Bank bank) {
        bank.EmergencyButton();
    }

    public int takeCashFromCashbox(Bank bank) {
        if (post == BankPost.CASHIER) {
            return bank.getAllCash();
        }
        else{
            throw new BankPermissionException("Данный человек не имеет доступа к кассе");
        }
    }


    @Override
    public void speech(String text) {
        System.out.println(text);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return post == employee.post &&
                super.getHP() == employee.getHP() &&
                super.getName().equals(employee.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(post, super.getHP(), super.getName());
    }

    @Override
    public String toString() {
        return "Employee[" +
                "name=" + super.getName() +
                ", HP=" + super.getHP() +
                ", post=" + post +
                ']';
    }
}
