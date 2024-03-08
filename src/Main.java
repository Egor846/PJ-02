

class Main {

    public static void main(String[] args) {



        Creature hero = new Player("Сэр Лансеврот", 8, 7, 30, 45, 0);
        Creature goblin = new Goblin("Гоблин", 5, 4, 100);
        Creature skeleton = new Skeleton("Skeleton", 2, 3, 90);


        while (true) {
            hero.fight(goblin);

        }
    }




}