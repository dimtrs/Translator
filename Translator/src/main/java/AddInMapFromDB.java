import java.io.BufferedReader;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

public class AddInMapFromDB {
    public Map<String, String> addInMapFromDB(Map<String, String> FullFile, String detectedStr) throws SQLException {

        ConnectionSQL ConnectionSQL = new ConnectionSQL();
        ConnectionSQL.ConnectSQL();

        Statement statement = ConnectionSQL.ConnectSQL().createStatement();

        ResultSet resultSet = statement.executeQuery("SELECT * FROM Words");

        if (detectedStr == "En") {
            while(resultSet.next()){

                //int id = resultSet.getInt(1);
                String nameEN = resultSet.getString(2);
                String nameRU = resultSet.getString(3);
                //System.out.printf("%d. %s - %d \n", id, name, price);
                FullFile.put(nameEN, nameRU);
            }
            return FullFile;
        }
        else{
            while(resultSet.next()){

                //int id = resultSet.getInt(1);
                String nameEN = resultSet.getString(2);
                String nameRU = resultSet.getString(3);
                //System.out.printf("%d. %s - %d \n", id, name, price);
                FullFile.put(nameRU, nameEN);
            }
            return FullFile;
        }

    }
}
