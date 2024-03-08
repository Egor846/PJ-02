

class Main {

    public static void main(String[] args) {



        Creature hero = new Player("Сэр Лансеврот", 8, 7, 30, 45, 0);
        Creature goblin = new Goblin("Гоблин", 5, 4, 100);
        Creature skeleton = new Skeleton("Скелет", 2, 3, 90);


        for (int i = 0; i < 1; i++) {
            hero.attack(goblin);
        }
    }




}