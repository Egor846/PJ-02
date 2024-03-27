import java.util.Scanner;

public class Answer {
    static int option;

    public static int getOption() {
        Scanner scanner = new Scanner(System.in);

        if (scanner.hasNextInt()) {
            option = scanner.nextInt();
        } else {
            System.out.println("Вы ввели неверное действие: " + option);
            getOption();
        }

        return option;
    }
}
