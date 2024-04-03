package CompareShowtimes_ChainOfResponsibility;

import BasicObjects.ShowTime;

public class IsDuring implements ICompareShowtimes{
    private ICompareShowtimes next;

    @Override
    public void setNext(ICompareShowtimes next) {
        this.next = next;
    }

    @Override
    public String compareTo(ShowTime showTimeMain, ShowTime showTime) {
        if ((showTimeMain.getStartTime().isEqual(showTime.getStartTime()) || showTimeMain.getStartTime().isAfter(showTime.getStartTime())) && (showTimeMain.getStartTime().isEqual(showTime.getEndTime()) || showTimeMain.getStartTime().isBefore(showTime.getEndTime()))){}
        else if ((showTimeMain.getEndTime().isEqual(showTime.getEndTime()) || showTimeMain.getEndTime().isBefore(showTime.getEndTime())) && (showTimeMain.getEndTime().isEqual(showTime.getStartTime()) || showTimeMain.getEndTime().isAfter(showTime.getStartTime()))){}
        else if ((showTimeMain.getStartTime().isEqual(showTime.getStartTime()) || showTimeMain.getStartTime().isAfter(showTime.getStartTime())) && (showTimeMain.getEndTime().isEqual(showTime.getEndTime()) || showTimeMain.getEndTime().isBefore(showTime.getEndTime()))){}
        else if ((showTimeMain.getStartTime().isBefore(showTime.getStartTime())) && (showTimeMain.getEndTime().isAfter(showTime.getEndTime()))){}
        else if ((showTimeMain.getStartTime().isAfter(showTime.getStartTime())) && (showTimeMain.getEndTime().isBefore(showTime.getEndTime()))){}
        else { next.compareTo(showTimeMain, showTime); }

        return "overlapping";
    }
}
