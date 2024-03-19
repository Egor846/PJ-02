public class Skeleton extends Creature {
    public Skeleton(String name, int hp, int power, int agility) {
        super(name, hp, power, agility);
    }

    int hp;

    @Override
    public int getHp() {
        return hp;
    }

    @Override
    public void setHp(int hp) {
        this.hp = hp;
    }

    static Skeleton createASkeleton(){
        return new Skeleton("Скелет", 90, 3, 2);
    }
}
