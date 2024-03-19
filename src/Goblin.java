public class Goblin extends Creature{
    public Goblin(String name, int power, int agility, int hp) {
        super(name, power, agility, hp);

    }
    public static Goblin createAGoblin(){
        return new Goblin("Гоблин", 5, 3, 300);
    }
}
