public class Player extends Human{

static String playerName;

    static public String getPlayerName() {
        return playerName;
    }

    static public void setPlayerName(String playerName) {
        Player.playerName = playerName;
    }

    public Player(String name, int power, int agility, int hp, int gold, int exp) {
        super(name, power, agility, hp, gold);
        Player.playerName = this.name;

        this.exp = exp;

    }



}
