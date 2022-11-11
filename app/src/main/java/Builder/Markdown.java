package Builder;

public class Markdown {

    private String rawText;
    private final String title;
    private final String[] lines;
    private final String author;

    public Markdown(String title, String text, String author) {
        this.title = title;
        this.lines = text.split(System.getProperty("line.separator"));
        this.author = author;

        this.makeRawText();
    }

    private void makeRawText() {
        StringBuilder newRawText = new StringBuilder();

        newRawText.append(String.format("%s\n", this.title));
        for (int i = 0; i < this.title.length(); i++) {
            newRawText.append('=');
        }
        newRawText.append("\n\n");
        for (String line : this.lines) {
            newRawText.append(String.format("%s\n\n", line));
        }
        newRawText.append(String.format("*Author: %s*\n", this.author));

        this.rawText = newRawText.toString();
    }

    public String getRawText() {
        return this.rawText;
    }
}
