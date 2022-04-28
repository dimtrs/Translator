import java.sql.SQLException;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("Введите слово");
            ScanString ScanString = new ScanString();
            String scanStr = ScanString.scanString();
            DetectLanguage DetectLanguage = new DetectLanguage();
            String detectedStr = DetectLanguage.detectRusLanguage(scanStr);
            Map<String, String> FullFile = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
            AddInMapFromDB AddInMapFromDB = new AddInMapFromDB();
            AddInMapFromDB.addInMapFromDB(FullFile, detectedStr);
            SearchInMap SearchInMap = new SearchInMap();
            SearchInMap.searchInMap(FullFile, scanStr);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}