import java.util.Scanner;

class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Введите имя персонажа: ");
        Player.setPlayerName(sc.nextLine());




        Creature traderMan = new TraderMan("Моршу", 10, 10, 9001, 10000);

        Fight fight = new Fight();
        fight.run();


    }




}