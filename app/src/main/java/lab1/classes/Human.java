package lab1.classes;

public abstract class Human {
    private int HP;
    private String name;

    protected Human(String name, int HP) {
        this.name = name;
        this.HP = HP;
    }

    public int getHP() {
        return this.HP;
    }

    public String getName() {
        return this.name;
    }

    protected void setHP(int HP) {
        this.HP = HP;
    }

    public abstract void speech(String text);
}
