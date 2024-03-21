import java.util.ArrayList;
import java.util.List;
import java.util.Random;


class FightClass implements Runnable {


    public static Creature generatingARandomMonster() {
        List<Creature> monsters = new ArrayList<>();
        monsters.add(Goblin.createAGoblin());
        monsters.add(Skeleton.createASkeleton());
        Random random = new Random();
        return monsters.get(random.nextInt(0, 2));

    }

    int sleepThreadTime = 2000;
    Player hero;
    Creature oneOfMonsters;

    public FightClass(Player hero, Creature oneOfMonsters) {
        this.hero = hero;
        this.oneOfMonsters = oneOfMonsters;

    }

    void fight(Player hero, Creature oneOfMonsters) {

        while (hero.getHp() > 0 & oneOfMonsters.getHp() > 0) { // if hero and monster is alive the battle starts
            if (hero.getHp() > 0 & oneOfMonsters.getHp() > 0) {

           System.out.println("vi videte, kak k vam dvizhetsya " + oneOfMonsters.getName() + ",\nno on vas esche ne zametil.\n\tchto vi budete delat'?");
                System.out.println("1 - Atakovat'\n2 - Ispol'zovat' zelie lecheniya (ostalos' " + hero.getPotions() + " sht.\n3 - Bezhat' v derevnyu.");
                oneOfMonsters.getAttacked(hero);
                hero.getAttacked(oneOfMonsters);


            } else System.out.println("someone is dead");


            //if someone hit to someone, the someones hp is get damaged

            // if someones hp get to the zero the battle is finished
        }
    }
/*
    void fight(Player hero, Creature oneOfMonsters) throws InterruptedException {

        while (hero.getHp() > 0 & oneOfMonsters.getHp() > 0) {
            if (oneOfMonsters.getHp() > 0) {

                int randomInt = (int) (Math.random() * 10);
                int hitPoint = (hero.getPower() * 2) + randomInt;
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


*/

    @Override
    public void run() {
        fight(hero, (Creature) generatingARandomMonster());
    }

}



















