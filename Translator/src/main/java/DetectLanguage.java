import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DetectLanguage {
    public String detectRusLanguage(String scanStr) {
        String regexRus = "[а-яёА-ЯЁ]+";
        Pattern pattern = Pattern.compile(regexRus);
        Matcher m = pattern.matcher(scanStr);
        if (m.find()) {
            return "Ru";
        }
        else {
            return "En";
        }
        }
    }