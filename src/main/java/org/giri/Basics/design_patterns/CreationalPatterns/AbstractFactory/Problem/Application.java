package main.java.org.giri.Basics.design_patterns.CreationalPatterns.AbstractFactory.Problem;

public class Application {
    public static void main(String[] args) {
        // Windows UI
        WindowsButton windowsButton = new WindowsButton();
        WindowsScrollBar windowsScrollBar = new WindowsScrollBar();
        windowsButton.render();
        windowsScrollBar.scroll();
        /*
        - we have the flexibility to override the windows scrollbar with mac
        - this shows inconsistent UI
         */

        // Mac OS

        String os = System.getProperty("os.name");
        // another scenario
        if(os.contains("Windows")) {
            WindowsButton windowsButton2 = new WindowsButton();
            WindowsScrollBar windowsScrollBar2 = new WindowsScrollBar();
            windowsButton2.render();
            windowsScrollBar2.scroll();
        }else if(os.contains("MacOS")) {
            MacOSButton macOSButton = new MacOSButton();
            MacOSScrollBar macOSScrollBar = new MacOSScrollBar();
            macOSScrollBar.scroll();
            macOSButton.render();
        }

    }
}
