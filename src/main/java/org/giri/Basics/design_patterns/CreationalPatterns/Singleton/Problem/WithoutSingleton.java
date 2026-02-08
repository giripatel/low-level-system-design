package main.java.org.giri.Basics.design_patterns.CreationalPatterns.Singleton.Problem;

public class WithoutSingleton {

    public static void main(String[] args) {
        AppSettings appSettings = new AppSettings();
        AppSettings appSettingsCopy = new AppSettings();

        System.out.println(appSettingsCopy.getApiKey());
        System.out.println(appSettings.getApiKey());

        System.out.println(appSettingsCopy == appSettings);

    }
}
