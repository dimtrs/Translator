import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;

public class AddInMap {
    public Map<String, String> addInMap(Map<String, String> FullFile, BufferedReader reader,String detectedStr) {
        if (detectedStr == "En") {
            try {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] arr = (line.split(",", 2));
                    String one = arr[0];
                    String two = arr[1];
                    FullFile.put(one, two);
                }
                return FullFile;
            } catch (IOException e) {
                throw new RuntimeException("Ошибка чтения txt файла из потока", e);
            }
        }
        else{
            try {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] arr = (line.split(",", 2));
                    String one = arr[1];
                    String two = arr[0];
                    FullFile.put(one, two);
                }
                return FullFile;
            } catch (IOException e) {
                throw new RuntimeException("Ошибка чтения txt файла из потока", e);
            }
        }

        }
    }
