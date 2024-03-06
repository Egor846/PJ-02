public class Player extends Creature {
    int money, potions, turnCount;

    public Player(String name, int power, int agility, int hp, int money, int potions) {
        super(name, power, agility, hp);
        this.money = money;
        this.potions = potions;

    }

    void attack(Creature monster, Player hero) {

        //  атакует героя
        if (monster.hp > 0 & hero.hp > 0)
            monster.hp -= hero.power;
        System.out.println(hero.name + " получает ранение");
    }

    public void trade() {
        System.out.println("Торговец предлагает зель ицелент за 5 онет");
        System.out.println("Торговать?\n1 - да\n2 - нет");
        switch (Main.scanner.nextInt()) {
            case 1 -> {
                if (money >= 5) {
                    money -= 5;
                    potions++;
                    System.out.println("Покупка овершена.\nТеперь у ва " + money + " онет, и " + potions + " зели");
                    trade();
                } else System.out.println(" У ва недотатоно денег");
            }
            case 2 -> {
                System.out.println("Вы возврааетеь в подзеелье");
                Main.GameLoop();
            }
        }
    }
}
