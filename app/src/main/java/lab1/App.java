package lab1;

import lab1.classes.*;

public class App {

    public static boolean manualFireFight = false;

    public static void main(String[] args) throws Exception {

        System.out.println("THE STORY ABOUT ONE HEIST...\n\n");

        Gangster sid = new Gangster("Sid", 100, WeaponType.RIFLE);
        Gangster nancy = new Gangster("Nancy", 100, WeaponType.MACHINE_GUN);
        Gang gang = new Gang("Hex Pistols", sid, nancy);

        Employee luckyCashier = new Employee("Lucky Cashier", 100, BankPost.CASHIER);
        Employee firstGuard = new Employee("Mike Tyson", 100, BankPost.GUARD);
        Employee firstLawyer = new Employee("Alex Nevsky", 100, BankPost.LAWYER);
        Employee firstManager = new Employee("Elsa Jean", 95, BankPost.MANAGER);
        Employee firstProgrammer = new Employee("Donald Knut", 100, BankPost.PROGRAMMER);
        Employee secondProgrammer = new Employee("Linus Torvalds", 100, BankPost.PROGRAMMER);
        Bank bank = new Bank("Davillonian CO Bank", luckyCashier, firstManager, firstGuard, firstLawyer, firstProgrammer, secondProgrammer);

        Policeman firstPoliceman = new Policeman("Nikolay Petrov", 99);
        Policeman secondPoliceman = new Policeman("Anatoliy Ivanov", 100);
        Policeman thirdPoliceman = new Policeman("Boris Animal", 100);
        Police police = new Police("DEA", firstPoliceman, secondPoliceman, thirdPoliceman);

        gang.setTarget(bank);
        System.out.println("Банда " + gang.getName() + " выбрала для ограбления " + bank.getName() + "\n");

        gang.burstIntoBank(BurstIntoTypes.IMPERCEPTIBLY);
        System.out.println(gang.getName() + ", как обычные посетители, тихо вошли в " + bank.getName() + " и закрыли входную дверь\n");

        nancy.speech("Всем лечь на пол!");
        sid.speech("Эй, " + luckyCashier.getName() + ", открывай кассу! Живо!\n");

        int cash = luckyCashier.takeCashFromCashbox(bank);
        System.out.println("Перепуганный " + luckyCashier.getName() + " открыл кассу со всеми деньгами\n");

        Gang.InBankActions inBankActions = gang.new InBankActions();

        try {
            System.out.println(gang.getName() + " выгребли из кассы " + gang.getStolenCash() + "$ и спрятали их в чемодан\n");
        } catch (Exception e) {
            System.out.println("Не получилось вскрыть кассу :/\n");
        }

        firstManager.pushEmergencyButton(bank);
        System.out.println(firstManager.getName() + " нажала на кнопку тревоги. Полицейские уже выехали!\n");

        System.out.println(gang.getName() + " от такой дерзости " + firstManager.getName() +
                " решили убить всех работников банка, кроме " + luckyCashier.getName() + ", ибо он был заперт в несгораемом сундуке\n");

        inBankActions.killEmployee(sid, firstManager);
        System.out.println(sid.getName() + " убил " + firstManager.getName());

        inBankActions.killEmployee(sid, firstGuard);
        System.out.println(sid.getName() + " убил " + firstGuard.getName());

        inBankActions.killEmployee(nancy, firstManager);
        System.out.println(nancy.getName() + " убила " + firstLawyer.getName());

        inBankActions.killEmployee(nancy, firstManager);
        System.out.println(nancy.getName() + " убила " + firstProgrammer.getName());

        inBankActions.killEmployee(nancy, firstManager);
        System.out.println(sid.getName() + " убил " + secondProgrammer.getName() + "\n");

        System.out.println("К банку подоспел полицейский отряд\n");

        System.out.println("Началась перестрелка\n");

        FireFight fireFight = new FireFight(gang, police);

        if (manualFireFight) {
            fireFight.shoot(sid, firstPoliceman);
            System.out.println(sid.getName() + " выстрелил в " + firstPoliceman.getName() + " [" + firstPoliceman.getHP() + "HP]");

            fireFight.shoot(nancy, firstPoliceman);
            System.out.println(nancy.getName() + " выстрелила в " + firstPoliceman.getName() + " [" + firstPoliceman.getHP() + "HP]");
            System.out.println(firstPoliceman.getName() + " убит");

            fireFight.shoot(secondPoliceman, sid);
            System.out.println(secondPoliceman.getName() + " выстрелил в " + sid.getName() + " [" + sid.getHP() + "HP]");

            fireFight.shoot(thirdPoliceman, nancy);
            System.out.println(thirdPoliceman.getName() + " выстрелил в " + nancy.getName() + " [" + nancy.getHP() + "HP]");

            fireFight.shoot(nancy, thirdPoliceman);
            System.out.println(nancy.getName() + " выстрелила в " + thirdPoliceman.getName() + " [" + thirdPoliceman.getHP() + "HP]");

            fireFight.shoot(sid, secondPoliceman);
            System.out.println(sid.getName() + " выстрелил в " + secondPoliceman.getName() + " [" + secondPoliceman.getHP() + "HP]");

            fireFight.shoot(sid, thirdPoliceman);
            System.out.println(sid.getName() + " выстрелила в " + thirdPoliceman.getName() + " [" + thirdPoliceman.getHP() + "HP]");
            System.out.println(thirdPoliceman.getName() + " убит\n");

            System.out.println("Перестрелка закончилась. В ходе нее было убито "
                    + police.getSquadState() + " полицейских и " + gang.getSquadState() + " бандитов\n");

            inBankActions.offIt();
            System.out.println("Банда " + gang.getName() + " успешно смылась с места преступления");
        }
        else {
            fireFight.setGangAccuracy(0.6);
            fireFight.setPoliceAccuracy(0.4);
            fireFight.autoFight();
        }
    }
}
