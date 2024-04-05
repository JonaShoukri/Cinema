package BasicObjects_MediatorAndVisitorPattern;

import UI_StrategyPattern.AdminInterface;
import UI_StrategyPattern.ClientInterface;
import UI_StrategyPattern.IInterface;

import java.util.Scanner;

public class User {
    IInterface userInterface;

    public User() {
       setInterface();
    }

    void setInterface() {
        Scanner scanner = new Scanner(System.in);
        String input;
        do{
            Console.Clear();
            System.out.println("Would you like to sign in as admin or client?");
            input = scanner.nextLine();
            if (input.equalsIgnoreCase("admin")) {
                this.userInterface = new AdminInterface();
                return;
            } else if (input.equalsIgnoreCase("client")) {
                this.userInterface = new ClientInterface();
                return;
            }
        } while(true);
    }
    void visit(Cinema cinema){ // might delete later and redirect directly to execute() but for now to visualise both
        // patters better ill keep it.
        execute(cinema);
    }

    void execute(Cinema cinema){
        userInterface.execute(cinema);
    }
}
