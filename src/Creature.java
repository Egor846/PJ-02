public class Creature{
   private String name;
    private int hp, power, agility;

    public Creature(String name, int power, int agility, int hp) {
        this.name = name;
        this.hp = hp;
        this.power = power;
        this.agility = agility;
    }

    void takeDamage(int powerOfDamage){
        this.hp -= powerOfDamage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }
}