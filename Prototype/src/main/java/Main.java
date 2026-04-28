import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Recommendation> savedLists = new ArrayList<>();
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        Recommendation fantasy = new Recommendation("Fantasy People");
        fantasy.addBook(new Book("The Hobbit", "J.R.R. Tolkien"));
        fantasy.addBook(new Book("Harry Potter", "J.K. Rowling"));
        savedLists.add(fantasy);

        System.out.println("Book Recommendations");

        while (true) {
            System.out.println("  - Type \"1\" to see all recommendation lists");
            System.out.println("  - Type \"2\" to copy an existing list and change it");
            System.out.println("  - Type \"3\" to exit");
            System.out.print("> ");
            String command = input.nextLine().trim().toLowerCase();

            switch (command) {
                case "1":
                    showAllLists();
                    break;
                case "2":
                    copyAndCustomizeList();
                    break;
                case "3":
                    System.out.println("End");
                    return;
                default:
                    System.out.println("try 1,2,3");
            }
        }
    }

    private static void showAllLists() {
        if (savedLists.isEmpty()) {
            System.out.println("No recommendation lists. Create one by copying!");
            return;
        }
        System.out.println("\n--- Recommendation Lists ---");
        for (int i = 0; i < savedLists.size(); i++) {
            System.out.println("\n List #" + (i + 1));
            savedLists.get(i).print();
            System.out.println("");

        }
    }

    private static void copyAndCustomizeList() {
        if (savedLists.isEmpty()) {
            System.out.println("No lists to copy. Add one first.");
            return;
        }

        showAllLists();
        System.out.print("\nWhich list number you want to copy? ");
        int number = Integer.parseInt(input.nextLine());

        if (number < 1 || number > savedLists.size()) {
            System.out.println("That list number doesn't exist.");
            return;
        }

        Recommendation original = savedLists.get(number - 1);
        Recommendation copy = original.clone();

        System.out.println("\nCopied \"" + original.getTargetAudience() + "\" list.");
        System.out.print("What name for audience? ");
        String newAudience = input.nextLine().trim();
        if (!newAudience.isEmpty()) {
            copy.setTargetAudience(newAudience);
        }

        System.out.print("Add a book? (yes/no): ");
        String answer = input.nextLine().trim().toLowerCase();

        if (answer.equals("yes") ) {
            System.out.print("Book title: ");
            String title = input.nextLine().trim();
            System.out.print("Author: ");
            String author = input.nextLine().trim();
            copy.addBook(new Book(title, author));
            System.out.println("Added \"" + title + "\" to the list.");
        }

        savedLists.add(copy);
        System.out.println("\nrecommendation list saved!");
        System.out.println("New:");
        copy.print();
        System.out.println("");

    }
}