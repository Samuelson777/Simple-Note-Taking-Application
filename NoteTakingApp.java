import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Note {
    String title;
    String content;

    Note(String title, String content) {
        this.title = title;
        this.content = content;
    }

    @Override
    public String toString() {
        return "Title: " + title + "\nContent: " + content;
    }
}

public class NoteTakingApp {
    private static final List<Note> notes = new ArrayList<>(); // Make notes final

    public static void main(String[] args) {
        // Using try-with-resources to ensure the scanner is closed properly
        try (Scanner scanner = new Scanner(System.in)) {
            int choice;

            do {
                System.out.println("\nNote-Taking Application Menu:");
                System.out.println("1. Add Note");
                System.out.println("2. View Notes");
                System.out.println("3. Update Note");
                System.out.println("4. Delete Note");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                // Using traditional switch statement
                switch (choice) {
                    case 1:
                        addNote(scanner);
                        break;
                    case 2:
                        viewNotes();
                        break;
                    case 3:
                        updateNote(scanner);
                        break;
                    case 4:
                        deleteNote(scanner);
                        break;
                    case 5:
                        System.out.println("Exiting the application. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } while (choice != 5);
        }
    }

    private static void addNote(Scanner scanner) {
        System.out.print("Enter note title: ");
        String title = scanner.nextLine();
        System.out.print("Enter note content: ");
        String content = scanner.nextLine();
        notes.add(new Note(title, content));
        System.out.println("Note added!");
    }

    private static void viewNotes() {
        System.out.println("Your Notes:");
        for (int i = 0; i < notes.size(); i++) {
            System.out.println((i + 1) + ". " + notes.get(i));
        }
    }

    private static void updateNote(Scanner scanner) {
        System.out.print("Enter note number to update: ");
        int updateIndex = scanner.nextInt() - 1;
        scanner.nextLine(); // Consume newline
        if (updateIndex >= 0 && updateIndex < notes.size()) {
            System.out.print("Enter new title: ");
            String newTitle = scanner.nextLine();
            System.out.print("Enter new content: ");
            String newContent = scanner.nextLine();
            notes.set(updateIndex, new Note(newTitle, newContent));
            System.out.println("Note updated!");
        } else {
            System.out.println("Invalid note number.");
        }
    }

    private static void deleteNote(Scanner scanner) {
        System.out.print("Enter note number to delete: ");
        int deleteIndex = scanner.nextInt() - 1;
        if (deleteIndex >= 0 && deleteIndex < notes.size()) {
            notes.remove(deleteIndex);
            System.out.println("Note deleted!");
        } else {
            System.out.println("Invalid note number.");
        }
    }
}