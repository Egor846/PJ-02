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

        while (hero.getHp() > 0 & oneOfMonsters.getHp() > 0) {
            if (oneOfMonsters.hp > 0) {

                int randomInt = (int) (Math.random() * 10);
                int hitPoint = (hero.power * 2) + randomInt;
                int doubleHitPoint = 0;

                System.out.println("\n" + hero.getName() + " атакует с силой " + hitPoint + "!");


                if (randomInt > oneOfMonsters.getAgility()) {
                    System.out.println(hero.getName() + " промахнулся.");

                } else if (oneOfMonsters.getAgility() > randomInt) {
                    doubleHitPoint = (hitPoint * 2);
                    takeDamage(oneOfMonsters, hitPoint, doubleHitPoint);

                } else takeDamage(oneOfMonsters, hitPoint, doubleHitPoint);

                Thread.sleep(sleepThreadTime);

                if (oneOfMonsters.getHp() <= 0) {
                    System.out.println(oneOfMonsters.getName() + " погибает.");
                    System.out.println("Поздравляем, вы получаете 5 монет и 10 очков опыта");


                    hero.setGold(hero.getGold() + 5);
                    hero.setExp(hero.getExp() + 10);
                    System.out.println("У вас " + hero.getGold() + " монет " + hero.getExp() + "/" + hero.getMAX_HP() + " очков опыта.");

                }

            }
            if (hero.getHp() > 0 & oneOfMonsters.getHp() > 0) {

                int randomInt = (int) (Math.random() * 10);
                int hitPoint = (oneOfMonsters.getPower() * 2) + randomInt;
                int doubleHitPoint = 0;

                System.out.println("\n" + oneOfMonsters.getName() + " атакует с силой " + hitPoint + "!");


                if (randomInt > hero.getAgility()) {
                    System.out.println(oneOfMonsters.getName() + " промахнулся.");

                } else if (hero.getAgility() > randomInt) {
                    doubleHitPoint = (hitPoint * 2);
                    takeDamage(hero, hitPoint, doubleHitPoint);
                } else takeDamage(hero, hitPoint, doubleHitPoint);

                Thread.sleep(sleepThreadTime);


                if (hero.getHp() <= 0) {
                    System.out.println("Вы погибли, игра проиграна!");
                    System.exit(0);

                }
            }

        }

    }

    void takeDamage(Creature someoneWhoFight, int hitPoint, int doubleHitPoint) {

        if (doubleHitPoint == 0) {
            int someoneWhoFightHp = someoneWhoFight.getHp();
            someoneWhoFight.setHp(someoneWhoFightHp -= hitPoint);
            System.out.println(someoneWhoFight.getName() + " получил ранение на " + hitPoint + ".");
        } else {
            System.out.println(someoneWhoFight.getName() + " получил критическое ранение на " + doubleHitPoint + "!");
        }
    }


}



















