public class Goblin extends Creature{
    public Goblin(String name, int hp, int power, int agility) {
        super(name, hp, power, agility);

    }
    public static Goblin createAGoblin(){
        return new Goblin("Гоблин", 300, 3, 5);
    }
}
