package lab1.classes;


import lab1.classes.Instruments.Rand;

public class FireFight {

    private Gang gang;
    private Police police;
    private double gangAccuracy;
    private double policeAccuracy;

    public FireFight(Gang gang, Police police) throws IllegalArgumentException {
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

}
