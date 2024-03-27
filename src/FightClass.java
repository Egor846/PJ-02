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


    Player hero;
    Creature oneOfMonsters;

    public FightClass(Player hero, Creature oneOfMonsters) {
        this.hero = hero;
        this.oneOfMonsters = oneOfMonsters;

    }

    void preFightMenu() {
        oneOfMonsters = generatingARandomMonster();
        hero.getInfo();
        System.out.println("Вы видите, как к вам движется " + oneOfMonsters.getName() + ".");
        System.out.println("Что вы будете делать?");
        System.out.println("1 - Выйти на бой.\n2 - Использовать зелье лечения.\n3 - Бежать в деревню.");


        switch (Answer.getOption()) {
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
        hero.getInfo();
        System.out.println("Перед вами стоит " + oneOfMonsters.getName() + ".\n\tВы можете биться до конца или бежать в деревню.");
        System.out.println("1 - Биться до конца.\n2 - Бежать в деревню");
        switch (Answer.getOption()) {
            case 1 -> {
                run();
                            }
            case 2 -> {
                System.out.println("Вы спасаетесь бегством.");
                Main.startMenu();
            }
            default -> System.out.println("Вы ввели неверное действие.");


        }

    }

    private void wannaTryAgain() {
        System.out.println("Поздравляем с победой! Хотите идти глубже в лес?\n1 - Да.\n2 - Нет.");
        switch (Answer.getOption()) {
            case 1 -> {
                System.out.println("Вас зовет дорога приключений!");
                preFightMenu();
            }
            case 2 -> Main.startMenu();
            default -> {
                System.out.println("Вы ввели неверное действие.");
                wannaTryAgain();
            }
        }
    }

    void fight(Player hero, Creature oneOfMonsters) throws InterruptedException {
        final long DURATION_OF_TURN = 1;

        while (hero.isAlive() & oneOfMonsters.isAlive()) {
            separator();
            hero.attack();
            oneOfMonsters.getAttackedBy(hero);


            if (!oneOfMonsters.isAlive()) {
                hero.getReward();
                hero.getInfo();
                wannaTryAgain();
            }
            if (!hero.isAlive()) {
                separator();
                System.out.println("\t|\tВы погибли в бою..\t|");
                System.exit(0);
            }


            oneOfMonsters.attack();
            hero.getAttackedBy(oneOfMonsters);
        }



    }



        @Override
        public void run () {
            try {
                fight(hero, oneOfMonsters);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }

        void separator(){
            System.out.println("---------------------------------------------------------------");
        }

    }



















