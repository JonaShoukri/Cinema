package BasicObjects;

import BasicObjects.ICinema;

public class Movie {
    private String name;
    private String director;
    private int releaseYear;
    private String description;
    private String genre;
    private ICinema cinema;

    Movie(ICinema cinema, String name, String director, int releaseYear, String description, String genre){
        this.name = name;
        this.director = director;
        this.releaseYear = releaseYear;
        this.description = description;
        this.genre = genre;
        this.cinema = cinema;
    }

    String getName(){
        return this.name;
    }
    String getDDirector(){
        return this.director;
    }
    int getReleaseYear(){
        return this.releaseYear;
    }
    String getDescription(){
        return this.description;
    }
    String getGenre(){
        return this.genre;
    }
    ICinema getCinema(){
        return this.cinema;
    }
}
