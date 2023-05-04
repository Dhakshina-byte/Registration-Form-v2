import java.sql.*;

public class DBStudent {
    public static Connection connect() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", null);
            Statement sDB = conn.createStatement();
            sDB.execute(
                    "Create Table if not exists Student_details(StudentID int primary key auto_increment, Student_Name varchar(300),Student_Address varchar(300),Student_City(300),Student_mail varchar(300),Student_ContactNumber int)");
            sDB.execute(
                    "Create Table if not exists Student_Course(StudentID int, CourseID int , constraint FK_Student_Course foreign key(StudentID,CourseID) references Student_details(StudentID,CourseID))");
            // Alert connectAlert = new Alert(AlertType.INFORMATION);
            // connectAlert.show();
            System.out.println(conn);
            sDB.close();

        } catch (Exception e) {
            System.out.println("inter.DBConnect.connect()");
        }
        return conn;

    }
}