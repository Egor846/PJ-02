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


    void fight(Creature enemy) { // метод атаки. врагом будет считаться любой недруг, если это герой, значит, его враг это гоблин или скелет, если это скелет или гоблин, то их враг это герой
        while (enemy.hp > 0) { // veroyatnost uvorota protivnika ishodya iz ego lovkosti
            int hitPoint = (int) (this.power + Math.random() * 10) / 2;
            if ((Math.random() * 10) > 8){
                hitPoint *= 2;
                System.out.println(enemy.name + " poluchaet kriticheskoe ranenie na " + hitPoint);
            }
            if (hitPoint < 3) {
                hitPoint += 6;
            }
            attack(enemy, hitPoint);
        }

    }


    void attack(Creature enemy, int hitPoint) {
        enemy.hp -= hitPoint;
        System.out.println(enemy.name + " получил ранение на " + hitPoint);
    }
}
