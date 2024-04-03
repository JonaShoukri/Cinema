package BasicObjects;

public class Hall {
    private int capacity;
    private Cinema cinema;

    Hall(int capacity, Cinema cinema){
        this.capacity = capacity;
        this.cinema = cinema;
        cinema.addHall(this);
    }
    Cinema getCinema(){
        return this.cinema;
    }
    int getCapacity(){
        return this.capacity;
    }
}
