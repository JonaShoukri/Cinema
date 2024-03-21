package Objects;

import java.util.ArrayList;

public class Hall {
    private static int i = 0;
    private int number;
    private int capacity;
    private ArrayList<Movie> movies;

    public Hall(int capacity) {
        this.capacity = capacity;
        i ++;
        this.number = i;
        this.movies = new ArrayList<>();
    }

    public int getNumber() {
        return this.number;
    }
    public int getCapacity() {
        return this.capacity;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public ArrayList<Movie> getMovies() {
        return this.movies;
    }

    public void addMovie(Movie movie) {
        if (!this.movies.contains(movie)) {
            for(Movie m: this.movies) {
                for(ShowTimes showTime: m.getShowTimes()) {
                    for(ShowTimes showTime1: movie.getShowTimes()) {
                        if(showTime1.overlaps(showTime)) {
                            System.out.println("This show time is already taken by " + m.getTitle() + " in this hall at " + showTime.getStartTime() + " to " + showTime.getEndTime());
                            return;
                        }
                    }
                }
            }
            this.movies.add(movie);
        }
        else {
            System.out.println("This movie is already in this hall");
        }
    }

    public void removeMovie(Movie movie) {
        this.movies.remove(movie);
    }
}
