package main.java.org.giri.Basics.design_patterns.CreationalPatterns.Singleton.Solution;

public class AppSettings {

    private static AppSettings instace;
    private String databaseURL;
    private String apiKey;

    private AppSettings() {
        this.databaseURL = "postgresql://user:password@localhost:5432/mydatabase";
        this.apiKey = "12345678-abcd-4efg-9012-3456789hijkl";
    }

    public String getApiKey() {
        return apiKey;
    }

    public  static AppSettings getInstance() {
        if(instace == null) {
            instace = new AppSettings();
        }

        return instace;
    }
}
