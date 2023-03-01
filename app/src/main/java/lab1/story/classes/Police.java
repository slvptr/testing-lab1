package lab1.story.classes;


import lab1.story.classes.Instruments.ArrayListFromArray;

import java.util.ArrayList;
import java.util.Objects;

public class Police{

    private final String name;
    public ArrayList<Policeman> policemen;

    public Police(String name, Policeman...policemen){
        this.name = name;
        this.policemen = ArrayListFromArray.convert(policemen);
    }

    public int getSquadState() {
        int numOfKilledPolicemen = 0;
        for (int i = 0; i < policemen.size(); ++i) {
            if (policemen.get(i).getHP() == 0){
                numOfKilledPolicemen++;
            }
        }
        return numOfKilledPolicemen;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof Police)) return false;
        Police police = (Police) o;
        return policemen.size() == police.policemen.size() &&
                policemen.equals(police.policemen);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(policemen.size());
        result = 31 * result + policemen.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Police[" +
                "size=" + policemen.size() +
                ", policemen=" + policemen.toString() +
                ']';
    }

}
