
public class TraderMan extends Human {
    int potionPrice = 20;

    public TraderMan(String name, int power, int agility, int hp, int gold) {
        super(name, power, agility, hp, gold);

    }

    public int getPotionPrice() {
        return potionPrice;
    }

    public void setPotionPrice(int potionPrice) {
        this.potionPrice = potionPrice;
    }

    public void trade (int playerGold){


        System.out.println("vi v hizhine torgovtsa.\ntorgovets predlagaet zeliya po 20 monet za flakon");
        System.out.println("\n\tzhelaete priobresti?\n1 - da, kupit' zelie za 20 monet\n2 - net, poproschatsya i uity");
        switch (Main.scanner.nextLine()){
            case "1" -> {
                if (playerGold > this.getPotionPrice()){
                    Main.hero.setGold(playerGold -= this.getPotionPrice());
                    System.out.println("Вы приобрели одно зелье. Всего у вас " + Main.hero.getPotions() + " .");
                }
            }
            case "2" -> Main.startMenu();
        }
    }

}

