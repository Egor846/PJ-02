import java.util.Scanner;

class Main {
    static Scanner sc = new Scanner(System.in);



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
                TraderMan.trade(Player.hero.getGold());
            }
        }





    }


}

