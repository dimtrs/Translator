import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;

public class ChangeRegularFile {
    public static void main(String[] args) {
        {
            try {
// input the file content to the StringBuffer "input"
                BufferedReader file = new BufferedReader(new FileReader("D://asd.txt"));
                String line;
                StringBuffer inputBuffer = new StringBuffer();

                while ((line = file.readLine()) != null) {
                    inputBuffer.append(line);
                    inputBuffer.append('\n');

                }
                String inputStr = inputBuffer.toString();

//String mainChapterNum = inputStr.substring(inputStr.indexOf("["), inputStr.indexOf("-"));
                inputStr = inputStr.replace("NEW!", "");

//file.close();

               // System.out.println(inputStr); // check that it inputted right




// write the new String with the replaced line OVER the same file
                FileOutputStream fileOut = new FileOutputStream("D://asd.txt");
                fileOut.write(inputStr.getBytes());
                fileOut.close();

            } catch (Exception e) {
                System.out.println("Problem reading file.");
            }
        }
    }
}