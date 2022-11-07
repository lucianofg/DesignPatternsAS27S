package Builder;

public class App {
    public static void main(String[] args) {
        Director director = new Director();

        System.out.println("----------HTML----------");
        HtmlBuilder htmlBuilder = new HtmlBuilder();
        director.constructLorenIpsum(htmlBuilder);
        Html htmlText = htmlBuilder.getResult();
        System.out.println(htmlText.getRawText());

        System.out.println("--------Markdown--------");
        MarkdownBuilder markdownBuilder = new MarkdownBuilder();
        director.constructLorenIpsum(markdownBuilder);
        Markdown markdownText = markdownBuilder.getResult();
        System.out.println(markdownText.getRawText());
    }
}
