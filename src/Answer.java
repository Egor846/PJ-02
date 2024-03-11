class Hero { 
    private int strength; 
 
    public Hero(int strength) { 
        this.strength = strength; 
    } 
 
    public synchronized void attack(Monster monster) { 
        // Ударить монстра 
        System.out.println("Hero attacks monster with strength " + strength); 
        monster.takeDamage(strength); 
    } 
} 
 
class Monster { 
    private int health; 
 
    public Monster(int health) { 
        this.health = health; 
    } 
 
    public synchronized void takeDamage(int damage) { 
        // Получить урон от героя 
        System.out.println("Monster takes damage: " + damage); 
        health -= damage; 
    } 
 
    public synchronized boolean isAlive() { 
        // Проверить, жив ли монстр 
        return health > 0; 
    } 
} 
 
class Battle implements Runnable { 
    private Hero hero; 
    private Monster monster; 
 
    public Battle(Hero hero, Monster monster) { 
        this.hero = hero; 
        this.monster = monster; 
    } 
 
    @Override 
    public void run() { 
        while (monster.isAlive()) { 
            // Герой атакует монстра, пока монстр жив 
            hero.attack(monster); 
        } 
        System.out.println("Monster defeated!"); 
    } 
} 
 
public class Main { 
    public static void main(String[] args) { 
        // Создаем героя и монстра 
        Hero hero = new Hero(10); // Герой с силой атаки 10 
        Monster monster = new Monster(50); // Монстр с здоровьем 50 
 
        // Создаем поток для битвы 
        Thread battleThread = new Thread(new Battle(hero, monster)); 
        battleThread.start(); // Запускаем поток битвы 
 
        // Ожидаем завершения битвы 
        try { 
            battleThread.join(); 
        } catch (InterruptedException e) { 
            e.printStackTrace(); 
        } 
 
        System.out.println("Battle finished!"); 
    } 
}