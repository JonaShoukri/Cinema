package UI_StrategyPattern;

import BasicObjects_MediatorAndVisitorPattern.Cinema;
import BasicObjects_MediatorAndVisitorPattern.Console;
import BasicObjects_MediatorAndVisitorPattern.Hall;
import BasicObjects_MediatorAndVisitorPattern.User;

import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

public class ClientInterface implements IInterface{
    @Override
    public void execute(Cinema cinema) {
        int input;

        do{
            input = OperationsMenu();
            switch (input){
                case 1:
                    chooseByMovie(cinema);
                    break;
                case 2:
                    chosenByHall(cinema);
                    break;
                case 3:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid input. Please try again.");
                    break;
            }
        }while (input != 3);
    }
    public int OperationsMenu(){
        int input;
        do{
            Console.Clear();
            System.out.println("Choose an option:");
            System.out.println("1. Choose by movie");
            System.out.println("2. Choose by hall");
            System.out.println("3. Exit");
            Scanner scanner = new Scanner(System.in);
            input = scanner.nextInt();
        }while (input < 1 || input > 3);
        return input;
    }
    public void chooseByMovie(Cinema cinema){
        if (cinema.getMovies().isEmpty() || cinema.getViewings().isEmpty()){
            System.out.println("There are no movies or viewings available.");
            return;
        }

        int input1;
        do{
            Console.Clear();
            for (int i = 0; i < cinema.getMovies().size(); i++){
                System.out.println(i + 1 + ". " + cinema.getMovies().get(i).getName());
            }
            Scanner scanner = new Scanner(System.in);
            input1 = scanner.nextInt();
        }while (input1 < 1 || input1 > cinema.getMovies().size());


        boolean found = false;
        for (int i = 0; i < cinema.getViewings().size(); i++){
            if (cinema.getViewings().get(i).getMovie().equals(cinema.getMovies().get(input1 - 1))) {
                found = true;
                break;
            }
        }
        if (!found){
            System.out.println("There are no viewings for this movie.");
            return;
        }

        int input2;
        int counter;
        do {
            Console.Clear();
            System.out.println("Choose a viewing:");
            counter = 1;
            for (int i = 0; i < cinema.getViewings().size(); i++) {
                if (cinema.getViewings().get(i).getMovie().equals(cinema.getMovies().get(input1 - 1))) {
                    System.out.println(counter + ". " + cinema.getViewings().get(i).getShowtime().getStartTime() + " to "
                            + cinema.getViewings().get(i).getShowtime().getEndTime());
                    i++;
                }
            }
            Scanner scanner = new Scanner(System.in);
            input2 = scanner.nextInt();
        } while (input2 < 1 || input2 > counter);

        int recount = 1;
        for (int i = 0; i < cinema.getViewings().size(); i++) {
            if (cinema.getViewings().get(i).getMovie().equals(cinema.getMovies().get(input1 - 1))) {
                if (recount == counter) {
                    System.out.println("You have chosen the viewing: " + cinema.getViewings().get(i).getMovie().getName()
                            + " @ " + cinema.getViewings().get(i).getShowtime().getStartTime() + " to "
                            + cinema.getViewings().get(i).getShowtime().getEndTime());

                    int count = 1;
                    for(int j = 0; j < cinema.getReservations().size(); j++){
                        if (cinema.getReservations().get(j).equals(cinema.getViewings().get(i))){
                            count++;
                        }
                    }

                    if (count > cinema.getViewings().get(i).getHall().getCapacity()){
                        System.out.println("This viewing is full.");
                        return;
                    }
                    cinema.addReservation(cinema.getViewings().get(i));
                    break;
                }
                recount++;
            }
        }
    }
    public void chosenByHall(Cinema cinema){
        if (cinema.getHalls().isEmpty() || cinema.getViewings().isEmpty()){
            System.out.println("There are no Hall or Viewing.");
            return;
        }

        int input1;
        do {
            Console.Clear();
            int i = 1;
            for (Map.Entry<Integer, Hall> entry : cinema.getHalls().entrySet()) {
                System.out.println(i + ". " + entry.getValue().getCapacity());
                i++;
            }
            Scanner scanner = new Scanner(System.in);
            input1 = scanner.nextInt();
        } while (input1 < 1 || input1 > cinema.getHalls().size());

        boolean found = false;
        for (int i = 0; i < cinema.getViewings().size(); i++) {
            if (cinema.getViewings().get(i).getHall().equals(cinema.getHalls().get(input1 - 1))) {
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("There are no viewings for this hall.");
            return;
        }

        int input2;
        int counter;
        do {
            Console.Clear();
            System.out.println("Choose a viewing:");
            counter = 1;
            for (int i = 0; i < cinema.getViewings().size(); i++) {
                if (cinema.getViewings().get(i).getHall().equals(cinema.getHalls().get(input1 - 1))) {
                    System.out.println(counter + ". " + cinema.getViewings().get(i).getShowtime().getStartTime() + " to "
                            + cinema.getViewings().get(i).getShowtime().getEndTime());
                    i++;
                }
            }
            Scanner scanner = new Scanner(System.in);
            input2 = scanner.nextInt();
        } while (input2 < 1 || input2 > counter);

        int recount = 1;
        for (int i = 0; i < cinema.getViewings().size(); i++) {
            if (cinema.getViewings().get(i).getHall().equals(cinema.getHalls().get(input1 - 1))) {
                if (recount == counter) {
                    System.out.println("You have chosen the viewing: " + cinema.getViewings().get(i).getMovie().getName()
                            + " @ " + cinema.getViewings().get(i).getShowtime().getStartTime() + " to "
                            + cinema.getViewings().get(i).getShowtime().getEndTime());

                    int count = 1;
                    for (int j = 0; j < cinema.getReservations().size(); j++) {
                        if (cinema.getReservations().get(j).equals(cinema.getViewings().get(i))) {
                            count++;
                        }
                    }

                    if (count > cinema.getViewings().get(i).getHall().getCapacity()) {
                        System.out.println("This viewing is full.");
                        return;
                    }
                    cinema.addReservation(cinema.getViewings().get(i));
                    break;
                }
                recount++;
            }
        }
    }
}
