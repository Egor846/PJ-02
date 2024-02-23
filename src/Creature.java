class Creature {
    String name;
    int power, agility, hp;

    public Creature(String name, int power, int agility, int hp) {
        this.name = name;
        this.power = power;
        this.agility = agility;
        this.hp = hp;
    }
    void attack(Creature enemy){
        enemy.damage(bbbbb); -= power;
        System.out.println(name + " атакует!");
    }

    void dodge(){
        System.out.println(name + " уворачивается!");
    }

    void status(){
        System.out.println("Имя" + name + "Сила" + power+ "Ловкость" + agility + "Здоровье" + hp);
    }

    void damage(int hit){
        hp -= hit;
    }
}
