import java.io.*;

public class OpenStream {
    public BufferedReader openStream(){
        try {
            InputStreamReader file = new InputStreamReader(new FileInputStream("D://asd.txt"), "UTF-8");
            BufferedReader reader = new BufferedReader(file);
            return reader;
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException("Файл не найден", e);
        } catch (IOException e) {
            throw new RuntimeException("Ошибка чтения txt файла из потока", e);
        }
    }
}
