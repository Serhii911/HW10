package json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;

public class Json {
    public static Object jsonReader() throws IOException {
        StringBuilder json = new StringBuilder();
        User user;
        BufferedReader reader = new BufferedReader(new FileReader("file2.txt"));
        while (reader.ready()) {
            String[] strings = reader.readLine().split(" ");
            for (int i = 0; i < strings.length - 1; i++) {
                try {
                    user = new User (strings[i], Integer.parseInt(strings[i + 1]));
                    Gson gson = new GsonBuilder().setPrettyPrinting().create();
                    json.append(gson.toJson(user)).append("\n");
                } catch (NumberFormatException e) {
                    continue;
                }
            }
        }
        return json.toString();
    }

    public static void jsonWriter(Object json) throws IOException {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("user.json"))) {
            writer.write((String) json);
        }
    }
    public static void main(String[] args) throws IOException {
        jsonWriter(jsonReader());
    }
}
