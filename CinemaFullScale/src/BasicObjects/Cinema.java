package BasicObjects;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Cinema {
    private static LinkedList<Movie> movies;
    private static HashMap<Integer, Hall> halls;
    private static ShowTime[] showtimes;
    private static int countShowTimes;
    private static int hallNum;
    private static ArrayList<Viewing> viewings;

    Cinema(){
        this.movies = new LinkedList<>();
        this.halls = new HashMap<>();
        countShowTimes = 0;
        this.showtimes = new ShowTime[countShowTimes];
        this.hallNum = 0;
        this.viewings = new ArrayList<>();
    }

    LinkedList<Movie> getMovies(){
        return movies;
    }
    void createMovie(){
        Console.Clear();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a movie name: ");
        String name = scanner.next();

        System.out.println("Enter a movie director: ");
        String director = scanner.next();

        System.out.println("Enter a movie description: ");
        String description = scanner.next();

        System.out.println("Enter a movie genre: ");
        String genre = scanner.next();

        Movie movie = new Movie(this, name, director, description, genre);

        if (!movies.contains(movie)) { movies.add(movie);}
        else {
            movies.remove(movie);
            System.out.println("This movie already exists");
        }
    }
    void addMovie(Movie movie){
        if (!movies.contains(movie)) { movies.add(movie);}
        else { System.out.println("This movie already exists");}
    }
    void removeMovie(Movie movie){
        if (movies.contains(movie)) { movies.remove(movie);}
        else { System.out.println("This movie does not exist");}
    }
    HashMap<Integer, Hall> getHalls(){
        return halls;
    }
    void createHall(){
        Console.Clear();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a capacity: ");
        int capacity = scanner.nextInt();

        Hall hall = new Hall(capacity, this);
    }
    void addHall(Hall hall){
        halls.put(hallNum, hall);
        hallNum++;
    }
    void removeHall(int hallNum){
        if (halls.containsKey(hallNum)){
            halls.remove(hallNum);
        }else { System.out.println("There is no such Hall");}
    }
    ShowTime[] getShowtime(){
        return showtimes;
    }
    void createShowtime(){
        Console.Clear();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the start year:");
        int year = scanner.nextInt();

        System.out.println("Enter the start month (1-12):");
        int month = scanner.nextInt();

        System.out.println("Enter the day of the month for the start date:");
        int dayOfMonth = scanner.nextInt();

        System.out.println("Enter the hour for the start date(0-23):");
        int hour = scanner.nextInt();

        System.out.println("Enter the minute for the start date(0-59):");
        int minute = scanner.nextInt();

        // Create LocalDateTime object using user input
        LocalDateTime start = LocalDateTime.of(year, month, dayOfMonth, hour, minute);

        Console.Clear();

        System.out.println("Enter the end year:");
        int year2 = scanner.nextInt();

        System.out.println("Enter the end month (1-12):");
        int month2 = scanner.nextInt();

        System.out.println("Enter the day of the month for the end date:");
        int dayOfMonth2 = scanner.nextInt();

        System.out.println("Enter the hour for the end date(0-23):");
        int hour2 = scanner.nextInt();

        System.out.println("Enter the minute for the end date(0-59):");
        int minute2 = scanner.nextInt();

        // Create LocalDateTime object using user input
        LocalDateTime end = LocalDateTime.of(year, month, dayOfMonth, hour, minute);

        if (start.isBefore(end)) { ShowTime showTime = new ShowTime(start, end, this);}
        else{ System.out.println("Start must appear before end.");}
    }
    void addShowtime(ShowTime showtime){
        ShowTime[] showTimes = new ShowTime[showtimes.length + 1];
        for (int i = 0; i < showtimes.length; i++) {
            showTimes[i] = showtimes[i];
        }
        showTimes[showtimes.length + 1] = showtime;
        showtimes = showTimes;
    }
    public void removeShowtime(ShowTime showtime) {
        // Check if the showtimes array is null or empty
        if (showtimes == null || showtimes.length == 0) {
            System.out.println("No showtimes available.");
            return;
        }

        // Find the index of the showtime to be removed
        int indexToRemove = -1;
        for (int i = 0; i < showtimes.length; i++) {
            if (showtimes[i].equals(showtime)) {
                indexToRemove = i;
                break;
            }
        }

        // If showtime is found, remove it
        if (indexToRemove != -1) {
            // Create a new array to hold the remaining showtimes
            ShowTime[] updatedShowtimes = new ShowTime[showtimes.length - 1];
            // Copy all elements except the one to be removed
            for (int i = 0, j = 0; i < showtimes.length; i++) {
                if (i != indexToRemove) {
                    updatedShowtimes[j++] = showtimes[i];
                }
            }
            // Update the showtimes array
            showtimes = updatedShowtimes;
            System.out.println("Showtime removed successfully.");
        } else {
            System.out.println("Showtime not found.");
        }
    }

    int getHallNum(){
        return hallNum;
    }
    ArrayList<Viewing> getViewings(){
        return viewings;
    }
    void addViewing(Viewing viewing){
        if (!viewings.contains(viewing)){
            viewings.add(viewing);
        }else {
            System.out.println("already exists");
        }
    }
    void removeViewing(Viewing viewing){
        if (viewings.contains(viewing)){
            viewings.remove(viewing);
        }else {
            System.out.println("Doesn't exist in viewings exists");
        }
    }

}
