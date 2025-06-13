package application.util;

//provides methods to print decorative dividing lines around section titles in the console.
public class Design {

    //prints a line of < characters, the title in blue, and then a line of > characters
    public static void dividingLinesUpper(String title) {
        for (int i = 0; i < 50; i++) {
            System.out.print('<');
        }
        System.out.print("\u001B[34m " + title + " \u001B[0m");
        for (int i = 0; i < 50; i++) {
            System.out.print('>');
        }
        System.out.println();
    }

    //prints a symmetrical line of < and > characters below the title based on the title's length
    public static void dividingLinesLower(String title) {
        int letterCount = title.length();
        for (int i = 0; i < 50 + letterCount/2; i++) {
            System.out.print('<');
        }
        System.out.print("  ");
        for (int i = 0; i < 50 + letterCount/2; i++) {
            System.out.print('>');
        }
        System.out.println('\n');
    }
}
