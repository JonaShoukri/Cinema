package CompareShowtimes_ChainOfResponsibility;

import BasicObjects.ShowTime;

public interface ICompareShowtimes {
    ICompareShowtimes next = null;
    void setNext(ICompareShowtimes next);
    String compareTo(ShowTime showTimeMain, ShowTime showTime);
}
