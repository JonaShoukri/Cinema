package BasicObjects_MediatorAndVisitorPattern;

public class Movie {
    private String name;
    private String director;
    private String description;
    private String genre;
    private Cinema cinema;

    Movie(Cinema cinema, String name, String director, String description, String genre){
        this.name = name;
        this.director = director;
        this.description = description;
        this.genre = genre;
        this.cinema = cinema;
        this.cinema.addMovie(this);
    }

    public String getName(){
        return this.name;
    }
    String getDDirector(){
        return this.director;
    }
    String getDescription(){
        return this.description;
    }
    String getGenre(){
        return this.genre;
    }
    Cinema getCinema(){
        return this.cinema;
    }
}
