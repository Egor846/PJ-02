public class Player extends Human {

    public static Creature hero = new Player(Player.getPlayerName(), 8, 7, 300, 5, 0, 1);
    static String playerName;
    static int potions;

    static public String getPlayerName() {
        return playerName;
    }

    static public void setPlayerName(String playerName) {

        Player.playerName = playerName;
    }

    public Player(String name, int power, int agility, int hp, int gold, int exp, int potions) {
        super(name, power, agility, hp, gold);
        Player.playerName = this.name;
        this.exp = exp;
        Player.potions = potions;

    }


    public static int getPotions() {
        return potions;
    }
}
