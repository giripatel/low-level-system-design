package main.java.org.giri.Basics.design_patterns.CreationalPatterns.Singleton.Solution;

public class WithSingleton {
    public static void main(String[] args) {
        AppSettings appSettings = AppSettings.getInstance();
        AppSettings appSettings1 = AppSettings.getInstance();

        System.out.println(appSettings1.getApiKey());
        System.out.println(appSettings.getApiKey());

        System.out.println(appSettings1 == appSettings);
    }
}
