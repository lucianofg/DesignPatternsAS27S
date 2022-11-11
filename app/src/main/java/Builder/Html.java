package Builder;

public class Html {

    private String rawText;
    private final String title;
    private final String lines[];
    private final String author;

    public Html(String title, String text, String author) {
        this.title = title;
        this.author = author;
        this.lines = text.split(System.getProperty("line.separator"));

        this.makeRawText();
    }

    private void makeRawText() {
        StringBuilder newRawText = new StringBuilder();

        newRawText.append(String.format("<html>\n\t<head>\n\t\t<title>%s</title>\n\t</head>"
                + "\n\t<body>\n\t\t<h1>%s</h1>", this.title, this.title));
        for (String line : this.lines) {
            newRawText.append(String.format("\n\t\t<p>%s</p>", line));
        }
        newRawText.append(String.format("\n\t\t<hr>\n\t\t<address>%s</address>", this.author));
        newRawText.append("\n\t</body>\n</html>");

        this.rawText = newRawText.toString();
    }

    public String getRawText() {
        return this.rawText;
    }
}
