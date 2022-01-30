import java.util.List;

public class Text {
    private String text;
    private List<String> bigWords;

    public Text(String text, List<String> bigWords) {
        this.text = text;
        this.bigWords = bigWords;
    }

    public String getText() {
        return text;
    }

    public List<String> getBigWords() {
        return bigWords;
    }

    @Override
    public String toString() {
        return "Text{" +
                "text='" + text + '\'' +
                ", bigWords=" + bigWords +
                '}';
    }
}
