package main.java.org.giri.Basics.design_patterns.BehaviouralPatterns.Template.Solution;

public abstract class DataPraser {
    public void parse() {
        openFile();
        parseData();
        closeFile();
    }

    protected void openFile() {
        System.out.println("Opening file");
    }

    protected void closeFile() {
        System.out.println("Closing file");
    }

    protected abstract void parseData();
}
