public class Creature {


    String name;
    int power, agility, hp;

    public Creature(String name, int power, int agility, int hp) {
        this.name = name;
        this.power = power;
        this.agility = agility;
        this.hp = hp;
    }

    void attack(Creature monster, Player hero) {

        //  attack hero
        if (monster.hp > 0 & hero.hp > 0) // if both of them is alive the battle is starts until someones death

            if (monster.agility == Math.random() * 10) { // random chance to crit
                hero.hp -= monster.power * 2; // hero takes double damage

            } else {
                hero.hp -= monster.power; // hero takes damage

                System.out.println(hero.name + " получает ранение, теряет " + monster.power + " оч. здоровья");
            }
    }


    // критует


    void status() {
        System.out.println("??? " + name + "???? " + power + "???????? " + agility + "???????? " + hp);
    }

    // зашэщищается


}


