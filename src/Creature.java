import java.util.Scanner;

class Creature {

    String name;
    int power, agility, hp, gold, exp;


    public Creature(String name, int power, int agility, int hp) {

        this.name = name;
        this.power = power;
        this.agility = agility;
        this.hp = hp;
    }



    public Runnable attack = new Runnable() {


            Creature enemy;
            public void run() {


            // метод атаки. врагом будет считаться любой недруг, если это герой, значит, его враг это гоблин или скелет, если это скелет или гоблин, то их враг это герой

            while (enemy.hp > 0) {
                int randomInt = (int) (Math.random() * 10);
                int hitPoint = (power * 2) + randomInt;
                if (randomInt < enemy.agility) {

                    System.out.println(name + " промахнулся.");
                }   // enemy dodges attack
                int doubleHitPoint = 0;
                if (agility > randomInt) {
                    doubleHitPoint = (hitPoint * 2);
                    takeDamage(enemy, hitPoint, doubleHitPoint);
                } else takeDamage(enemy, hitPoint, doubleHitPoint);  // enemy takes double damage

                if (enemy.hp <= 0) {
                    System.out.println(enemy.name + " погибает.");

                }   //enemy is dying
            }

        }

        // player takes a drop from enemy


        void takeDamage(Creature enemy, int hitPoint, int doubleHitPoint) {

            if (doubleHitPoint == 0) {
                enemy.hp -= hitPoint;
                System.out.println(enemy.name + " получил ранение на " + hitPoint + ".");
            } else {
                System.out.println(enemy.name + " получил критическое ранение на " + doubleHitPoint + "!");
            }


        }
    };
}

