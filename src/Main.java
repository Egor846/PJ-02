import java.util.Scanner;

class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Введите имя персонажа: ");
        Player.setPlayerName(sc.nextLine());
        System.out.println("Вы доблестный средневековый воин,\nвы можете пойти в темный лес,\nспасат лес от наестви монстров или айти к торов\n а припасами.");
        System.out.println("Кда пт держим?");



        Creature traderMan = new TraderMan("Моршу", 10, 10, 9001, 10000);

        Fight fight = new Fight();
        fight.run();


    }




}