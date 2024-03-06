import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Creature hero = new Player("Сэр Лансеврот", 8, 7, 30, 45, 0);
        Creature goblin = new Goblin("Гоблин", 5, 4, 10);

        hero.attack(goblin);
        goblin.attack(hero);
    }
}