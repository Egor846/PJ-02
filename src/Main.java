import java.util.Scanner;


class Main {

    static MyScannerForSettingPlayerName sc = new MyScannerForSettingPlayerName(); // мне пришлось так сделать, потомучто Идея ругалась, что я не могу использовать нестатичное из статичного, и моих монстров звали так же, как и главного героя. Создавать в классе героя отдельный playerName, затыкая в конструкторе поле name null'ом считаю неправильным использованием наследования
    static Scanner scanner = new Scanner(System.in);
    static String playerName = sc.getSc();
    static Player hero = new Player(playerName, 8, 7, 100, 21, 0, 1);
    static TraderMan traderMan = new TraderMan("Моршу", 10, 10, 9001, 10000);


    public static void main(String[] args) {

        System.out.println("Вы - отважный воин по имени " + hero.getName() + ".\nВаш долг защитить родную деревню от пробирающихся через лес скелетов и гоблинов.\nВы можете отправится в лес прямо сейчас или\nзайти к торговцу за зельями лечения.");
        startMenu();
    }

    static void startMenu() {
        hero.getInfo();
        System.out.println("Вы находитесь в деревне\n\tКуда путь держим?");
        System.out.println("1 - В лес. Вы готовы вступить в бой!\n2 - К торговцу. У вас есть какая-то тактика и вы её придерживаетесь.\n3 - Выйти из игры. Вы хотите к маме.");

        switch (Answer.getOption()) {
            case 1 -> {
                FightClass fightInForest = new FightClass(hero, FightClass.generatingARandomMonster());
                fightInForest.preFightMenu();
            }
            case 2 -> {
                traderMan.letsTrade();
            }
            case 3 -> {
                System.exit(0);
            }
            case 4 -> {
                System.out.println("hero.getHp() " + hero.getHp() + ". hero.getName() " + hero.getName() + ". hero.getExp() " + hero.getExp() + ". hero.getPotions() " + hero.getPotions() + ". hero.getAgility() " + hero.getAgility() + ". hero.getPower() " + hero.getPower());
            }

        }

    }
}
