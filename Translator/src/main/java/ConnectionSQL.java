import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionSQL {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/DB_Translator?user=postgres&password=787898";

    public static Connection ConnectSQL() {
        Properties props = new Properties();
        props.setProperty("user", "postgres");
        props.setProperty("password", "787898");
        try {
            Connection connection = DriverManager.getConnection(DB_URL, props);
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
