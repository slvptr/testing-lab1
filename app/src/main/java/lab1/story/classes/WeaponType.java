package lab1.story.classes;


import lab1.story.classes.Instruments.Rand;

public enum WeaponType {
    GUN(30), RIFLE(50), MACHINE_GUN(80), GRENADE(100);

    int damage;

    private WeaponType (int damage) {
        this.damage = damage;
    }

    public static WeaponType getRandomWeapon(){
        int numOfWeapon = Rand.randInt(1, 4);

        switch (numOfWeapon){
            case 1: return GUN;
            case 2: return RIFLE;
            case 3: return MACHINE_GUN;
            case 4: return GRENADE;
        }

        return null;
    }
}
