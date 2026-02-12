package main.java.org.giri.Basics.design_patterns.BehaviouralPatterns.Template.Problem;

public class CSVParser {
    public void openFile() {
        System.out.println("Opening file");
    }

    public void closeFile() {
        System.out.println("Closing file");
    }

    public void parse() {
        openFile();
        System.out.println("Parsing CSVParser");
        closeFile();
    }
}
