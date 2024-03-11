public class Fight implements Runnable{
    int hp, power, agility;
    Object hero;
    Object enemy;

    public Fight(Player hero, Creature enemy, int hp, int power,  int agility) {
        this.hero = hero;
        this.enemy = enemy;
        this.hp = hp;
    }

    @Override
    public void run() {
        while (enemy.hp > 0) {
            int randomInt = (int) (Math.random() * 10);
            int hitPoint = (power * 2) + randomInt;
            if (randomInt < enemy.agility) {

                System.out.println(name + " промахнулся.");
            }   // enemy dodges attack
            int doubleHitPoint = 0;
            if (agility > randomInt) {
                doubleHitPoint = (hitPoint * 2);
                takeDamage(enemy, hitPoint, doubleHitPoint);
            } else takeDamage(enemy, hitPoint, doubleHitPoint);  // enemy takes double damage

            if (enemy.hp <= 0) {
                System.out.println(enemy.name + " погибает.");

            }   //enemy is dying
        }

    }

    // player takes a drop from enemy


}
}
