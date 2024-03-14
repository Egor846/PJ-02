import javax.print.attribute.standard.ReferenceUriSchemesSupported;

class Fight{

    Creature hero = new Player(Player.getPlayerName(),8, 7, 30, 45, 0);
    Creature goblin = new Goblin("Гоблин", 5, 3, 30);
    Creature skeleton = new Skeleton("Скелет", 2, 3, 90);


    void fight(Creature hero, Creature monster) { // метод атаки. врагом будет считаться любой недруг, если это герой, значит, его враг это гоблин или скелет, если это скелет или гоблин, то их враг это герой
        {

            // peredelat zanovo


            if (monster.hp > 0) {
                int randomInt = (int) (Math.random() * 10);
                int hitPoint = (hero.power * 2) + randomInt;
                if (randomInt < monster.agility) {
                    System.out.println(hero.name + " промахнулся.");
                }   // enemy dodges attack
                int doubleHitPoint = 0;
                if (monster.agility > randomInt) {
                    doubleHitPoint = (hitPoint * 2);
                    takeDamage(monster, hitPoint, doubleHitPoint);
                } else takeDamage(monster, hitPoint, doubleHitPoint);  // enemy takes double damage

                if (monster.hp <= 0) {
                    System.out.println(monster.name + " погибает.");
                    System.exit(0);


                }   //enemy is dying
            }
            if (hero.hp > 0) {
                int randomInt = (int) (Math.random() * 10);
                int hitPoint = (monster.power * 2) + randomInt;
                if (randomInt < hero.agility) {
                    System.out.println(monster.name + " промахнулся.");
                }   // enemy dodges attack
                int doubleHitPoint = 0;
                if (hero.agility > randomInt) {
                    doubleHitPoint = (hitPoint * 2);
                    takeDamage(hero, hitPoint, doubleHitPoint);
                } else takeDamage(hero, hitPoint, doubleHitPoint);  // enemy takes double damage

                if (hero.hp <= 0) {
                    System.out.println("Вы погибли, игра проиграна!");
                    System.exit(0);



                }   //player is dying
            } fight(hero, monster);

        }

        // player takes a drop from enemy


    }


    void takeDamage(Creature enemy, int hitPoint, int doubleHitPoint) {

        if (doubleHitPoint == 0) {
            enemy.hp -= hitPoint;
            System.out.println(enemy.name + " получил ранение на " + hitPoint + ".");
        } else {
            System.out.println(enemy.name + " получил критическое ранение на " + doubleHitPoint + "!");
        }


    }
    Runnable heroAttack = new Runnable() {
        @Override
         public synchronized void run() {

            fight(hero, goblin);
        }
    };







}





