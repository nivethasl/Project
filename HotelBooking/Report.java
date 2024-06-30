package HotelBooking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Report {

    int bill;
    Scanner s = new Scanner(System.in);

    void checkin(){
        System.out.println("Enter the mobile number of the client");
        String CsMobileNo = s.nextLine();

        try {
             // Load the JDBC driver explicitly
             Class.forName("com.mysql.cj.jdbc.Driver");
             String url = "jdbc:mysql://127.0.0.1:3306/hotel";
             String user = "root";
             String password = "Nivetha@2002";

             Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = con.prepareStatement("UPDATE hotel.customer SET StayStarted=1 WHERE CsMobileNo=?");

             pstmt.setString(1,  CsMobileNo);
             int i = pstmt.executeUpdate();
                if (i > 0) {
                    System.out.println("Successfully Checked In");
                } else {
                    System.out.println("Error: No matching record found");
                }

        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found: " + e);
        } catch (Exception e) {
            System.out.println("Exception has occurred: " + e);
        }
    }

    void checkout() {
        System.out.println("Enter the mobile number of the client");
        String CsMobileNo = s.nextLine();

        try {
             // Load the JDBC driver explicitly
             Class.forName("com.mysql.cj.jdbc.Driver");
             String url = "jdbc:mysql://127.0.0.1:3306/hotel";
             String user = "root";
             String password = "Nivetha@2002";

             Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement updatePstmt = con.prepareStatement("UPDATE hotel.customer SET StayStarted=-1 WHERE CsMobileNo=?");
             PreparedStatement selectPstmt = con.prepareStatement("SELECT Days, Rooms FROM hotel.customer WHERE CsMobileNo=?");

             // Update the status of stay
             updatePstmt.setString(1, CsMobileNo);
             int i = updatePstmt.executeUpdate();
                if (i > 0) {
                    System.out.println("Successfully Checked Out");

                    // Calculation for total bill
                    selectPstmt.setString(1, CsMobileNo);
                    ResultSet rs = selectPstmt.executeQuery();
                        if (rs.next()) {
                            int days = rs.getInt("Days");
                            int rooms = rs.getInt("Rooms");
                            int cost = 2000 * days * rooms;
                            System.out.println("Your bill is " + cost);
                        } else {
                            System.out.println("Error: No matching record found");
                        }

                } else {
                    System.out.println("Error: No matching record found");
                }

        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found: " + e);
        } catch (Exception e) {
            System.out.println("Exception has occurred: " + e);
        }
    }
}
