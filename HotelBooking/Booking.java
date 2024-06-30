package HotelBooking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Booking extends Vacancy {

    Scanner s = new Scanner(System.in);
    Vacancy j=new Vacancy();

    public void book() {

        int ab = j.remainingrooms();// it shows the available rooms

        String CsName;
        int Rooms;
        int Days;
        String CsMobileNo;

        System.out.println("Enter your name: ");
        CsName = s.nextLine();

        System.out.println("Enter your mobile number: ");
        CsMobileNo = s.nextLine();

        System.out.println("Enter the number of rooms you want to book: ");
        Rooms = s.nextInt();

        System.out.println("Enter the number of days you want to stay with us: ");
        Days = s.nextInt();

        if (Rooms <= ab) {
            try {
                // Load JDBC driver and establish connection
                Class.forName("com.mysql.cj.jdbc.Driver");
                String url = "jdbc:mysql://127.0.0.1:3306/hotel";
                String user = "root";
                String password = "Nivetha@2002";

                Connection con = DriverManager.getConnection(url, user, password);
                PreparedStatement pstmt = con.prepareStatement("INSERT INTO hotel.customer (CsName, Days, Rooms, CsMobileNo) VALUES (?, ?, ?, ?)");

                // Set values for prepared statement
                pstmt.setString(1, CsName);
                pstmt.setInt(2, Days);
                pstmt.setInt(3, Rooms);
                pstmt.setString(4, CsMobileNo);

                // Execute the update query
                int i = pstmt.executeUpdate();

                    if (i > 0) {
                        System.out.println("Record inserted");
                    } else {
                        System.out.println("Error");
                    }

            } catch (Exception e) {
                System.out.println("Exception has occurred: " + e);
            }


        } else {
            System.out.println("We only have " + ab + " rooms remaining.");
        }
    }
}

