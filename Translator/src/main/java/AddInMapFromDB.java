import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import java.util.Objects;

public class AddInMapFromDB {
    public void addInMapFromDB(Map<String, String> FullFile, String detectedStr) throws SQLException {
ConnectionSQL ConnectionSQL = new ConnectionSQL();
        try (Statement statement = ConnectionSQL.ConnectSQL().createStatement()) {
            try (ResultSet resultSet = statement.executeQuery("SELECT * FROM Words")) {
                if (Objects.equals(detectedStr, "En")) {
                    while (resultSet.next()) {
                        String nameEN = resultSet.getString(2);
                        String nameRU = resultSet.getString(3);
                        FullFile.put(nameEN, nameRU);
                    }
                } else {
                    while (resultSet.next()) {
                        String nameEN = resultSet.getString(2);
                        String nameRU = resultSet.getString(3);
                        FullFile.put(nameRU, nameEN);
                    }
                }
            }
        }

    }
}