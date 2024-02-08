import java.io.*;
import java.util.Scanner;


class Card {
    public void seeCard() {
        System.out.println("\n");
        try {
            File file = new File("C:\\Users\\Dell\\OneDrive\\Documents\\Buteelt\\BD1\\card.txt");
            try (Scanner sc = new Scanner(file)) {
                while (sc.hasNext()) {
                    System.out.println(sc.nextLine());
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
            System.exit(1);
        }
        System.out.println("\n");
    }

    // flashcarduudaa asuult hariultaar ni salgaj filed oruulna
    public void readCards() throws IOException {
        FileOutputStream writer = new FileOutputStream("C:\\Users\\Dell\\OneDrive\\Documents\\Buteelt\\BD1\\answer.txt");
        writer.write(("").getBytes());
        writer.close();
        FileOutputStream writer1 = new FileOutputStream("C:\\Users\\Dell\\OneDrive\\Documents\\Buteelt\\BD1\\question.txt");
        writer1.write(("").getBytes());
        writer1.close();
        try {
            File file = new File("C:\\Users\\Dell\\OneDrive\\Documents\\Buteelt\\BD1\\card.txt");
            Scanner sc = new Scanner(file);
            while (sc.hasNext()) {
                String ss = sc.nextLine();
                String[] strArr = ss.split("/");
                FileWriter fileWriter = new FileWriter(
                        "C:\\Users\\Dell\\OneDrive\\Documents\\Buteelt\\BD1\\question.txt",
                        true);
                FileWriter fileWriter2 = new FileWriter(
                        "C:\\Users\\Dell\\OneDrive\\Documents\\Buteelt\\BD1\\answer.txt", true);

                PrintWriter printWriter = new PrintWriter(fileWriter);
                PrintWriter printWriter2 = new PrintWriter(fileWriter2);
                printWriter.println(strArr[0]);
                printWriter2.println(strArr[1]);
                printWriter.close();
                printWriter2.close();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
            // System.exit(1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
//
//    public void readQuestion() {
//        System.out.println("\n");
//        File file = new File("C:\\Users\\Dell\\OneDrive\\Documents\\Buteelt\\BD1\\question.txt");
//        Scanner sc;
//        try {
//            sc = new Scanner(file);
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//        while (sc.hasNext()) {
//            String ss = sc.nextLine();
//            System.out.println(ss);
//        }
//    }
}