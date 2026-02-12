package main.java.org.giri.Basics.design_patterns.BehaviouralPatterns.Template.Problem;

public class Mian {
    public static void main(String[] args) {
        CSVParser csvParser = new CSVParser();
        csvParser.parse();

        XMLParser xmlParser = new XMLParser();
        xmlParser.parse();
    }
}
