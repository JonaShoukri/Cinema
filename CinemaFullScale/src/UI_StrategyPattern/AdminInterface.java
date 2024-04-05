package UI_StrategyPattern;

import BasicObjects_MediatorAndVisitorPattern.Cinema;
import BasicObjects_MediatorAndVisitorPattern.Console;
import BasicObjects_MediatorAndVisitorPattern.Hall;

import java.util.Map;
import java.util.Scanner;

public class AdminInterface implements IInterface{
    @Override
    public void execute(Cinema cinema) {
        int input;

        do {
            input = OperationsMenu();

            switch (input){
                case 1:
                    addMovie(cinema);
                    break;
                case 2:
                    removeMovie(cinema);
                    break;
                case 3:
                    addHall(cinema);
                    break;
                case 4:
                    removeHall(cinema);
                    break;
                case 5:
                    addShowtime(cinema);
                    break;
                case 6:
                    removeShowtime(cinema);
                    break;
                case 7:
                    addViewing(cinema);
                    break;
                case 8:
                    removeViewing(cinema);
                    break;
                default:
                    System.out.println("Invalid input. Please try again.");
                    break;
            }
        }while (input != 9);
    }
    public int OperationsMenu(){
        int input;
        Scanner scanner = new Scanner(System.in);
        do{
            Console.Clear();
            System.out.println("1. Add movie");
            System.out.println("2. Remove movie");
            System.out.println("3. Add a hall");
            System.out.println("4. Remove a hall");
            System.out.println("5. Add a showtime");
            System.out.println("6. Remove a showtime");
            System.out.println("7. Add a viewing");
            System.out.println("8. Remove a viewing");
            System.out.println("9. Quit");
            input = scanner.nextInt();
        }while(input != 1 && input != 2 && input != 3 && input != 4 && input != 5 && input != 6 && input != 7 && input != 8 && input != 9);
        return input;
    }
    public void addMovie(Cinema cinema){
        cinema.createMovie();
    }
    public void removeMovie(Cinema cinema){
        int movieIndex;

        if (cinema.getMovies().size() == 0) {
            System.out.println("There are no movies to remove.");
            return;
        }
        do{
            // Display all movies
            Console.Clear();
            for (int i = 0; i < cinema.getMovies().size(); i++) {
                System.out.println((i + 1) + ". " + cinema.getMovies().get(i).getName());
            }

            // Ask user to select a movie
            System.out.println("Enter the number of the movie you want to remove:");
            Scanner scanner = new Scanner(System.in);
            movieIndex = scanner.nextInt() - 1;
        } while (movieIndex < 0 && movieIndex > cinema.getMovies().size() -1);


        // Check if the index is valid
        if (movieIndex >= 0 && movieIndex < cinema.getMovies().size()) {
            // Remove the selected movie
            cinema.removeMovie(cinema.getMovies().get(movieIndex));
            System.out.println("Movie removed successfully.");
        } else {
            System.out.println("Invalid movie number. Please try again.");
        }
    }
    public void addHall(Cinema cinema){
        cinema.createHall();
    }
    public void removeHall(Cinema cinema) {
        Integer hallKey;

        if (cinema.getHalls().isEmpty()) {
            System.out.println("There are no halls to remove.");
            return;
        }
        do {
            // Display all halls
            Console.Clear();

            for (Map.Entry<Integer, Hall> entry : cinema.getHalls().entrySet()) {
                System.out.println(entry.getKey() + ". " + entry.getValue().getCapacity() + " seats");
            }

            // Ask user to select a hall
            System.out.println("Enter the number of the hall you want to remove:");
            Scanner scanner = new Scanner(System.in);
            hallKey = scanner.nextInt();
        } while (!cinema.getHalls().containsKey(hallKey));

        // Check if the key is valid
        if (cinema.getHalls().containsKey(hallKey)) {
            // Remove the selected hall
            cinema.removeHall(hallKey);
            System.out.println("Hall removed successfully.");
        } else {
            System.out.println("Invalid hall key. Please try again.");
        }
    }
    public void addShowtime(Cinema cinema){
        cinema.createShowtime();
    }
    public void removeShowtime(Cinema cinema){
        int showtimeIndex;

        if (cinema.getShowtimes().length == 0) {
            System.out.println("There are no showtimes to remove.");
            return;
        }
        do {
            // Display all showtimes
            Console.Clear();

            for (int i = 0; i < cinema.getShowtimes().length; i++) {
                System.out.println((i + 1) + ".  From " + cinema.getShowtimes()[i].getStartTime() + " to " + cinema.getShowtimes()[i].getEndTime());
            }

            // Ask user to select a showtime
            System.out.println("Enter the number of the showtime you want to remove:");
            Scanner scanner = new Scanner(System.in);
            showtimeIndex = scanner.nextInt() - 1;
        } while (showtimeIndex < 0 && showtimeIndex > cinema.getShowtimes().length -1);

        // Check if the index is valid
        if (showtimeIndex >= 0 && showtimeIndex < cinema.getShowtimes().length) {
            // Remove the selected showtime
            cinema.removeShowtime(cinema.getShowtimes()[showtimeIndex]);
        } else {
            System.out.println("Invalid showtime number. Please try again.");
        }
    }
    public void addViewing(Cinema cinema){
        if (cinema.getShowtimes().length == 0) {
            System.out.println("There are no showtimes to add a viewing to.");
            return;
        }
        else if (cinema.getHalls().isEmpty()) {
            System.out.println("There are no halls to add a viewing to.");
            return;
        } else if (cinema.getMovies().isEmpty()) {
            System.out.println("There are no movies to add a viewing to.");
            return;
        }

        String input1;
        String input2;
        int input3;

        do {
            Console.Clear();
            for (int i = 0; i < cinema.getMovies().size(); i++) {
                System.out.println((i + 1) + ". " + cinema.getMovies().get(i).getName());
            }
            System.out.println("Enter the name of the movie you want to add a viewing to:");
            Scanner scanner = new Scanner(System.in);
            input1 = scanner.nextLine();
        } while (Integer.parseInt(input1) < 0 || Integer.parseInt(input1) > cinema.getMovies().size());

        do {
            Console.Clear();
            for (Map.Entry<Integer, Hall> entry : cinema.getHalls().entrySet()) {
                System.out.println(entry.getKey() + ". " + entry.getValue().getCapacity() + " seats");
            }
            System.out.println("Enter the number of the hall you want to add a viewing to:");
            Scanner scanner = new Scanner(System.in);
            input2 = scanner.nextLine();
        } while (!cinema.getHalls().containsKey(Integer.parseInt(input2)));


        do {
            Console.Clear();
            for (int i = 0; i < cinema.getShowtimes().length; i++) {
                System.out.println((i + 1) + ".  From " + cinema.getShowtimes()[i].getStartTime() + " to " + cinema.getShowtimes()[i].getEndTime());
            }
            System.out.println("Enter the number of the showtime you want to add a viewing to:");
            Scanner scanner = new Scanner(System.in);
            input3 = scanner.nextInt() -1;
        } while (input3 < 0 || input3 >= cinema.getShowtimes().length); // Changed the condition here

        //cinema.addViewing(cinema.getMovies().get(Integer.parseInt(input1)), cinema.getHalls().get(Integer.parseInt(input2)), cinema.getShowtimes()[input3]);
        cinema.addViewing(cinema.getMovies().get(Integer.parseInt(input1) - 1), cinema.getHalls().get(Integer.parseInt(input2)), cinema.getShowtimes()[input3]);
    }
    public void removeViewing(Cinema cinema){
        int viewingIndex;

        if (cinema.getViewings().isEmpty()) {
            System.out.println("There are no viewings to remove.");
            return;
        }
        do {
            // Display all viewings
            Console.Clear();

            for (int i = 0; i < cinema.getViewings().size(); i++) {
                System.out.println((i + 1) + ". " + cinema.getViewings().get(i).getMovie().getName() + " in hall of "
                        + cinema.getViewings().get(i).getHall().getCapacity() + " seats at "
                        + cinema.getViewings().get(i).getShowtime().getStartTime() + " to "
                        + cinema.getViewings().get(i).getShowtime().getEndTime());
            }

            // Ask user to select a viewing
            System.out.println("Enter the number of the viewing you want to remove:");
            Scanner scanner = new Scanner(System.in);
            viewingIndex = scanner.nextInt() - 1;
        } while (viewingIndex < 0 || viewingIndex > cinema.getViewings().size() -1);

        // Check if the index is valid
        if (viewingIndex <= cinema.getViewings().size() -1) {
            // Remove the selected viewing
            cinema.removeViewing(cinema.getViewings().get(viewingIndex));
            System.out.println("Viewing removed successfully.");
        } else {
            System.out.println("Invalid viewing number. Please try again.");
        }
    }
}
