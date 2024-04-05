package CompareShowtimes_ChainOfResponsibility;

import BasicObjects_MediatorAndVisitorPattern.ShowTime;

public class IsAfter implements ICompareShowtimes{
    private ICompareShowtimes next;

    @Override
    public void setNext(ICompareShowtimes next) {
        this.next = next;
    }

    @Override
    public String compareTo(ShowTime showTimeMain, ShowTime showTime) {
        return "is after";
    }
}
