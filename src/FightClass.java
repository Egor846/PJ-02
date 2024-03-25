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
        System.out.println("1 - Viyty na boy.\n2 - Ispol'zovat' zelie lecheniya.\n3 - Bezhat' v derevnyu.");

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
        System.out.println("1 - odinichniy udar\n2 - bitsya do kontsa.");

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
                    if (!oneOfMonsters.isAlive()) {
                        System.out.println(oneOfMonsters.getName() + FightClass.deathPhrase());
                        System.out.println("//////////////////////////////////////////\n" + oneOfMonsters.getName() + " умирает."); // выход из цикла, если один из них мёртв
                        hero.getReward();
                        System.out.println("\n");
                    }
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

    private static String deathPhrase() {
        int i = (int) (Math.random() * 10);
        switch (i) {
            case 0 -> {
                return " padaet navzhnich.";
            }
            case 1 -> {
                return " otletaet na neskol'ko metrov.";
            }
            case 2 -> {
                return " padaet zamertvo.";
            }
            case 3 -> {
                return " poshatnulsya i ypal. ego golova ykatilas' v kusty.";
            }
            case 4 -> {
                return " prevratilsya v neuznavaemoe mesevo.";
            }
            case 5 -> {
                return " izdal posledniy vopl'";
            }
            case 6 -> {
                return " nashel svoy smert' v lesu.";
            }
            case 7 -> {
                return " pal v bou.";

            }
            case 8 -> {
                return " usnul vechnym snom.";

            }
            case 9 -> {
                return " bol'she ne vstanet.";
            }
        }
        return null;

    }
    @Override
    public void run() {
        fight(hero, oneOfMonsters);
        Thread.currentThread().interrupt();
    }

}



















