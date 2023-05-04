import java.sql.*;
//import javafx.scene.control.Alert;
//import javafx.scene.control.Alert.AlertType;

public class DBConnect {
    public static Connection connect() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", null);
            Statement SDB = conn.createStatement();
            SDB.execute(
                    "Create Table if not exists Course_details(CourseID int primary key auto_increment, Course_Name varchar(300),Course_Description varchar(300),Course_Price int,Course_Period int)");
            // Alert connectAlert = new Alert(AlertType.INFORMATION);
            // connectAlert.show();
            System.out.println(conn);
            SDB.close();

        } catch (Exception e) {
            System.out.println("inter.DBConnect.connect()");
        }
        return conn;
    }
}
