public class Player extends Creature {
    static int money;
    int potions;

    public Player(String name, int power, int agility, int hp, int money, int potions) {
        super(name, power, agility, hp);
        Player.money = money;
        this.potions = potions;

    }



    public void trade() {
        System.out.println("Торговец предлагает зелья исцеления за 5 монет");
        System.out.println("Торговать?\n1 - да\n2 - нет");
        switch (Main.scanner.nextInt()) {
            case 1 -> {
                if (money >= 5) {
                    money -= 5;
                    potions++;
                    System.out.println("Покупка совершена.\nТеперь у вас " + money + " монет, и " + potions + " зелий");
                    trade();
                } else System.out.println(" У вас недостаточно денег");
            }
            case 2 -> {
                System.out.println("Вы возврааетесь в подземелье");
                Main.GameLoop();
            }
        }
    }
}
