package Builder;

public class MarkdownBuilder implements Builder {
    private String title;
    private String text;
    private String author;

    public Markdown getResult() {
        return new Markdown(title, text, author);
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
