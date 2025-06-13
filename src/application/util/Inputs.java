package application.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

//provides various input-handling methods
public class Inputs {
    private static final Scanner scanner = new Scanner(System.in);

    //prompts the user to choose between console and file input and returns the corresponding text
    public static String getInput() {
        System.out.println("Choose input method: ");
        System.out.println("1 - Console input");
        System.out.println("2 - File input");
        System.out.print("Enter your choice: ");
        String choice = scanner.next();
        scanner.nextLine();

        if (choice.equals("1")) {
            System.out.print("\nEnter text: ");
            return scanner.nextLine();
        } else if (choice.equals("2")) {
            System.out.print("Enter file path: ");
            String path = scanner.nextLine();
            try {
                return readFile(path);
            } catch (Exception e) {
                System.out.println("Error reading file: " + e.getMessage());
                System.exit(1);
            }
        }

        System.out.println("\nInvalid choice! Please try again.");
        return getInput();
    }

    //reads a numeric Caesar cipher shift value with validation
    public static int getShiftValue() {
        System.out.print("Enter shift value: ");
        String shift = scanner.nextLine();
        if (shift.isEmpty()) {
            return 0;
        } else {
            try {
                return Integer.parseInt(shift);
            } catch (NumberFormatException e) {
                System.out.println("\nPlease enter valid shift value (number).");
                return getShiftValue();
            }
        }
    }

    //prompts the user to enter an arithmetic expression
    public static String getExpressionInput() {
        System.out.print("Enter arithmetic expression: ");
        scanner.nextLine();
        return scanner.nextLine();
    }

    //Asks the user if they want to continue and returns a boolean
    public static boolean askToContinue() {
        System.out.print("Continue? (y/n): ");
        String response = scanner.next();
        if (response.equalsIgnoreCase("y")) {
            return true;
        } else if (response.equalsIgnoreCase("n")) {
            return false;
        } else {
            System.out.println("\nPlease enter 'y' to continue and 'n' to exit");
            return askToContinue();
        }
    }

    //reads and returns a numeric menu option from the user
    public static int getUserChoice() {
        try {
            return scanner.nextInt();
        } catch (Exception e) {
            scanner.nextLine();
            return -1;
        }
    }

    //reads and returns the contents of a file from the specified path
    public static String readFile(String filePath) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        }
        return content.toString().trim();
    }

    //closes the shared Scanner resource
    public static void closeScanner() {
        scanner.close();
    }
}
