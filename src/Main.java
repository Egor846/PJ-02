import java.util.Scanner;

class Main {

    static MyScannerForSettingPlayerName sc = new MyScannerForSettingPlayerName(); // мне пришлось так сделать, потомучто Идея ругалась, что я не могу использовать нестатичное из статичного, и моих монстров звали так же, как и главного героя. Создавать в классе героя отдельный playerName, затыкая в конструкторе поле name null'ом считаю неправильным использованием наследования
    static Scanner scanner = new Scanner(System.in);
    static String playerName = sc.getSc();
    static Player hero = new Player(playerName, 8, 7, 100, 5, 0, 1, 100);



  //  Creature traderMan = new TraderMan("Моршу", 10, 10, 9001, 10000);


    public static void main(String[] args) {



        System.out.println("Вы - отважный воин по имени " + hero.getName() + ".\nВаш долг защитить родную деревню от пробирающихся через лес скелетов и гоблинов.\nВы можете отправится в лес прямо сейчас или\nзайти к торговцу за зельями лечения.");
        System.out.println("\tКуда путь держим?");
        System.out.println("1 - В лес. Вы готовы вступить в бой!\n2 - К торговцу. У вас есть какая-то тактика и вы ей придерживаетесь.\n3 - Выйти из игры. Вы хотите к маме.");

        switch (scanner.nextInt()){
            case 1 -> {
                FightClass fightInForest = new FightClass(hero);
                fightInForest.run();
            }
        }




//
//        System.out.println("Вы доблестный средневековый воин по имени " + Player.getPlayerName() + ",\nвы можете пойти в темный лес,\nспасать лес от нашествия монстров или зайти к торговцу\nза припасами.");
//        game();
//
//
//    }
//
//    public static void game() {
//        System.out.println("Куда путь держим?\n1 - В темный лес\n2 - К торговцу\n3 - Выход из игры");
//
//        switch (sc.nextInt()) {
//            case 1 -> {
//
//                FightClass.fight.run();
//                game();
//            }
//            case 2 -> {
//                TraderMan.trade(hero.getGold());
//            }
//        }
//
//
//
//
//
//    }


    }
}
