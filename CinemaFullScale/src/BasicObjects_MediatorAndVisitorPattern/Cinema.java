package BasicObjects_MediatorAndVisitorPattern;

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
    private static LinkedList<Viewing> reservations;

    public Cinema(){
        this.movies = new LinkedList<>();
        this.halls = new HashMap<>();
        countShowTimes = 0;
        this.showtimes = new ShowTime[countShowTimes];
        this.hallNum = 0;
        this.viewings = new ArrayList<>();
        this.reservations = new LinkedList<>();
    }

    public LinkedList<Movie> getMovies(){
        return movies;
    }
    public void createMovie(){
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
    }
    void addMovie(Movie movie){
        if (!movies.contains(movie)) { movies.add(movie);}
        else { System.out.println("This movie already exists");}
    }
    public void removeMovie(Movie movie){
        if (movies.contains(movie)) { movies.remove(movie);}
        else { System.out.println("This movie does not exist");}
    }
    public HashMap<Integer, Hall> getHalls(){
        return halls;
    }
    public void createHall(){
        String capacity;
        do {
            Console.Clear();

            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter a capacity: ");
            capacity = scanner.next();
        } while (!isInteger(capacity));
        Hall hall = new Hall(Integer.parseInt(capacity), this);
    }
    void addHall(Hall hall){
        halls.put(hallNum, hall);
        hallNum++;
    }
    public void removeHall(int hallNum){
        if (halls.containsKey(hallNum)){
            halls.remove(hallNum);
        }else { System.out.println("There is no such Hall");}
    }
    ShowTime[] getShowtime(){
        return showtimes;
    }
    public void createShowtime(){
        Console.Clear();
        Scanner scanner = new Scanner(System.in);

        int year;
        do{
            System.out.println("Enter the start year:");
            year = scanner.nextInt();
        } while (year < 2024);

        int month;
        do {
            System.out.println("Enter the start month (1-12):");
            month = scanner.nextInt();
        } while (month < 1 || month > 12);

        int dayOfMonth;
        do {
            System.out.println("Enter the day of the month for the start date:");
            dayOfMonth = scanner.nextInt();
        } while (dayOfMonth < 1 || dayOfMonth > 31);


        int hour;
        do {
            System.out.println("Enter the hour for the start date(0-23):");
            hour = scanner.nextInt();
        } while (hour < 0 || hour > 23);

        int minute;
        do {
            System.out.println("Enter the minute for the start date(0-59):");
            minute = scanner.nextInt();
        } while (minute < 0 || minute > 59);

        // Create LocalDateTime object using user input
        LocalDateTime start = LocalDateTime.of(year, month, dayOfMonth, hour, minute);

        Console.Clear();

        int year2;
        do {
            System.out.println("Enter the end year:");
            year2 = scanner.nextInt();
        } while (year2 < 2024);

        int month2;
        do {
            System.out.println("Enter the end month (1-12):");
            month2 = scanner.nextInt();
        } while (month2 < 1 || month2 > 12);

        int dayOfMonth2;
        do {
            System.out.println("Enter the day of the month for the end date:");
            dayOfMonth2 = scanner.nextInt();
        } while (dayOfMonth2 < 1 || dayOfMonth2 > 31);

        int hour2;
        do {
            System.out.println("Enter the hour for the end date(0-23):");
            hour2 = scanner.nextInt();
        } while (hour2 < 0 || hour2 > 23);

        int minute2;
        do {
            System.out.println("Enter the minute for the end date(0-59):");
            minute2 = scanner.nextInt();
        } while (minute2 < 0 || minute2 > 59);

        // Create LocalDateTime object using user input
        LocalDateTime end = LocalDateTime.of(year2, month2, dayOfMonth2, hour2, minute2);

        if (start.isBefore(end)) { ShowTime showTime = new ShowTime(start, end, this);}
        else{ System.out.println("Start must appear before end.");}
    }
    void addShowtime(ShowTime showtime){
        ShowTime[] showTimes = new ShowTime[showtimes.length + 1];
        for (int i = 0; i < showtimes.length; i++) {
            showTimes[i] = showtimes[i];
        }
        showTimes[showtimes.length] = showtime; // Corrected line
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
    public ArrayList<Viewing> getViewings(){
        return viewings;
    }
    public void addViewing(Movie movie, Hall hall, ShowTime showTime){
        Viewing viewing = new Viewing(movie, showTime, hall);
        if (!viewings.contains(viewing)){
            viewings.add(viewing);
        }else {
            System.out.println("already exists");
        }
    }
    public void removeViewing(Viewing viewing){
        if (viewings.contains(viewing)){
            viewings.remove(viewing);
        }else {
            System.out.println("Doesn't exist in viewings exists");
        }
    }
    public void accept(User user){
        user.visit(this);
    }
    public boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public ShowTime[] getShowtimes() {
        return showtimes;
    }
    public LinkedList<Viewing> getReservations() {
        return reservations;
    }
    public void addReservation(Viewing viewing) {
        reservations.add(viewing);
    }

}
