import javafx.fxml.FXML;
import java.sql.*;
import javafx.event.ActionEvent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class form {
    Connection conDB = CreateDB.DBCreate();
    Connection connStu = null;

    @FXML
    private TextField Address;

    @FXML
    private TextField City;

    @FXML
    private CheckBox English;

    @FXML
    private TextField Full;

    @FXML
    private CheckBox ICT;

    @FXML
    private CheckBox Maths;

    @FXML
    private TextField Phone;

    @FXML
    private CheckBox Science;

    @FXML
    private TextField mail;

    @FXML
    void Submit(ActionEvent event) throws SQLException {

        connStu = DBStudent.connect();
        Statement stmt = connStu.createStatement();
        String StuName = Full.getText();
        String stuMail = mail.getText();
        String StuAddress = Address.getText();
        String StuNumber = Phone.getText();
        String StuCity = City.getText();
        try {
            String q = "Insert into Student_details(Student_Name, Student_Address, Student_mail, Student_ContactNumber, Student_City,) values ('"
                    + StuName + "' , '" + StuAddress + "' , '" + stuMail + "' , '" + StuNumber + "','" + StuCity + "')";
            PreparedStatement pst = connStu.prepareStatement(q);
            pst.execute();
            String q1 = "Select StudentID from Student_details Where Student_Name = '" + StuName + "'";
            ResultSet rSetName = stmt.executeQuery(q1);
            rSetName.next();
            int StuID = rSetName.getInt("StudentID");
            System.out.println(StuID);
            if (English.isSelected() == true) {
                String Engname = English.getText();
                String strSelectENG = "Select CourseID from Course_details Where Course_Name = '" + Engname + "'";
                ResultSet rSetENG = stmt.executeQuery(strSelectENG);
                rSetENG.next();
                int IDENG = rSetENG.getInt("CourseID");
                String q2 = "Insert into Student_Course(StudentID , CourseID) values ('" + StuID + "' , '" + IDENG
                        + "')";
                PreparedStatement pst2 = connStu.prepareStatement(q2);
                pst2.execute();
            } else {
                System.out.println("Error!");
            }
            if (ICT.isSelected() == true) {
                String ITname = ICT.getText();
                String strSelectICT = "Select CourseID from Course_details Where Course_Name = '" + ITname + "'";
                ResultSet rSetICT = stmt.executeQuery(strSelectICT);
                rSetICT.next();
                int IDICT = rSetICT.getInt("CourseID");
                String q3 = "Insert into Student_Course(StudentID , CourseID) values ('" + StuID + "' , '" + IDICT
                        + "')";
                PreparedStatement pst3 = connStu.prepareStatement(q3);
                pst3.execute();
            } else {
                System.out.println("Error!");
            }
            if (Maths.isSelected() == true) {
                String Mathsname = Maths.getText();
                String strSelectMaths = "Select CourseID from Course_details Where Course_Name = '" + Mathsname
                        + "'";
                ResultSet rSetMaths = stmt.executeQuery(strSelectMaths);
                rSetMaths.next();
                int IDMaths = rSetMaths.getInt("CourseID");
                String q4 = "Insert into Student_Course(StudentID , CourseID) values ('" + StuID + "' , '" + IDMaths
                        + "')";
                PreparedStatement pst4 = connStu.prepareStatement(q4);
                pst4.execute();
            } else {
                System.out.println("Error!");
            }
            if (Science.isSelected() == true) {
                String Sciencename = Science.getText();
                String strSelectScience = "Select CourseID from Course_details Where Course_Name = '" + Sciencename
                        + "'";
                ResultSet rSetScience = stmt.executeQuery(strSelectScience);
                rSetScience.next();
                int IDScience = rSetScience.getInt("CourseID");
                String q5 = "Insert into Student_Course(StudentID , CourseID) values ('" + StuID + "' , '" + IDScience
                        + "')";
                PreparedStatement pst5 = connStu.prepareStatement(q5);
                pst5.execute();
            } else {
                System.out.println("Error!");
            }
            System.out.println("Done!");
            DBConnect.connect().close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
