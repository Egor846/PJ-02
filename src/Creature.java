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
        while (true) {
            if (enemy.hp > 0) {
                if (agility < (Math.random() * 10)) {
                    enemy.hp -= power;
                    System.out.println(enemy.name + " получил ранение на " + power);
                } else System.out.println(name + " промахнулся.");

            }
        }
    }
}
