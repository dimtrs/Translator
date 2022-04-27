import java.io.BufferedReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;
import java.util.TreeMap;

public class ReadFile {
    public static void main(String[] args) throws IOException {
        OpenStream OpenStream = new OpenStream();
        BufferedReader reader = OpenStream.openStream();
        try {
            System.out.println("Введите слово");
            ScanString ScanString = new ScanString();
            String scanStr = ScanString.scanString();

            DetectLanguage DetectLanguage = new DetectLanguage();
            String detectedStr = DetectLanguage.detectRusLanguage(scanStr);
            Map<String, String> FullFile = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
            //AddInMap AddInMap = new AddInMap();
           // AddInMap.addInMap(FullFile, reader, detectedStr);
            AddInMapFromDB AddInMapFromDB = new AddInMapFromDB();
            AddInMapFromDB.addInMapFromDB(FullFile,detectedStr);

            SearchInMap SearchInMap = new SearchInMap();
            SearchInMap.searchInMap(FullFile, scanStr);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            reader.close();
        }
    }
}