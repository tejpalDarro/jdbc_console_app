import static java.lang.System.out;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

class UserDetailsDao {
    public static void createUser(UserDetails user) throws SQLException {
        Connection con = DbConnection.connect();
        String query = Query.insert;
        out.println("Connection: " + con);
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, user.getName());
        ps.setString(2, user.getEmail());
        ps.setString(3, user.getPass());

        out.println("\n ps = "+ps+"\n" + user);
        ps.executeUpdate();
        ps.close();
    }

    public static void update(int id, String name) throws SQLException {
        Connection con = DbConnection.connect();
        String query = Query.update;
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, name);
        ps.setInt(2, id);
        out.println("\n ps = " + ps);
        ps.executeUpdate();
        ps.close();
    }

    public static ArrayList<UserDetails> printUser() throws SQLException {
        ArrayList<UserDetails> list = new ArrayList<>();
        Connection con = DbConnection.connect();
        String query = Query.select;
        Statement st = con.prepareStatement(query);
        out.println("\n st = " + st);
        ResultSet rs = st.executeQuery(query);

        while (rs.next()) {
            UserDetails ud = new UserDetails(rs.getString(1), rs.getString(2), rs.getString(3));
            list.add(ud);
        }

        st.close();
        return list;
    }
}
