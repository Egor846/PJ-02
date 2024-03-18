import java.util.Scanner;

class Main {
    Scanner sc = new Scanner(System.in);
    Fight fight = new Fight();
    public Player hero = new Player(Player.getPlayerName(), 8, 7, 300, 5, 0, 1);

    Creature goblin = new Goblin("Гоблин", 5, 3, 300);
    Creature skeleton = new Skeleton("Скелет", 2, 3, 90);
    Creature traderMan = new TraderMan("Моршу", 10, 10, 9001, 10000);


    public static void main(String[] args) {


        System.out.println("Введите имя персонажа: ");


        Player.setPlayerName(sc.nextLine());


        System.out.println("Вы доблестный средневековый воин по имени " + Player.getPlayerName() + ",\nвы можете пойти в темный лес,\nспасать лес от нашествия монстров или зайти к торговцу\nза припасами.");
        game();


    }

    public static void game() {
        System.out.println("Куда путь держим?\n1 - В темный лес\n2 - К торговцу\n3 - Выход из игры");

        switch (sc.nextInt()) {
            case 1 -> {

                Fight.fight.run();
                game();
            }
            case 2 -> {
                TraderMan.trade(hero.getGold());
            }
        }





    }


}

