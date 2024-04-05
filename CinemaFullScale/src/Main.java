import BasicObjects_MediatorAndVisitorPattern.*;
import UI_StrategyPattern.IInterface;

public class Main {
    public static void main(String[] args) {
        Cinema cinema = new Cinema();
        while (true){
            User user = new User();
            cinema.accept(user);
        }
    }
}