import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.Scanner;

public class Study  implements App{
    
    @Override
    public void Start()
    {
        System.out.println("1.baigaa carduudiig harah\n2.test uguh\n0.Exit");
    }
    
    public void getCaption() {
        System.out.println("Study: Carduudaa nudlen uuriiguu beltgene");
    }

    public void seeCards() {
        Card cr = new Card();
        cr.seeCard();
    }

    public void testUguh()
    {
        Scanner in = new Scanner(System.in);
        String ans;
        int count = 0, count1 = 0;
        File file = new File("C:\\Users\\Dell\\OneDrive\\Documents\\Buteelt\\BD1\\question.txt");
        File answer = new File("C:\\Users\\Dell\\OneDrive\\Documents\\Buteelt\\BD1\\answer.txt");
        Scanner sc , sa;
        try {
            sc = new Scanner(file);
            sa = new Scanner(answer);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        while (sc.hasNext()) {
            count++;
            String ss = sc.nextLine();
            System.out.println("Question: "+ss);
            ans = in.nextLine();
            String answ = sa.nextLine();
            if(Objects.equals(ans, answ))
            {
                System.out.println("Correct");
                count1++;
            }
            else
            {
                System.out.println("Incorrect, Answer: "+answ);
            }
        }
        System.out.println("Point: "+count1+"/"+count);
    }

    public void useDirection() {
        Scanner in = new Scanner(System.in);
        int choice ;
        Start();
        choice = in.nextInt();
        in.nextLine();
        while (choice != 0) {
            switch (choice) {
                case 1 -> seeCards();
                case 2 -> testUguh();
                default -> System.out.println("zuv utga oruulna uu.");
            }
            Start();
            choice = in.nextInt();
            in.nextLine();
        }
    }
}
