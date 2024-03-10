import java.util.Scanner;

class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Введите имя персонажа: ");
        String playerName = sc.nextLine();


        Creature hero = new Player(playerName,8, 7, 30, 45, 0);
        Creature goblin = new Goblin("Гоблин", 5, 4, 100);
        Creature skeleton = new Skeleton("Скелет", 2, 3, 90);
        Creature traderMan = new TraderMan("Моршу", 10, 10, 9001, 10000);


        for (int i = 0; i < 1; i++) {
            hero.attack.run();

        }
    }




}