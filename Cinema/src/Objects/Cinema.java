package Objects;

import java.util.ArrayList;
import java.util.LinkedList;

public class Cinema {
    private LinkedList<Movie> movies; // This is the first LINKEDLIST you have asked for in the documentation
    private ArrayList<Hall> halls;
    private LinkedList<Ticket> reservations; // This is the third LINKEDLIST you have asked for in the documentation
    private static final Cinema instance = new Cinema();

    private Cinema() {
        this.movies = new LinkedList<>();
        this.halls = new ArrayList<>();
        this.reservations = new LinkedList<>();
    }

    public LinkedList<Movie> getMovies() {
        return this.movies;
    }
    public void addMovie(Movie movie){
        this.movies.add(movie);
    }
    public void removeMovie(Movie movie) {

        this.movies.remove(movie);
    }
    public ArrayList<Hall> getHalls() {
        return this.halls;
    }
    public void addHall(Hall hall) {
        this.halls.add(hall);
    }
    public LinkedList<Ticket> getReservations() {
           return this.reservations;
    }
    public void addReservation(Ticket ticket) {
        this.reservations.add(ticket);
    }
    public void removeReservation(Ticket ticket) {
        this.reservations.remove(ticket);
    }
    public static Cinema getInstance() {
        return instance;
    }
}
