package Builder;

public class Markdown {

    private String rawText;
    private String title;
    private String[] lines;
    private String author;

    public Markdown(String title, String text, String author) {
        this.title = title;
        this.lines = text.split(System.getProperty("line.separator"));
        this.author = author;

        this.makeRawText();
    }

    private void makeRawText() {
        StringBuilder newRawText = new StringBuilder();

        newRawText.append(String.format("# %s\n\n", this.title));
        for (String line : this.lines) {
            newRawText.append(String.format("%s\n\n", line));
        }
        newRawText.append(String.format("Author: %s\n", this.author));

        this.rawText = newRawText.toString();
    }

    public String getRawText() {
        return this.rawText;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setLines(String[] lines) {
        this.lines = lines;
    }
}
