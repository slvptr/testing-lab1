package lab1.classes;

import java.util.ArrayList;
import java.util.Objects;
import lab1.classes.Instruments.ArrayListFromArray;

public class Gang implements IHeist {

    private final String name;
    private Bank targetBank;
    private int stolenCash = 0;
    private boolean gangInBank = false;
    private boolean spottedByPolice = false;
    protected ArrayList<Gangster> gangsters;

    public class InBankActions {

        public void killEmployee(Gangster killer, Employee employee) {
            if (gangInBank) {
                while (employee.getHP() > 0) {
                    killer.shootAtHuman(employee);
                }
            }
            else {
                throw new OutOfBankException("Нельзя выполнить данное действие, находясь вне банка");
            }
        }

        public void offIt() {
            gangInBank = false;
            spottedByPolice = false;
        }
    }


    public Gang(String name, Gangster ...gangsters) {
        this.name = name;
        this.gangsters = ArrayListFromArray.convert(gangsters);
    }


    public int getSquadState(){
        int numOfKilledGangsters = 0;
        for (int i = 0; i < gangsters.size(); ++i) {
            if (gangsters.get(i).getHP() == 0){
                numOfKilledGangsters++;
            }
        }
        return numOfKilledGangsters;
    }

    public String getName() {
        return this.name;
    }

    protected void setSpottedStatus(boolean status) {
        spottedByPolice = status;
    }

    protected boolean getSpottedStatus() {
        return spottedByPolice;
    }

    @Override
    public void setTarget(Bank bank) {
        targetBank = bank;
    }

    @Override
    public void burstIntoBank(BurstIntoTypes burstIntoType) {
        gangInBank = true;
        if (targetBank == null)
            throw new NoBankTargetException("Сначала нужно понять какой банк грабить...");

        targetBank.gangIntoBank = this;

        if (burstIntoType == BurstIntoTypes.LOUDLY) {
            this.setSpottedStatus(true);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof Gang)) return false;
        Gang gang = (Gang) o;
        return gangsters.size() == gang.gangsters.size() &&
                gangsters.equals(gang.gangsters) &&
                targetBank.equals(gang.targetBank);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(targetBank, gangsters.size(), stolenCash);
        result = 31 * result + gangsters.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Gang[" +
                "size=" + gangsters.size() +
                ", stolenCash=" + stolenCash + "$" +
                ", targetBank=" + targetBank +
                ", gangsters=" + gangsters.toString() +
                ']';
    }
}
