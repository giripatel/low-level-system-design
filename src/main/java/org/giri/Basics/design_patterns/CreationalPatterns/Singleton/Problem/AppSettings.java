package main.java.org.giri.Basics.design_patterns.CreationalPatterns.Singleton.Problem;

public class AppSettings {

    private String databaseURL;
    private String apiKey;

    public AppSettings() {
        this.databaseURL = "postgresql://user:password@localhost:5432/mydatabase";
        this.apiKey = "12345678-abcd-4efg-9012-3456789hijkl";
    }

    public String getApiKey() {
        return apiKey;
    }
}
