import java.sql.Connection;
import java.sql.DriverManager;

class DbConnection {
    static Connection con = null;
    public static Connection connect() {
        try {
            String driver = "jdbc:mysql://localhost:3306/mail_app";
            String name = "root";
            String pass = "phenol";
        
            con = DriverManager.getConnection(driver, name, pass);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

}
