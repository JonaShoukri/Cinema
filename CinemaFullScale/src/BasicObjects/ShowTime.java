package BasicObjects;

import java.time.LocalDateTime;
import CompareShowtimes_ChainOfResponsibility.*;

public class ShowTime {
    private ICinema cinema;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public ShowTime( LocalDateTime startTime, LocalDateTime endTime){
        this.startTime = startTime;
        this.endTime = endTime;
    }

    ICinema getCinema(){
        return this.cinema;
    }
    public LocalDateTime getStartTime(){
        return this.startTime;
    }
    public LocalDateTime getEndTime(){
        return this.endTime;
    }
    void setStartTime(LocalDateTime startTime){
        this.startTime = startTime;
    }
    void setEndTime(LocalDateTime endTime){
        this.endTime = endTime;
    }

    public String compareTo(ShowTime showTime){
        // delegates the comparison to the chain of responsibility
        ICompareShowtimes isAfter = new IsAfter();
        ICompareShowtimes isBefore = new IsBefore();
        ICompareShowtimes isDuring = new IsDuring();

        isDuring.setNext(isBefore);
        isBefore.setNext(isAfter);

        return isDuring.compareTo(this, showTime);
    }
}
