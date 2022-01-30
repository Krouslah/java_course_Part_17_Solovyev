import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        File file = new File("test.txt");
        File file2 = new File("test2.txt");
        List<String> words = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file));
             BufferedWriter bw = new BufferedWriter(new FileWriter(file2))) {
            StringBuilder str = new StringBuilder();
            String word;
            while ((word = br.readLine()) != null) {
                str.append(word.toLowerCase()).append("\n");
            }
            if (str.length() > 128) {
                System.out.println("В файле находятся более 128 символов. Перепишите файл вручную и начните программу заново");
                System.exit(1);
            }
            String str2 = str.toString();
            String str3 = str2.replaceAll("\\p{Punct}", "").replaceAll("\n", " ");
            String[] array = str3.split(" ");
            Arrays.stream(array).filter(n -> n.length() > 6).forEach(words::add);
          Text text = new Text(str2, words);
          System.out.println(text.getText() + "\n" + text.getBigWords());
          bw.write(str2);
          bw.write(text.getBigWords().toString());
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
