package CompareShowtimes_ChainOfResponsibility;

import BasicObjects.ShowTime;

public class IsBefore implements ICompareShowtimes{
    private ICompareShowtimes next;

    @Override
    public void setNext(ICompareShowtimes next) {
        this.next = next;
    }

    @Override
    public String compareTo(ShowTime showTimeMain, ShowTime showTime) {
        if (showTimeMain.getStartTime().isBefore(showTime.getStartTime()) && showTimeMain.getEndTime().isBefore(showTime.getStartTime())){
            return "is before";
        }
        else {
            return next.compareTo(showTimeMain, showTime);
        }
    }
}
