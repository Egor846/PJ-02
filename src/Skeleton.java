public class Skeleton extends Creature {
    public Skeleton(String name, int power, int agility, int hp) {
        super(name, power, agility, hp);
    }


    static Skeleton createASkeleton(){
        return new Skeleton("Скелет", 2, 3, 90);
    }
}
