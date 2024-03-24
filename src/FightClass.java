import java.util.ArrayList;
import java.util.List;
import java.util.Random;


class FightClass implements Runnable {


    public static Creature generatingARandomMonster() {
        List<Creature> monsters = new ArrayList<>();
        monsters.add(Goblin.createAGoblin());
        monsters.add(Skeleton.createASkeleton());
        Random random = new Random();
        return monsters.get(random.nextInt(2));

    }

    int sleepThreadTime = 2000;
    Player hero;
    Creature oneOfMonsters;

    public FightClass(Player hero, Creature oneOfMonsters) {
        this.hero = hero;
        this.oneOfMonsters = oneOfMonsters;

    }

    void preFightMenu(){
        oneOfMonsters = generatingARandomMonster();
        System.out.println("vi videte, kak k vam dvizhetsya " + oneOfMonsters.getName() + ".");
        System.out.println("chto vi budete delat'?");
        hero.getHealthAndPotionsInfo();
        System.out.println("1 - Viity na boy.\n2 - Ispol'zovat' zelie lecheniya.\n3 - Bezhat' v derevnyu.");

        switch (Main.scanner.nextLine()) {
            case "1" -> fightMenu();
            case "2" -> {
                hero.useHealPotion();
                fightMenu();
            }
            case "3" -> {
                System.out.println("vi spasaetes' begstvom.");
                Main.startMenu();
            }
            default -> System.out.println("\nvi vibrali nevernyi variant. poprobuyte esche raz.\n");
        }
    }

    private void fightMenu() {
        System.out.println("pered vami stoit " + oneOfMonsters.getName() + " ( " + oneOfMonsters.getHp() + " ).\n\tvi mozhete nanesti odinochyi udar, ili srazhatsya, poka odin iz vas ne umret");
        System.out.println("1 - odinichniy udar\n2 - bitsya do kontsa\n3 - nabrat' distantsiyu");

        switch (Main.scanner.nextLine()){
            case "1" -> {
                hero.getAttacked(oneOfMonsters);
                oneOfMonsters.getAttacked(hero);
                fightMenu();
            }
            case "2" -> {
                run();
                preFightMenu();
            }
            case "3" -> {
                System.out.println("vi otbezhali ot protivnika");
                preFightMenu();

            }
        }
        // odinochniy udar
        // bitsya do kontsa
    }

    void fight(Player hero, Creature oneOfMonsters) {

        Random r = new Random();
        while (hero.isAlive() & oneOfMonsters.isAlive()) {
            if (hero.isAlive() & oneOfMonsters.isAlive()) {
                System.out.println("------------------------------------------");
                hero.attack(); // герой атакует
                oneOfMonsters.getAttacked(hero); // монстр получает атаку от героя
                if (!(hero.isAlive() & oneOfMonsters.isAlive())) { // проверка, живы ли соперники
                     // выход из цикла, если один из них мёртв
                    if (!hero.isAlive()){
                        System.out.println("\n\t----------------------------------\n\t|Вы погибли в бою. Игра окончена.|\n\t----------------------------------");
                        System.exit(0);
                    }   break;
                }
                oneOfMonsters.attack(); // монстр атакует
                hero.getAttacked(oneOfMonsters); // герой получает атаку от монстра

            }
        }

    }
    @Override
    public void run() {
        fight(hero, oneOfMonsters);
        Thread.currentThread().interrupt();
    }

}



















