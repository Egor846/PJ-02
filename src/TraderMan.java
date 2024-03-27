public class TraderMan extends Human {
    final int POTION_PRICE = -20;

    public int getPotionPrice() {
        return POTION_PRICE;
    }


    public TraderMan(String name, int power, int agility, int hp, int gold) {
        super(name, power, agility, hp, gold);

    }


    public void letsTrade() {

        Main.hero.getInfo();
        System.out.println("Вы в хижине торговца.\nТорговец предлагает зелья по 20 монет за флакон.");
        System.out.println("\n\tЖелаете приобрести?\n1 - Да, купить зелье за 20 монет.\n2 - Нет, попрощаться и уйти.");

        switch (Answer.getOption()) {
            case 1 -> {
                sellAPotion();
                letsTrade();
            }
            case 2 -> Main.startMenu();

        }
    }

    private void sellAPotion() {
        if ( Main.hero.getGold() >= Math.abs( this.getPotionPrice() )) {
            Main.hero.setGold(Main.hero.getGold() + this.getPotionPrice());
            Main.hero.setPotions(Main.hero.getPotions() + 1);
            System.out.println("\tВы приобрели одно зелье.");
        } else if (Main.hero.getGold() <= Math.abs( this.getPotionPrice() )){
            System.out.println("\n\tУ вас недостаточно монет.\n");
            letsTrade();
        }
    }
}





