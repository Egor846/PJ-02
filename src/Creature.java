
import java.util.Scanner;

class Creature {

    String name;
    int power, agility, hp, gold, exp;

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public Creature(String name, int power, int agility, int hp) {

        this.name = name;
        this.power = power;
        this.agility = agility;
        this.hp = hp;
    }


    public int getMaxExp() {
        return 100;
    }


}
