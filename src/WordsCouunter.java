import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WordsCouunter {

    public static Map<String, Integer> counter() {
        Map<String, Integer> result = new HashMap<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("words.txt"))) {
            while (bufferedReader.ready()) {
                String[] splitString = bufferedReader.readLine().split(" ");
                for (String st : splitString) {
                    if(!result.containsKey(st)) {
                        result.put(st, 1);
                    } else {
                        result.put(st, result.get(st) + 1);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
