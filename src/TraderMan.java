public class TraderMan extends Human {
    public TraderMan(String name, int power, int agility, int hp, int gold) {
        super(name, power, agility, hp, gold);

    }

    public void trade (Player player){

        player.gold -= iPrice;
    }

}
