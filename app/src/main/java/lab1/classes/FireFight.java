package lab1.classes;


import lab1.classes.Instruments.Rand;

public class FireFight {

    private Gang gang;
    private Police police;
    private double gangAccuracy;
    private double policeAccuracy;

    public FireFight(Gang gang, Police police) throws  IllegalArgumentException {
        if (gang.getSpottedStatus()) {
            this.gang = gang;
            this.police = police;
        }
        else{
            throw new IllegalArgumentException();
        }
    }

    public void setGangAccuracy (double gangAccuracy) {
        if (gangAccuracy > 1d || gangAccuracy < 0d) {
            throw new IllegalArgumentException();
        }
        this.gangAccuracy = gangAccuracy;
    }

    public void setPoliceAccuracy (double policeAccuracy) {
        if (policeAccuracy > 1d || policeAccuracy < 0d) {
            throw new IllegalArgumentException();
        }
        this.policeAccuracy = policeAccuracy;
    }

    public void shoot(Human shooter, Human victim) {
        if (shooter instanceof Gangster) {
            ((Gangster) shooter).shootAtHuman(victim);
        }
        if (shooter instanceof Policeman) {
            ((Policeman) shooter).shootAtHuman(victim);
        }
    }

    // Just for fun
    public void autoFight() {
        boolean isGangMove = true;

        while (gang.gangsters.size() != 0 && police.policemen.size() != 0) {
            Gangster randGangster = Rand.randChoice(gang.gangsters);
            Policeman randPoliceman = Rand.randChoice(police.policemen);

            if (isGangMove) {
                randGangster.shootAtHuman(randPoliceman);

                if (Math.random() < gangAccuracy) {
                    System.out.print(randGangster.getName() + " стреляет в " + randPoliceman.getName() + " и наносит " + randGangster.weapon.damage + " урона. ");
                    if (randPoliceman.getHP() == 0) {
                        System.out.println(randPoliceman.getName() + " застрелен");
                        police.policemen.remove(randPoliceman);
                    }
                    else System.out.println("У " + randPoliceman.getName() + " " + randPoliceman.getHP() + "HP");
                }
                else {
                    System.out.println(randGangster.getName() + " промахнулся");
                }
            }
            else{
                randPoliceman.shootAtHuman(randGangster);

                if (Math.random() < policeAccuracy) {
                    System.out.print(randPoliceman.getName() + " стреляет в " + randGangster.getName() + " и наносит " + randPoliceman.weapon.damage + " урона. ");
                    if (randGangster.getHP() == 0) {
                        System.out.println(randGangster.getName() + " застрелен");
                        gang.gangsters.remove(randGangster);
                    }
                    else System.out.println("У " + randGangster.getName() + " " + randGangster.getHP() + " HP");
                }
                else {
                    System.out.println(randPoliceman.getName() + " промахнулся");
                }
            }
            isGangMove = !isGangMove;
        }

        if (gang.gangsters.size() > 0) {
            System.out.println("Грабители победили!");
        }
        else {
            System.out.println("Полицейские победили ((");
        }
    }

}
