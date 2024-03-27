public class Player extends Human {


    int potions, exp;
    final int MAX_HP = 100;
    final int MAX_EXP = 100;

    public int GET_MAX_EXP() {
        return MAX_EXP;
    }

    public Player(String name, int power, int agility, int hp, int gold, int exp, int potions) {
        super(name, power, agility, hp, gold);
        this.setName(name);
        this.exp = exp;
        this.potions = potions;


    }


    public int GET_MAX_HP() {
        return MAX_HP;
    }

    @Override
    public void setHp(int hp) {
        super.setHp(hp);
        if (this.getHp() > GET_MAX_HP()) {
            setHp(GET_MAX_HP());
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
        if (getExp() == GET_MAX_EXP()){
            setExp(0);
            this.setPower(this.getPower() + 1);
            this.setAgility(this.getAgility() + 1);
            System.out.println("Поздравляем! Вы получили новый уровень!");
        }
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




    public void getInfo() {
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Имя: " + this.getName() + ". Здоровье: " + this.getHp() + ". Сила: " + this.getPower() + ". Ловкость: " + this.getAgility() + ". Опыт: " + this.getExp() + ". Монеты: " + this.getGold() + ". Зелья: " + this.getPotions() + ". Статус: " + Main.hero.isAlive());
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    public void getReward() {
        this.setGold(this.getGold() + 5);
        this.setExp(this.getExp() + 25);
        System.out.println("Вы победили! вы получаете 5 монет и 25 очков опыта." );

    }
}
