public class Player extends Human {


    int potions, exp;
    final int MAX_HP = 100;

    public Player(String name, int power, int agility, int hp, int gold, int exp, int potions, int maxHp) {
        super(name, power, agility, hp, gold);
        this.name = name;
        this.exp = exp;
        this.potions = potions;

    }




    public int getMAX_HP() {
        return MAX_HP;
    }

    public int getPotions() {
        return potions;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public void setPotions(int potions) {
        this.potions = potions;
    }


}
