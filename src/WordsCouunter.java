import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WordsCouunter {

    public static String counter() {
        StringBuilder find = new StringBuilder();
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
            for(Map.Entry<String, Integer> entry: result.entrySet()) {

                String key = entry.getKey();

                Integer value = entry.getValue();
                find.append(key).append(" ").append(value).append("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }        return find.toString();
    }

    public static void main(String[] args) {
        System.out.println(counter());
    }
}
