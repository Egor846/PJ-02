public class Human extends Creature {

    int gold;
    public Human(String name, int power, int agility, int hp, int gold) {
        super(name, power, agility, hp);
        this.gold = gold;


    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
        if (this.getGold() < 0){
            setGold(0);
        }
    }
}

