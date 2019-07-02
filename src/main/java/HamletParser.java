import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by thook on 10/7/15.
 */
public class HamletParser {

    private String hamletData;

    public HamletParser(){
        this.hamletData = loadFile();
    }

    private String loadFile(){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("hamlet.txt").getFile());
        StringBuilder result = new StringBuilder("");

        try(Scanner scanner = new Scanner(file)){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }
            scanner.close();
        }catch(IOException e){
            e.printStackTrace();
        }
        return result.toString();
    }

    public String getHamletData(){return this.hamletData;}

    String replace(String from, String to){
  //      return this.hamletData.replaceAll("(?i)\\b(" + from + ")\\b",to);
        return this.hamletData.replaceAll("(?i)\\b(" + from + ")\\b",to);
    }

    Integer count(String input, String theText){
   //     Pattern myRegex = Pattern.compile("(?i)"+input);
        Pattern myRegex = Pattern.compile("(?i)\\b(" + input + ")\\b");
        Matcher matcher = myRegex.matcher(theText);
        Integer count =0;
        while(matcher.find())count++;
        return count;
    }
}
