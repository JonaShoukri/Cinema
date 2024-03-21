package Objects;

public class Ticket {
    private static int i = 0;
    private int ID;
    private Customer customer;
    private ShowTimes showTime;

    public Ticket(Customer customer, ShowTimes showTime) {
        this.customer = customer;
        this.showTime = showTime;
        i++;
        this.ID = i;
    }
}
