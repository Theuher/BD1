import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Manage implements App {
    

    public Manage() {
    }

    @Override
    public void Start() {
        System.out.println("1.Card nemeh\n2.Card harah\n3.Card ustgah\n0.Exit");
    }

    @Override
    public void getCaption() {
        System.out.println("Manage: Cardaa nemj,hasaj,harj bolno ");
    }

    public void seeCards() {
        Card cr = new Card();
        cr.seeCard();
    }

    public void writeCards()
            throws IOException {
        Scanner in = new Scanner(System.in);
        String str;
        str = in.nextLine();
        in.nextLine();
        try {
            FileWriter fileWriter = new FileWriter("C:\\Users\\Dell\\OneDrive\\Documents\\Buteelt\\BD1\\card.txt",
                    true);

            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println(str);
            printWriter.close();

            System.out.println("Success.");
        } catch (InputMismatchException e) {
            System.out.println("Input Error");
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    public void deleteTextFromFile(String CardsToDelete) {
        try {
            String filePath = "C:\\Users\\Dell\\OneDrive\\Documents\\Buteelt\\BD1\\card.txt";
            File file = new File(filePath);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.contains(CardsToDelete)) {
                    stringBuilder.append(line);
                    stringBuilder.append(System.lineSeparator());
                }
            }
            reader.close();
            FileWriter writer = new FileWriter(filePath);
            writer.write(stringBuilder.toString());
            writer.close();

            System.out.println("Card '" + CardsToDelete + "' deleted successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    public void useDirection() {
        Scanner in = new Scanner(System.in);
        int choice;
        Start();
        choice = in.nextInt();
        in.nextLine();
        while (choice != 0) {
            switch (choice) {
                case 1 -> {
                    System.out.println("Nemeh kartaa oruulna uu.(Hello/sainuu):");
                    try {
                        writeCards();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                case 2 -> seeCards();
                case 3 -> {
                    String card;
                    System.out.println("Ustgah cardaa bichne uu:(Hello/sainu):\n");
                    card = in.nextLine();
                    in.nextLine();
                    deleteTextFromFile(card);
                }
                default -> System.out.println("zuv utga oruulna uu.");
            }
            Start();
            choice = in.nextInt();
            in.nextLine();
        }
    }

}
