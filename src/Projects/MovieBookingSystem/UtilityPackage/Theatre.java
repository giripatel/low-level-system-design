package Projects.MovieBookingSystem.UtilityPackage;

import java.util.ArrayList;
import java.util.List;

public class Theatre {
    int id;
    String name;
    List<Screen> screens;

    public Theatre(int id, String name) {
        this.id = id;
        this.name = name;
        this.screens = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Screen> getScreens() {
        return screens;
    }

    public void setScreens(List<Screen> screens) {
        this.screens = screens;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addScreen(Screen screen) {
        screens.add(screen);
    }

    public void removeScreen(Screen screen) {
        screens.remove(screen);
    }
}
