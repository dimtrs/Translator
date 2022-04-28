import java.io.*;
import java.nio.charset.StandardCharsets;

public class OpenStream {
    public BufferedReader openStream(){
        try {
            InputStreamReader file = new InputStreamReader(new FileInputStream("D://asd.txt"), StandardCharsets.UTF_8);
            return new BufferedReader(file);
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException("Файл не найден", e);
        } catch (IOException e) {
            throw new RuntimeException("Ошибка чтения txt файла из потока", e);
        }
    }
}
