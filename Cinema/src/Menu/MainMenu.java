package Menu;

import Objects.Console;

public class MainMenu {
    public static void run() {
        Console.Clear();
        System.out.println("\t\tHello, would you like to sign in as a customer or an admin? (c/a): ");
        String input = new java.util.Scanner(System.in).nextLine();

        if (input.equals("c")) {
            new CustomerMenu().run();
        } else if (input.equals("a")) {
            new AdminMenu().run();
        } else {
            System.out.println("Invalid input");
        }

        try {
            Thread.sleep(2000); // Pause for 2 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
