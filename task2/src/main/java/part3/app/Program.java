package part3.app;

import part3.entity.Element;
import part3.entity.elementType;
import part3.fileWork.Parser;
import part3.fileWork.TextFileWorker;

public class Program {

    private static final String path = "textFiles/text.txt";
    private static final String path2 = "textFiles/text2.txt";

    public static void main(String[] args) {
        TextFileWorker thw = new TextFileWorker();
        Parser parser = new Parser();
        parser.elementsSplit(thw.readText(path)).stream().forEach(System.out::println);
    }

}
