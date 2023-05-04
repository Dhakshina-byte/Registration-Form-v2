import java.sql.*;

public class CreateDB {
    public static Connection DBCreate() {
        Connection connDB = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connDB = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", null);
            Statement sDB = connDB.createStatement();
            sDB.execute("Create Database if not exists test");
            // Alert connectAlert = new Alert(AlertType.INFORMATION);
            // connectAlert.show();
            System.out.println(connDB);
            sDB.close();
            connDB.close();

        } catch (Exception e) {
            System.out.println("inter.CreateDB.DBCreate()");
        }
        return connDB;
    }
}
