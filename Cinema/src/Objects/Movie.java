package Objects;

import java.util.LinkedList;

public class Movie {
    private String title;
    private String director;
    private int releaseYear;
    private String description;
    private String genre;
    private LinkedList<Integer> ratings;
    private ShowTimes[] showTimes; // This is the second ARRAY you have asked for in the documentation

    public Movie() {
        this.ratings = new LinkedList<>();
        this.showTimes = new ShowTimes[7];
    }

    public String getTitle() {
        return this.title;
    }
    public String getDirector() {
        return this.director;
    }
    public int getReleaseYear() {
        return this.releaseYear;
    }
    public String getDescription() {
        return this.description;
    }
    public String getGenre() {
        return this.genre;
    }
    public LinkedList<Integer> getRating() {
        return this.ratings;
    }
    public int getAmountOfRatings() {
        return this.ratings.size();
    }
    public int getAverageRating() {
        int sum = 0;
        for (int rating : this.ratings) {
            sum += rating;
        }
        return sum / this.ratings.size();
    }
    public ShowTimes[] getShowTimes() {
        return this.showTimes;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setDirector(String director) {
        this.director = director;
    }
    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public void addRating(int rating) {
        if (rating < 1 || rating > 5) {
            System.out.println("Rating must be between 1 and 5");
            return;
        }
        this.ratings.add(rating);
    }

    public void addShowTime(ShowTimes showTime) {
        for (Movie movie : showTime.getHall().getMovies()) {
            for (ShowTimes time : movie.getShowTimes()) {
                if (time.overlaps(showTime)) {
                    System.out.println("This show time is already taken by " + movie.getTitle() + " in hall " + time.getHall().getNumber() + " at " + time.getStartTime() + " to " + time.getEndTime());
                    return;
                }
            }
        }

        for (int i = 0; i < this.showTimes.length; i++) {
            if (this.showTimes[i] == null) {
                this.showTimes[i] = showTime;
                return;
            }
        }
        System.out.println("This movie is already showing 7 times.");
    }
}
