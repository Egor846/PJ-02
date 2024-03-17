import java.util.Scanner;

class Main {
    static Scanner sc = new Scanner(System.in);

    static Fight fight = new Fight();
    public static void main(String[] args) {


        System.out.println("Введите имя персонажа: ");
        Player.setPlayerName(sc.nextLine());

        System.out.println("Вы доблестный средневековый воин,\nвы можете пойти в темный лес,\nспасать лес от нашествия монстров или зайти к торговцу\n за припасами.");
        game();


    }

    public static void game(){
        System.out.println("Куда путь держим?\n1 - В темный лес\n2 - К торговцу\n3 - Выо з гры");

        switch (sc.nextInt()) {
            case 1 -> {

                Main.fight.run();
                game();


            }
        }



        Creature traderMan = new TraderMan("Моршу", 10, 10, 9001, 10000);


    }



}