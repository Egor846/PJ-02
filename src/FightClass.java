import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class FightClass implements Runnable {

    int sleepThreadTime = 1;
    Player hero;

    public FightClass(Player hero) {
        this.hero = hero;

    }


    @Override
    public void run() {
        try {
            fight(hero, (Creature) generatingARandomMonster());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    public Object generatingARandomMonster() {
        List<Object> monsters = new ArrayList<>();
        monsters.add(Goblin.createAGoblin());
        monsters.add(Skeleton.createASkeleton());
        Random random = new Random();
        return monsters.get(random.nextInt(0, 2));

    }

    void fight(Player hero, Creature oneOfMonsters) throws InterruptedException {

        while (hero.hp > 0 & oneOfMonsters.hp > 0) {
            if (oneOfMonsters.hp > 0) {

                int randomInt = (int) (Math.random() * 10);
                int hitPoint = (hero.power * 2) + randomInt;
                int doubleHitPoint = 0;

                System.out.println("\n" + hero.getName() + " атакует с силой " + hitPoint + "!");


                if (randomInt < oneOfMonsters.agility) {
                    System.out.println(hero.getName() + " промахнулся.");

                } else if (oneOfMonsters.agility > randomInt) {
                    doubleHitPoint = (hitPoint * 2);
                    takeDamage(oneOfMonsters, hitPoint, doubleHitPoint);

                } else takeDamage(oneOfMonsters, hitPoint, doubleHitPoint);

                Thread.sleep(sleepThreadTime);

                if (oneOfMonsters.hp <= 0) {
                    System.out.println(oneOfMonsters.name + " погибает.");
                    System.out.println("Поздравляем, вы получаете 5 монет и 10 очков опыта");


                    hero.setGold(hero.getGold() + 5);
                    hero.setExp(hero.getExp() + 10);
                    System.out.println("У вас " + hero.getGold() + " монет " + hero.getExp() + "/" + hero.getMAX_HP() + " очков опыта.");

                }

            }
            if (hero.hp > 0 & oneOfMonsters.hp > 0) {

                int randomInt = (int) (Math.random() * 10);
                int hitPoint = (oneOfMonsters.power * 2) + randomInt;
                int doubleHitPoint = 0;

                System.out.println("\n" + oneOfMonsters.name + " атакует с силой " + hitPoint + "!");


                if (randomInt < hero.agility) {
                    System.out.println(oneOfMonsters.name + " промахнулся.");

                } else if (hero.agility > randomInt) {
                    doubleHitPoint = (hitPoint * 2);
                    takeDamage(hero, hitPoint, doubleHitPoint);
                } else takeDamage(hero, hitPoint, doubleHitPoint);

                Thread.sleep(sleepThreadTime);


                if (hero.hp <= 0) {
                    System.out.println("Вы погибли, игра проиграна!");
                    System.exit(0);

                }
            }

        }

    }

    void takeDamage(Creature someoneWhoFight, int hitPoint, int doubleHitPoint) {

        if (doubleHitPoint == 0) {
            someoneWhoFight.hp -= hitPoint;
            System.out.println(someoneWhoFight.name + " получил ранение на " + hitPoint + ".");
        } else {
            System.out.println(someoneWhoFight.name + " получил критическое ранение на " + doubleHitPoint + "!");
        }
    }


}



















