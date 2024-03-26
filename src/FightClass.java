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
        System.out.println("Вы видите, как к вам движется " + oneOfMonsters.getName() + ".");
        System.out.println("Что вы будете делать?");
        hero.getHealthAndPotionsInfo();
        System.out.println("1 - Выйти на бой.\n2 - Использовать зелье лечения.\n3 - Бежать в деревню.");


        Main.scanner.nextLine(); // vipolneniu koda meshaet neopoznannyi simvol, kotoryi lovit etot scanner


        switch (Main.scanner.nextInt()) {
            case 1 -> fightMenu();
            case 2 -> {
                hero.useHealPotion();
                fightMenu();
            }
            case 3 -> {
                System.out.println("Вы спасаетесь бегством.");
                Main.startMenu();
            }
            default -> System.out.println("\nВы выбрали неверный вариант, попробуйте еще раз.\n");
        }
    }

    private void fightMenu() {
        System.out.println("Перед вами стоит " + oneOfMonsters.getName() + ".\n\tВы можете биться до конца или бежать в деревню.");
        System.out.println("1 - Биться до конца.\n2 - Бежать в деревню");

        switch (Main.scanner.nextInt()){
            case 1 -> {
                run();
                wannaTryAgain();
            }
            case 2 -> {
                System.out.println("Вы спасаетесь бегством.");
                Main.startMenu();
            }
            default -> System.out.println("Вы ввели неверное действие.");

        }

    }

    private void wannaTryAgain() {
        System.out.println("Поздравляем с победой! Хотете идти глубже в лес?\n1 - Да.\n2 - Нет.");
        System.out.println("error: " + Main.scanner.nextLine());
        switch (Main.scanner.nextLine()){
            case "1" -> preFightMenu();
            case "2" -> Main.startMenu();
            default -> {
                System.out.println("Вы ввели неверное действие.");
                wannaTryAgain();
            }
        }
    }

    void fight(Player hero, Creature oneOfMonsters) throws InterruptedException {
        final long DURATION_OF_TURN = 1;
        Random r = new Random();
        while (hero.isAlive() & oneOfMonsters.isAlive()) {
            if (hero.isAlive() & oneOfMonsters.isAlive()) {
                System.out.println("------------------------------------------");
                hero.attack(); // герой атакует
                oneOfMonsters.getAttacked(hero); // монстр получает атаку от героя

                Thread.sleep(DURATION_OF_TURN);

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
                Thread.sleep(DURATION_OF_TURN);

            }
        }

    }

    private static String deathPhrase() {
        int i = (int) (Math.random() * 10);
        switch (i) {
            case 0 -> {
                return " падает навзничь.";
            }
            case 1 -> {
                return " отлетает на несколько метров.";
            }
            case 2 -> {
                return " падает замертво.";
            }
            case 3 -> {
                return " пошатнулся и упал. Его голова укатилась в кусты.";
            }
            case 4 -> {
                return " превратился в неузнаваемое месево.";
            }
            case 5 -> {
                return " издалпоследний вопль";
            }
            case 6 -> {
                return " нашел свою смерть в лесу.";
            }
            case 7 -> {
                return " пал в бою.";

            }
            case 8 -> {
                return " уснул вечным сном.";

            }
            case 9 -> {
                return " больше не встанет.";
            }
        }
        return null;

    }
    @Override
    public void run() {
        try {
            fight(hero, oneOfMonsters);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}



















