package lab1.story.classes;

import java.util.Objects;

public class Gangster extends Human{

    WeaponType weapon;

    public Gangster(String name, int HP, WeaponType weapon){
        super(name, HP);
        this.weapon = weapon;
    }

    protected void shootAtHuman(Human human) {
        int humanHP = human.getHP();
        humanHP -= weapon.damage;
        if (humanHP < 0) humanHP = 0;
        human.setHP(humanHP);
    }

    @Override
    public void speech(String text)
    {
        System.out.println(super.getName() + ": " + text);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Gangster)) return false;
        Gangster gangster = (Gangster) o;
        return weapon == gangster.weapon &&
                super.getHP() == gangster.getHP() &&
                super.getName() == gangster.getName();
    }

    @Override
    public int hashCode() {
        return Objects.hash(weapon, super.getHP(), super.getName());
    }

    @Override
    public String toString() {
        return "Gangster[" +
                "name=" + super.getName() +
                ", HP=" + super.getHP() +
                ", weapon=" + weapon +
                ']';
    }
}
