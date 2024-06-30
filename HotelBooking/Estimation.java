package HotelBooking;
import java.util.Scanner;

public class Estimation {
    void cost() {
        Scanner ss = new Scanner(System.in);
        int price = 2000;
        int room;
        int day;
        System.out.println("Enter the number of rooms you want to book");
        room = ss.nextInt();
        System.out.println("Enter the number of days you want to stay for");
        day = ss.nextInt();
        int cost = price * day * room;
        System.out.println("It will cost you " + cost + " to book " + room + " rooms for " + day + " days");

        ss.close();
    }
}

