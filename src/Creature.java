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
        if (this.getHp() > 0) {
            return true;
        } else { return false;
        }
    }


        public void attack(){
            System.out.println(this.getName() + " атакует");
}

    public void getAttacked(Creature enemy) {
        int damageCoefficient = (int) ((Math.random() / 2) * 10);
        int damagePoints = enemy.getPower() + damageCoefficient;
        int criticalDamage = damagePoints * 2;
        int criticalDamageCoefficient = (int) ((Math.random() * 10));
        if (criticalDamageCoefficient == 9) {
            this.setHp(getHp() - criticalDamage);
            System.out.println(this.getName() + " получает критическое ранение на " + criticalDamage + "!");
        } else {
            this.setHp(getHp() - damagePoints);
            System.out.println(this.getName() + " получает ранение на " + damagePoints);
        }

    }
}