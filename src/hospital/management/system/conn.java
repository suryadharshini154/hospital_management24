package hospital.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class conn {
    Connection connectiom;
    Statement statement;


    public conn() {
        try {
            connectiom = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_management_system", "root", "root");
            statement = connectiom.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
