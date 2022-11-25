import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

public class PhoneNumberMatcher {
    public static void main(String[] args) {
        String absolutePath = "file.txt";
        String temp = "";
        List<String> list = new ArrayList<>();
        try (BufferedReader fileReader = new BufferedReader(new FileReader(absolutePath))) {
            while (fileReader.ready()) {
                temp = fileReader.readLine();
                if(temp.matches("^((8|\\+7)[\\- ]?)?(\\(?\\d{3,4}\\)?[\\- ]?)?[\\d\\- ]{5,10}$")) {
                    list.add(temp);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (String st : list) {
            System.out.println(st);
        }
    }
}
