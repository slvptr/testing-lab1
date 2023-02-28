package lab1.classes;

import java.util.Objects;

public class Policeman extends Human {

    WeaponType weapon;

    public Policeman(String name, int HP) {
        super(name, HP);
        this.weapon = WeaponType.GUN;
    }

    protected void shootAtHuman(Human human) {
        int humanHP = human.getHP();
        humanHP -= weapon.damage;
        if (humanHP < 0) humanHP = 0;
        human.setHP(humanHP);
    }

    @Override
    public void speech(String text) {
        System.out.println("eat donut");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Policeman)) return false;
        Policeman policeman = (Policeman) o;
        return weapon == policeman.weapon &&
                super.getHP() == policeman.getHP() &&
                super.getName() == policeman.getName();
    }

    @Override
    public int hashCode() {
        return Objects.hash(weapon, super.getHP(), super.getName());
    }

    @Override
    public String toString() {
        return "Policeman[" +
                "name=" + super.getName() +
                ", HP=" + super.getHP() +
                ", weapon=" + weapon +
                ']';
    }
}
