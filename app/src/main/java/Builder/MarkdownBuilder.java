package Builder;

public class MarkdownBuilder implements IBuilder {

    private String title;
    private String text;
    private String author;

    public Markdown getResult() {
        String[] lines = text.split(System.getProperty("line.separator"));
        return new Markdown(title, lines, author);
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public void setText(String text) {
        this.text = text;
    }

    @Override
    public void setAuthor(String author) {
        this.author = author;
    }
}
