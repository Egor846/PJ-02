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
        } else {
            System.out.println(this.getName() + this.deathPhrase());
            System.out.println("//////////////////////////////////////////\n" + this.getName() + " umiraet.");
            return false;
        }
    }

    private String deathPhrase() {
        int i = (int) (Math.random() * 10);
        switch (i) {
            case 0 -> {
                return " padaet navzhnich.";
            }
            case 1 -> {
                return " otletaet na neskol'ko metrov.";
            }
            case 2 -> {
                return " padaet zamertvo.";
            }
            case 3 -> {
                return " poshatnulsya i ypal. ego golova ykatilas' v kusty.";
            }
            case 4 -> {
                return " prevratilsya v neuznavaemoe mesevo.";
            }
            case 5 -> {
                return " izdal posledniy vopl'";
            }
            case 6 -> {
                return " nashel svoy smert' v lesu.";
            }
            case 7 -> {
                return " pal v bou.";

            }
            case 8 -> {
                return " usnul vechnym snom.";

            }
            case 9 -> {
                return " bol'she ne vstanet.";
            }
        }
        return null;

    }
        public void attack(){
            System.out.println(this.getName() + " atakuet");
}

    public void getAttacked(Creature enemy) {
        int damageCoefficient = (int) ((Math.random() / 2) * 10);
        int damagePoints = enemy.getPower() + damageCoefficient;
        int criticalDamage = damagePoints * 2;
        int criticalDamageCoefficient = (int) ((Math.random() * 10));
        if (criticalDamageCoefficient == 9) {
            this.setHp(getHp() - criticalDamage);
            System.out.println(this.getName() + " poluchaet criticheskoe ranenie na " + criticalDamage + "!");
        } else {
            this.setHp(getHp() - damagePoints);
            System.out.println(this.getName() + " poluchaet ranenie na " + damagePoints);
        }

    }
}