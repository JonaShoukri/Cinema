import BasicObjects.*;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        LocalDateTime startTime = LocalDateTime.of(2021, 1, 1, 0, 0, 0);
        LocalDateTime endTime = LocalDateTime.of(2021, 1, 1, 1, 0, 0);
        ShowTime showTime1 = new ShowTime(startTime, endTime);
        ShowTime showTime2 = new ShowTime(startTime, endTime);

        System.out.println(showTime1.compareTo(showTime2));
    }
}