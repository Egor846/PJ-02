import java.util.Scanner;

public class Main {
    static int deadMonsterCount;
    public static void main(String[] args) {

        System.out.println("Вы находитесь в подземелье, кишащем монстрами.\nВаша задача зачистить подземелье.\nК счастью, в подземелье темно, и они не видят вас,\nпока вы не подберетесь к ним вплотную.\nВы можете начать зачистку прямо сейчас или\nвернуться в город и купить припасы");
        GameLoop();


    }

    static void GameLoop(){
        System.out.println("~Вводите команды для действия~\n1 - атаковать ближайшего монстра\n2 - Вернуться в город к торговцу");
        Creature hero = new Creature("Stranger", 15, 4, 100);
        Creature monster = new Creature("Monster", 7, 9, 100);
        Scanner scanner = new Scanner(System.in);



        switch (scanner.nextLine()) {
            case "1" -> {
                hero.attack(monster, hero);
            }
        }

    }
}





