public class MyScannerForSettingPlayerName {

    java.util.Scanner sc = new java.util.Scanner(System.in);

    public String getSc() {
        System.out.println("Введите имя персонажа: ");
        return sc.nextLine();
    }

    public void setSc(java.util.Scanner sc) {
        this.sc = sc;
    }
}