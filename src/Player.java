public class Player extends Human {


    int potions, exp;
    final int MAX_HP = 100;

    public Player(String name, int power, int agility, int hp, int gold, int exp, int potions) {
        super(name, power, agility, hp, gold);
        this.setName(name);
        this.exp = exp;
        this.potions = potions;


    }


    public int getMAX_HP() {
        return MAX_HP;
    }

    @Override
    public void setHp(int hp) {
        super.setHp(hp);
        if (this.getHp() > getMAX_HP()) {
            setHp(getMAX_HP());
        }
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


    public void useHealPotion() {
        //usepotion
        if (this.getPotions() > 0) {
            this.setPotions(this.getPotions() - 1);
            this.setHp(this.getHp() + 20);
            System.out.println("Вы лечитесь. Ваше здоровье восстановлено на 20.");
        } else System.out.println("У вас нет зелий для лечения.");
    }




    public void getHealthAndPotionsInfo() {
        System.out.println("У вас " + this.getHp() + " здоровья и\n" + getPotions() + " шт. зелий.");
    }

    public void getReward() {
        this.setGold(this.getGold() + 5);
        this.setExp(this.getExp() + 25);
        System.out.println("Вы победили! вы получаете 5 монет и 25 очков опыта." );

    }
}
