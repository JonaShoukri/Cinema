package BasicObjects;

public class Hall {
    private int capacity;
    private ICinema cinema;

    Hall(int capacity, ICinema cinema){
        this.capacity = capacity;
        this.cinema = cinema;
    }
    ICinema getCinema(){
        return this.cinema;
    }
    int getCapacity(){
        return this.capacity;
    }
}
