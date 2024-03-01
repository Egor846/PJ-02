class Creature {


    String name;
    int power, agility, hp;

    public Creature(String name, int power, int agility, int hp) {
        this.name = name;
        this.power = power;
        this.agility = agility;
        this.hp = hp;
    }

    void attack(Creature enemy, Creature hero) {
        while (enemy.hp > 0 & hero.hp > 0) {
            System.out.println(hero.name + " атакует!");
            if (enemy.agility <= (Math.random() * 10) * 2) {
                enemy.hp -= hero.power;
                if (enemy.hp <= 0) {
                    enemy.hp = 0;
                    System.out.println(enemy.name + " погибает.");
                    System.out.println("Вы одерживаете победу!");
                    Main.deadMonsterCount++;
                    System.out.println("Вы убили " + Main.deadMonsterCount + " из 10!");
                    Main.GameLoop();
                    break;
                } else {
                    System.out.println(enemy.name + " получает ранение, его здоровье " + enemy.hp);

                }
            } else System.out.println(enemy.name + " уворачивается!");

            System.out.println(enemy.name + " атакует!");
            if (hero.agility <= Math.random() * 10) {
                hero.hp -= enemy.power;
                if (hero.hp <= 0) {
                    hero.hp = 0;
                    System.out.println(hero.name + " погибает.");
                    System.out.println("Вы проиграли");
                    break;
                } else
                    System.out.println(hero.name + " получает ранение, его здоровье " + hero.hp);


            } else System.out.println(hero.name + " уворачивается!");

        }


    }


    void status() {
        System.out.println("Имя " + name + "Сила " + power + "Ловкость " + agility + "Здоровье " + hp);
    }

    void damage(int hit) {
        hp -= hit;
    }

}