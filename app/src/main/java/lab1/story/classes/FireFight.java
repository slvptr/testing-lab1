package lab1.story.classes;


public class FireFight {

    private Gang gang;
    private Police police;

    public FireFight(Gang gang, Police police) throws IllegalArgumentException {
        if (gang.getSpottedStatus()) {
            this.gang = gang;
            this.police = police;
        }
        else{
            throw new IllegalArgumentException();
        }
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
