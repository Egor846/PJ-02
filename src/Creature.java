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


    void attack(Creature enemy) { // метод атаки. врагом будет считаться любой недруг, если это герой, значит, его враг это гоблин или скелет, если это скелет или гоблин, то их враг это герой
        {
            while (enemy.hp > 0) {
                int randomInt = (int) (Math.random() * 10);
                int hitPoint = (power * 2) + randomInt;
                if (randomInt < enemy.agility) {
                    // enemi dodges attack
                    System.out.println(name + " промахнулся.");
                }
                if (randomInt == 1) {
                    // enemy takes double damage
                    takeDamage(enemy, hitPoint * 2);
                    System.out.println(enemy.name + " получает критический урон!");
                }
                takeDamage(enemy, hitPoint);
                if (enemy.hp <= 0) {
                    System.out.println(enemy.name + " погибает.");

                }
            }

        }

        System.out.println("и");

    }


    void takeDamage(Creature enemy, int hitPoint) {
        enemy.hp -= hitPoint;
        System.out.println(enemy.name + " получил ранение на " + hitPoint);
    }
}
