
import java.util.Map;

public class SearchInMap {

    public void searchInMap(Map<String, String> FullFile, String scanStr) {
        System.out.println(FullFile.getOrDefault(scanStr, "Такого слова нет в базе данных"));
    }


}
