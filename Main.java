import java.io.IOException;
import java.util.Scanner;

public class Main {
    static App[] app = new App[3];

    public void useApp1() {
        app[0] = new Manage();
        ((Manage) app[0]).useDirection();
    }

    public void useApp2() {
        app[1] = new Study();
        ((Study)app[1]).useDirection();
    }

    public void useApp3() {
        app[2] = new Play();
        ((Play)app[2]).useDirection();
    }

    public void readCaption()
    {
        app[0] = new Manage();
        app[1] = new Study();
        app[2] = new Play();
        for (int i = 0 ; i < app.length ; i++)
        {
            app[i].getCaption();
        }
    }

    public void printMenu() {
        System.out.println("1.manage\n2.study\n3.play\n4.read captions\n0.Exit");
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        Card cr = new Card();
        cr.readCards();
        Main mn = new Main();
        int choice = 1;
        while (choice != 0) {
            mn.printMenu();
            choice = in.nextInt();
            in.nextLine();
            switch (choice) {
                case 1 -> mn.useApp1();
                case 2 -> mn.useApp2();
                case 3 -> mn.useApp3();
                case 4 -> mn.readCaption();
                case 0 -> {
                }
                default -> System.out.println("Zuv utga oruulna uu.");
            }
        }
    }
}
