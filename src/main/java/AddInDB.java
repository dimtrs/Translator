import java.io.*;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.SQLException;

public class AddInDB {
    private static final String CREATE_TABLE_QUERY = "CREATE TABLE IF NOT EXISTS Words ("
            + "id INTEGER PRIMARY KEY, "
            + "en TEXT NOT NULL, "
            + "ru TEXT NOT NULL)";
    private static final String INSERT_WORDS_QUERY = "INSERT INTO Words (id, en, ru) VALUES (?, ?, ?)";

    public static void main(String[] args) {
        ConnectionSQL ConnectionSQL = new ConnectionSQL();
        ConnectionSQL.ConnectSQL();
        try (Statement stmt = ConnectionSQL.ConnectSQL().createStatement()) {
            stmt.execute(CREATE_TABLE_QUERY);
        } catch (SQLException exc) {
            exc.printStackTrace();
        }

        try {
            InputStreamReader file = new InputStreamReader(new FileInputStream("D://asd.txt"), "UTF-8");
            BufferedReader reader = new BufferedReader(file);
            PreparedStatement stmt = ConnectionSQL.ConnectSQL().prepareStatement(INSERT_WORDS_QUERY);
            String line;
            int i = 0;
            while ((line = reader.readLine()) != null) {
                i++;
                String[] record = (line.split(",", 2));
                stmt.setInt(1, i);
                stmt.setString(2, record[0]);
                stmt.setString(3, record[1]);
                stmt.executeUpdate();
            }

        } catch (SQLException | FileNotFoundException | UnsupportedEncodingException exc) {
            exc.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
