package Menu;
import Objects.*;

import java.util.Scanner;
public class CustomerMenu {

    public static void run() {
        int moviePick = getMoviePick();
        if (moviePick == -1) {
            return;
        }

    }

    private static int getMoviePick() {
        Console.Clear();
        System.out.println("\t\tSelect a movie");
        int i = 1;
        for (Movie movie : Cinema.getInstance().getMovies()){
            System.out.println(i + ". " + movie.getTitle());
        }
        if (Cinema.getInstance().getMovies().size() == 0) {
            System.out.println("No movies available");
            return -1;
        }

        int input = new Scanner(System.in).nextInt() - 1;
        if (input < 0 || input >= Cinema.getInstance().getMovies().size()) {
            System.out.println("Invalid input");
            return -1;
        }
        return input;
    }

    private static int getShowTimePick(int moviePick) {
        Console.Clear();
        System.out.println("\t\tSelect a show time");
        int i = 1;
        for (ShowTimes showTime : Cinema.getInstance().getMovies().get(moviePick).getShowTimes()){
            System.out.println(i + ". " + showTime.getStartTime());
        }

        int input = new Scanner(System.in).nextInt() - 1;
        if (input < 0 || input >= Cinema.getInstance().getMovies().get(moviePick).getShowTimes().length) {
            System.out.println("Invalid input");
            return -1;
        }
        return input;
    }
}
