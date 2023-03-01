package lab1.story.classes;


import lab1.story.classes.Instruments.Rand;

public enum BankPost {
    CASHIER, GUARD, MANAGER, PROGRAMMER, LAWYER;

    public static BankPost getRandomBankPost(){
        int numOfWeapon = Rand.randInt(1, 5);

        switch (numOfWeapon){
            case 1: return CASHIER;
            case 2: return GUARD;
            case 3: return MANAGER;
            case 4: return PROGRAMMER;
            case 5: return LAWYER;
        }

        return null;
    }
}
