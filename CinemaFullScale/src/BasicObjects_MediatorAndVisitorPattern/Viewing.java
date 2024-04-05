package BasicObjects_MediatorAndVisitorPattern;

// in order to stay loyal to the mediator pattern and keep the cinema interface as mediator and intermediary between
// movie, hall and showtimes we have created this class to manage instances of viewings which are comoposed of all three.
public class Viewing {
    private Movie movie;
    private ShowTime showTime;
    private Hall hall;

    Viewing(Movie movie, ShowTime showTime, Hall hall){
        this.movie = movie;
        this.showTime = showTime;
        this.hall = hall;
    }

    public Movie getMovie(){
        return this.movie;
    }
    public ShowTime getShowtime(){
        return this.showTime;
    }
    public Hall getHall(){
        return this.hall;
    }
}
