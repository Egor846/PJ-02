import java.util.Random;

public class Creature {
    private String name;
    private int hp, power, agility;

    public Creature(String name, int power, int agility, int hp) {
        this.name = name;
        this.hp = hp;
        this.power = power;
        this.agility = agility;
    }

    void takeDamage(int powerOfDamage) {
        this.hp -= powerOfDamage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
        if (getHp() < 0) {
            setHp(0);
        }


    }


    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    boolean isAlive() {
        if (this.getHp() <= 0) {
            System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
            System.out.println(this.getName() + deathPhrase());
            return false;
        }
        return true;
    }


    public void attack() {
        System.out.println(this.getName() + " атакует");

    }

    public void getAttackedBy(Creature enemy) {
        Random r = new Random();
        int damageCoefficient = (int) ((Math.random() / 2) * 10);
        int damagePoints = enemy.getPower() + damageCoefficient;
        int criticalDamage = damagePoints * 2;
        int criticalDamageCoefficient = (int) ((Math.random() * 10));
        if( ( this.getAgility() * 3 ) > r.nextInt(101)){
            System.out.println(enemy.getName() + " промаxнулся.");
        } else if (criticalDamageCoefficient == 9) {
            this.setHp(getHp() - criticalDamage);
            System.out.println(this.getName() + " получает критическое ранение на " + criticalDamage + "!");
        } else {
            this.setHp(getHp() - damagePoints);
            System.out.println(this.getName() + " получает ранение на " + damagePoints);
        }
    }

    private static String deathPhrase() {
        int i = (int) (Math.random() * 10);
        switch (i) {
            case 0 -> {
                return " падает навзничь.";
            }
            case 1 -> {
                return " отлетает на несколько метров.";
            }
            case 2 -> {
                return " падает замертво.";
            }
            case 3 -> {
                return " пошатнулся и упал. Его голова укатилась в кусты.";
            }
            case 4 -> {
                return " превратился в неузнаваемое месево.";
            }
            case 5 -> {
                return " издал последний вопль";
            }
            case 6 -> {
                return " нашел свою смерть в лесу.";
            }
            case 7 -> {
                return " пал в бою.";

            }
            case 8 -> {
                return " уснул вечным сном.";

            }
            case 9 -> {
                return " больше не встанет.";
            }
        }
        return null;
    }
}