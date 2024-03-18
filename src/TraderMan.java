public class TraderMan extends Human {
    static Creature traderMan = new TraderMan("Моршу", 10, 10, 9001, 10000);
    public TraderMan(String name, int power, int agility, int hp, int gold) {
        super(name, power, agility, hp, gold);

    }

    public static void trade (int playerGold){

        int potionPrice = 5;
        System.out.println("vi v hizhine torgovtsa.\ntorgovets predlagaet zeliya po 20 monet za flakon");
        System.out.println("\n\tzhelaete priobresti?\n1 - da, kupit' zelie za 20 monet\n2 - net, poproschatsya i uity");
        switch (Main.sc.nextInt()){
            case 1 -> {
                TraderMan.trade();
            }
        }
    }

}
