import static java.lang.System.out;

import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        out.println("Hello World");
        Connection con = null; 
        String driver = "jdbc:mysql://localhost:3306/mail_app";
        String name = "root";
        String pass = "phenol";

        try {
            con = DriverManager.getConnection(driver, name, pass);
            out.println(con);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
