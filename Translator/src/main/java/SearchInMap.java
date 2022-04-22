import java.util.Map;

public class SearchInMap {

    public void searchInMap(Map<String, String> FullFile, String scanStr){

        if (FullFile.containsKey(scanStr)) {
            System.out.println(FullFile.get(scanStr));
        } else
            System.out.println("Такого слова нет в базе данных");
    }




    }


