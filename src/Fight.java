import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Fight implements Runnable{


    long sleepThreadTime = 1000;

  Player hero;
  Creature goblin, skeleton;

    public Fight(long sleepThreadTime, Player hero) {
        this.sleepThreadTime = sleepThreadTime;
        this.hero = hero;
    }



    @Override
    public void run() {
        fight(hero, (Creature) randomMonster());
    }



    public Object randomMonster(){


        List<Object> monsters = new ArrayList<>();
        monsters.add(goblin);
        monsters.add(skeleton);
        Random random = new Random();
        return monsters.get(random.nextInt(0,2));

    }

    void fight(Creature hero, Creature monster) {

            while (hero.hp > 0 & monster.hp > 0) {
                if (monster.hp > 0) {

                    int randomInt = (int) (Math.random() * 10);
                    int hitPoint = (hero.power * 2) + randomInt;
                    int doubleHitPoint = 0;

                    System.out.println("\n" + Player.getPlayerName() + " атакует с силой " + hitPoint + "!");


                    // enemy dodges attack
                    if (randomInt < monster.agility) {
                        System.out.println(Player.getPlayerName() + " промахнулся.");
                    } else if (monster.agility > randomInt) {
                        doubleHitPoint = (hitPoint * 2);
                        takeDamage(monster, hitPoint, doubleHitPoint);
                    } else takeDamage(monster, hitPoint, doubleHitPoint);  // enemy takes double damage

                    //enemy is dying
                    if (monster.hp <= 0) {
                        System.out.println(monster.name + " погибает.");
                        System.out.println("Поздравляем, вы получаете 5 монет и 10 очков опыта");

                        // player takes a drop from enemy
                        //player takes exp

                        hero.setGold(hero.getGold() + 5);
                        hero.setExp(hero.getExp() + 10);
                        System.out.println("У вас " + hero.getGold() + " монет " + hero.getExp() + "/" + hero.getMaxExp() + " очков опыта.");

                    }

                }
                if (hero.hp > 0 & monster.hp > 0) {

                    int randomInt = (int) (Math.random() * 10);
                    int hitPoint = (monster.power * 2) + randomInt;
                    int doubleHitPoint = 0;

                    System.out.println("\n" + monster.name + " атакует с силой " + hitPoint + "!");

                    // hero dodges attack
                    if (randomInt < hero.agility) {
                        System.out.println(monster.name + " промахнулся.");
                    } else if (hero.agility > randomInt) {
                        doubleHitPoint = (hitPoint * 2);
                        takeDamage(hero, hitPoint, doubleHitPoint);
                    } else takeDamage(hero, hitPoint, doubleHitPoint);  // enemy takes double damage

                    //player is dying
                    if (hero.hp <= 0) {
                        System.out.println("Вы погибли, игра проиграна!");
                        System.exit(0);

                    }
                }

            }

        }

    void takeDamage(Creature enemy, int hitPoint, int doubleHitPoint) {

        if (doubleHitPoint == 0) {
            enemy.hp -= hitPoint;
            System.out.println(enemy.name + " получил ранение на " + hitPoint + ".");
        } else {
            System.out.println(enemy.name + " получил критическое ранение на " + doubleHitPoint + "!");
        }
    }


}



















