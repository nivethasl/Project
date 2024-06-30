package HotelBooking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Vacancy {

    private static final int NumberOfRooms = 20; // Total number of rooms in the hotel
    int occupiedRooms ;

    public int remainingrooms() {
        try {
             Class.forName("com.mysql.cj.jdbc.Driver");
             String url = "jdbc:mysql://127.0.0.1:3306/hotel";
             String user = "root";
             String password = "Nivetha@2002";

             Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = con.prepareStatement("SELECT SUM(Rooms) AS totalRooms FROM hotel.customer WHERE StayStarted >= 0 ");

             ResultSet rs = pstmt.executeQuery();

                if (rs.next()) {
                    occupiedRooms = rs.getInt("totalRooms");
                }

             // Calculate remaining rooms
             int remainingRooms = NumberOfRooms - occupiedRooms;
             System.out.println("The available number of rooms are " + remainingRooms);

             return remainingRooms;

        } catch (Exception e) {
            System.out.println("Exception has occurred: " + e);
            return -1; // if an exception occurs it will return the -1
        }
    }
}
