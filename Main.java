import java.util.Scanner;

class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
Creature monster = new Creature("monster", 5, 5, 5);
Player hero = new Player("hero", 5, 5, 5, 5, 5);
hero.attack(monster, hero);
    }

    public static void GameLoop() {

    }
}