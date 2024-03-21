package Menu;

import Objects.Console;

public class AdminMenu {
    public static void run() {
    }

    private static int addMovie() {
        Console.Clear();
        System.out.println("\t\tAdmin Menu");
        System.out.println("Which path would you like to follow: ");
        System.out.println("1. Add a movie");
        System.out.println("2. Remove a movie");
        System.out.println("3. Add a show time");
        System.out.println("4. Remove a show time");
        System.out.println("5. Add a hall");
        System.out.println("6. Remove a hall");
        System.out.println("7. Go back");
        return new java.util.Scanner(System.in).nextInt();

    }
}
