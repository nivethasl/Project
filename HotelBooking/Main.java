package HotelBooking;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while (true) {
            System.out.println("Welcome to Hotel Management System");
            System.out.println(
                    "What are you looking for? \n1)Book Rooms\n2)Check In\n3)Check Out\n4)Get An Estimate for your stay\n5)Check availability of rooms");

            int choice;

            Scanner in = new Scanner(System.in);
            System.out.println("Enter your choice");
            choice = in.nextInt();
            switch (choice) {
                case 1:
                    Booking reserve = new Booking();
                    reserve.book();
                    break;
                case 2:
                    Report enter = new Report();
                    enter.checkin();
                    break;
                case 3:
                    Report exit = new Report();
                    exit.checkout();
                    break;
                case 4:
                    Estimation expense = new Estimation();
                    expense.cost();
                    break;
                case 5:
                    Vacancy left = new Vacancy();
                    left.remainingrooms();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }

            System.out.println("Are you willing continue: y/n?");
            char ch = in.next().charAt(0);
            if(ch == 'n'){
                System.out.println("Thank you for visiting...");
                break;
            }

        }
    }
}
