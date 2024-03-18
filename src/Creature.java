class Creature{
    String name;
    int hp, power, agility;

    public Creature(String name, int hp, int power, int agility) {
        this.name = name;
        this.hp = hp;
        this.power = power;
        this.agility = agility;
    }

    void getDamage(int powerOfDamage){
        this.hp -= powerOfDamage;
    }
}