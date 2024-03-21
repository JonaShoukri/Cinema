package Objects;

import java.time.LocalDateTime;

public class ShowTimes {
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Hall hall;
    private int reservations;

    public ShowTimes(Hall hall) {
        this.hall = hall;
        this.reservations = 0;
    }

    public LocalDateTime getStartTime() {
        return this.startTime;
    }
    public LocalDateTime getEndTime() {
        return this.endTime;
    }
    public Hall getHall() {
        return this.hall;
    }
    public int getReservations() {
        return this.reservations;
    }
    public void setStartTime(LocalDateTime startTime) {
        for (Movie movie: hall.getMovies()) {
            for (ShowTimes showTime: movie.getShowTimes()) {
                if(startTime.isAfter(showTime.getStartTime()) || startTime.isEqual(showTime.getStartTime()) &&
                        (startTime.isBefore(showTime.getEndTime()) || startTime.isEqual(showTime.getEndTime()))) {
                    System.out.println("This show time is already taken by " + movie.getTitle() + " in hall "
                            + showTime.getHall().getNumber() + " at " + showTime.getStartTime() + " to "
                            + showTime.getEndTime());
                    return;
                }
            }
        }

        this.startTime = startTime;
    }
    public void setEndTime(LocalDateTime endTime) {
        for (Movie movie: hall.getMovies()) {
            for (ShowTimes showTime: movie.getShowTimes()) {
                if(endTime.isAfter(showTime.getStartTime()) || endTime.isEqual(showTime.getStartTime()) && (endTime.isBefore(showTime.getEndTime()) || endTime.isEqual(showTime.getEndTime()))) {
                    System.out.println("This show time is already taken by " + movie.getTitle() + " in hall " + showTime.getHall().getNumber() + " at " + showTime.getStartTime() + " to " + showTime.getEndTime());
                    return;
                }
            }
        }

        this.endTime = endTime;
    }
    public void setHall(Hall hall) {
        for (Movie movie: hall.getMovies()) {
            for (ShowTimes showTime: movie.getShowTimes()) {
                if(this.startTime.isAfter(showTime.getStartTime()) || this.startTime.isEqual(showTime.getStartTime()) && (this.startTime.isBefore(showTime.getEndTime()) || this.startTime.isEqual(showTime.getEndTime()))) {
                    System.out.println("This show time is already taken by " + movie.getTitle() + " in hall " + showTime.getHall().getNumber() + " at " + showTime.getStartTime() + " to " + showTime.getEndTime());
                    return;
                }
                if(this.endTime.isAfter(showTime.getStartTime()) || this.endTime.isEqual(showTime.getStartTime()) && (this.endTime.isBefore(showTime.getEndTime()) || this.endTime.isEqual(showTime.getEndTime()))) {
                    System.out.println("This show time is already taken by " + movie.getTitle() + " in hall " + showTime.getHall().getNumber() + " at " + showTime.getStartTime() + " to " + showTime.getEndTime());
                    return;
                }
            }
        }
        this.hall = hall;
    }
    public void addReservations() {
        this.reservations++;
    }
    public void removeReservations() {
        this.reservations--;
    }

    public boolean overlaps(ShowTimes showTime) {
        if ((this.startTime.isAfter(showTime.getStartTime())) || this.startTime.isEqual(showTime.getStartTime()) &&
                ((this.startTime.isBefore(showTime.getEndTime())) || this.startTime.isEqual(showTime.getEndTime()))) {
            return true;
        }
        else if ((this.endTime.isAfter(showTime.getStartTime())) || this.endTime.isEqual(showTime.getStartTime()) &&
                ((this.endTime.isBefore(showTime.getEndTime())) || this.endTime.isEqual(showTime.getEndTime()))) {
            return true;
        }
        return false;
    }
}
