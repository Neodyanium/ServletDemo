import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class JDBCUtil {

    public static Connection connection(){
        String url = "jdbc:sql://localhost:3306/practice_database";
        String user = "root";
        String password = "qwertyuiop";
        try {
            return DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
